package ru.digdes.steammarketparser.model.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.digdes.steammarketparser.model.entity.User;

/**
 * TODO javadoc
 */
@Repository
public interface UserRepository extends CrudRepository<User, Long> {
}
