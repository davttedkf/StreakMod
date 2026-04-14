package net.fabricmc.example;

import java.io.*;
import java.nio.file.*;
import java.time.LocalDate;

public class StreakLogic {
    private static final Path SAVE_PATH = Paths.get("config/streak_data.txt");

    public static String getStreakInfo() {
        try {
            if (!Files.exists(SAVE_PATH)) return "0 §cX"; // No streak, show X
            
            String content = Files.readString(SAVE_PATH);
            String[] parts = content.split(",");
            int count = Integer.parseInt(parts[0]);
            LocalDate lastDate = LocalDate.parse(parts[1]);
            LocalDate today = LocalDate.now();

            if (lastDate.isBefore(today.minusDays(1))) {
                return "0 §cX"; // Lost it!
            }
            return count + " §e★"; // Active streak!
        } catch (Exception e) {
            return "0 §cX";
        }
    }

    public static void updateLogin() {
        // Logic to increment count if today is a new day
        // (Similar to Python file handling)
    }
}
