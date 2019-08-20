package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.demo.model.SecurityQuestion;
import com.example.demo.repository.SecurityQuestionRepository;
import com.example.demo.repository.UserRepository;


@Service(value = "securityQuestionService")
public class SecurityQuestionServiceImpl implements SecurityQuestionService {

	@Autowired
    @Qualifier(value = "securityQuestionRepository")
	SecurityQuestionRepository securityQuestionRepository;
	
	@Override
	public List<SecurityQuestion> findAll() {
		// TODO Auto-generated method stub
		
		List<SecurityQuestion> temp =securityQuestionRepository.findAll();
		System.out.println("temp");
		System.out.println(temp);
		return temp;
	}

}
