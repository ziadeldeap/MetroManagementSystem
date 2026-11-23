package gui;

import models.Admin;
import javax.swing.*;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminDashboard implements ActionListener{
    
    JFrame frame = new JFrame();
    JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.LEFT);
    
    JPanel profile = new JPanel();
    JPanel lines = new JPanel();
    JPanel trains = new JPanel();
    JPanel reports = new JPanel();
    JPanel stations = new JPanel();
    
    JLabel frameIdentifier = new JLabel("Admin");
    JButton logoutButton = new JButton("Logout");
    
    AdminDashboard(Admin admin){
                
        frame.add(frameIdentifier);
        frame.add(logoutButton);
        
        logoutButton.setFocusable(false);
        
        logoutButton.addActionListener(this);
        
        logoutButton.setBounds(52, 10, 100, 20);
        frameIdentifier.setBounds(210, 10, 100, 20);
        tabbedPane.setBounds(10, 40, 380, 330);
        
        tabbedPane.addTab("profile", profile);
        tabbedPane.addTab("lines", lines);
        tabbedPane.addTab("trains", trains);
        tabbedPane.addTab("reports", reports);
        tabbedPane.addTab("stations", stations);

     
        frame.add(tabbedPane);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,420);
        frame.setLayout(null);
        frame.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        
    }
}
