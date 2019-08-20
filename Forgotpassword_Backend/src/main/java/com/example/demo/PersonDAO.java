package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
@Repository
public interface PersonDAO extends CrudRepository<Person,Long> {
	  @Query("SELECT ques1,ques2 FROM Person p WHERE p.email=:email")
    String findQuestionsById(String email);
	  @Query("SELECT ans1,ans2 FROM Person p WHERE p.email=:email")
    String findAnswersById(String  email);
    @Query("SELECT count(*) FROM Person p WHERE p.email=:email")
    public int findByEmail(@Param("email") String email);
    @Modifying(clearAutomatically=true)
 @Query("UPDATE Person p set p.password=:password  WHERE p.email=:email")
 int setPassword(@Param("password") String password,@Param("email") String email);
}
