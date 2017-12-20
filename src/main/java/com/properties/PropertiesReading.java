package com.properties;

import java.io.*;
import java.util.Properties;

public class PropertiesReading {
    private static Properties prop = new Properties();
    private static InputStream input = null;
    public static Properties getCredentials() {
        try {
            input = new FileInputStream("credentials.properties");

            prop.load(input);
            return prop;
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return prop;
        }
    }

    public static Properties getURLs(){
        try {
            input = new FileInputStream("urls.properties");

            prop.load(input);
            return prop;
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return prop;
        }
    }
}
