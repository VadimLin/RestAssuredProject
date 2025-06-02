package org.senla.eu.property;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyFile {
    private static Properties property;

    static {
        try {
            property = new Properties();
            FileInputStream propertyFile = new FileInputStream("src/test/resources/config.properties");
            property.load(propertyFile);
        } catch (IOException e) {
            System.out.println("Error: Properties file doesn't found!");
        }
    }
    public static String getProperty(String key) {
        return property.getProperty(key);
    }
}
