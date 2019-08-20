package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.ActiveUsers;
import com.example.model.User;
import com.example.repository.ActiveProfileRepository;
import com.example.repository.ProfileRepository;

@RestController
@RequestMapping("/")
public class AdminController {
	@Autowired
	private ActiveProfileRepository activeProfileRepository;
	@Autowired
	private ProfileRepository profileRepository;

	@PostMapping(value = "/putData")
	public String addNewUser(@RequestBody ActiveUsers activeUser) {

		System.out.println(activeUser);
		activeProfileRepository.save(activeUser);
		return "Saved";
	}

	@GetMapping(value = "/getAll")
	public Iterable<User> findAll() {
		System.out.println("getting user");
		return profileRepository.findAll();
	}

	@GetMapping(value = "/getActiveUsers")
	public Iterable<ActiveUsers> findActiveUsers() {
		System.out.println("getting user");
		return activeProfileRepository.findAll();
	}

}
