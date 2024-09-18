package com.introduce_SE.demo.ClinicWeb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.introduce_SE.demo.ClinicWeb.model.User;


public interface UserRepository extends JpaRepository<User, Integer> {
	public User findByUsername(String username);
}
