package com.ubs.TaskManager.repository;

import org.springframework.data.repository.CrudRepository;

import com.ubs.TaskManager.model.Task;

public interface TaskRepository extends CrudRepository<Task, Integer> {

}