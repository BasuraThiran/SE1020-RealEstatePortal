package com.realestate.utils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {

    // 1. Define where the file will be saved.
    // This will create a "properties.txt" file in your main project folder.
    private static final String FILE_PATH = "properties.txt";

    // ==========================================
    // CREATE OPERATION: Save a property to the file
    // ==========================================
    public static void saveProperty(String propertyData) {
        // We use FileWriter with "true" to APPEND data to the bottom of the file, not overwrite it.
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
            writer.write(propertyData);
            writer.newLine(); // Moves to the next line for the next property
            System.out.println("Property saved successfully!");
        } catch (IOException e) {
            System.out.println("Error saving property: " + e.getMessage());
        }
    }

    // ==========================================
    // READ OPERATION: Get all properties from the file
    // ==========================================
    public static List<String> getAllProperties() {
        List<String> properties = new ArrayList<>();
        File file = new File(FILE_PATH);

        // If the file doesn't exist yet (like on first run), return the empty list
        if (!file.exists()) {
            return properties;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            // Read the file line by line until there is nothing left
            while ((line = reader.readLine()) != null) {
                properties.add(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading properties: " + e.getMessage());
        }

        return properties;
    }
    // ==========================================
    // DELETE OPERATION: Remove a property by ID
    // ==========================================
    public static void deleteProperty(String idToDelete) {
        // 1. Get all current properties
        List<String> properties = getAllProperties();

        // 2. Open the file to OVERWRITE it (append is false)
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, false))) {
            for (String prop : properties) {
                // If the line does NOT start with our ID, write it back to the file
                if (!prop.startsWith(idToDelete + ",")) {
                    writer.write(prop);
                    writer.newLine();
                }
            }
            System.out.println("Property deleted (if ID existed).");
        } catch (IOException e) {
            System.out.println("Error deleting property: " + e.getMessage());
        }
    }
}
