package dataLayer;

import businessLayer.MenuItem;
import businessLayer.Order;
import businessLayer.User;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Serializator {

    public static void SerializeUserList(ArrayList<User> users) throws IOException {

        try {
            FileOutputStream fileOut = new FileOutputStream("users.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.reset();
            System.out.println("inainte de scris in fisier");
            out.writeObject(users);
            System.out.println("s-a scris in fisier");
            out.close();
            fileOut.close();
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    public static void SerializeMenuItem(ArrayList<MenuItem> menuItems) throws IOException{
        try {
            FileOutputStream fileOut = new FileOutputStream("menuItems.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.reset();
            System.out.println("inainte de scris in fisier");
            out.writeObject(menuItems);
            System.out.println("s-a scris in fisier");
            out.close();
            fileOut.close();
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    public static void SerializeOrders(HashMap<Order, ArrayList<MenuItem>> order) throws IOException{
        try {
            FileOutputStream fileOut = new FileOutputStream("order.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.reset();
            System.out.println("inainte de scris in fisier");
            out.writeObject(order);
            System.out.println("s-a scris in fisier");
            out.close();
            fileOut.close();
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    public static void SerializeComenzi(ArrayList<Order> comenzi) throws IOException{
        try {
            FileOutputStream fileOut = new FileOutputStream("comenzi.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.reset();
            System.out.println("inainte de scris in fisier");
            out.writeObject(comenzi);
            System.out.println("s-a scris in fisier");
            out.close();
            fileOut.close();
        } catch (IOException i) {
            i.printStackTrace();
        }
    }
}
