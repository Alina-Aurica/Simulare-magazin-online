package presentationLayer;

import businessLayer.*;
import businessLayer.MenuItem;
import dataLayer.Deserializator;
import dataLayer.FileWriteDoc;
import dataLayer.Serializator;
import presentationLayer.admin.AdminModifyProduct;
import presentationLayer.admin.AdminReportProduct;
import presentationLayer.admin.AdminView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class Controller {
    private MainGUI gui;
    private AdminView adminView;
    private EmployeeView employeeView;
    private ClientView clientView;
    private AdminModifyProduct adminModifyProduct;
    private AdminReportProduct adminReportProduct;
    private DeliveryService deliveryService = new DeliveryService();
    private Client client;
    private ArrayList<MenuItem> comanda = new ArrayList<MenuItem>();
    public boolean mentine = false;

    public Controller(MainGUI gui){
        this.gui = gui;
        gui.addRegisterListener(new RegisterListener());
        gui.addLogInListener(new LogInListener());
    }

    class RegisterListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            String userName = gui.getUserNameField();
            String password = gui.getPasswordField();
            try {
                deliveryService.setUsers(Deserializator.DeserializeUserList());
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            User client = new Client(userName, password);
            deliveryService.getUsers().add(client);
            try {
                Serializator.SerializeUserList(deliveryService.getUsers());
                deliveryService.setUsers(Deserializator.DeserializeUserList());
            } catch (IOException ex) {
                ex.printStackTrace();
            }

            /*for(User u: deliveryService.getUsers()){
                System.out.println(u.toString());
            }*/
        }
    }

    class LogInListener implements ActionListener{ //nu imi deschide fereastra

        @Override
        public void actionPerformed(ActionEvent e) {
            String userName = gui.getUserNameField();
            String password = gui.getPasswordField();

            try {
                deliveryService.setUsers(Deserializator.DeserializeUserList());
            } catch (IOException ex) {
                ex.printStackTrace();
            }

            //User admin = new Admin("admin1", "admin1");
            //User employee = new Employee("employee1", "employee1");
            //deliveryService.getUsers().add(admin);
            //deliveryService.getUsers().add(employee);
            /*
            try {
                Serializator.SerializeUserList(deliveryService.getUsers());
                deliveryService.setUsers(Deserializator.DeserializeUserList());
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            */

            for(User u: deliveryService.getUsers())
            {
                //System.out.println(u.toString());
                if(u.getUserName().compareTo(userName) == 0 && u.getPassword().compareTo(password) == 0)
                {
                    System.out.println("suntem aici");
                    if(u.getRole().compareTo("admin") == 0)
                    {
                        //deschidem fereastra pentru admin
                        gui.setVisible(false);
                        gui.dispose();
                        adminView = new AdminView();

                        adminView.addImportListener(new ImportListener());
                        adminView.addModifyListener(new ModifyListener());
                        adminView.addReportListener(new ReportListener());

                        adminView.setVisible(true);
                    }

                    if(u.getRole().compareTo("client") == 0)
                    {
                        //deschidem fereastra pentru client
                        gui.setVisible(false);
                        gui.dispose();
                        clientView = new ClientView();

                        try {
                            deliveryService.setMenuItems(Deserializator.DeserializeMenuItems());
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }

                        String result1 = "";
                        for(MenuItem m: deliveryService.getMenuItems()){
                            result1 += m.toString() + "\n";
                        }
                        clientView.setMenuSimpleArea(result1);
                        client = new Client(u.getUserName(), u.getPassword());
                        System.out.println("mesaj" + client.toString());

                        clientView.addSearchProductsListener(new SearchClientListener());
                        clientView.addAddOrdersListener(new AddOrdersClientListener());
                        clientView.addBackListener(new AddBackListener());

                        clientView.setVisible(true);
                    }

                    if(u.getRole().compareTo("employee") == 0){
                        //deschidem fereastra pentru employee
                        gui.setVisible(false);
                        gui.dispose();
                        employeeView = new EmployeeView();

                        if(mentine == true)
                            employeeView.setMesajNotificare("Avem o comanda de procesat!");

                        employeeView.setVisible(true);
                    }
                }
            }
        }
    }

    class AddBackListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            clientView.setVisible(false);
            clientView.dispose();

            gui.setVisible(true);
        }
    }

    class ImportListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            deliveryService.setMenuItems(deliveryService.importProduct());

            try {
                Serializator.SerializeMenuItem(deliveryService.getMenuItems());
            } catch (IOException ex) {
                ex.printStackTrace();
            }

            for(MenuItem m: deliveryService.getMenuItems()){
                System.out.println(m.toString());
            }
        }
    }

    class ModifyListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            gui.setVisible(false);
            gui.dispose();
            adminModifyProduct = new AdminModifyProduct();

            try {
                deliveryService.setMenuItems(Deserializator.DeserializeMenuItems());
            } catch (IOException ex) {
                ex.printStackTrace();
            }

            String result1 = "";
            for(MenuItem m: deliveryService.getMenuItems()){
                result1 += m.toString() + "\n";
            }
            adminModifyProduct.setMenuSimpleArea(result1);

            adminModifyProduct.addAddProductsListener(new AddProductAdminListener());
            adminModifyProduct.addDeleteProductsListener(new DeleteProductAdminListener());
            adminModifyProduct.addModifyProductsListener(new ModifyProductAdminListener());
            adminModifyProduct.addCreateProductsListener(new CreateProductAdminListener());

            adminModifyProduct.setVisible(true);
        }
    }

    class ReportListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            gui.setVisible(false);
            gui.dispose();
            adminReportProduct = new AdminReportProduct();

            adminReportProduct.addReport1ButtonListener(new Report1Listener());
            adminReportProduct.addReport2ButtonListener(new Report2Listener());
            adminReportProduct.addReport3ButtonListener(new Report3Listener());
            adminReportProduct.addReport4ButtonListener(new Report4Listener());

            adminReportProduct.setVisible(true);
        }
    }

    class Report1Listener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                deliveryService.setComenzi(Deserializator.DeserializeComenzi());
                deliveryService.setOrders(Deserializator.DeserializeOrder());
                deliveryService.setMenuItems(Deserializator.DeserializeMenuItems());
            } catch (IOException ex) {
                ex.printStackTrace();
            }

            int startHour = Integer.parseInt(adminReportProduct.getDataFirstField());
            int endHour = Integer.parseInt(adminReportProduct.getDataSecondField());

            deliveryService.createReport1(startHour, endHour, deliveryService);
        }
    }

    class Report2Listener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                deliveryService.setComenzi(Deserializator.DeserializeComenzi());
                deliveryService.setOrders(Deserializator.DeserializeOrder());
                deliveryService.setMenuItems(Deserializator.DeserializeMenuItems());
            } catch (IOException ex) {
                ex.printStackTrace();
            }

            int noOfTime = Integer.parseInt(adminReportProduct.getNoOfTimeField());

            deliveryService.createReport2(noOfTime, deliveryService);
        }
    }

    class Report3Listener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                deliveryService.setComenzi(Deserializator.DeserializeComenzi());
                deliveryService.setOrders(Deserializator.DeserializeOrder());
                deliveryService.setMenuItems(Deserializator.DeserializeMenuItems());
            } catch (IOException ex) {
                ex.printStackTrace();
            }

            int noOfTime = Integer.parseInt(adminReportProduct.getNoOfTimeField());
            int price = Integer.parseInt(adminReportProduct.getPriceField());

            deliveryService.createReport3(noOfTime, price, deliveryService);
        }
    }

    class Report4Listener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                deliveryService.setComenzi(Deserializator.DeserializeComenzi());
                deliveryService.setOrders(Deserializator.DeserializeOrder());
                deliveryService.setMenuItems(Deserializator.DeserializeMenuItems());
            } catch (IOException ex) {
                ex.printStackTrace();
            }

            int day = Integer.parseInt(adminReportProduct.getDataFirstField());

            deliveryService.createReport4(day, deliveryService);
        }
    }

    class AddProductAdminListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            String title = adminModifyProduct.getTitle1Field();
            float rating = Float.parseFloat(adminModifyProduct.getRatingField());
            int calories = Integer.parseInt(adminModifyProduct.getCaloriesField());
            int protein = Integer.parseInt(adminModifyProduct.getProteinField());
            int fat = Integer.parseInt(adminModifyProduct.getFatField());
            int sodium = Integer.parseInt(adminModifyProduct.getSodiumField());
            int price = Integer.parseInt(adminModifyProduct.getPriceField());

            try {
                deliveryService.setMenuItems(Deserializator.DeserializeMenuItems());
            } catch (IOException ex) {
                ex.printStackTrace();
            }

            deliveryService.addProduct(title, rating, calories, protein, fat, sodium, price);
            try {
                Serializator.SerializeMenuItem(deliveryService.getMenuItems());
                deliveryService.setMenuItems(Deserializator.DeserializeMenuItems());
            } catch (IOException ex) {
                ex.printStackTrace();
            }

            String result1 = "";
            for(MenuItem m: deliveryService.getMenuItems()){
                //System.out.println(m.toString());
                result1 += m.toString() + "\n";
            }
            adminModifyProduct.setMenuSimpleArea(result1);
        }
    }

    class DeleteProductAdminListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            String title = adminModifyProduct.getTitle1Field();

            try {
                deliveryService.setMenuItems(Deserializator.DeserializeMenuItems());
            } catch (IOException ex) {
                ex.printStackTrace();
            }

            deliveryService.deleteProduct(title);

            try {
                Serializator.SerializeMenuItem(deliveryService.getMenuItems());
                deliveryService.setMenuItems(Deserializator.DeserializeMenuItems());
            } catch (IOException ex) {
                ex.printStackTrace();
            }

            String result1 = "";
            for(MenuItem m: deliveryService.getMenuItems()){
                //System.out.println(m.toString());
                result1 += m.toString() + "\n";
            }
            adminModifyProduct.setMenuSimpleArea(result1);
        }
    }

    class ModifyProductAdminListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            String title = adminModifyProduct.getTitle1Field();
            float rating = Float.parseFloat(adminModifyProduct.getRatingField());
            int calories = Integer.parseInt(adminModifyProduct.getCaloriesField());
            int protein = Integer.parseInt(adminModifyProduct.getProteinField());
            int fat = Integer.parseInt(adminModifyProduct.getFatField());
            int sodium = Integer.parseInt(adminModifyProduct.getSodiumField());
            int price = Integer.parseInt(adminModifyProduct.getPriceField());

            try {
                deliveryService.setMenuItems(Deserializator.DeserializeMenuItems());
            } catch (IOException ex) {
                ex.printStackTrace();
            }

            deliveryService.modifyProduct(title, rating, calories, protein, fat, sodium, price);
            try {
                Serializator.SerializeMenuItem(deliveryService.getMenuItems());
                deliveryService.setMenuItems(Deserializator.DeserializeMenuItems());
            } catch (IOException ex) {
                ex.printStackTrace();
            }

            String result1 = "";
            for(MenuItem m: deliveryService.getMenuItems()){
                //System.out.println(m.toString());
                result1 += m.toString() + "\n";
            }
            adminModifyProduct.setMenuSimpleArea(result1);
        }
    }

    class CreateProductAdminListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            CompositeProduct menu = new CompositeProduct();
            String title1 = adminModifyProduct.getTitle1Field();
            String title2 = adminModifyProduct.getTitle2Field();
            String title3 = adminModifyProduct.getTitle3Field();
            String name = adminModifyProduct.getNameField();

            try {
                deliveryService.setMenuItems(Deserializator.DeserializeMenuItems());
            } catch (IOException ex) {
                ex.printStackTrace();
            }

            menu = deliveryService.createMenu(title1, title2, title3);
            menu.setTitle(name);
            deliveryService.getMenuItems().add(menu);

            try {
                Serializator.SerializeMenuItem(deliveryService.getMenuItems());
                deliveryService.setMenuItems(Deserializator.DeserializeMenuItems());
            } catch (IOException ex) {
                ex.printStackTrace();
            }

            String result1 = "";
            for(MenuItem m: deliveryService.getMenuItems()){
                //System.out.println(m.toString());
                result1 += m.toString() + "\n";
            }
            adminModifyProduct.setMenuSimpleArea(result1);

        }
    }

    class SearchClientListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            String keyWord = clientView.getKeyField();
            float rating = Float.parseFloat(clientView.getRatingField());
            int calories = Integer.parseInt(clientView.getCaloriesField());
            int protein = Integer.parseInt(clientView.getProteinField());
            int fat = Integer.parseInt(clientView.getFatField());
            int sodium = Integer.parseInt(clientView.getSodiumField());
            int price = Integer.parseInt(clientView.getPriceField());

            try {
                deliveryService.setMenuItems(Deserializator.DeserializeMenuItems());
            } catch (IOException ex) {
                ex.printStackTrace();
            }

            if(keyWord != null)
                deliveryService.setMenuItems(deliveryService.searchKeyWord(keyWord));
            if(rating != 0)
                deliveryService.setMenuItems(deliveryService.searchRating(rating));
            if(calories != 0)
                deliveryService.setMenuItems(deliveryService.searchCalories(calories));
            if(protein != 0)
                deliveryService.setMenuItems(deliveryService.searchProtein(protein));
            if(fat != 0)
                deliveryService.setMenuItems(deliveryService.searchFat(fat));
            if(sodium != 0)
                deliveryService.setMenuItems(deliveryService.searchSodium(sodium));
            if(price != 0)
                deliveryService.setMenuItems(deliveryService.searchPrice(price));

            String result1 = "";
            for(MenuItem m: deliveryService.getMenuItems()){
                //System.out.println(m.toString());
                result1 += m.toString() + "\n";
            }
            clientView.setMenuComposeArea(result1);

        }
    }

    class AddOrdersClientListener implements ActionListener{ //mai uita-te pe formarea de clientId si orderId
        int nrOfIteration = 0;
        int price = 0;

        @Override
        public void actionPerformed(ActionEvent e) {
            String title = clientView.getTitleField();
            //title += title + " ";
            try {
                deliveryService.setMenuItems(Deserializator.DeserializeMenuItems());
            } catch (IOException ex) {
                ex.printStackTrace();
            }

            for(MenuItem m: deliveryService.getMenuItems()){
                if(m.getTitle().compareTo(title) == 0){
                    comanda.add(m);
                    price += m.getPrice();
                    nrOfIteration++;
                    m.incrementNrOrders();
                }
            }

            if(nrOfIteration == 4){
                Random rand = new Random();
                int clientId = client.getUserName().length();
                //System.out.println("mesaj" + client.toString());
                int orderId = rand.nextInt(1000);
                String data = clientView.getDataField();
                try {
                    deliveryService.setOrders(Deserializator.DeserializeOrder());
                    deliveryService.setComenzi(Deserializator.DeserializeComenzi());
                    Order order = null;
                    try {
                        order = new Order(orderId, clientId, data, price);
                    } catch (ParseException ex) {
                        ex.printStackTrace();
                    }
                    deliveryService.setOrders(deliveryService.createOrder(order, comanda));
                    //deliveryService.getOrders().put(order, comanda);
                    deliveryService.getComenzi().add(order); //trebuie serializata si asta4

                    Observer observer = new Observer() {
                        @Override
                        public void update(String mesaj) {

                        }
                    };
                    deliveryService.addObserver(observer);
                    deliveryService.addComanda(order);
                    deliveryService.addObserver(observer);
                    mentine = true;
                    JOptionPane.showMessageDialog(null, "order " + order.getOrderId() + " is added" + "\n");
                    FileWriteDoc.billCreate(deliveryService.getOrders());
                    Serializator.SerializeOrders(deliveryService.getOrders());
                    Serializator.SerializeComenzi(deliveryService.getComenzi());
                } catch (HeadlessException ex) {
                    ex.printStackTrace();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }

            }

        }
    }
}
