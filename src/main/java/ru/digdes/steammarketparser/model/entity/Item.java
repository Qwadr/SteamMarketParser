package ru.digdes.steammarketparser.model.entity;

import lombok.Data;
import ru.digdes.steammarketparser.model.enums.ItemQuality;

import javax.persistence.*;
import java.util.List;

/**
 * "Item" entity.
 * Describes all the fields of this entity.
 *
 * Fields:
 * itemID - unique identifier;
 * name - full name of the item on the Steam Community Market;
 * quality - quality of the item (see ru.digdes.steammarketparser.model.enums.ItemQuality);
 * SteamURL - link to the item page on Steam Community Market;
 * description - text description from Steam Community Market;
 * prices - in short, tracking result.
 */
@Entity
@Data
@Table(name = "Items")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ItemID")
    private long itemID;

    @Column(name = "Name", nullable = false)
    private String name;

    @Column(name = "Quality", nullable = false)
    private ItemQuality quality;

    @Column(name = "SteamURL", nullable = false)
    private String steamURL;

    @Column(name = "Description", columnDefinition = "text")
    private String description;

    @OneToMany
    @JoinColumn(name="ItemID")
    private List<Price> prices;

    @Override
    public String toString() {
        return "Item{" +
                "itemID=" + itemID +
                ", name='" + name + '\'' +
                ", quality=" + quality +
                ", steamURL='" + steamURL + '\'' +
                ", description='" + description + '\'' +
                ", number of price snapshots=" + prices.size() +
                '}';
    }
}
