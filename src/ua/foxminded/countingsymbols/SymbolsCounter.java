package ua.foxminded.countingsymbols;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class SymbolsCounter {

    public static final Map<String, String> MAP_CACHE = new HashMap<>();

    private String text;

    public SymbolsCounter() {
    }

    public String calculateCounterOfCharacters() {

        if (text == null) {
            throw new IllegalArgumentException("Data can`t be null");
        }

        if (MAP_CACHE.containsKey(text)) {
            return MAP_CACHE.get(text);
        } else {
            MAP_CACHE.put(text, generateValue(text));
        }
        return generateValue(text);
    }

    private String generateValue(String text) {
        Map<Character, Integer> map = new LinkedHashMap<>();

        for (int i = 0; i < text.length(); i++) {
            char letter = text.charAt(i);
            if (map.containsKey(letter)) {
                int oldValue = map.get(letter);
                int newValue = oldValue + 1;
                map.replace(letter, oldValue, newValue);
            } else {
                map.put(letter, 1);
            }
        }
        return text + "\n" + writeResultString(map);
    }

    private String writeResultString(Map<Character, Integer> map) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Character, Integer> item : map.entrySet()) {
            sb.append("\"" + item.getKey() + "\" - " + item.getValue() + "\n");
        }
        return sb.toString();
    }

    public void setText(String text) {
        this.text = text;
    }
}
