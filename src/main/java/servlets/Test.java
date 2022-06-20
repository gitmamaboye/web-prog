package servlets;

import jakarta.json.Json;
import jakarta.json.stream.JsonParser;

import java.io.StringReader;

public class Test {
    public static void main(String[] args) {
        // Parse back
        final String result = "{\"name\":\"Falco\",\"age\":3,\"bitable\":false}";
        final JsonParser parser = Json.createParser(new StringReader(result));
        String key = null;
        String value = null;
        while (parser.hasNext()) {
            final JsonParser.Event event = parser.next();
            switch (event) {
                case KEY_NAME:
                    key = parser.getString();
                    System.out.println(key);
                    break;
                case VALUE_STRING:
                    value = parser.getString();
                    System.out.println(value);
                    break;
            }
        }
        parser.close();
    }
}
