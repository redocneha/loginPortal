package com.example.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.model.ActiveUsers;

public interface ActiveProfileRepository extends CrudRepository<ActiveUsers, Integer> {

}
