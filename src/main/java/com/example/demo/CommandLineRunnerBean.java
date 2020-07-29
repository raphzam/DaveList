package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CommandLineRunnerBean implements CommandLineRunner {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    public void run(String...strings){
        User user = new User();
        user.setUsername("DaveWolf");
        user.setPassword("beastmaster");
        user.setEnabled(true);

        Role role = new Role();
        role.setUsername("DaveWolf");
        role.setRole("ROLE_ADMIN");

        userRepository.save(user);
        roleRepository.save(role);


    }
}
