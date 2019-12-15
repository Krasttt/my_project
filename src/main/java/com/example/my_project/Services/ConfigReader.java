package com.example.my_project.Services;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class ConfigReader {
    private static Map<String,String> map = new HashMap();

    static {
        Properties prop = new Properties();
        InputStream inputStream = null;
        try {
            String filename = "config.properties";
            inputStream = ConfigReader.class.getClassLoader().getResourceAsStream(filename);
            if (inputStream == null) {
                System.out.println("Sorry, unable to find " + filename);
            }
            prop.load(inputStream);

            map.put("url",prop.getProperty("url"));
            map.put("user",prop.getProperty("user"));
            map.put("password",prop.getProperty("password"));

        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static String getProperty(String prop){
        return map.get(prop);
    }
}
