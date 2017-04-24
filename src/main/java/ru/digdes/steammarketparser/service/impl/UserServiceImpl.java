package ru.digdes.steammarketparser.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.digdes.steammarketparser.model.entity.User;
import ru.digdes.steammarketparser.model.repository.UserRepository;
import ru.digdes.steammarketparser.service.UserService;

import javax.xml.ws.Action;

/**
 * Service access to the UserRepository.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public Iterable<User> findAll() {
        return userRepository.findAll();
    }
}
