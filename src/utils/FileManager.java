/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import models.Admin;
import models.MetroLine;
import models.Staff;
import models.Station;
import models.Ticket;
import models.Train;
import models.TripSchedule;
import models.User;

public class FileManager {

    private static final String USERS_FILE = "users.txt";

    public static ArrayList<User> users = new ArrayList<>();
    public static ArrayList<Station> stations = new ArrayList<>();
    public static ArrayList<MetroLine> lines = new ArrayList<>();
    public static ArrayList<Train> trains = new ArrayList<>();
    public static ArrayList<TripSchedule> schedules = new ArrayList<>();
    public static ArrayList<Ticket> tickets = new ArrayList<>();

    public static void loadAll() {
        loadUsers();
    }

    public static void saveAll() {
        saveUsers();
    }

    public static void saveUsers() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(USERS_FILE))) {
            for (User u : users) {
                writer.write(u.toFileString());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving users: " + e.getMessage());
        }
    }

    public static void loadUsers() {
        users.clear();
        File file = new File(USERS_FILE);

        if (!file.exists()) {
            createDefaultUsers();
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.trim().isEmpty()) {
                    continue;
                }
                String[] parts = line.split("\\|");
                if (parts.length == 5) {
                    String id = parts[0];
                    String name = parts[1];
                    String username = parts[2];
                    String password = parts[3];
                    String role = parts[4];

                    if (role.equalsIgnoreCase("ADMIN")) {
                        users.add(new Admin(id, name, username, password));
                    } else if (role.equalsIgnoreCase("STAFF")) {
                        users.add(new Staff(id, name, username, password));
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error loading users: " + e.getMessage());
        }

        if (users.isEmpty()) {
            createDefaultUsers();
        }
    }

    private static void createDefaultUsers() {
        users.add(new Admin("A1", "System Admin", "admin", "123"));
        users.add(new Staff("S1", "Metro Staff", "staff", "123"));
        saveUsers();
    }

    public static User authenticate(String username, String password) {
        for (User u : users) {
            if (u.getUsername().equals(username) && u.getPassword().equals(password)) {
                return u;
            }
        }
        return null;
    }
}
