package com.ubs.TaskManager.repository;

import org.springframework.data.repository.CrudRepository;

import com.ubs.TaskManager.model.User;

public interface UserRepository extends CrudRepository<User, Integer> {

	public User findUserByUsername(String name);
}