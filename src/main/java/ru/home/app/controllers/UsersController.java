package ru.home.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.home.app.repositories.CustomRepository;
import ru.home.app.repositories.GatesRepository;
import ru.home.app.repositories.UsersRepository;

@Controller
public class UsersController {

    private final UsersRepository repository;
    private final CustomRepository customRepository;
    private final GatesRepository gatesRepository;

    @Autowired
    public UsersController(UsersRepository repository, CustomRepository customRepository, GatesRepository gatesRepository) {
        this.repository = repository;
        this.customRepository = customRepository;
        this.gatesRepository = gatesRepository;
    }

    @ResponseBody
    @RequestMapping("/")
    public String home() {
        customRepository.sub();
        return repository.findAll().toString();
    }

    @ResponseBody
    @RequestMapping("/gates")
    public String gates() {
        return gatesRepository.findAll().toString();
    }

    @ResponseBody
    @RequestMapping("/{username}")
    public String getByUserName(@PathVariable("username") String username) {
        return repository.findByUsername(username).toString();
    }
}
