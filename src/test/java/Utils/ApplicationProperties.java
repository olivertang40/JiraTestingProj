package Utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class ApplicationProperties {
    private static final Properties properties;

    static {
        properties = new Properties();
        try (FileInputStream fis = new FileInputStream("src/test/resources/application.properties")) {
            properties.load(fis);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static String get(String key) {
        return properties.getProperty(key);
    }
}
