package ru.digdes.steammarketparser.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.digdes.steammarketparser.dto.UserDTO;
import ru.digdes.steammarketparser.model.entity.User;
import ru.digdes.steammarketparser.service.UserService;

@RestController
public class UserController {

    @Qualifier("userServiceImpl")
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public Iterable<UserDTO> allUsers() {
        return userService.getAllInDTOFormat();
    }
}
