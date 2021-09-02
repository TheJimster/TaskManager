package com.ubs.TaskManager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ubs.TaskManager.model.Task;
import com.ubs.TaskManager.repository.TaskRepository;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public Iterable<Task> GetAllTasks() {
        return taskRepository.findAll();
    }

    public Task GetTaskById(Integer id) {
        return taskRepository.findById(id).get();
    }

    public Task AddTask(Task task) {
        return taskRepository.save(task);
    }
    
    public void UpdateTask(Task task) {
        Task oldTask = taskRepository.findById(task.getId()).get();
        oldTask.setName(task.getName());
        oldTask.setStartDate(task.getStartDate());
        oldTask.setEndDate(task.getEndDate());
        oldTask.setDescription(task.getDescription());
        oldTask.setEmail(task.getEmail());
        oldTask.setSeverity(task.getSeverity());
        taskRepository.save(oldTask);
    }

    public void DeleteTask(Task task) {
        taskRepository.delete(task);
    }
}