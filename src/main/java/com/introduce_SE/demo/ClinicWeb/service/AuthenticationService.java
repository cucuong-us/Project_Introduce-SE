package com.introduce_SE.demo.ClinicWeb.service;

import java.text.ParseException;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.introduce_SE.demo.ClinicWeb.dto.request.AuthenticationRequest;
import com.introduce_SE.demo.ClinicWeb.dto.request.IntrospectRequest;
import com.introduce_SE.demo.ClinicWeb.dto.response.AuthenticationResponse;
import com.introduce_SE.demo.ClinicWeb.dto.response.IntrospectResponse;
import com.introduce_SE.demo.ClinicWeb.model.User;
import com.introduce_SE.demo.ClinicWeb.repository.UserRepository;
import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jose.JWSHeader;
import com.nimbusds.jose.JWSObject;
import com.nimbusds.jose.JWSVerifier;
import com.nimbusds.jose.KeyLengthException;
import com.nimbusds.jose.Payload;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jose.crypto.MACVerifier;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;

@Service
public class AuthenticationService {

	@Autowired
	private UserRepository userRepository;

	@Value("${jwt.signerKey}")
	protected String SIGNER_KEY;
	
	public IntrospectResponse introspect(IntrospectRequest request) throws JOSEException, ParseException {
		var token = request.getToken();
		
		JWSVerifier verifier = new MACVerifier(SIGNER_KEY.getBytes());
		
		SignedJWT signedJWT = SignedJWT.parse(token);
		
		Date expiryTime = signedJWT.getJWTClaimsSet().getExpirationTime();
		
		var verified = signedJWT.verify(verifier);
		
		return new IntrospectResponse(verified && expiryTime.after(new Date()));
	}
	
	public AuthenticationResponse authenticate(AuthenticationRequest request) throws Exception {
		User user = userRepository.findByUsername(request.getUsername());
		
		if (user == null) {
            throw new UsernameNotFoundException("Could not find user");
        }
		
		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);
        boolean authenticated = passwordEncoder.matches(request.getPassword(), user.getPassword());
        
        if(!authenticated) {
        	throw new Exception("Unauthenticated");
        }
        
        var token = generateToken(request.getUsername());
        return new AuthenticationResponse(token, true);
	}
	
	private String generateToken(String username) {
		JWSHeader header = new JWSHeader(JWSAlgorithm.HS512);
		
		JWTClaimsSet jwsClaimsSet = new JWTClaimsSet.Builder()
				.subject(username)
				.issuer("clinicweb.com")
				.issueTime(new Date())
				.expirationTime(new Date(Instant.now().plus(1,ChronoUnit.HOURS).toEpochMilli()
						))
				.claim("customClaim", "Datdeptraiprovip")
				.build();
		
		Payload payload = new Payload(jwsClaimsSet.toJSONObject());
		
		JWSObject jwsObject = new JWSObject(header, payload);
		
		try {
			jwsObject.sign(new MACSigner(SIGNER_KEY.getBytes()));
		} catch (KeyLengthException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JOSEException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return jwsObject.serialize();
		
	}
}
