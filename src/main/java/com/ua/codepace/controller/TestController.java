package com.ua.codepace.controller;

import com.ua.codepace.model.User;
import com.ua.codepace.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Controller
@RequestMapping("/test")
public class TestController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/save-rand")
    @ResponseBody
    public String save() {
        userRepository.save(new User("User" + Math.random()));
        return "Saved";
    }

    @RequestMapping("/get-all")
    @ResponseBody
    public List<String> getUsers() {
        return userRepository.findAll()
                .stream()
                .map(User::getName)
                .collect(toList());
    }
}
