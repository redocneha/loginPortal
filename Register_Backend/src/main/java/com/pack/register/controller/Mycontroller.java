package com.pack.register.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.pack.register.model.SecurityQuestion;
import com.pack.register.model.User;
import com.pack.register.service.SecurityQuestionService;
import com.pack.register.service.UserService;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.MediaType.APPLICATION_XML_VALUE;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/users")
public class Mycontroller {

	@Autowired
	private UserService userService;

	@Autowired
	private SecurityQuestionService securityquestionService;
	@Autowired
	ObjectMapper mapper;

	@GetMapping(value = "/securityquestions")
	public List<SecurityQuestion> securityquestions() {
		System.out.println("inside security questions .....");
		return securityquestionService.findAll();
	}

	@CrossOrigin(origins = "*")
	@PostMapping(path = "/register")
	public ObjectNode saveProduct(@RequestBody User user) {
		
		ObjectNode objectNode = mapper.createObjectNode();
		
		System.out.println("inside Save .....");
		System.out.println(user);
		User temp = userService.saveUser(user);
		try {
			
			if(temp!=null) {
			objectNode.put("status", 200);
			objectNode.put("message", "Success");
			}
			else {
				objectNode.put("status", 301);
				objectNode.put("message", "DbError");
			}
	    }
	    catch (DataIntegrityViolationException e) {
	    	
	        System.out.println("history already exist");
	        objectNode.put("status", 400);
			objectNode.put("message", "User Already Exists");
	    }
		return objectNode;
	}

}
