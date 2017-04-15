package ru.digdes.steammarketparser.model.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.digdes.steammarketparser.model.entity.ItemTracking;

import java.util.List;

/**
 * TODO javadoc
 */
@Repository
public interface ItemTrackingRepository extends CrudRepository<ItemTracking, Long> {
    Iterable<ItemTracking> findByUser_UserID(long userID);

    Iterable<ItemTracking> findItemTrackingsByTrackingStatusIsTrueOrderByItem_ItemID();
}
