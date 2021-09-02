package com.ubs.TaskManager.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ubs.TaskManager.model.User;
import com.ubs.TaskManager.service.UserService;

@Controller
public class RegisterController {

private Logger log = LoggerFactory.getLogger(RegisterController.class);
    
    @GetMapping("/register")
    public String getRegistration(ModelMap model) {
        return "register";
    }
    
    @Autowired
    UserService service;
    
    @PostMapping("/register")
    public ModelAndView postRegistration(ModelMap model, User user) {
        log.info("Registering user: " + user.toString());
        if(user != null && user.getPassword() != "" && user.getEmail() != "" && user.getUsername() != "") {
            service.addUser(user);
            return new ModelAndView("redirect:/show-all", model);
        } else {
            model.put("Error", "You must fill the form completely.");
            return new ModelAndView("register", model);
        }
    }
}