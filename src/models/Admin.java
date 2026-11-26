
package models;


public class Admin extends User{
    private String adminId;
    private String adminName;
    private String adminUsername; 
    private String adminPassword;
    
    public Admin(String adminId, String adminName, String adminUsername, String adminPassword){
        super(adminId, adminName, adminUsername, adminPassword, "admin");
        this.adminId = adminId;
        this.adminName = adminName;
        this.adminUsername = adminUsername;
        this.adminPassword = adminPassword;
    }  
    
    public String getAdminId(){
        return this.adminId;
    }
    
    public void setAdminId(String adminId){
        this.adminId = adminId;
    }
    
    public String getAdminName(){
        return this.adminName;
    }
    
    public void setAdminName(String adminName){
        this.adminName = adminName;
    }
    public String getAdminUsername(){
        return this.adminUsername;
    }
    
    public void setAdminUsername(String adminUsername){
        this.adminUsername = adminUsername;
    }
    
    public String getAdminPassword(){
        return this.adminPassword;
    }
    
    public void setAdminPassword(String adminPassword){
        this.adminPassword = adminPassword;
    }
}
