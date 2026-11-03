package assignment9.flyweight;

import java.util.HashMap;
import java.util.Map;

public class CharacterPropertyFactory {

    private static final Map<String, CharacterProperty> properties =
            new HashMap<>();

    public static CharacterProperty getProperty(
            String font,
            int size,
            String color) {

        String key = font + "-" + size + "-" + color;

        if (!properties.containsKey(key)) {
            properties.put(
                    key,
                    new CharacterProperty(font, size, color)
            );

            System.out.println(
                    "Creating new CharacterProperty: " + key
            );
        }

        return properties.get(key);
    }

    public static int getPropertyCount() {
        return properties.size();
    }
}
