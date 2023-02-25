package businessLayer;

import java.io.Serializable;

public class User implements Serializable {
    private static final long serialVersionUID = -8006826680063246755l;
    private String userName;
    private String password;
    private String role;

    public User(String userName, String password, String role){
        this.userName = userName;
        this.password = password;
        this.role = role;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return this.role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String toString(){
        return "Userul " + userName + " cu parola " + password + " si rolul " + role;
    }
}
