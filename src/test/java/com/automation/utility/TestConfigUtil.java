package com.automation.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class TestConfigUtil {

    public static String GetConfigValue(String key) throws IOException {
        Properties prop = new Properties();
        FileInputStream fileInputStream = new FileInputStream(System.getProperty("user.dir") + "/src/test/java/com/automation/resources/TestConfig.properties");
        prop.load(fileInputStream);
        return String.valueOf(prop.getProperty(key));

    }
}
