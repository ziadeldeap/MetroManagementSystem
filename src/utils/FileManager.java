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
import models.*;

public class FileManager {
    
   
       

    private static final String USERS_FILE = "users.txt";
    private static final String STATIONS_FILE = "stations.txt";
    private static final String LINES_FILE = "lines.txt";
    private static final String TRAINS_FILE = "trains.txt";
    private static final String SCHEDULE_FILE = "schedule.txt";

    public static ArrayList<User> users = new ArrayList<>();
    public static ArrayList<Station> stations = new ArrayList<>();
    public static ArrayList<MetroLine> lines = new ArrayList<>();
    public static ArrayList<Train> trains = new ArrayList<>();
    public static ArrayList<TripSchedule> schedules = new ArrayList<>();
    public static ArrayList<Ticket> tickets = new ArrayList<>();

    public static void loadAll() {
        loadUsers();
        loadSchedule();
        loadStations();
        loadLines();
        loadTrain();
    }

    public static void saveAll() {
        saveUsers();
        saveSchedule();
        saveStations();
        saveLines();
        saveTrain();
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
            if (u.getUserUsername().equals(username) && u.getUserPassword().equals(password)) {
                return u;
            }
        }
        return null;
    }
    
    //---------------Station

    public static void saveStations() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(STATIONS_FILE))) {
            for (Station u : stations) {
                writer.write(u.toFileString());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving stations: " + e.getMessage());
        }
    }

    public static void loadStations() {
        stations.clear();
        File file = new File(STATIONS_FILE);

        if (!file.exists()) {
            createDefaultstation();
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                stations.add(Station.fromFileString(line));
            }
        } catch (IOException e) {
            System.out.println("Error loading stations: " + e.getMessage());
        }

        if (stations.isEmpty()) {
            createDefaultstation();
        }
    }

    private static void createDefaultstation() {
        stations.add(new Station("000", "default", "yesItsInMars"));
        saveStations();
    }
 
    //---------------MetroLine

    public static void saveLines() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(LINES_FILE))) {
            for (MetroLine u : lines) {
                writer.write(u.toFileString());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving metrolines: " + e.getMessage());
        }
    }

    public static void loadLines() {
        lines.clear();
        File file = new File(LINES_FILE);

        if (!file.exists()) {
            createDefaultline();
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(MetroLine.fromFileString(line));
            }
        } catch (IOException e) {
            System.out.println("Error loading metrolines: " + e.getMessage());
        }

        if (lines.isEmpty()) {
            createDefaultline();
        }
    }

    private static void createDefaultline() {
        lines.add(new MetroLine("000", "default"));
        saveLines();
    }
    
    //---------------train

    public static void saveTrain() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(TRAINS_FILE))) {
            for (Train u : trains) {
                writer.write(u.toFileString());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving trains: " + e.getMessage());
        }
    }

    public static void loadTrain() {
        trains.clear();
        File file = new File(TRAINS_FILE);

        if (!file.exists()) {
            createDefaultTrain();
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                trains.add(Train.fromFileString(line));                    
            }
        } catch (IOException e) {
            System.out.println("Error loading trains: " + e.getMessage());
        }

        if (trains.isEmpty()) {
            createDefaultTrain();
        }
    }

    private static void createDefaultTrain() {
        trains.add(new Train("000", 000, "Trash"));
        saveTrain();
    }
  
    
     //---------------TripSchedule
   
    public static void saveSchedule() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(SCHEDULE_FILE))) {
            for (TripSchedule t : schedules) {
                writer.write(t.toFileString());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving schedules: " + e.getMessage());
        }
    }

 public static void loadSchedule() {
        schedules.clear();
        File file = new File(SCHEDULE_FILE);
        if (!file.exists()) {
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.trim().isEmpty()) {
                    continue;
                }
                TripSchedule trip = TripSchedule.fromFileString(line);
                if (trip != null) {
                    schedules.add(trip);
                }
            }
        } catch (IOException e) {
            System.out.println("Error loading schedules: " + e.getMessage());
        }
    }

    public static boolean hasScheduleConflict(TripSchedule newTrip) {
        for (TripSchedule existing : schedules) {
            if (existing.getTripId().equals(newTrip.getTripId())) {
                continue;
            }
            if (newTrip.conflictsWith(existing)) {
                return true;
            }
        }
        return false;
    }

}
 
