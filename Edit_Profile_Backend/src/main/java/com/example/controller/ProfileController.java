package com.example.controller;

import java.util.Optional;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailAuthenticationException;
import org.springframework.mail.MailSendException;
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
	public ResponseEntity<User> findById(@PathVariable("id") int id) {
		try {
			Optional<User> foundUser = profileRepository.findById(id);
			if (foundUser.isPresent())
				return new ResponseEntity<User>(foundUser.get(), HttpStatus.OK);
		} catch (IllegalArgumentException exe) {
			System.out.println(" Invalid USER ID! FINDING FAILED " + exe);
		}
		return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
	}

	@PostMapping(value = "/updateUser")
	public ResponseEntity<String> updateUser(@RequestBody User user) {

		Optional<User> foundUser;
		try {
			foundUser = profileRepository.findById(user.getUserid());
			if (foundUser.isPresent()) {
				profileRepository.save(user);
				return new ResponseEntity<String>("User Updated Successfully!", HttpStatus.OK);
			} else {
				return new ResponseEntity<String>("User NOT FOUND! Updation failed.", HttpStatus.NOT_FOUND);
			}
		} catch (IllegalArgumentException exe) {
			System.out.println(" Invalid USER ID! UPDATE FAILED " + exe);
		}
		return new ResponseEntity<String>(HttpStatus.NOT_FOUND);

	}

	@PostMapping(value = "/sendOtp")
	public String otp(@RequestBody String email) {
		JSONObject json = new JSONObject(email);
		SimpleMailMessage msg = new SimpleMailMessage();
		System.out.println("SendOTP Function  " + json.getString("emailid"));
		msg.setTo(json.getString("emailid"));
		msg.setSubject("OTP For Forgot Password");
		String otp = String.valueOf((long) (Math.random() * 900000) + 100000);
		msg.setText("Your OTP is :" + otp);
		try {
			javaMailSender.send(msg);
		} catch (MailAuthenticationException mailAuthExe) {
			System.out.println("JAVA MAILER AUTHENTICATION FAILED! " + mailAuthExe.getStackTrace());
		} catch (MailSendException mailSendExe) {
			System.out.println("JAVA MAIL SENDING FAILED! " + mailSendExe.getStackTrace());
		} catch (Exception e) {
			System.out.println("Exception ==" + e);
		}
		return "OTPsent";
	}

}
