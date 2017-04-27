package ru.digdes.steammarketparser.dto;

import lombok.Data;
import ru.digdes.steammarketparser.model.entity.Item;
import ru.digdes.steammarketparser.model.entity.ItemTracking;

import javax.persistence.Entity;

/**
 * TODO javadoc
 */
@Entity
@Data
public class ItemTrackingDTO {
    private long trackingID;

    private long userID;

    private long itemID;

    private boolean trackingStatus;

    public ItemTrackingDTO(ItemTracking itemTracking) {
        this.trackingID =     itemTracking.getTrackingID();
        this.userID =         itemTracking.getUser().getUserID();
        this.itemID =         itemTracking.getItem().getItemID();
        this.trackingStatus = itemTracking.isTrackingStatus();
    }
}
