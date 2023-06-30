/**
 * 
 */
package com.app.digitalbussiness.controller;

import java.util.NoSuchElementException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.digitalbussiness.model.User;
import com.app.digitalbussiness.service.RegistrationService;

/**
 * @author BasaniVa
 *
 */
@Controller
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class FarmerController {

	private RegistrationService service;

	@Autowired
	public void setClientRepository(RegistrationService service) {
		this.service = service;
	}

	@PostMapping("/registrationFormUser")
	public ResponseEntity<User> registerUser(@RequestBody @Valid User user) throws Exception {
		String temEmailId = user.getEmailId();
		if (temEmailId != null && !"".equals(temEmailId)) {
			User userObj = service.fetchUserByEmailId(temEmailId);
			if (userObj != null) {
				throw new Exception("user with " + temEmailId + " is already exist");
			}
		}

		return new ResponseEntity<>(service.saveUser(user), HttpStatus.CREATED);
	}

	@PostMapping("/login")
	public User loginUser(@RequestBody @Valid User user) throws Exception {
		String tempEmailId = user.getEmailId();
		String tempPass = user.getPassword();
		String tempRole = user.getRole();
		User userObj = null;
		if (tempEmailId != null && tempPass != null && tempRole != null) {
			userObj = service.fetchUserByEmailIdandPasswordandRole(tempEmailId, tempPass, tempRole);
		}
		if (userObj == null) {
			throw new Exception("Bad credentials");
		}
		return userObj;
	}

	@GetMapping("/user/{id}")
	public User getEquipmentById(@PathVariable("id") Long id) throws NoSuchElementException {
		return service.getUserById(id);
	}

}
