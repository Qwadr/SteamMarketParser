package ru.digdes.steammarketparser;

import ru.digdes.steammarketparser.model.utils.HibernateDataGetter;
import ru.digdes.steammarketparser.model.utils.InitialDataGenerator;

import java.io.IOException;

/**
 * Entry point of the application.
 * Class checks the database (creating tables, data adding, data getting)
 */
public class ServerStarter {

    public static void main(String[] args) throws IOException {

        InitialDataGenerator.generateAll();

        HibernateDataGetter.testDatabaseAndViewResults();

    }
}

