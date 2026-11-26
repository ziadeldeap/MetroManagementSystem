package metro;

import gui.*;
import models.*;
import utils.FileManager;

public class main {
    public static void main(String[] args){
        FileManager.loadAll();
        FileManager.saveAll();
        
        LoginFrame login = new LoginFrame();
    }
}
