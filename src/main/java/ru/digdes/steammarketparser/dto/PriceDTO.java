package ru.digdes.steammarketparser.dto;

import lombok.Data;
import ru.digdes.steammarketparser.model.entity.Price;

import javax.persistence.Entity;
import java.math.BigDecimal;
import java.util.Date;

/**
 * TODO javadoc
 */
@Entity
@Data
public class PriceDTO {
    private long priceID;

    private long itemID;

    BigDecimal value;

    java.util.Date scanTime;

    public PriceDTO(Price price) {
        this.priceID  = price.getPriceID();
        this.itemID   = price.getItem().getItemID();
        this.value    = price.getValue();
        this.scanTime = price.getScanTime();
    }
}
