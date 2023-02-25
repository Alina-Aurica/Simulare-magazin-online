package businessLayer;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;

public interface IDeliveryServiceProcessing {
    //Comenzi ale Adminului -- deocamdata fara rapoarte -- acum si cu rapoarte
    public ArrayList<MenuItem> importProduct();
    public ArrayList<MenuItem> addProduct(String title, Float rating, int calories, int protein, int fat, int sodium, int price);
    public ArrayList<MenuItem> deleteProduct(String title);
    public ArrayList<MenuItem> modifyProduct(String title, Float rating, int calories, int protein, int fat, int sodium, int price);
    public CompositeProduct createMenu(String title1, String title2, String title3);
    public void createReport1(int startHour, int endHour, DeliveryService deliveryService);
    public void createReport2(int noOfTime, DeliveryService deliveryService);
    public void createReport3(int noOfTime, int price, DeliveryService deliveryService);
    public void createReport4(int day, DeliveryService deliveryService);

    //Comenzi ale clientului
    public ArrayList<MenuItem> searchKeyWord(String KeyWord);
    public ArrayList<MenuItem> searchRating(Float rating);
    public ArrayList<MenuItem> searchCalories(int calories);
    public ArrayList<MenuItem> searchProtein(int protein);
    public ArrayList<MenuItem> searchFat(int fat);
    public ArrayList<MenuItem> searchSodium(int sodium);
    public ArrayList<MenuItem> searchPrice(int price);
    public HashMap<Order, ArrayList<MenuItem>> createOrder(Order order, ArrayList<MenuItem> menu);

}
