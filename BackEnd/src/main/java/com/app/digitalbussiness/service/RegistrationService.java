/**
 * 
 */
package com.app.digitalbussiness.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.digitalbussiness.model.User;
import com.app.digitalbussiness.repository.RegistartionRepository;

/**
 * @author BasaniVa
 *
 */
@Service
public class RegistrationService {

	private RegistartionRepository repo;

	@Autowired
	public void setClientRepository(RegistartionRepository repo) {
		this.repo = repo;
	}

	public User saveUser(User user) {
		return repo.save(user);
	}

	public User fetchUserByEmailId(String email) {
		return repo.findByEmailId(email);

	}

	public User fetchUserByEmailIdandPasswordandRole(String emailId, String password, String role) {
		return repo.findByEmailIdAndPasswordAndRole(emailId, password, role);
	}

	public User getUserById(Long id) {

		return repo.findById(id).get();
		
	}
	

}
