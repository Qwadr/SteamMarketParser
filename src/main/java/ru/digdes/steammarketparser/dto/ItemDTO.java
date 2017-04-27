package ru.digdes.steammarketparser.dto;

import lombok.Data;
import ru.digdes.steammarketparser.model.entity.Item;
import ru.digdes.steammarketparser.model.entity.Price;
import ru.digdes.steammarketparser.model.enums.ItemQuality;

import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.List;

/**
 * TODO javadoc
 */
@Entity
@Data
public class ItemDTO {
    private long itemID;

    private String name;

    private ItemQuality quality;

    private String steamURL;

    private String description;

    private List<PriceDTO> prices;

    public ItemDTO(Item item) {
        this.itemID = item.getItemID();
        this.name = item.getName();
        this.quality = item.getQuality();
        this.steamURL = item.getSteamURL();
        this.description = item.getDescription();
        this.prices = new ArrayList<>();
        for (Price price : item.getPrices()) {
            this.prices.add(new PriceDTO(price));
        }
    }
}
