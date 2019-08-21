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
	public String authenticate(@RequestBody User loginUser) {
		String url = "http://localhost:8017/api/data/user";
		System.out.println(loginUser);
		HttpEntity<User> httpEntity = new HttpEntity<User>(loginUser);
		ResponseEntity<Optional<User>> response = restTemplate.exchange(url, HttpMethod.POST, httpEntity,
				new ParameterizedTypeReference<Optional<User>>() {
				});
		Optional<User> optional = response.getBody();
		String status = authenticateUser(optional, loginUser);
		return status;
	}

	private String authenticateUser(Optional<User> optional, User loginUser) {

		if (optional.isPresent()) {
			User user = optional.get();
			String storedhashedPwd = user.gethashedpwd();
			String storedSalt = user.getSalt();
			String hashedPwd = cpencoder.encodeWithSalt(loginUser.gethashedpwd(), storedSalt);
			System.out.println(hashedPwd);
			if (hashedPwd.equals(storedhashedPwd)) {
				return "Authenticated";
			} else {
				return "Incorrect Password";
			}
		}
		return "User doesnot exist";
	}

}
