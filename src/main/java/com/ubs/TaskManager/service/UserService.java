package com.ubs.TaskManager.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ubs.TaskManager.model.User;
import com.ubs.TaskManager.model.UserPrincipal;
import com.ubs.TaskManager.repository.UserRepository;


@Service
public class UserService implements UserDetailsService {
    private Logger log = LoggerFactory.getLogger(UserService.class);
    
    @Autowired
    PasswordEncoder passwordEncoder;
    
    @Autowired
    UserRepository userRepo;
    
    public User addUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        log.info("User added: " + user.toString());
        return userRepo.save(user);
    }
    
    public User getUserByName(String name) {
        return userRepo.findUserByUsername(name);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findUserByUsername(username);
        log.info("Loading user: " + user.toString());
        return new UserPrincipal(user);
    }

}