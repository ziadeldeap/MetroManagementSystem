/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;
import java.time.LocalDateTime;


/**
 *
 * @author ziadeldeap
 */
public class TripSchedule {
    private String tripId;
    private String trainId;
    private String lineId;
    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;
    private String status;
  
    
//Constructor
    public TripSchedule(String tripId, String trainId, String lineId, LocalDateTime departureTime, LocalDateTime arrivalTime, String Status) {
        this.tripId = tripId;
        this.trainId = trainId;
        this.lineId = lineId;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.status = Status;
    }

//get Methods
    public String getTripId() {
        return tripId;
    }

    public String getTrainId() {
        return trainId;
    }

    public String getLineId() {
        return lineId;
    }

    public LocalDateTime getDepartureTime() {
        return departureTime;
    }

    public LocalDateTime getArrivalTime() {
        return arrivalTime;
    }

    public String getStatus() {
        return status;
    }
    
   
    
//set methods

    public void setTripId(String tripId) {
        this.tripId = tripId;
    }

    public void setTrainId(String trainId) {
        this.trainId = trainId;
    }

    public void setLineId(String lineId) {
        this.lineId = lineId;
    }

    public void setDepartureTime(LocalDateTime departureTime) {
        this.departureTime = departureTime;
    }

    public void setArrivalTime(LocalDateTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public void setStatus(String Status) {
        this.status = Status;
    }
    
    
 //methods   
    
    public void updateSchedule(LocalDateTime newDepartureTime ,LocalDateTime newArrivalTime, String newStatus ) {
        
        this.departureTime = newDepartureTime;
        this.arrivalTime = newArrivalTime;
        this.status = newStatus;
    }
    
    
    public void cancelTrip() {
        this.status = "Cancelled";
    }
    
   
    public boolean conflictsWith(TripSchedule other) {
        if(!this.trainId.equals(other.trainId))
        {
            return false;
        }
        if (this.status.equalsIgnoreCase("Cancelled") || other.status.equalsIgnoreCase("Cancelled"))
        {
            return false;
        }
        return this.departureTime.isBefore(other.arrivalTime)
                && this.arrivalTime.isAfter(other.departureTime);

               
    }
    
    public String toFileString () {
        return tripId +'|'+ trainId + '|' + lineId + '|' +
                departureTime.toString() + '|' + arrivalTime.toString()+'|'+ status ;
    }
    
    
    public static TripSchedule fromFileString (String line) {
        String[] parts = line.split("\\|");
        if(parts.length == 6) {
            String tripId = parts[0];
            String trainId = parts[1];
            String lineId = parts[2];
            LocalDateTime departure = LocalDateTime.parse(parts[3]);
            LocalDateTime arrival = LocalDateTime.parse(parts[4]);
            String status = parts[5];
            // return new tripSchedule
            return new TripSchedule(tripId, trainId, lineId, departure, arrival, status);
            
        
        }
        return null;
    }

}
