package ru.digdes.steammarketparser.service;

import org.springframework.stereotype.Service;
import ru.digdes.steammarketparser.model.entity.ItemTracking;

/**
 * TODO javadoc
 */
public interface ItemTrackingService {
    Iterable<ItemTracking> findAll();

    ItemTracking findByID(long trackingID);

    Iterable<ItemTracking> findTrackingsByUserID(long userID);

    Iterable<ItemTracking> findItemTrackingsByTrackingStatusIsTrueOrderByItem_ItemID();

    ItemTracking save(ItemTracking tracking);
}
