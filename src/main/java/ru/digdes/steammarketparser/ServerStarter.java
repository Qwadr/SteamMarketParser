package ru.digdes.steammarketparser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.digdes.steammarketparser.model.entity.Item;
import ru.digdes.steammarketparser.model.entity.ItemTracking;
import ru.digdes.steammarketparser.service.ItemTrackingService;
//import ru.digdes.steammarketparser.model.utils.HibernateDataGetter;
//import ru.digdes.steammarketparser.model.utils.InitialDataGenerator;

import java.io.IOException;

/**
 * Entry point of the application.
 * Class checks the database (creating tables, data adding, data getting)
 */
@Component
public class ServerStarter {

    private static ItemTrackingService itemTrackingService;

    @Autowired
    public ServerStarter(ItemTrackingService itemTrackingService) {
        ServerStarter.itemTrackingService = itemTrackingService;
    }

    public static void main(String[] args) throws IOException {

//        InitialDataGenerator.generateAll();
//
//        HibernateDataGetter.testDatabaseAndViewResults();

        Iterable<ItemTracking> trackings = itemTrackingService
                .findItemTrackingsByTrackingStatusIsTrueOrderByItem_ItemID();

        Item actualItem = null;
        for (ItemTracking tracking : trackings) {
            if (tracking.getItem() != actualItem){
                actualItem = tracking.getItem();
                System.out.println("Item ID = " + actualItem.getItemID()
                + "; name = \""+actualItem.getName()
                +"\"; tracking status = " + tracking.isTrackingStatus());
            }
        }
    }
}

