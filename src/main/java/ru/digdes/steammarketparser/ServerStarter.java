package ru.digdes.steammarketparser;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.PropertySource;
import ru.digdes.steammarketparser.model.entity.Item;
import ru.digdes.steammarketparser.model.entity.User;
import ru.digdes.steammarketparser.model.enums.ItemQuality;
import ru.digdes.steammarketparser.model.utils.HibernateUtil;

import java.io.IOException;
import java.util.Date;

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

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();

            session.save(newItem);
            session.save(newUser);

            session.getTransaction().commit();
        }

        System.out.println("Весь предыдущий код отработал. Чекай базу.");

    }
}
