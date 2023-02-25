package presentationLayer;

import businessLayer.Order;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Observable;
import presentationLayer.Observer;
//import java.util.Observer;

public class EmployeeView extends JFrame implements Observer { //ramane sa ne dam seama ce vrea de la viata noastra chestia asta
    private JTextArea mesajNotificare;

    public EmployeeView(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 300);

        JPanel panel = new JPanel();
        mesajNotificare = new JTextArea(1, 8);
        panel.add(mesajNotificare);

        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        this.setContentPane(panel);
    }

    public String getMesajNotificare() {
        return mesajNotificare.getText();
    }

    public void setMesajNotificare(String mesajNotificare) {
        this.mesajNotificare.setText(mesajNotificare);
    }

    /*
    @Override
    public void update(Observable o, Object arg) {

    }
    */

    @Override
    public void update(String mesaj){
        mesajNotificare.setText(mesaj);
    }
}
