package Models;

public class User {
    private String AdminID ;
    private String Name;
    private String UserName;
    private String Password;


    public User(String adminID, String userName, String name, String password) {
        this.AdminID = adminID;
        this.Name = name;
        this.UserName = userName;
        this.Password = password;
    }

    public String getAdminID() {
        return AdminID;
    }

    public String getName() {
        return Name;
    }

    public String getUserName() {
        return UserName;
    }

    public String getPassword() {
        return Password;
    }

    public void setAdminID(String adminID) {
        AdminID = adminID;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
