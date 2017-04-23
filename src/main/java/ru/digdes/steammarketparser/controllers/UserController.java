package ru.digdes.steammarketparser.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.digdes.steammarketparser.model.entity.User;
import ru.digdes.steammarketparser.service.UserService;

@RestController
public class UserController {


    @Qualifier("userServiceImpl")
    @Autowired
    private UserService users;

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public Iterable<User> allUsers() {
        return users.getAllUsers();
    }
}
