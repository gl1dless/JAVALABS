package singleton;

import java.io.*;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class SaveManager {

    private static SaveManager instance;

    private Map<String, Object> data = new HashMap<>();

    private SaveManager() {
        // начальные значения
        data.put("health", 100);
        data.put("position", "0,0");
        data.put("coins", 0);
    }

    public static synchronized SaveManager getInstance() {
        if (instance == null) {
            instance = new SaveManager();
        }
        return instance;
    }

    public void set(String key, Object value) {
        data.put(key, value);
    }

    public Object get(String key) {
        return data.get(key);
    }

    public void saveGame(String filename) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            String now = LocalDateTime.now().toString();
            writer.println("savedAt=" + now);
            for (Map.Entry<String, Object> e : data.entrySet()) {
                writer.println(e.getKey() + "=" + e.getValue());
            }
            System.out.println("Game saved to " + filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadGame(String filename) {
        Map<String, Object> loaded = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (!line.contains("=")) continue;
                String[] parts = line.split("=", 2);
                String key = parts[0];
                String value = parts[1];

                if ("savedAt".equals(key) || "loadedAt".equals(key)) {
                    continue;
                }

                loaded.put(key, value);
            }
            data = loaded;
            System.out.println("Game loaded from " + filename);
            appendLoadTime(filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void appendLoadTime(String filename) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename, true))) {
            String now = LocalDateTime.now().toString();
            writer.println("loadedAt=" + now);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}