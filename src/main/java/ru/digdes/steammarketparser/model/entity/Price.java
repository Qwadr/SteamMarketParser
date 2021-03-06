package ru.digdes.steammarketparser.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * "Price" entity.
 * Every tracked item has list of Prices.
 *
 * Fields:
 * priceID - unique identifier;
 * item - item tracked by the user;
 * value - cost as it is, BigDecimal for high accuracy;
 * scanTime - snapshot time, will be used for building graphs.
 */
@Entity
@Data
@Table(name = "Prices")
public class Price {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PriceID")
    private Long priceID;

    @JsonIgnore //TODO dto & вытащить одно поле из item
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="ItemID")
    private Item item;

    @Column(nullable = false)
    BigDecimal value;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    java.util.Date scanTime;

}
