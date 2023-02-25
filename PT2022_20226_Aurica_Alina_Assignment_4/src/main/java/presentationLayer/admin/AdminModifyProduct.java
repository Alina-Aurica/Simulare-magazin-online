package presentationLayer.admin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class AdminModifyProduct extends JFrame { //trebuie adaugata si partea de generate raports
    private JTextArea menuSimpleArea;
    //private JTextArea menuComposeArea;
    private JButton addProductsButton;
    private JButton deleteProductsButton;
    private JButton modifyProductsButton;
    private JButton createProductsButton;
    private JLabel title1Label;
    private JTextField title1Field;
    private JLabel title2Label;
    private JTextField title2Field;
    private JLabel title3Label;
    private JTextField title3Field;
    private JLabel nameLabel;
    private JTextField nameField;
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
    //am nevoie de field-uri pentru operatii

    public AdminModifyProduct() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1600, 600);

        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();
        JPanel panel4 = new JPanel();
        JPanel panel5 = new JPanel();

        addProductsButton = new JButton("add products");
        deleteProductsButton = new JButton("delete product");
        modifyProductsButton = new JButton("modify product");
        createProductsButton = new JButton("create product");
        panel1.add(addProductsButton);
        panel1.add(deleteProductsButton);
        panel1.add(modifyProductsButton);
        panel1.add(createProductsButton);

        title1Label = new JLabel("title");
        title1Field = new JTextField(15);
        title2Label = new JLabel("title2");
        title2Field = new JTextField(15);
        title3Label = new JLabel("title3");
        title3Field = new JTextField(15);
        nameLabel = new JLabel("nameCP");
        nameField = new JTextField(15);
        ratingLabel = new JLabel("rating");
        ratingField = new JTextField(15);
        caloriesLabel = new JLabel("calories");
        caloriesField = new JTextField(15);
        proteinLabel = new JLabel("protein");
        proteinField = new JTextField(15);
        fatLabel = new JLabel("fat");
        fatField = new JTextField(15);
        sodiumLabel = new JLabel("sodium");
        sodiumField = new JTextField(15);
        priceLabel = new JLabel("price");
        priceField = new JTextField(15);
        panel2.add(title1Label);
        panel2.add(title1Field);
        panel2.add(title2Label);
        panel2.add(title2Field);
        panel2.add(title3Label);
        panel2.add(title3Field);
        panel2.add(nameLabel);
        panel2.add(nameField);
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


        menuSimpleArea = new JTextArea(12, 40);
        JScrollPane scrollMenuSimpleArea = new JScrollPane(menuSimpleArea);
        scrollMenuSimpleArea.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        //menuComposeArea = new JTextArea(12, 40);
        panel5.add(scrollMenuSimpleArea);
        //panel5.add(menuComposeArea);

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

    /*
    public String getMenuComposeArea() {
        return menuComposeArea.getText();
    }

    public void setMenuComposeArea(String menuComposeArea) {
        this.menuComposeArea.setText(menuComposeArea);
    }
    */
    public String getTitle1Field() {
        return title1Field.getText();
    }

    public void setTitle1Field(String titleField) {
        this.title1Field.setText(titleField);
    }

    public String getTitle2Field() {
        return title2Field.getText();
    }

    public void setTitle2Field(String titleField) {
        this.title2Field.setText(titleField);
    }

    public String getTitle3Field() {
        return title3Field.getText();
    }

    public void setTitle3Field(String titleField) {
        this.title3Field.setText(titleField);
    }

    public String getNameField() {
        return nameField.getText();
    }

    public void setNameField(String titleField) {
        this.nameField.setText(titleField);
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

    public void addAddProductsListener(ActionListener e) {

        addProductsButton.addActionListener(e);
    }

    public void addDeleteProductsListener(ActionListener e) {

        deleteProductsButton.addActionListener(e);
    }

    public void addModifyProductsListener(ActionListener e) {

        modifyProductsButton.addActionListener(e);
    }

    public void addCreateProductsListener(ActionListener e) {

        createProductsButton.addActionListener(e);
    }
}
