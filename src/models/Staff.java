
package models;

public class Staff extends User{
    private String staffId;
    private String staffName;
    private String staffUsername; 
    private String staffPassword;
    
    public Staff(String staffId, String staffName, String staffUsername, String staffPassword){
        super(staffId, staffName, staffUsername, staffPassword, "staff");
        this.staffId = staffId;
        this.staffName = staffName;
        this.staffUsername = staffUsername;
        this.staffPassword = staffPassword;
    } 
    
    public String getStaffId(){
        return this.staffId;
    }
    
    public void setStaffId(String staffId){
        this.staffId = staffId;
    }
    
    public String getStaffName(){
        return this.staffName;
    }
    
    public void setStaffName(String staffName){
        this.staffName = staffName;
    }
    public String getStaffUsername(){
        return this.staffUsername;
    }
    
    public void setStaffUsername(String staffUsername){
        this.staffUsername = staffUsername;
    }
    
    public String getStaffPassword(){
        return this.staffPassword;
    }
    
    public void setStaffPassword(String staffPassword){
        this.staffPassword = staffPassword;
    }
}
