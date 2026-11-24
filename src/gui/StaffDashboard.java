package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import models.Staff;

public class StaffDashboard implements ActionListener{
    
    JFrame frame = new JFrame();
    JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.LEFT);
    
    JPanel profile = new JPanel();
    JPanel Tickets = new JPanel();
    JPanel Schedules = new JPanel();
    
    JLabel frameIdentifier = new JLabel("Staff");
    JButton logoutButton = new JButton("Logout");
    
    
    StaffDashboard(Staff staff){
                
        frame.add(frameIdentifier);
        frame.add(logoutButton);
        
        logoutButton.setFocusable(false);
        
        logoutButton.addActionListener(this);
        
        logoutButton.setBounds(52, 10, 100, 20);
        frameIdentifier.setBounds(210, 10, 100, 20);
        tabbedPane.setBounds(10, 40, 380, 330);
        
        tabbedPane.addTab("profile", profile);
        tabbedPane.addTab("Tickets", Tickets);
        tabbedPane.addTab("Schedules", Schedules);

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
