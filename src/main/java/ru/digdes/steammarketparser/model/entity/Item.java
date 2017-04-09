package ru.digdes.steammarketparser.model.entity;

import ru.digdes.steammarketparser.model.enums.ItemQuality;

import javax.persistence.*;

/**
 * "Item" entity.
 * Describes all the fields of this entity.
 */
@Entity
@Table(name = "Item")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ItemID")
    private long itemID;

    private String name;
    private ItemQuality quality;
    private String steamURL;
    private String description;

    public Item() {
    }

    @Column(name = "Name", nullable = false)
    public String getName() {
        return name;
    }

    @Column(name = "Quality", nullable = false)
    public ItemQuality getQuality() {
        return quality;
    }

    @Column(name = "SteamURL", nullable = false)
    public String getSteamURL() {
        return steamURL;
    }

    @Column(name = "Description", columnDefinition = "text")
    public String getDescription() {
        return description;
    }

    public long getItemID() {
        return itemID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setQuality(ItemQuality quality) {
        this.quality = quality;
    }

    public void setSteamURL(String steamURL) {
        this.steamURL = steamURL;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}
