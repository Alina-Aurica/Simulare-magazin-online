package businessLayer;

import java.io.Serializable;

public class Client extends User implements Serializable {
    public Client(String userName, String password) {
        super(userName, password, "client");
    }

}
