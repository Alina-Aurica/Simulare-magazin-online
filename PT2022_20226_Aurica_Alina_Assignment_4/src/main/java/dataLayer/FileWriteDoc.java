package dataLayer;

import businessLayer.MenuItem;
import businessLayer.Order;
import businessLayer.User;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class FileWriteDoc {

    public static void billCreate(HashMap<Order, ArrayList<MenuItem>> orders){
        try {
            FileWriter myWriter = new FileWriter("bill.txt");
            myWriter.write(String.valueOf(orders));
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void report1Create(ArrayList<Order> order){
        try {
            FileWriter myWriter = new FileWriter("report1.txt");
            myWriter.write(String.valueOf(order));
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void report2Create(ArrayList<MenuItem> menuItems){
        try {
            FileWriter myWriter = new FileWriter("report2.txt");
            myWriter.write(String.valueOf(menuItems));
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void report3Create(ArrayList<Integer> users){
        try {
            FileWriter myWriter = new FileWriter("report3.txt");
            myWriter.write(String.valueOf(users));
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void report4Create(String result){
        try {
            FileWriter myWriter = new FileWriter("report4.txt");
            myWriter.write(result);
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
