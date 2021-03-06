package ru.digdes.steammarketparser.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.digdes.steammarketparser.model.entity.Item;
import ru.digdes.steammarketparser.model.entity.Price;


/**
 * TODO javadoc
 */
@Repository
@Transactional
public interface ItemRepository extends JpaRepository<Item, Long> {

/*    @Query("UPDATE Item c set c.prices = :prices WHERE c.itemID = :id")
    Integer setPricesForId(@Param("prices") List<Price> a, @Param("id") long itemID);*/

}
