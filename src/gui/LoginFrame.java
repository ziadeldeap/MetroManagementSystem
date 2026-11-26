package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import models.*;
import utils.FileManager;

public class LoginFrame implements ActionListener{
    JFrame frame = new JFrame();
    
    JLabel loginTitle = new JLabel("LOGIN");
    JButton loginButton = new JButton("Login");
    JTextField userUsername = new JTextField("admin");
    JPasswordField userPassword = new JPasswordField("123");
    JLabel userUsernameLabel = new JLabel("Username");
    JLabel userPasswordLabel = new JLabel("Password");
    
    public LoginFrame(){
        
        loginTitle.setBounds(210,25,75,50);
        userUsernameLabel.setBounds(50,100,75,25);
        userPasswordLabel.setBounds(50,150,75,25);
        userUsername.setBounds(125,100,100,25);
        userPassword.setBounds(125,150,100,25);
        loginButton.setBounds(125,200,100,25);
        
        loginButton.setFocusable(false);
        
        loginButton.addActionListener(this);
        
        frame.add(loginTitle);
        frame.add(userUsernameLabel);
        frame.add(userPasswordLabel);
        frame.add(userUsername);
        frame.add(userPassword);
        frame.add(loginButton);
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,420);
        frame.setResizable(false);
        frame.setLayout(null);
        frame.setVisible(true);
        
    }   
    
    @Override
    public void actionPerformed(ActionEvent e){
       String inputUsername = userUsername.getText();
       String inputPassword = userPassword.getText();
       
       User authUser = FileManager.authenticate(inputUsername, inputPassword); 
       if(authUser.getUserRole().equalsIgnoreCase("ADMIN") ){
           AdminDashboard openAdmin = new AdminDashboard();
           frame.setVisible(false);
       }
       else if(authUser.getUserRole().equalsIgnoreCase("STAFF") ){
           StaffDashboard openStaff = new StaffDashboard();
           frame.setVisible(false);
       }
       
    }
}
