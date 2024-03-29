package com.sapient.password;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.autoconfigure.security.servlet.ManagementWebSecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class, ManagementWebSecurityAutoConfiguration.class })
//@SpringBootApplication(exclude = {UserDetailsServiceAutoConfiguration.class})
public class ChangePasswordServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChangePasswordServiceApplication.class, args);
	}

}
