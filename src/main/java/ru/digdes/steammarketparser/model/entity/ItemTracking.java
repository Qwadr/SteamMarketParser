package ru.digdes.steammarketparser.model.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * "ItemTracking" entity.
 *
 * Fields:
 * trackingId - unique identifier;
 * user - user who tracks an item;
 * item - item tracked by the user;
 * trackingStatus - is the tracking active or not.
 */
@Entity
@Data
@Table(name = "ItemTracking")
public class ItemTracking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long trackingID;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "UserID")
    private User user;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ItemID")
    private Item item;

    @Column(name = "TrackingStatus")
    private boolean trackingStatus;
}
