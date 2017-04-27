package ru.digdes.steammarketparser.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.digdes.steammarketparser.dto.ItemTrackingDTO;
import ru.digdes.steammarketparser.model.entity.Item;
import ru.digdes.steammarketparser.model.entity.ItemTracking;
import ru.digdes.steammarketparser.model.repository.ItemTrackingRepository;
import ru.digdes.steammarketparser.service.ItemTrackingService;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO javadoc
 */
@Service
public class ItemTrackingServiceImpl implements ItemTrackingService {

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

    @Override
    public Iterable<ItemTrackingDTO> getAllInDTOFormat() {
        Iterable<ItemTracking> trackings = itemTrackingRepository.findAll();
        List<ItemTrackingDTO> trackingDTOs = new ArrayList<>();

        for (ItemTracking itemTracking : trackings) {
            trackingDTOs.add(new ItemTrackingDTO(itemTracking));
        }

        return trackingDTOs;
    }
}
