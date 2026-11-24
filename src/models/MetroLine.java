/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.util.ArrayList;

import java.util.List;
/**
 *
 * @author ziadeldeap
 */
public class MetroLine {
    
    private String lineId;
    private String lineName;
    private ArrayList<Station> stations;
    
    public MetroLine() {
        this.stations = new ArrayList<>();
    }
    public MetroLine(String lineId, String lineName) {
        this.lineId = lineId;
        this.lineName = lineName;
        this.stations = new ArrayList<>();
    }
    public MetroLine(String lineId, String lineName, ArrayList<Station> stations) {
        this.lineId = lineId;
        this.lineName = lineName;
        this.stations = (stations != null) ? stations : new ArrayList<>();
    }
    
    public String getLineId() {
        return lineId;
    }
    public void setLineId(String lineId) {
        this.lineId = lineId;
    }
    public String getLineName() {
        return lineName;
    }
    public void setLineName(String lineName) {
        this.lineName = lineName;
    }
    public ArrayList<Station> getStations() {
        return stations;
    }
    public void setStations(ArrayList<Station> stations) {
        this.stations = (stations != null) ? stations : new ArrayList<>();
    }
    public boolean addStation(Station s) {
        if (s == null || s.getStationId() == null) {
            return false;
        }
        for (Station existing : stations) {
            if (existing.getStationId().equalsIgnoreCase(s.getStationId())) {
                return false;
            }
        }
        stations.add(s);
        return true;
    }
    public boolean removeStation(String stationId) {
        if (stationId == null) {
            return false;
        }
        for (int i = 0; i < stations.size(); i++) {
            if (stationId.equalsIgnoreCase(stations.get(i).getStationId())) {
                stations.remove(i);
                return true;
            }
        }
        return false;
    }
    public int getStationCountBetween(String startId, String endId) {
        if (startId == null || endId == null || stations == null || stations.isEmpty()) {
            return -1;
        }

        int startIndex = -1;
        int endIndex = -1;

        for (int i = 0; i < stations.size(); i++) {
            Station s = stations.get(i);
            if (s != null && s.getStationId() != null) {
                if (startId.equalsIgnoreCase(s.getStationId()) && startIndex == -1) {
                    startIndex = i;
                }
                if (endId.equalsIgnoreCase(s.getStationId()) && endIndex == -1) {
                    endIndex = i;
                }
            }
        }

        if (startIndex == -1 || endIndex == -1) {
            return -1;
        }

        return Math.abs(endIndex - startIndex);
    }
    public String toFileString() {
        StringBuilder idsBuilder = new StringBuilder();
        if (stations != null) {
            for (int i = 0; i < stations.size(); i++) {
                Station s = stations.get(i);
                if (s != null) {
                    if (idsBuilder.length() > 0) {
                        idsBuilder.append(",");
                    }
                    idsBuilder.append(s.getStationId());
                }
            }
        }
        return lineId + "|" + lineName + "|" + idsBuilder.toString();
    }
    public static MetroLine fromFileString(String line, List<Station> availableStations) {
        if (line == null || line.trim().isEmpty()) {
            return null;
        }

        String[] parts = line.split("\\|", -1);
        if (parts.length < 2) {
            throw new IllegalArgumentException("Invalid metro line data: " + line);
        }

        String id = parts[0].trim();
        String name = parts[1].trim();
        ArrayList<Station> loadedStations = new ArrayList<>();

        if (parts.length >= 3 && !parts[2].trim().isEmpty()) {
            String[] stationIds = parts[2].split(",");
            for (String rawId : stationIds) {
                String cleanId = rawId.trim();
                if (cleanId.isEmpty()) {
                    continue;
                }
                Station matched = findStationById(availableStations, cleanId);
                if (matched != null) {
                    loadedStations.add(matched);
                } else {
                    loadedStations.add(new Station(cleanId, cleanId, ""));
                }
            }
        }

        return new MetroLine(id, name, loadedStations);
    }
    
    public static MetroLine fromFileString(String line) {
        return fromFileString(line, null);
    }
    private static Station findStationById(List<Station> availableStations, String stationId) {
        if (availableStations == null) {
            return null;
        }
        for (Station s : availableStations) {
            if (s != null && stationId.equalsIgnoreCase(s.getStationId())) {
                return s;
            }
        }
        return null;
    }
    @Override
    public String toString() {
        return lineId + " - " + lineName;
    }
}
