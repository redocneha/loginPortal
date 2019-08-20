package com.example.demo;

import java.util.ArrayList;
import java.util.List;



public interface ForgotPwdService   {
	 boolean findByEmail(String email);
	    String findQuestionsById(String email);
	    String findAnswersById(String  email);
    boolean setPassword(String pass,String email);

}
