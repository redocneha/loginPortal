package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.SecurityQuestion;
import com.example.demo.model.User;

@Repository("securityQuestionRepository")

public interface SecurityQuestionRepository extends JpaRepository<SecurityQuestion,Integer> {

}
