package com.loop.utilities;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * This class is designed to read properties file and provide the data to the source code.
 */
public class ConfigurationReader {

    private static Properties properties;

    static {
        try {
            // Load configuration.properties file
            String path = "configuration.properties";
            FileInputStream input = new FileInputStream(path);
            properties = new Properties();
            properties.load(input);
            input.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Gets the value of the specified key from the properties file.
     *
     * @param keyName Key to retrieve the value for
     * @return Value associated with the key
     */
    public static String getProperty(String keyName) {
        return properties.getProperty(keyName);
    }
}
