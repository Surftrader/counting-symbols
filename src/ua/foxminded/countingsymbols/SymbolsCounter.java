package ua.foxminded.countingsymbols;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class SymbolsCounter {

    private Map<String, String> mapCache = new HashMap<>();

    public String countChars(String text) {

        if (text == null) {
            throw new IllegalArgumentException("Data can`t be null");
        }

        if (!mapCache.containsKey(text)) {
            mapCache.put(text, generateValue(text));
        }

        return mapCache.get(text);
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
        return text + "\n" + writeCount(map);
    }

    private String writeCount(Map<Character, Integer> map) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Character, Integer> item : map.entrySet()) {
            sb.append("\"" + item.getKey() + "\" - " + item.getValue() + "\n");
        }
        return sb.toString();
    }
}
