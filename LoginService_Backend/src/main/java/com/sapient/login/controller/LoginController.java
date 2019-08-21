package com.sapient.login.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.sapient.login.model.CustomPasswordEncoder;
import com.sapient.login.model.LoginStatus;
import com.sapient.login.model.User;

@RestController
@RequestMapping("/api/authenticate")
@CrossOrigin(origins = "http://localhost:8014")
public class LoginController {

	@Autowired
	RestTemplate restTemplate;

	@Autowired
	CustomPasswordEncoder cpencoder;

	@PostMapping
	public LoginStatus authenticate(@RequestBody User loginUser) {
		String url = "http://localhost:8017/api/data/user";
		System.out.println(loginUser.getPasswordHistory());
		HttpEntity<User> httpEntity = new HttpEntity<User>(loginUser);
		ResponseEntity<Optional<User>> response = restTemplate.exchange(url, HttpMethod.POST, httpEntity,
				new ParameterizedTypeReference<Optional<User>>() {
				});
		Optional<User> optional = response.getBody();
		return authenticateUser(optional, loginUser);
	}

	private LoginStatus authenticateUser(Optional<User> optional, User loginUser) {

		LoginStatus loginStatus = new LoginStatus();
		if (optional.isPresent()) {
			User user = optional.get();
			String storedhashedPwd = user.getPasswordHistory().getPwd1();
			String storedSalt = user.getPasswordHistory().getSalt1();
			String hashedPwd = cpencoder.encodeWithSalt(loginUser.getPasswordHistory().getPwd1(), storedSalt);
			System.out.println(hashedPwd);
			if (hashedPwd.equals(storedhashedPwd)) {
				String url = "http://localhost:8017/api/data/checkflag";
				HttpEntity<User> httpEntity = new HttpEntity<User>(user);
				ResponseEntity<Boolean> response = restTemplate.exchange(url, HttpMethod.POST, httpEntity,
						new ParameterizedTypeReference<Boolean>() {
						});
				if (response.getBody()) {
					loginStatus.setMessage("Authenticated");
					loginStatus.setUserID(user.getUserID());
				} else {
					loginStatus.setMessage("Not a confirmed user");
					loginStatus.setUserID(user.getUserID());
				}
			} else {
				loginStatus.setMessage("Incorrect Password");
				loginStatus.setUserID(user.getUserID());
			}
		} else {
			loginStatus.setMessage("User doesnot exists");
		}
		return loginStatus;
	}

}
