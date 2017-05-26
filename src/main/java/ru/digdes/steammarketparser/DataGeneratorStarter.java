package ru.digdes.steammarketparser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.digdes.steammarketparser.model.entity.Item;
import ru.digdes.steammarketparser.model.entity.ItemTracking;
import ru.digdes.steammarketparser.service.ItemTrackingService;
import ru.digdes.steammarketparser.model.utils.HibernateDataGetter;
import ru.digdes.steammarketparser.model.utils.InitialDataGenerator;

import java.io.IOException;

/**
 * Entry point of the application.
 * Class checks the database (creating tables, data adding, data getting)
 */
@Component
public class DataGeneratorStarter {

    public static void main(String[] args) throws IOException {
        InitialDataGenerator.generateAll();
    }
}

