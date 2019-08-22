package com.sapient.password.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.sapient.password.model.CustomPasswordEncoder;
import com.sapient.password.model.User;

@RestController
@RequestMapping("/api/change")
@CrossOrigin(origins = "*")
public class ChangePasswordController {

	@Autowired
	RestTemplate restTemplate;

	@Autowired
	CustomPasswordEncoder customPasswordEncoder;

	@PostMapping
	public String changePassword(@RequestBody User loginUser) {
		String url = "http://localhost:8017/api/data/user";
		User user = new User();
		
		if (loginUser.getUserID() != null) {
			user.setUserID(loginUser.getUserID());
		} else {
			user.setEmailID(loginUser.getEmailID());
		}
		
		HttpEntity<User> httpEntity = new HttpEntity<User>(user);
		ResponseEntity<Optional<User>> response = restTemplate.exchange(url, HttpMethod.POST, httpEntity,
				new ParameterizedTypeReference<Optional<User>>() {
				});
		Optional<User> optional = response.getBody();

		String status = changePasswordOfUser(optional, loginUser.getPassword().getPwd1(), loginUser.getPassword().getPwd2());
		return status;
	}

	private String changePasswordOfUser(Optional<User> optional, String rawOldPassword, String rawNewPassword) {
		if (optional.isPresent()) {
			User user = optional.get();
			String storedHashedOldPassword = user.getPassword().getPwd1();
			String storedSalt = user.getPassword().getSalt1();
			String inputHashedOldPassword = customPasswordEncoder.encodeWithSalt(rawOldPassword, storedSalt);
			
			if (inputHashedOldPassword.equals(storedHashedOldPassword)) {
				String newSalt = BCrypt.gensalt(12);
				String inputHashedNewPassword = customPasswordEncoder.encodeWithSalt(rawNewPassword, newSalt);
				user.getPassword().setPwd1(inputHashedNewPassword);
				user.getPassword().setSalt1(newSalt);
				user.getPassword().setPwd2(null);
				String url = "http://localhost:8017/api/data/update";
				HttpEntity<User> httpEntity = new HttpEntity<User>(user);
				ResponseEntity<Integer> response = restTemplate.exchange(url, HttpMethod.POST, httpEntity,
						new ParameterizedTypeReference<Integer>() {
						});
				int status = response.getBody();
				if (status > 0) {
					return "Password changed successfully";
				} else
					return "Some error";
			}
			return "Please enter correct password";
		}
		return "User doesn't exist";
	}
}
