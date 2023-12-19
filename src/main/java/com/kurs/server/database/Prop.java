package com.kurs.server.database;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Prop {

    private final Properties prop = new Properties();

    public Prop() {

        try (InputStream file = getClass().getResourceAsStream("/app.properties")) {
            prop.load(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String getDBLogin() {
        return prop.getProperty("DBLogin");
    }
    public String getDBName() {
        return prop.getProperty("DBName");
    }

    public String getMenuTableName() {
        return prop.getProperty("menuTable");
    }

    public String getDBPassword() {
        return prop.getProperty("DBPassword");
    }
}
