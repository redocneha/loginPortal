package com.pack.register.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pack.register.model.SecurityQuestion;
import com.pack.register.model.User;

@Repository("userRepository")
public interface UserRepository extends JpaRepository<User,Integer>{
	

}
