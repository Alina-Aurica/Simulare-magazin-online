package presentationLayer.admin;

import javax.swing.*;
import java.awt.event.ActionListener;

public class AdminView extends JFrame{
    private JButton importButton;
    private JButton modifyButton;
    private JButton reportButton;

    public AdminView(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(350, 200);

        JPanel panel = new JPanel();

        importButton = new JButton("Import CSV");
        modifyButton = new JButton("Modify data");
        reportButton = new JButton("Generate reports");
        panel.add(importButton);
        panel.add(modifyButton);
        panel.add(reportButton);

        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));

        this.setContentPane(panel);
    }

    public void addImportListener(ActionListener e) {

        importButton.addActionListener(e);
    }

    public void addModifyListener(ActionListener e) {

        modifyButton.addActionListener(e);
    }

    public void addReportListener(ActionListener e) {

        reportButton.addActionListener(e);
    }
}
