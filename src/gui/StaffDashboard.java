package gui;

import javax.swing.*;
import java.awt.*;

public class StaffDashboard {
    
    JFrame frame = new JFrame();
    JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.LEFT);
    
    JPanel profile = new JPanel();
    JPanel tickets = new JPanel();
    JPanel schedule = new JPanel();
    JPanel head = new JPanel();
    
    //head
    JLabel frameTitle = new JLabel("Staff");
    JButton logoutButton = new JButton("Logout");
    
    //Profile panel
    JLabel staffNameLabel = new JLabel("Name: ");
    JTextField staffNameField = new JTextField("Jason");    
    JLabel staffIdLabel = new JLabel("ID: ");
    JLabel staffIdInfo = new JLabel("23145");
    JButton profileModifyButton = new JButton("Modify");
    
    //Ticket panel
    JButton recordTicketButton = new JButton("Record ticket");
    JButton cancelTicketButton = new JButton("Cancel ticket");
    
    //schedule panel
    JButton createScheduleButton = new JButton("Create train schedule");
    JButton updateScheduleButton = new JButton("Update/cancel schedule");
    
    public StaffDashboard(){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,420);
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);
        
        frame.add(head,BorderLayout.NORTH);
        head.add(frameTitle);
        head.add(logoutButton);
        logoutButton.setFocusable(false);
                

        frame.add(tabbedPane, BorderLayout.CENTER);        
        tabbedPane.addTab("profile", profile);
        tabbedPane.addTab("Tickets", tickets);
        tabbedPane.addTab("Schedules", schedule);
        
        profile.add(staffIdLabel);
        profile.add(staffIdInfo);
        profile.add(staffNameLabel);
        profile.add(staffNameField);
        profile.add(profileModifyButton);
        staffNameField.setEditable(false);
        
        tickets.add(recordTicketButton);
        tickets.add(cancelTicketButton);
        
        schedule.add(createScheduleButton);
        schedule.add(updateScheduleButton);
    }
    
}
