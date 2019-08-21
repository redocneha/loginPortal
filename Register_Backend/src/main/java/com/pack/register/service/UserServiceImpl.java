package com.pack.register.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pack.register.model.CustomPasswordEncoder;
import com.pack.register.model.Password;
import com.pack.register.model.SecurityAnswer;
import com.pack.register.model.SecurityQuestion;
import com.pack.register.model.User;
import com.pack.register.repository.UserRepository;

@Service(value = "userService")

public class UserServiceImpl implements UserService {
	@Autowired
    @Qualifier(value = "userRepository")
    UserRepository userrepo;
	
	@Autowired 
	CustomPasswordEncoder cutompasswordencoder;
	
	
    public UserServiceImpl(UserRepository userrepo){
        this.userrepo = userrepo;
    }
    //@Transactional
	public void saveUser(User user) {
		
//		//System.out.println(user.getSecurityquestion1());
//		//System.out.println(user.getSecurityquestion2());
//		long secqueId1 = userrepo.findquestionId(user.getSecurityquestion1());
//		long secqueId2 = userrepo.findquestionId(user.getSecurityquestion2());
//		SecurityAnswer temp = user.getSecurityAns();
//		temp.setSecurityQueID1(secqueId1);
//		temp.setSecurityQueID2(secqueId2);
//		user.setSecurityAns(temp);
//	//	System.out.println(temp);
		
		//Password Encrypt
		String salt1 = BCrypt.gensalt(12);
		Password pwd = user.getPasswordHistory();
		String hashpwd1= cutompasswordencoder.encodeWithSalt(pwd.getPwd1(),salt1);
		
		pwd.setPwd1(hashpwd1);
		pwd.setSalt1(salt1);
		user.setPasswordHistory(pwd);
    	userrepo.save(user);
	}

	 
}
