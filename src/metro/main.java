package metro;

import gui.StaffDashboard;
import gui.LoginFrame;
import models.Staff;

public class main {
    public static void main(String[] args){
        
        Staff tempstaff = new Staff();
        LoginFrame login = new LoginFrame ();
        StaffDashboard temp = new StaffDashboard(tempstaff);
    }
}
