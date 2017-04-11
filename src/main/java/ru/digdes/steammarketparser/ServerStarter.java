package ru.digdes.steammarketparser;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.PropertySource;
import ru.digdes.steammarketparser.model.entity.Item;
import ru.digdes.steammarketparser.model.entity.Price;
import ru.digdes.steammarketparser.model.entity.TrackingItem;
import ru.digdes.steammarketparser.model.entity.User;
import ru.digdes.steammarketparser.model.enums.ItemQuality;
import ru.digdes.steammarketparser.model.utils.HibernateUtil;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Entry point of the application.
 * Class checks the database.
 * In future all database logic will be transferred
 * to another classes.
 */
public class ServerStarter {

    public static void main(String[] args) throws IOException {
        Item newItem = new Item();
        newItem.setName("Tempest Helm of the Thundergod");
        newItem.setQuality(ItemQuality.ARCANA);
        newItem.setSteamURL("https://steamcommunity.com/market/listings/570/Exalted%20Tempest%20Helm%20of%20the%20Thundergod");
        newItem.setDescription("Этот шлем, выкованный кланом Молотов Целестарра и наполненный энергией древних, словно влитой сидит на челе самого Повелителя небес. Неверующие содрогнутся, когда заслышат над полем боя раскаты грома!");

        User newUser = new User();
        newUser.setLogin("qwadr");
        newUser.setEmail("qwadr@qwadr");
        newUser.setPassword("qwadr");
        newUser.setRegistrationDate(new Date(System.currentTimeMillis()));

        Price price1 = new Price();
        price1.setValue(new BigDecimal(1451.46));
        price1.setScanTime(new java.util.Date(System.currentTimeMillis() - 10000));
        price1.setItem(newItem);

        Price price2 = new Price();
        price2.setValue(new BigDecimal(2389.09));
        price2.setScanTime(new java.util.Date(System.currentTimeMillis()));
        price2.setItem(newItem);

        TrackingItem trackingItem1 = new TrackingItem();
        trackingItem1.setItem(newItem);
        trackingItem1.setUser(newUser);
        trackingItem1.setTrackingStatus(true);

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();

            session.save(newItem);
            session.save(newUser);
            session.save(price1);
            session.save(price2);
            session.save(trackingItem1);

            session.getTransaction().commit();
        }

        System.out.println("Весь предыдущий код отработал. Чекай базу.");

    }
}
