package com.app.digitalbussiness.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.digitalbussiness.model.User;

public interface RegistartionRepository extends JpaRepository<User, Long> {

	public User findByEmailId(String emailId);

	public User findByEmailIdAndPasswordAndRole(String emailId, String password, String role);

	public User findByemailId(String emailId);

	
}
