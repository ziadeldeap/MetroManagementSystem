package gui;
/*
import gui.actions.StationActions;
import gui.actions.profileActions;
*/
import javax.swing.*;
import java.awt.*;

public class AdminDashboard extends JPanel{
    
    JFrame frame = new JFrame("Admin Dashboard");
    JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.LEFT);
    
    JPanel profile = new JPanel();
    JPanel lines = new JPanel();
    JPanel trains = new JPanel();
    JPanel reports = new JPanel();
    JPanel stations = new JPanel();
    JPanel head = new JPanel();
    
    //headpanel
    JLabel pageTitle = new JLabel("Admin");
    JButton logoutButton = new JButton("Logout");

    //Profile panel
    JLabel adminNameLabel = new JLabel("Name: ");
    JTextField adminNameField = new JTextField("Jason");    
    JLabel adminIdLabel = new JLabel("ID: ");
    JLabel adminIdInfo = new JLabel("23145");
    JButton profileModifyButton = new JButton("Modify");
    
    //Station panel
    JButton createStationButton = new JButton("Add station");
    JButton updateStationButton = new JButton("Update station");
    JButton deleteStationButton = new JButton("Delete station");
    JButton listAllStationsButton = new JButton("List station");
    JButton searchStationButton = new JButton("Search station");
    
    //Lines panel
    JButton createLineButton = new JButton("Add station");
    JButton addStationButton = new JButton("Update station");
    
    //Trains panel
    JButton recordTrainsButton = new JButton("Record a train");
    JButton updateTrainsButton = new JButton("Update a train");
    JButton listTrainsButton = new JButton("List trains");
    
    //Reports panel
    JButton tripReportsButton = new JButton("Trip report");
    JButton ticketReportsButton = new JButton("Tickets report");
    JButton revenueReportsButton = new JButton("Revenue report");

    public AdminDashboard(){
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,420);
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);
        frame.add(head,BorderLayout.NORTH);
        frame.add(tabbedPane,BorderLayout.CENTER);
        
        head.setLayout(new BorderLayout());
        head.add(pageTitle,BorderLayout.CENTER);
        head.add(logoutButton,BorderLayout.EAST);
        
        tabbedPane.addTab("profile", profile);
        tabbedPane.addTab("stations", stations);
        tabbedPane.addTab("lines", lines);
        tabbedPane.addTab("trains", trains);
        tabbedPane.addTab("reports", reports);

        profile.add(adminIdLabel);
        profile.add(adminIdInfo);
        profile.add(adminNameLabel);
        profile.add(adminNameField);
        profile.add(profileModifyButton);
        adminNameField.setEditable(false);
        //profileModifyButton.addActionListener(e -> profileActions.changeName(adminNameField));
        
        stations.add(createStationButton);
        stations.add(updateStationButton);
        stations.add(deleteStationButton);
        stations.add(listAllStationsButton);
        stations.add(searchStationButton);
        //createStationButton.addActionListener(e -> StationActions.addStation());
       
        
        lines.add(createLineButton);
        lines.add(addStationButton);
        
        
        trains.add(recordTrainsButton);
        trains.add(updateTrainsButton);
        trains.add(listTrainsButton);
        
        
        reports.add(tripReportsButton);
        reports.add(ticketReportsButton);
        reports.add(revenueReportsButton);
        
        
    }
    
}
