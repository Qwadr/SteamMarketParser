package ru.digdes.steammarketparser.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.digdes.steammarketparser.model.entity.ItemTracking;
import ru.digdes.steammarketparser.model.repository.ItemTrackingRepository;
import ru.digdes.steammarketparser.service.ItemTrackingService;

/**
 * TODO javadoc
 */
@Service
public class ItemTrackingServiceImpl implements ItemTrackingService{

    private final ItemTrackingRepository itemTrackingRepository;

    @Autowired
    public ItemTrackingServiceImpl(ItemTrackingRepository itemTrackingRepository) {
        this.itemTrackingRepository = itemTrackingRepository;
    }

    @Override
    public Iterable<ItemTracking> findAll() {
        return itemTrackingRepository.findAll();
    }

    @Override
    public ItemTracking findByID(long trackingID) {
        return itemTrackingRepository.findOne(trackingID);
    }

    @Override
    public Iterable<ItemTracking> findItemTrackingsByTrackingStatusIsTrueOrderByItem_ItemID() {
        return itemTrackingRepository.findItemTrackingsByTrackingStatusIsTrueOrderByItem_ItemID();
    }

    @Override
    public Iterable<ItemTracking> findTrackingsByUserID(long userID) {
        return itemTrackingRepository.findByUser_UserID(userID);
    }

    @Override
    public ItemTracking save(ItemTracking tracking) {
        return itemTrackingRepository.save(tracking);
    }
}
