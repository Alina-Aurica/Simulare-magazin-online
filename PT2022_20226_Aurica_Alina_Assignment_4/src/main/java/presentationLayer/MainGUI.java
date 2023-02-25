package presentationLayer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class MainGUI extends JFrame {
    private JLabel userNameLabel;
    private JTextField userNameField;
    private JLabel passwordLabel;
    private JTextField passwordField;
    private JButton registerButton;
    private JButton logInButton;

    public MainGUI(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(320, 200);

        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();

        userNameLabel = new JLabel("USERNAME");
        userNameField = new JTextField(15);
        panel1.add(userNameLabel);
        panel1.add(userNameField);

        passwordLabel = new JLabel("PASSWORD");
        passwordField = new JTextField(15);
        panel2.add(passwordLabel);
        panel2.add(passwordField);

        registerButton = new JButton("REGISTER");
        logInButton = new JButton("LOG IN");
        panel3.add(registerButton);
        panel3.add(logInButton);

        JPanel panel = new JPanel();
        panel.add(panel1);
        panel.add(panel2);
        panel.add(panel3);

        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        this.setContentPane(panel);
    }

    public String getUserNameField() {
        return this.userNameField.getText();
    }

    public void setUserNameField(String userNameField) {
        this.userNameField.setText(userNameField);
    }

    public String getPasswordField() {
        return this.passwordField.getText();
    }

    public void setPasswordField(String passwordField) {
        this.passwordField.setText(passwordField);
    }

    public void addRegisterListener(ActionListener e) {

        registerButton.addActionListener(e);
    }

    public void addLogInListener(ActionListener e) {

        logInButton.addActionListener(e);
    }
}
