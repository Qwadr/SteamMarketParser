package ru.digdes.steammarketparser.workers.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.digdes.steammarketparser.model.entity.Item;
import ru.digdes.steammarketparser.model.entity.ItemTracking;
import ru.digdes.steammarketparser.model.entity.Price;
import ru.digdes.steammarketparser.model.entity.User;
import ru.digdes.steammarketparser.model.enums.ItemQuality;
import ru.digdes.steammarketparser.model.repository.ItemRepository;
import ru.digdes.steammarketparser.model.repository.ItemTrackingRepository;
import ru.digdes.steammarketparser.model.repository.PriceRepository;
import ru.digdes.steammarketparser.model.repository.UserRepository;
import ru.digdes.steammarketparser.model.utils.HibernateUtil;
import ru.digdes.steammarketparser.service.HttpService;
import ru.digdes.steammarketparser.service.ItemService;
import ru.digdes.steammarketparser.service.ItemTrackingService;
import ru.digdes.steammarketparser.service.PriceParser;
import ru.digdes.steammarketparser.workers.PriceWorker;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * TODO javadoc
 */
@Component("priceWorker")
public class PriceWorkerImpl implements PriceWorker {

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private PriceRepository priceRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ItemTrackingRepository itemTrackingRepository;

    @Autowired
    private ItemTrackingService itemTrackingService;

    @Autowired
    private HttpService httpService;

    @Autowired
    private PriceParser priceParser;

    @Override
    public void collectPricesOfAllItems() {
        Iterable<ItemTracking> trackings = itemTrackingService
                .findItemTrackingsByTrackingStatusIsTrueOrderByItem_ItemID();

        System.out.println("--------------------------");

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

        Price newPrice = priceParser.parse(jsonText); //Приходит объект с заполненным полем value и только им; scanTime и item нужно заполнить

        if (newPrice != null) {
            newPrice.setScanTime(new Date(actualTime));
            newPrice.setItem(actualItem);

            actualItem.getPrices().add(newPrice); //TODO вопрос консистентности данных

           /* //прямое сохранение в базу, TODO переписать на DAO
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            try (Session session = sessionFactory.openSession()) {
                session.beginTransaction();

                session.save(newPrice);

                session.getTransaction().commit();
            }*/


            User user1 = new User();
            user1.setLogin("qwadr");
            user1.setEmail("qwadr@mail.ru");
            user1.setPassword("qwadr");
            user1.setRegistrationDate(new Date(System.currentTimeMillis()));

            Item item1 = new Item();
            item1.setName("Frost Avalanche");
            item1.setQuality(ItemQuality.ARCANA);
            item1.setSteamURL("https://steamcommunity.com/market/listings/570/Frost%20Avalanche");
            item1.setDescription("Ходят слухи, что это одеяние было свадебным платьем древней королевы. По другим сведениям оно являлось плащом ледяного огра. Однако в действительности, эти зачарованные ткани изменчивы, как лавина, и могут принимать любые формы. Эта форма привлекла одинокого волчонка, который стал выносливым и верным спутником.");

            Price price1 = new Price();
            price1.setValue(new BigDecimal(1451.46));
            price1.setScanTime(new java.util.Date(System.currentTimeMillis() - 10000));
            price1.setItem(item1);

            ItemTracking trackingItem1 = new ItemTracking();
            trackingItem1.setUser(user1);
            trackingItem1.setItem(item1);
            item1.getPrices().add(price1);
            trackingItem1.setTrackingStatus(true);

            System.out.println(newPrice.toString());
            try {
                itemRepository.save(item1);
                userRepository.save(user1);
                priceRepository.save(price1);
                itemTrackingRepository.save(trackingItem1);

                System.out.println("*************");
                System.out.println(item1.toString());
                System.out.println(user1.toString());
                System.out.println(price1.toString());
                System.out.println(trackingItem1.toString());
                System.out.println("*************");

                priceRepository.save(newPrice);
                System.out.println(newPrice.toString());
//                itemRepository.setPricesForId(actualItem.getPrices(), newPrice.getItem().getItemID());
            } catch (Exception e) {
                e.printStackTrace();
                /*System.out.println("Что-то пошло не так: " + e.getLocalizedMessage());
                System.out.println("--------------------------");*/
        }
//            itemRepository.save(newPrice.getItem());
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
