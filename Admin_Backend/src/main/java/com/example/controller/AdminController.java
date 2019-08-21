package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AdminController {
	@Autowired
	private ActiveProfileRepository activeProfileRepository;
	@Autowired
	private ProfileRepository profileRepository;

	@PostMapping(value = "/putData")
	public ResponseEntity<String> addNewUser(@RequestBody ActiveUsers activeUser) {

		System.out.println(activeUser);
		activeProfileRepository.save(activeUser);
		//return "Saved";
		return new ResponseEntity<String>("Response entity return from addnewUser",HttpStatus.OK);

	}

	@GetMapping(value = "/getAll")
	public ResponseEntity<Iterable<User>> findAll() {
		System.out.println("getting user");
		System.out.println("***********************");
		Iterable<User> u1=profileRepository.findAll();
		return ResponseEntity.ok().body(u1);
	}

	@GetMapping(value = "/getActiveUsers")
	public ResponseEntity<Iterable<ActiveUsers>> findActiveUsers() {
		System.out.println("getting user");
		System.out.println("***********************");
		Iterable<ActiveUsers> a1=activeProfileRepository.findAll();
		return ResponseEntity.ok().body(a1);
	}

}
