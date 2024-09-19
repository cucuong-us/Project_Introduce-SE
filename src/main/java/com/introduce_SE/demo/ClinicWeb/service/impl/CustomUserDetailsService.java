package com.introduce_SE.demo.ClinicWeb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.introduce_SE.demo.ClinicWeb.dto.MyUserDetails;
import com.introduce_SE.demo.ClinicWeb.model.User;
import com.introduce_SE.demo.ClinicWeb.repository.UserRepository;

public class CustomUserDetailsService implements UserDetailsService	 {
	@Autowired
	private UserRepository userRepository;
	
	@Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
         
        if (user == null) {
            throw new UsernameNotFoundException("Could not find user");
        }
         
        return new MyUserDetails(user);
    }
}
