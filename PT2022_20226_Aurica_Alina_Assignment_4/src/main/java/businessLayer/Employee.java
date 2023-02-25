package businessLayer;

public class Employee extends User{
    public Employee(String userName, String password) {
        super(userName, password, "employee");
    }
}
