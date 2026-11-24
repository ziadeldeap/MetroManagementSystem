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
    
    private String username;
    private String password;

    public String getPassword() {
        return password;
    }


    public String getUsername() {
        return username;
    }

    @Override
    public String toFileString() {
        return "User{" + "username=" + username + ", password=" + password + '}';
    }
    
    
}
