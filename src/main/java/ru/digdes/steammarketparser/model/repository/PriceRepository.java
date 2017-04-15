package ru.digdes.steammarketparser.model.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.digdes.steammarketparser.model.entity.Price;

/**
 * TODO javadoc
 */
@Repository
public interface PriceRepository extends CrudRepository<Price, Long> {
}
