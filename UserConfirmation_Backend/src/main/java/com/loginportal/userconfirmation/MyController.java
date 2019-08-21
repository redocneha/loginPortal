package com.loginportal.userconfirmation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.loginportal.userconfirmation.model.Register;
import com.loginportal.userconfirmation.service.EmployeeService;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.MediaType.APPLICATION_XML_VALUE;

import java.sql.Timestamp;
import java.util.Date;
import java.util.NoSuchElementException;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@CrossOrigin(origins="http://localhost:8882")
@RestController
@RequestMapping("/api/v1")
public class MyController{
	
	@Autowired
    private JavaMailSender javaMailSender;
	
	@Autowired
	ObjectMapper mapper;
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping(value="/sendmail/{uid}")
	public Object sendingEmail(@PathVariable("uid") String userid) {
		long id = Long.parseLong(userid);
		//System.out.println(userid);
		
		ObjectNode o = mapper.createObjectNode();
		
		
		try {
			Register e = employeeService.findById(id);
			//o.put("response", "Email Has been successfully sent"); 
			if(e.isEmailConfirmationFlag() == true) {
				o.put("response", "User already verified");
			}
			else {
				e.setEmailConfirmationFlag(true);
				Date date = new Date();    
			    Timestamp accountCreationTime = new Timestamp(date.getTime());
				e.setAccountCreationTime(accountCreationTime);
	        	Register a = employeeService.save(e);
	        	if(a != null) {
	        		o.put("response", "Congrats! Your account has been successfully activated...");
	        	}
	        	else {
	        		o.put("response", "Error...");
	        	}
				
//				try {
//	        		employeeService.sendEmail(e.getEmailID(),e.getUserID());
//	        		o.put("response", "Email Has been successfully sent");  
//	            } 
//	        	catch (MessagingException me) {
//	                me.printStackTrace();
//	                o.put("response", "Error in sending mail");
//	            }
			}
		}
    	catch(NoSuchElementException e) {
    		e.printStackTrace();
    		o.put("response", "Not a valid id");
    	}
		return o;
	}
    
	/*
	 * public void sendEmail(String email, String uid) { SimpleMailMessage msg = new
	 * SimpleMailMessage(); msg.setTo(email);
	 * msg.setSubject("Account Activation Link"); String url =
	 * "http:localhost:8765/api/v1/confirmmail/" + uid;
	 * msg.setText("Click on the following link to activate your account :" + url,
	 * "UTF-8", "html"); javaMailSender.send(msg); }
	 */
    
    @GetMapping(value="/confirmmail/{uid}")
   	public Object confirmingEmail(@PathVariable("uid") String userId) {
    	long id = Long.parseLong(userId);
    	
    	ObjectNode o = mapper.createObjectNode();
    	
    	try {
    		Register e = employeeService.findById(id);
        	
        	if(e.isEmailConfirmationFlag() == true) {
        		o.put("response", "User already verified");
        	}
        	else {
        		e.setEmailConfirmationFlag(true);
            	Register a = employeeService.save(e);
            	
            	if(a != null) {
            		o.put("response", "Congrats! Your account has been successfully activated...");
            	}
            	else {
            		o.put("response", "Error...");
            	}
        	}
    	}
    	catch(NoSuchElementException e) {
    		e.printStackTrace();
    		o.put("response", "Not a valid id");
    	}
    	
    	//String email = "sanketgiri48@gmail.com";
        //sendEmail(email,uid);
   		//return "<h1>Congrats! Your account with UserId : " + userId + " has been successfully activated...</h1>";
		return o;
    }
}
