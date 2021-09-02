package com.ubs.TaskManager.controller;

import java.security.Principal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.ubs.TaskManager.model.Task;
import com.ubs.TaskManager.service.TaskService;
import com.ubs.TaskManager.service.UserService;

@Controller
public class TaskController {

    private Logger log = LoggerFactory.getLogger(TaskController.class);

    @Autowired
    TaskService taskService;

    @Autowired
    UserService userService;

    //create tasks
    @GetMapping("/create")
    public String newTaskForm(ModelMap model) {
        return "create";
    }
@PostMapping("/create")
    public RedirectView createNewTask(ModelMap model, Principal principal, Task task) {
        task.setUser(userService.getUserByName(principal.getName()));
        log.info(task.toString());
        taskService.AddTask(task);
        return new RedirectView("show-all");
    }

    //show tasks
    @GetMapping({"/", "/show-all"})
    public String showAllTasks(ModelMap model, Principal principal) {
        log.info(principal.getName());
        Iterable<Task> tasks = taskService.GetAllTasks();
        model.put("tasks", tasks);
        model.put("user", userService.getUserByName(principal.getName()));
        return "show-all";
    }

    //edit tasks
    @GetMapping("/edit/{id}")
    public String updateTaskForm(ModelMap model, @PathVariable("id") Integer id) {
        Task task = taskService.GetTaskById(id);
        log.info(task.toString());
        model.put("task", task);
        System.out.println("Yep. you find me.");
        return "update";
    }

    @PostMapping("/edit/{id}")
    public RedirectView updateTask(Principal principal, Task task, @PathVariable("id") Integer id) {
        log.info(task.toString());
        taskService.UpdateTask(task);
        return new RedirectView("/show-all");
    }

    //remove task
    @GetMapping("delete/{id}")
    public ModelAndView deleteTask(ModelMap model, @PathVariable("id") Integer id) {
        log.info("Removing task: " + id);
        Task task = taskService.GetTaskById(id);
        taskService.DeleteTask(task);
        model.put("deleted", task.getName());
        return new ModelAndView("redirect:/show-all", model);
    }
}