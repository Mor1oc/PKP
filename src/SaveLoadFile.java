import Models.Component;
import Models.Order;
import Models.User;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SaveLoadFile {     // Фасад

    public static void saveAccounts(Map<String, User> accounts) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("src/folder/accounts.txt"));
            oos.writeObject(accounts);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static Map<String, User> loadAccounts() {
        Map<String, User> accounts = new HashMap<>();
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("src/folder/accounts.txt"));
            accounts = ((Map<String, User>) ois.readObject());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return accounts;
    }

    public static void saveComponents(ArrayList<Component> components) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("src/folder/components.txt"));
            oos.writeObject(components);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static ArrayList<Component> loadComponents() {
        var components = new ArrayList<Component>();
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("src/folder/components.txt"));
            components = ((ArrayList<Component>) ois.readObject());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return components;
    }

    public static void saveOrders(ArrayList<Order> components) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("src/folder/components.txt"));
            oos.writeObject(components);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static ArrayList<Order> loadOrders() {
        var components = new ArrayList<Order>();
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("src/folder/components.txt"));
            components = ((ArrayList<Order>) ois.readObject());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return components;
    }

}
