package presentationLayer;

import javax.swing.*;
import java.awt.event.ActionListener;

public class ClientView extends JFrame{
    private JTextArea menuSimpleArea;
    private JTextArea menuComposeArea;
    private JButton searchProductsButton;
    private JButton addOrdersButton;
    private JButton backButton;
    //private JButton modifyProductsButton;
    //private JButton createProductsButton;
    private JLabel dataLabel;
    private JTextField dataField;
    private JLabel keyLabel;
    private JTextField keyField;
    private JLabel titleLabel;
    private JTextField titleField;
    private JLabel ratingLabel;
    private JTextField ratingField;
    private JLabel caloriesLabel;
    private JTextField caloriesField;
    private JLabel proteinLabel;
    private JTextField proteinField;
    private JLabel fatLabel;
    private JTextField fatField;
    private JLabel sodiumLabel;
    private JTextField sodiumField;
    private JLabel priceLabel;
    private JTextField priceField;

    public ClientView() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1000, 600);

        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();
        JPanel panel4 = new JPanel();
        JPanel panel5 = new JPanel();

        searchProductsButton = new JButton("search products");
        addOrdersButton = new JButton("add order");
        backButton = new JButton("back");
        //modifyProductsButton = new JButton("modify product");
        //createProductsButton = new JButton("create product");
        panel1.add(searchProductsButton);
        panel1.add(addOrdersButton);
        panel1.add(backButton);
        //panel1.add(modifyProductsButton);
        //panel1.add(createProductsButton);

        dataLabel = new JLabel("data");
        dataField = new JTextField(15);
        titleLabel = new JLabel("title");
        titleField = new JTextField(15);
        ratingLabel = new JLabel("rating");
        ratingField = new JTextField("0",15);
        caloriesLabel = new JLabel("calories");
        caloriesField = new JTextField("0",15);
        proteinLabel = new JLabel("protein");
        proteinField = new JTextField("0",15);
        fatLabel = new JLabel("fat");
        fatField = new JTextField("0",15);
        sodiumLabel = new JLabel("sodium");
        sodiumField = new JTextField("0",15);
        priceLabel = new JLabel("price");
        priceField = new JTextField("0",15);
        keyLabel = new JLabel("keyWord");
        keyField = new JTextField(15);
        panel2.add(dataLabel);
        panel2.add(dataField);
        panel2.add(titleLabel);
        panel2.add(titleField);
        panel2.add(ratingLabel);
        panel2.add(ratingField);
        panel2.add(caloriesLabel);
        panel2.add(caloriesField);
        panel3.add(proteinLabel);
        panel3.add(proteinField);
        panel3.add(fatLabel);
        panel3.add(fatField);
        panel3.add(sodiumLabel);
        panel3.add(sodiumField);
        panel4.add(priceLabel);
        panel4.add(priceField);
        panel4.add(keyLabel);
        panel4.add(keyField);


        menuSimpleArea = new JTextArea(12, 40);
        JScrollPane scrollMenuSimpleArea = new JScrollPane(menuSimpleArea);
        scrollMenuSimpleArea.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        menuComposeArea = new JTextArea(12, 40);
        JScrollPane scrollMenuComposeArea = new JScrollPane(menuComposeArea);
        scrollMenuComposeArea.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        panel5.add(scrollMenuSimpleArea);
        panel5.add(scrollMenuComposeArea);

        JPanel panel = new JPanel();
        panel.add(panel1);
        panel.add(panel2);
        panel.add(panel3);
        panel.add(panel4);
        panel.add(panel5);

        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        this.setContentPane(panel);
    }

    public String getMenuSimpleArea() {
        return menuSimpleArea.getText();
    }

    public void setMenuSimpleArea(String menuSimpleArea) {
        this.menuSimpleArea.setText(menuSimpleArea) ;
    }

    public String getMenuComposeArea() {
        return menuComposeArea.getText();
    }

    public void setMenuComposeArea(String menuComposeArea) {
        this.menuComposeArea.setText(menuComposeArea);
    }

    public String getDataField() {
        return dataField.getText();
    }

    public void setDataField(String titleField) {
        this.dataField.setText(titleField);
    }

    public String getKeyField() {
        return keyField.getText();
    }

    public void setKeyField(String titleField) {
        this.keyField.setText(titleField);
    }

    public String getTitleField() {
        return titleField.getText();
    }

    public void setTitleField(String titleField) {
        this.titleField.setText(titleField);
    }

    public String getRatingField() {
        return ratingField.getText();
    }

    public void setRatingField(String ratingField) {
        this.ratingField.setText(ratingField);
    }

    public String getCaloriesField() {
        return caloriesField.getText();
    }

    public void setCaloriesField(String caloriesField) {
        this.caloriesField.setText(caloriesField);
    }

    public String getProteinField() {
        return proteinField.getText();
    }

    public void setProteinField(String proteinField) {
        this.proteinField.setText(proteinField);
    }

    public String getFatField() {
        return fatField.getText();
    }

    public void setFatField(String fatField) {
        this.fatField.setText(fatField);
    }

    public String getSodiumField() {
        return sodiumField.getText();
    }

    public void setSodiumField(String sodiumField) {
        this.sodiumField.setText(sodiumField);
    }

    public String getPriceField() {
        return priceField.getText();
    }

    public void setPriceField(String priceField) {
        this.priceField.setText(priceField);
    }

    public void addSearchProductsListener(ActionListener e) {

        searchProductsButton.addActionListener(e);
    }

    public void addAddOrdersListener(ActionListener e) {

        addOrdersButton.addActionListener(e);
    }

    public void addBackListener(ActionListener e) {

        backButton.addActionListener(e);
    }

    /*
    public void addModifyProductsListener(ActionListener e) {

        modifyProductsButton.addActionListener(e);
    }

    public void addCreateProductsListener(ActionListener e) {

        createProductsButton.addActionListener(e);
    }
     */
}
