package ru.digdes.steammarketparser.server.workers;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.digdes.steammarketparser.model.entity.Item;
import ru.digdes.steammarketparser.model.entity.ItemTracking;
import ru.digdes.steammarketparser.model.entity.Price;
import ru.digdes.steammarketparser.model.utils.HibernateUtil;
import ru.digdes.steammarketparser.service.HttpService;
import ru.digdes.steammarketparser.service.ItemTrackingService;
import ru.digdes.steammarketparser.service.PriceParser;

import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * TODO javadoc
 */
@Component
public class PriceWorker {

    @Autowired
    private ItemTrackingService itemTrackingService;

    @Autowired
    private HttpService httpService;

    @Autowired
    private PriceParser priceParser;

    public void start() {
        Iterable<ItemTracking> trackings = itemTrackingService
                .findItemTrackingsByTrackingStatusIsTrueOrderByItem_ItemID();

        Item actualItem = null;

        for (ItemTracking itemTracking : trackings) {
            if (actualItem != itemTracking.getItem() && itemTracking.isTrackingStatus()) {
                actualItem = itemTracking.getItem();
                collectInfo(actualItem);
            }
        }
    }

    private void collectInfo(Item actualItem) {
        long actualTime = System.currentTimeMillis();
        String url = buildSteamPricesUrlString(actualItem.getName());
        String jsonText = httpService.getUrl(url);

        Price newPrice = priceParser.parse(jsonText); //Приходит объект с заполненным полем value и только им.

        if (newPrice != null) {
            newPrice.setScanTime(new Date(actualTime));
            newPrice.setItem(actualItem);

            actualItem.getPrices().add(newPrice); //вопрос консистентности данных

            //прямое сохранение в базу, TODO переписать на DAO
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            try (Session session = sessionFactory.openSession()) {
                session.beginTransaction();

                session.save(newPrice);

                session.getTransaction().commit();
            }
        } else {
            Logger.getGlobal().log
                    (Level.INFO, "Невозможен сбор информации для предмета с ID = "
                            + actualItem.getItemID()
                            + " и именем = \"" + actualItem.getName()
                            + "\"; необходимо срочно проверить корректность имени данного предмета.");

        }
    }

    private String buildSteamPricesUrlString(String officialAndCorrectNameOfItem) {
        StringBuilder answer = new StringBuilder
                ("http://steamcommunity.com/market/priceoverview/?appid=570&currency=5&market_hash_name=");
        String[] partsOfName = officialAndCorrectNameOfItem.split(" ");
        for (int i = 0; i < partsOfName.length - 1; i++) {
            answer.append(partsOfName[i]).append("%20");
        }
        answer.append(partsOfName[partsOfName.length - 1]);
        return answer.toString();
    }
}
