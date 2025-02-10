package org.example.utils;

import com.google.gson.Gson;
import java.io.FileReader;
import java.util.Map;

public class JsonUtils {
    public static Map<String, String>[] loadJson(String filePath) {
        try (FileReader reader = new FileReader(filePath)) {
            Gson gson = new Gson();
            return gson.fromJson(reader, Map[].class);
        } catch (Exception e) {
            e.printStackTrace();
            return new Map[0];
        }
    }
}
