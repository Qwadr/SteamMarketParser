package ru.digdes.steammarketparser.service;

import ru.digdes.steammarketparser.model.entity.User;

/**
 * Service providing work with users.
 */
public interface UserService {
    Iterable<User> findAll();
}
