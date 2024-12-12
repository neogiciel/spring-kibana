package com.neogiciel.spring_kibana.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class TraceProperties {
    
    private static Properties propsExported = new Properties();

    // Load properties from the "error.properties" file
    static {
        try (InputStream inputStream = TraceProperties.class.getClassLoader().getResourceAsStream("application.properties")) {
            if (inputStream == null) {
                throw new IOException("Properties file 'application.properties' not found on the classpath");
            }
            propsExported.load(inputStream);
        } catch ( IOException e) {
            e.printStackTrace();
        }
    }
    
    public static String getProperty(final String key) {
        String value = propsExported.getProperty(key);
        return value;
    }
}