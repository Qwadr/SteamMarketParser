//package ru.digdes.steammarketparser.model.utils;
//
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import ru.digdes.steammarketparser.model.entity.Item;
//import ru.digdes.steammarketparser.model.entity.ItemTracking;
//import ru.digdes.steammarketparser.model.entity.Price;
//import ru.digdes.steammarketparser.model.entity.User;
//import ru.digdes.steammarketparser.model.enums.ItemQuality;
//
//import java.math.BigDecimal;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//
///**
// * Fills the database with test data
// */
//public class InitialDataGenerator {
//    private static SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
//    private static List<User> userList;
//    private static List<Item> itemList;
//
//    public static void generateAll() {
//        generateUsers();
//        generateItems();
//        generatePrices();
//        generateTracking();
//    }
//
//    private static void generateUsers() {
//        List<User> listOfUsers = new ArrayList<>();
//
//        User user1 = new User();
//        user1.setLogin("qwadr");
//        user1.setEmail("qwadr@mail.ru");
//        user1.setPassword("qwadr");
//        user1.setRegistrationDate(new Date(System.currentTimeMillis()));
//
//        User user2 = new User();
//        user2.setLogin("Masha");
//        user2.setEmail("Masha@mail.ru");
//        user2.setPassword("Masha");
//        user2.setRegistrationDate(new Date(System.currentTimeMillis()));
//
//        User user3 = new User();
//        user3.setLogin("Vasya");
//        user3.setEmail("Vasya@mail.ru");
//        user3.setPassword("Vasya");
//        user3.setRegistrationDate(new Date(System.currentTimeMillis()));
//
//        User user4 = new User();
//        user4.setLogin("Petya");
//        user4.setEmail("Petya@mail.ru");
//        user4.setPassword("Petya");
//        user4.setRegistrationDate(new Date(System.currentTimeMillis()));
//
//        listOfUsers.add(user1);
//        listOfUsers.add(user2);
//        listOfUsers.add(user3);
//        listOfUsers.add(user4);
//
//        commitList(listOfUsers);
//
//        userList = listOfUsers;
//    }
//
//    private static void generateItems() {
//        List<Item> listOfItems = new ArrayList<>();
//
//        Item item1 = new Item();
//        item1.setName("Frost Avalanche");
//        item1.setQuality(ItemQuality.ARCANA);
//        item1.setSteamURL("https://steamcommunity.com/market/listings/570/Frost%20Avalanche");
//        item1.setDescription("Ходят слухи, что это одеяние было свадебным платьем древней королевы. По другим сведениям оно являлось плащом ледяного огра. Однако в действительности, эти зачарованные ткани изменчивы, как лавина, и могут принимать любые формы. Эта форма привлекла одинокого волчонка, который стал выносливым и верным спутником.");
//
//        Item item2 = new Item();
//        item2.setName("Tempest Helm of the Thundergod");
//        item2.setQuality(ItemQuality.ARCANA);
//        item2.setSteamURL("https://steamcommunity.com/market/listings/570/Exalted%20Tempest%20Helm%20of%20the%20Thundergod");
//        item2.setDescription("Этот шлем, выкованный кланом Молотов Целестарра и наполненный энергией древних, словно влитой сидит на челе самого Повелителя небес. Неверующие содрогнутся, когда заслышат над полем боя раскаты грома!");
//
//        Item item3 = new Item();
//        item3.setName("Blades of Voth Domosh");
//        item3.setQuality(ItemQuality.ARCANA);
//        item3.setSteamURL("https://http://steamcommunity.com/market/listings/570/Blades%20of%20Voth%20Domosh");
//        item3.setDescription("Встав на путь мести против бездны, Тресдин посетила кузнеца Квита, о котором ходила недобрая молва. Он подарил ей эти адские клинки. Но слишком поздно может прийти осознание факта, что цена за использование такой силы будет намного больше того, с чем она готова расстаться...");
//
//        listOfItems.add(item1);
//        listOfItems.add(item2);
//        listOfItems.add(item3);
//
//        commitList(listOfItems);
//
//        itemList = listOfItems;
//    }
//
//    private static void generatePrices() {
//        List<Price> listOfPrices = new ArrayList<>();
//
//        Price price1 = new Price();
//        price1.setValue(new BigDecimal(1451.46));
//        price1.setScanTime(new java.util.Date(System.currentTimeMillis() - 10000));
//        price1.setItem(itemList.get(0));
//
//        Price price2 = new Price();
//        price2.setValue(new BigDecimal(2389.09));
//        price2.setScanTime(new java.util.Date(System.currentTimeMillis() - 4000));
//        price2.setItem(itemList.get(0));
//
//        Price price3 = new Price();
//        price3.setValue(new BigDecimal(1632.51));
//        price3.setScanTime(new java.util.Date(System.currentTimeMillis() - 5000));
//        price3.setItem(itemList.get(1));
//
//        Price price4 = new Price();
//        price4.setValue(new BigDecimal(2145.23));
//        price4.setScanTime(new java.util.Date(System.currentTimeMillis() - 2000));
//        price4.setItem(itemList.get(1));
//
//        Price price5 = new Price();
//        price5.setValue(new BigDecimal(1562.89));
//        price5.setScanTime(new java.util.Date(System.currentTimeMillis() - 3000));
//        price5.setItem(itemList.get(2));
//
//        Price price6 = new Price();
//        price6.setValue(new BigDecimal(2156.73));
//        price6.setScanTime(new java.util.Date(System.currentTimeMillis() - 500));
//        price6.setItem(itemList.get(2));
//
//        listOfPrices.add(price1);
//        listOfPrices.add(price2);
//        listOfPrices.add(price3);
//        listOfPrices.add(price4);
//        listOfPrices.add(price5);
//        listOfPrices.add(price6);
//
//        commitList(listOfPrices);
//    }
//
//    private static void generateTracking() {
//        List<ItemTracking> listOfItemTracking = new ArrayList<>();
//
//        ItemTracking trackingItem1 = new ItemTracking();
//        trackingItem1.setUser(userList.get(0));
//        trackingItem1.setItem(itemList.get(0));
//        trackingItem1.setTrackingStatus(true);
//
//        ItemTracking trackingItem2 = new ItemTracking();
//        trackingItem2.setUser(userList.get(1));
//        trackingItem2.setItem(itemList.get(1));
//        trackingItem2.setTrackingStatus(true);
//
//        ItemTracking trackingItem3 = new ItemTracking();
//        trackingItem3.setUser(userList.get(2));
//        trackingItem3.setItem(itemList.get(2));
//        trackingItem3.setTrackingStatus(true);
//
//        ItemTracking trackingItem4 = new ItemTracking();
//        trackingItem4.setUser(userList.get(3));
//        trackingItem4.setItem(itemList.get(2));
//        trackingItem4.setTrackingStatus(true);
//
//        ItemTracking trackingItem5 = new ItemTracking();
//        trackingItem5.setUser(userList.get(0));
//        trackingItem5.setItem(itemList.get(2));
//        trackingItem5.setTrackingStatus(true);
//
//        listOfItemTracking.add(trackingItem1);
//        listOfItemTracking.add(trackingItem2);
//        listOfItemTracking.add(trackingItem3);
//        listOfItemTracking.add(trackingItem4);
//        listOfItemTracking.add(trackingItem5);
//
//        commitList(listOfItemTracking);
//    }
//
//    private static void commitList(List<?> list) {
//        try (Session session = sessionFactory.openSession()) {
//            session.beginTransaction();
//
//            for (Object object : list) {
//                session.save(object);
//            }
//
//            session.getTransaction().commit();
//        }
//    }
//}
