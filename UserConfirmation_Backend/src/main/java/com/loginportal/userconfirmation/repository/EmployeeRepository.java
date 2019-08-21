package com.loginportal.userconfirmation.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.loginportal.userconfirmation.model.Register;

@Repository
public interface EmployeeRepository extends CrudRepository<Register, Long>{

}
