package presentationLayer.admin;

import javax.swing.*;
import java.awt.event.ActionListener;

public class AdminReportProduct extends JFrame {
    private JLabel dataFirstLabel;
    private JLabel dataSecondLabel;
    private JLabel noOfTimeLabel;
    private JLabel priceLabel;
    private JTextField dataFirstField;
    private JTextField dataSecondField;
    private JTextField noOfTimeField;
    private JTextField priceField;
    private JButton report1Button;
    private JButton report2Button;
    private JButton report3Button;
    private JButton report4Button;

    public AdminReportProduct(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 600);

        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();

        dataFirstLabel = new JLabel("data1");
        dataSecondLabel = new JLabel("data2");
        dataFirstField = new JTextField(15);
        dataSecondField = new JTextField(15);
        panel1.add(dataFirstLabel);
        panel1.add(dataFirstField);
        panel1.add(dataSecondLabel);
        panel1.add(dataSecondField);

        noOfTimeLabel = new JLabel("nr de ori");
        noOfTimeField = new JTextField(4);
        priceLabel = new JLabel("Price");
        priceField = new JTextField(4);
        panel2.add(noOfTimeLabel);
        panel2.add(noOfTimeField);
        panel2.add(priceLabel);
        panel2.add(priceField);

        report1Button = new JButton("report1");
        report2Button = new JButton("report2");
        report3Button = new JButton("report3");
        report4Button = new JButton("report4");
        panel3.add(report1Button);
        panel3.add(report2Button);
        panel3.add(report3Button);
        panel3.add(report4Button);

        JPanel panel = new JPanel();
        panel.add(panel1);
        panel.add(panel2);
        panel.add(panel3);

        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        this.setContentPane(panel);
    }

    public String getDataFirstField() {
        return dataFirstField.getText();
    }

    public void setDataFirstField(String dataFirstField) {
        this.dataFirstField.setText(dataFirstField);
    }

    public String getDataSecondField() {
        return dataSecondField.getText();
    }

    public void setDataSecondField(String dataSecondField) {
        this.dataSecondField.setText(dataSecondField);
    }

    public String getNoOfTimeField() {
        return noOfTimeField.getText();
    }

    public void setNoOfTimeField(String noOfTimeField) {
        this.noOfTimeField.setText(noOfTimeField); ;
    }

    public String getPriceField() {
        return priceField.getText();
    }

    public void setPriceField(String priceField) {
        this.priceField.setText(priceField);
    }

    public void addReport1ButtonListener(ActionListener e) {

        report1Button.addActionListener(e);
    }

    public void addReport2ButtonListener(ActionListener e) {

        report2Button.addActionListener(e);
    }

    public void addReport3ButtonListener(ActionListener e) {

        report3Button.addActionListener(e);
    }

    public void addReport4ButtonListener(ActionListener e) {

        report4Button.addActionListener(e);
    }
}
