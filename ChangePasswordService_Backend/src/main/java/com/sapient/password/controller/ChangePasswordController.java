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
@CrossOrigin(origins = "http://10.150.120.183.:8016")
public class ChangePasswordController {

	@Autowired
	RestTemplate restTemplate;

	@Autowired
	CustomPasswordEncoder customPasswordEncoder;

	@PostMapping
	public String changePassword(@RequestBody User currentUser) {
		System.out.println("user in changePassword: " + currentUser);
		String url = "http://localhost:8017/api/data/user";
		User user = new User(currentUser.getUserID(), null, null);
		HttpEntity<User> httpEntity = new HttpEntity<User>(user);
		ResponseEntity<Optional<User>> response = restTemplate.exchange(url, HttpMethod.POST, httpEntity,
				new ParameterizedTypeReference<Optional<User>>() {
				});
		Optional<User> optional = response.getBody();
		// System.out.println("H1"+optional.get());
		String status = changePasswordOfUser(optional, currentUser.getPasswordHistory().getOldpwd(),
				currentUser.getPasswordHistory().getPwd1());
		return status;
	}

	private String changePasswordOfUser(Optional<User> optional, String oldPassword, String newPassword) {
		if (optional.isPresent()) {
			User user = optional.get();
			System.out.println("user in response from api: " + user);
			String storedhashedPassword = user.getPasswordHistory().getPwd1();
			String storedSalt = user.getPasswordHistory().getSalt1();
			System.out.println("old pwd: " + oldPassword);
			System.out.println("new pwd: " + newPassword);
			System.out.println("stored salt: " + storedSalt);
			System.out.println("stored hashed pwd: " + storedhashedPassword);
			String hashOfOldPassword = customPasswordEncoder.encodeWithSalt(oldPassword, storedSalt);
			if (hashOfOldPassword.equals(storedhashedPassword)) {
				// System.out.println("hello");
				String newSalt = BCrypt.gensalt(12);
				String hashOfNewPassword = customPasswordEncoder.encodeWithSalt(newPassword, newSalt);
				System.out.println("new hashed pwd: " + hashOfNewPassword);
				user.getPasswordHistory().setPwd1(hashOfNewPassword);
				user.getPasswordHistory().setSalt1(newSalt);
				System.out.println("H2" + user);
				String url = "http://localhost:8017/api/data/update";
				HttpEntity<User> httpEntity = new HttpEntity<User>(user);
				ResponseEntity<Integer> response = restTemplate.exchange(url, HttpMethod.POST, httpEntity,
						new ParameterizedTypeReference<Integer>() {
						});
				int status = response.getBody();
				if (status > 0) {
					return "Password changed successfully";
				}
				return "some error";
			}
			return "Please enter correct password";
		}
		return "User doesnot exist";
	}
}
