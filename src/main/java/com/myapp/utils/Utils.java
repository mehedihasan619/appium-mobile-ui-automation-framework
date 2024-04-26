package com.myapp.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Utils {
    Properties properties = new Properties();
    public Utils(String resourceName) {
        File configFile = new File(System.getProperty("user.dir")
                + File.separator + "src"
                + File.separator + "main" + File.separator + "resources" + File.separator
                + resourceName);

        try {
            InputStream inputStream = new FileInputStream(configFile);
            properties.load(inputStream);
        } catch (IOException exception) {
            System.err.printf("Could not load %s file%n", resourceName);
        }
    }
    public String getStringProperty(String key) {
        if (properties.containsKey(key)) return properties.getProperty(key);
        return String.format("Requested key: %s does not exist",key);
    }
}
