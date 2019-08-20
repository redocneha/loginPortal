package com.sapient.data.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sapient.data.model.User;


@Repository
public interface DataDao extends CrudRepository<User, Long>{
	
	 @Query(value = "SELECT * FROM LOGINDETAILS WHERE EMAILID = ?1", nativeQuery = true)
	 Optional<User> findByEmailID(String emailID);
	 
	 @Query(value = "SELECT * FROM LOGINDETAILS WHERE USERID = ?1", nativeQuery = true)
	 Optional<User> findByUserID(Long userID);
	 
	 @Modifying
	 @Query(value = "UPDATE LOGINDETAILS SET HASHEDPWD = :hpwd, SALT = :salt WHERE EMAILID = :email",nativeQuery = true)
	 int updateByEmailID(@Param("email")String emailID, @Param("hpwd")String HashedPwd, @Param("salt")String Salt);
	 
	 @Modifying
	 @Query(value = "UPDATE LOGINDETAILS SET HASHEDPWD = :hpwd, SALT = :salt WHERE USERID = :uid",nativeQuery = true)
	 int updateByUserID(@Param("uid")Long userID, @Param("hpwd")String HashedPwd, @Param("salt")String Salt);
}
