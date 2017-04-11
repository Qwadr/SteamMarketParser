package ru.digdes.steammarketparser.model.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * "TrackingItem" entity.
 *
 * Fields:
 * trackingId - unique identifier;
 * user - user who tracks an item;
 * item - item tracked by the user;
 * trackingStatus - is the tracking active or not.
 */
@Entity
@Data
@Table(name = "TrackingItems")
public class TrackingItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int trackingID;

    @ManyToOne
    @JoinColumn(name = "UserID")
    private User user;

    @ManyToOne
    @JoinColumn(name = "ItemID")
    private Item item;

    @Column(name = "TrackingStatus")
    private boolean trackingStatus;
}
