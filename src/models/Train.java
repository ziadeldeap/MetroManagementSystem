/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author ziadeldeap
 */
public class Train {
    private String trainId;
    private int capacity;
    private String serviceStatus;
    
    //Constructors
    public Train(){
    }
    
    public Train(String trainId,int capacity,String serviceStatus){
        this.trainId=trainId;
        this.capacity=capacity;
        this.serviceStatus=serviceStatus;
    }
    
    //Gatters and Setters
    public String getTrainId(){
        return trainId;
    }
    public void setTrainId(String trainId){
        this.trainId= trainId;
    }
    public int getCapacity(){
        return capacity;
    }
    public void setCapacity(int capacity){
        if(capacity <=0){
            throw new IllegalArgumentException("Capacity must be greater than zero.");
        }
        this.capacity= capacity;
    }
    public String getServiceStatus(){
        return serviceStatus;
    }
    public void setServiceStatus(String serviceStatus){
        if(serviceStatus ==null ||(!serviceStatus.equals("Active")&& !serviceStatus.equals("Maintenance"))){
            throw new IllegalArgumentException("Status must be Active or Maintenance");
        }
        this.serviceStatus= serviceStatus;
    }
  
    public void updateTrainDetails(int newCap,String newStatus){
        setCapacity(newCap);
        setServiceStatus(newStatus);
    }
    public String toFileString(){
        return trainId + "|" +capacity+ "|" +serviceStatus;
    }
    
    public static Train fromFileString(String line){
        if(line ==null || line.trim().isEmpty()){
            return null;
        }
        String[] parts =line.split("\\|");
        if(parts.length<3){
            return null;
        }
        String id = parts[0].trim();
        int cap=Integer.parseInt(parts[1].trim());
        String status =parts[2].trim();
        return new Train(id,cap,status);
    }
    @Override
    public String toString(){
        return trainId +"("+serviceStatus+")";
    }
}
