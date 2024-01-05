package com.loop.utilities;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * This class is designed to read property files and send the data to the source code.
 */
public class ConfigurationReader {

    private static Properties properties;

    static {
        try {
            String path = "configuration.properties";
            // Help us to read Properties file --> and add Constructor (path)
            FileInputStream input = new FileInputStream(path);
            properties = new Properties();
            properties.load(input);
            input.close();
        } catch (Exception e) {
            // We use it for diagnostic exceptions.
            e.printStackTrace();
        }
    }

    // Reusable method for call and reading configuration.properties for do cross-browser testing.
    public static String getProperty(String keyName) {
        return properties.getProperty(keyName);
    }
}