package com.sapient.password.model;

import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.password.PasswordEncoder;

public class CustomPasswordEncoder implements PasswordEncoder{
	
	public String encodeWithSalt(CharSequence rawPassword, String salt){
		return BCrypt.hashpw(rawPassword.toString(), salt);
	}
	
	@Override
	public String encode(CharSequence rawPassword) {
		// TODO Auto-generated method stub
		return BCrypt.hashpw(rawPassword.toString(), BCrypt.gensalt(12));
	}

	@Override
	public boolean matches(CharSequence rawPassword, String encodedPassword) {
		// TODO Auto-generated method stub
		return BCrypt.checkpw(rawPassword.toString(), encodedPassword);
	}
	
}
