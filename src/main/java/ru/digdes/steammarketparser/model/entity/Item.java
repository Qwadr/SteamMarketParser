package ru.digdes.steammarketparser.model.entity;

import ru.digdes.steammarketparser.model.enums.ItemQuality;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * "Item" entity.
 * Describes all the fields of this entity.
 */
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

    @Column(name = "Description", columnDefinition = "date")
    private String description;

    public Item() {

    }

    public long getItemID() {
        return itemID;
    }

    public String getName() {
        return name;
    }

    public ItemQuality getQuality() {
        return quality;
    }

    public String getSteamURL() {
        return steamURL;
    }

    public String getDescription() {
        return description;
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
