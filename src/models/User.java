/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author ziadeldeap
 */
public class User {
    

    private String userId;
    private String userName;
    private String userUsername; 
    private String userPassword;
    private String role;
    
    public User(String userId, String userName, String userUsername, String userPassword, String role){
        this.userId = userId;
        this.userName = userName;
        this.userUsername = userUsername;
        this.userPassword = userPassword;
        this.role = role;
    }
    
    public String getUserPassword(){
        return userPassword;
    }
    
    public String getUserRole(){
        return role;
    }


    public String getUserUsername() {
        return userUsername;
    }

    public String toFileString() {
        return userId+"|"+userName+"|"+userUsername+"|"+userPassword+"|"+role;
    }
    
    
}
