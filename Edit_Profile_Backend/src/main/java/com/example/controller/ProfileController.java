package com.example.controller;

import java.util.Optional;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.User;
import com.example.repository.ProfileRepository;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/")
public class ProfileController {
	@Autowired
	private ProfileRepository profileRepository;
	@Autowired
	private JavaMailSender javaMailSender;

	@GetMapping(value = "/{id}")
	public Optional<User> findById(@PathVariable("id") int id) {
		System.out.println("getting user");
		return profileRepository.findById(id);
		// return new User();
	}

	@PostMapping(value = "/updateUser")
	public String addNewUser(@RequestBody User user) {

		System.out.println(user);
		profileRepository.save(user);

		return "Saved";
	}

	@PostMapping(value = "/sendOtp")
	public String otp(@RequestBody String email) {
		System.out.println("EMAILLLLLLLLLLLLL " + email);
		JSONObject json = new JSONObject(email);
		SimpleMailMessage msg = new SimpleMailMessage();
		System.out.println("commandliner  " + json.getString("email"));
		msg.setTo(json.getString("email"));
		msg.setSubject("OTP For Forgot Password");
		String otp = String.valueOf((long) (Math.random() * 900000) + 100000);
		msg.setText("Your OTP is :" + otp);
		System.out.println("commandliner");
		// javaMailSender.send(msg);

		return "OTPsent";
	}

}
