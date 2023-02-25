package dataLayer;

import businessLayer.MenuItem;
import businessLayer.Order;
import businessLayer.User;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

import static java.lang.System.in;

public class Deserializator {

    public static ArrayList<User> DeserializeUserList() throws IOException {
        FileInputStream fileIn = new FileInputStream("users.ser");
        ObjectInputStream in = new ObjectInputStream(fileIn);;
        try {
            //fileIn = new FileInputStream("users.ser");
            //in = new ObjectInputStream(fileIn);
            return (ArrayList<User>) in.readObject();
        } catch (IOException i) {
            i.printStackTrace();
            return null;
        } catch (ClassNotFoundException e) {
            System.out.println("clasa nu a fost gasita");
            e.printStackTrace();
            return null;
        }finally {
            in.close();
            fileIn.close();
        }
    }

    public static ArrayList<MenuItem> DeserializeMenuItems() throws IOException {
        FileInputStream fileIn = new FileInputStream("menuItems.ser");
        ObjectInputStream in = new ObjectInputStream(fileIn);;
        try {
            //fileIn = new FileInputStream("users.ser");
            //in = new ObjectInputStream(fileIn);
            return (ArrayList<MenuItem>) in.readObject();
        } catch (IOException i) {
            i.printStackTrace();
            return null;
        } catch (ClassNotFoundException e) {
            System.out.println("clasa nu a fost gasita");
            e.printStackTrace();
            return null;
        }finally {
            in.close();
            fileIn.close();
        }
    }

    public static HashMap<Order, ArrayList<MenuItem>> DeserializeOrder() throws IOException {
        FileInputStream fileIn = new FileInputStream("order.ser");
        ObjectInputStream in = new ObjectInputStream(fileIn);;
        try {
            //fileIn = new FileInputStream("users.ser");
            //in = new ObjectInputStream(fileIn);
            return (HashMap<Order, ArrayList<MenuItem>>) in.readObject();
        } catch (IOException i) {
            i.printStackTrace();
            return null;
        } catch (ClassNotFoundException e) {
            System.out.println("clasa nu a fost gasita");
            e.printStackTrace();
            return null;
        }finally {
            in.close();
            fileIn.close();
        }
    }

    public static ArrayList<Order> DeserializeComenzi() throws IOException {
        FileInputStream fileIn = new FileInputStream("comenzi.ser");
        ObjectInputStream in = new ObjectInputStream(fileIn);;
        try {
            //fileIn = new FileInputStream("users.ser");
            //in = new ObjectInputStream(fileIn);
            return (ArrayList<Order>) in.readObject();
        } catch (IOException i) {
            i.printStackTrace();
            return null;
        } catch (ClassNotFoundException e) {
            System.out.println("clasa nu a fost gasita");
            e.printStackTrace();
            return null;
        }finally {
            in.close();
            fileIn.close();
        }
    }
}
