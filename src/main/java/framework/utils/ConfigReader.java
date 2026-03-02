package framework.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public final class ConfigReader {
    private static final Properties PROPERTIES = new Properties();

    static {
        try (InputStream inputStream = ConfigReader.class.getClassLoader().getResourceAsStream("config.properties")) {
            if (inputStream == null) {
                throw new IllegalStateException("config.properties not found in resources");
            }
            PROPERTIES.load(inputStream);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load config.properties", e);
        }
    }

    private ConfigReader() {
    }

    public static String get(String key) {
        String systemValue = System.getProperty(convertToPropertyName(key));
        if (systemValue != null && !systemValue.isBlank()) {
            return systemValue;
        }
        String propertyValue = PROPERTIES.getProperty(key);
        if (propertyValue == null) {
            throw new IllegalArgumentException("No config value defined for key: " + key);
        }
        return propertyValue.trim();
    }

    public static int getInt(String key) {
        return Integer.parseInt(get(key));
    }

    private static String convertToPropertyName(String key) {
        return switch (key) {
            case "base.url" -> "baseUrl";
            default -> key;
        };
    }
}
