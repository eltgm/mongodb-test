package ru.home.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.home.app.repositories.CustomRepository;
import ru.home.app.repositories.UsersRepository;

@Controller
public class UsersController {

    @Autowired
    private UsersRepository repository;
    @Autowired
    private CustomRepository customRepository;

    @ResponseBody
    @RequestMapping("/")
    public String home() {
        customRepository.sub();
        return repository.findAll().toString();
    }

    @ResponseBody
    @RequestMapping("/{username}")
    public String getByUserName(@PathVariable("username") String username) {
        return repository.findByUsername(username).toString();
    }
}
