package ru.digdes.steammarketparser.model.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.digdes.steammarketparser.model.entity.Item;

import java.util.Set;

/**
 * TODO javadoc
 */
@Repository
public interface ItemRepository extends CrudRepository<Item, Long> {
}
