package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginFrame implements ActionListener{
    JFrame frame = new JFrame();
    
    JLabel loginTitle = new JLabel("LOGIN");
    JButton loginButton = new JButton("Login");
    JTextField userId = new JTextField();
    JPasswordField userPassword = new JPasswordField();
    JLabel userIdLabel = new JLabel("ID");
    JLabel userPasswordLabel = new JLabel("Password");
    
    public LoginFrame(){
        
        loginTitle.setBounds(210,25,75,50);
        userIdLabel.setBounds(50,100,75,25);
        userPasswordLabel.setBounds(50,150,75,25);
        userId.setBounds(125,100,100,25);
        userPassword.setBounds(125,150,100,25);
        loginButton.setBounds(125,200,100,25);
        
        loginButton.setFocusable(false);
        
        loginButton.addActionListener(this);
        
        frame.add(loginTitle);
        frame.add(userIdLabel);
        frame.add(userPasswordLabel);
        frame.add(userId);
        frame.add(userPassword);
        frame.add(loginButton);
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,420);
        frame.setLayout(null);
        frame.setVisible(true);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        
    }
}
