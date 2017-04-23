package ru.digdes.steammarketparser.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.digdes.steammarketparser.model.entity.User;

/**
 * TODO javadoc
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
