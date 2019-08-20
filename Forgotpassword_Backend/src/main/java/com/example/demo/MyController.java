package com.example.demo;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

@RestController
@RequestMapping("/forgotpassword")
public class MyController {
	String email;
	@Autowired
	private JavaMailSender javaMailSender;
	@Autowired
	private ForgotPwdService fgps=new ForgotPwdServiceImpl();
	@Autowired
	private ObjectMapper mapper;
	String otp;
	@CrossOrigin(origins= {"http://10.150.223.154:3003","http://localhost:3000"})
	@PostMapping("/uic")
	
	public String getValidation( @RequestBody Person p) {
	
		String p1=p.getEmail();
		email=p1;
		ObjectNode jsonObject = mapper.createObjectNode();
		
		// don't forget to change return type to support this
		if(fgps.findByEmail(p1))
		{
			
			jsonObject.put("status", "true");
			
		}
		else
			jsonObject.put("status", "false");
		String str=jsonObject.toString();
		 System.out.println(str);
		return str;
   
     
                   }
	@RequestMapping("/")
	public String demo()
	{
		return "hi";
	}
	@CrossOrigin(origins={"http://localhost:3000","http://10.150.223.154:3003"})
	@PostMapping("/otp")
	public String validateOTP( @RequestBody Person p) {
		ObjectNode jsonObject = mapper.createObjectNode();
		System.out.println(p.getOtp());
	if(p.getOtp().equals(otp))
	{
		jsonObject.put("status", "true");
	}
	else
		jsonObject.put("status", "false");
	String str=jsonObject.toString();
	return str;
	}
	

	
	@CrossOrigin(origins={"http://localhost:3000","http://10.150.223.154:3003"})
	@PostMapping("/mts")
	public String  methodToSet( @RequestBody Person p) {
		
	String email=p.getEmail();
	System.out.println(email);
	ObjectNode jsonObject = mapper.createObjectNode();
	String  c=p.getChoice();
	System.out.println(c);
	if(c.equals("2")) {
		
			SimpleMailMessage msg = new SimpleMailMessage();
			msg.setTo(email);
			System.out.println(email);
			msg.setSubject("OTP For Forgot Password");
			otp = String.valueOf((long) (Math.random() * 9000) + 1000);
			msg.setText("Your OTP is :" + otp);
			System.out.println(otp);
			javaMailSender.send(msg);
			System.out.println(otp);
				

		jsonObject.put("otp", otp);
		  
	}
	
   if(c.equals("3")) {
	  
	   String al=fgps.findQuestionsById(email);
	   System.out.println(al);
	  al= al.replace('[', ' ');
	  al= al.replace(']', ' ');
	  String[] q=al.split(",");
	   jsonObject.put("question1", q[0]);
	   System.out.println(q[0]);
	   jsonObject.put("question2", q[1]);
	   
	  
	  

    
	        
	}
   String str=jsonObject.toString();
   System.out.println(str);
	return str;

	}
	
 
	
	@CrossOrigin(origins={"http://localhost:3000","http://10.150.223.154:3003"})
	@PostMapping("/sec")
	public String security( @RequestBody Person p) {
		
		System.out.println("hi");
			ObjectNode jsonObject = mapper.createObjectNode();
	    if(securityQuestionsCheck(p))
	    {
	    	
	    	  jsonObject.put("status", "true");
	    	 
	    }
		
		else
		{
			 jsonObject.put("status", "false");
		      
	    	  
		}
	    String str=jsonObject.toString();
		return str;
		}
		
	
	private boolean securityQuestionsCheck(Person p) {
		// TODO Auto-generated method stub
		System.out.println("hi");
		String email=p.getEmail();
		System.out.println(email);
		ArrayList<String> al2=new ArrayList<String>();
		String al=fgps.findAnswersById(email);
		   System.out.println(al);
		  al= al.replace('[', ' ');
		  al= al.replace(']', ' ');
		  String[] q=al.split(",");
		   
		   
		
	if(q[0].equals(p.getAns1())&&q[1].equals(p.getAns2()))
		
		return true;
	else
		return false;
	}
	
	@CrossOrigin(origins= {"http://localhost:3000","http://10.150.223.154:3003"})
	@PostMapping("/set")
	public String setPassword( @RequestBody Person p) {
		
		ObjectNode jsonObject = mapper.createObjectNode();
		System.out.println("hi from set");
		
		String pass=p.getPassword();
		
		System.out.println(pass);
		if(fgps.setPassword(pass, email))
			jsonObject.put("status", "true");
		else
	    	  jsonObject.put("status", "false");
	    	  String str=jsonObject.toString();
	    	  System.out.println(str);
	  		return str;
	      
	    }
}
