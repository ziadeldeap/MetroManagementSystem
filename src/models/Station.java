/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author ziadeldeap
 */
public class Station {
    //Attributes (تخزين بيانات المحطة)
    private String stationId;
    private String name;
    private String location;
//constructors(انشاء محطة جديدة)
    public Station(String stationId, String name, String location){
        this.stationId = stationId;
        this.name = name;
        this.location = location;
    }
    //getters(قراءة البيانات)
    public String getStationId(){
        return stationId;
    }
    public String getName(){
        return name;
    }
    public String getLocation(){
        return location;
    }
    //setters(تعديل البيانات)
    public void setStationId(String stationId){
        this.stationId =stationId;
    }
    public void setName(String name){
        this.name=name;
    }
    public void setLocation(String location){
        this.location=location;
    }
    // station info
    @Override //(بتساعدني اتجنب اخطاء الكتابة و بتقول للجافا ان الداله دي باعيد تعريفهاو هي موجودة قبل كدة)
    public String toString(){//(عرض بيانات المحطة)
        return stationId + "-" + name + "-" + location;
    }
    //object to file line
    public String toFileString(){ // (بتحول المحطة لنص للحفظ)
        return stationId + "|" + name + "|" + location;
    }
    //file line to object
    public static Station fromFileString(String line){ //(بتسترجع المحطة من النص)
        String[] data = line.split("\\|",-1);
        if (data.length !=3){
            throw new IllegalArgumentException("Invalid station data");
        }
        return new Station(data[0], data[1], data[2]);

    }
}
