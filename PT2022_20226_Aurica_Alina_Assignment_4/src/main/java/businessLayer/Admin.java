package businessLayer;

import java.io.Serializable;

public class Admin extends User implements Serializable {
    public Admin(String userName, String password) {
        super(userName, password, "admin");
    }
}
