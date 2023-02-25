package businessLayer;

import dataLayer.FileWriteDoc;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;

public class DeliveryService extends Observable implements IDeliveryServiceProcessing, Serializable {
    private ArrayList<MenuItem> menuItems;
    private ArrayList<User> users;
    private ArrayList<Order> comenzi;
    private HashMap<Order, ArrayList<MenuItem>> orders;


    public DeliveryService(){
        this.menuItems = new ArrayList<MenuItem>();
        this.users = new ArrayList<User>();
        this.comenzi = new ArrayList<Order>();
        this.orders = new HashMap<Order, ArrayList<MenuItem>>();
    }

    public ArrayList<MenuItem> getMenuItems() {
        return menuItems;
    }

    public void setMenuItems(ArrayList<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }

    public ArrayList<Order> getComenzi() {
        return this.comenzi;
    }

    public void setComenzi(ArrayList<Order> comenzi) {
        this.comenzi = comenzi;
    }

    public HashMap<Order, ArrayList<MenuItem>> getOrders() {
        return orders;
    }

    public void setOrders(HashMap<Order, ArrayList<MenuItem>> orders) {
        this.orders = orders;
    }

    private static Function<String, MenuItem> line;
    public static Function<String, MenuItem> baseProductSplit = (line) -> {
        String[] data = line.split(",");
        System.out.println(data[1]);
        BaseProduct baseProduct = new BaseProduct(data[0], Float.parseFloat(data[1]), Integer.parseInt(data[2]), Integer.parseInt(data[3]), Integer.parseInt(data[4]), Integer.parseInt(data[5]), Integer.parseInt(data[6]));
        return baseProduct;
    };

    public TreeSet<String> importProductFromCsv() {
        TreeSet<String> items = new TreeSet<String>();
        File productFile = new File("D:\\Facultate\\ANUL 2\\Anul 2 - Semestrul 2\\TP\\PT2022_20226_Aurica_Alina_Assignment_4\\products.csv");
        try {
            Scanner sc = new Scanner(productFile);
            sc.useDelimiter(",");
            sc.nextLine();
            while(sc.hasNext())
            {
                items.add(sc.nextLine());
            }
            sc.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return items;
    }

    public void invariant(){
        assert users.size() != 0;
        assert menuItems.size() != 0;
        assert orders.size() != 0;
    }

    @Override
    public ArrayList<MenuItem> importProduct() {
        invariant();
        DeliveryService delivery = new DeliveryService();
        menuItems = (ArrayList<MenuItem>) delivery.importProductFromCsv().stream().map(baseProductSplit).collect(toList());
        return menuItems;
    }

    @Override
    public ArrayList<MenuItem> addProduct(String title, Float rating, int calories, int protein, int fat, int sodium, int price) {
        invariant();
        BaseProduct product = new BaseProduct(title, rating, calories, protein, fat, sodium, price);
        menuItems.add(product);
        for(MenuItem m: menuItems) {
            System.out.println("asdfghjk " + m.toString());
        }
        return menuItems;
    }

    @Override
    public ArrayList<MenuItem> deleteProduct(String title) {
        invariant();
        ArrayList<MenuItem> menuItemsCopy = new ArrayList<MenuItem>();
        title = title + " ";
        for(MenuItem m: menuItems){
            menuItemsCopy.add(m);
        }
        for(MenuItem m: menuItemsCopy){

            if(m.getTitle().equals(title))
            {
                System.out.println(m.getTitle());
                System.out.println("ce ii dau eu" + title);
                menuItems.remove(m);
            }
        }
        return menuItems;
    }

    @Override
    public ArrayList<MenuItem> modifyProduct(String title, Float rating, int calories, int protein, int fat, int sodium, int price) {
        invariant();
        ArrayList<MenuItem> menuItemsCopy = new ArrayList<MenuItem>();
        title = title + " ";
        for(MenuItem m: menuItems){
            menuItemsCopy.add(m);
        }
        for(MenuItem m: menuItemsCopy){
            if(m.getTitle().compareTo(title) == 0)
            {
                m.setRating(rating);
                m.setCalories(calories);
                m.setProtein(protein);
                m.setFat(fat);
                m.setSodium(sodium);
                m.setPrice(price);
                //m = b;
            }
        }
        return menuItems;
    }

    @Override
    public CompositeProduct createMenu(String title1, String title2, String title3) {
        invariant();
        CompositeProduct menu = new CompositeProduct();
        for(MenuItem m: menuItems){
            if(m.getTitle().compareTo(title1) == 0)
                menu.addProduct(m);
            if(m.getTitle().compareTo(title2) == 0)
                menu.addProduct(m);
            if(m.getTitle().compareTo(title3) == 0)
                menu.addProduct(m);
        }
        return menu;
    }

    /**
     * @param KeyWord = cauta elementele cu sodium dat
     * @return
     */

    @Override
    public ArrayList<MenuItem> searchKeyWord(String KeyWord){
        assert KeyWord != null;
        ArrayList<MenuItem> menu;
        menu = (ArrayList<MenuItem>) menuItems.stream().filter(m -> {
            return m.getTitle().contains(KeyWord);
        }).collect(toList());
        assert menu != null;
        return menu;
    }

    /**
     * @param rating = cauta elementele cu rating dat
     * @return
     */

    @Override
    public ArrayList<MenuItem> searchRating(Float rating){
        assert rating != 0;
        ArrayList<MenuItem> menu;
        menu = (ArrayList<MenuItem>) menuItems.stream().filter(m -> {
            return Float.compare(m.getRating(), rating) == 0;
        }).collect(toList());
        assert menu != null;
        return menu;
    }

    /**
     * @param calories = cauta elementele cu calories dat
     * @return
     */
    @Override
    public ArrayList<MenuItem> searchCalories(int calories){
        assert calories != 0;
        ArrayList<MenuItem> menu;
        menu = (ArrayList<MenuItem>) menuItems.stream().filter(m -> {
            return m.getCalories() == calories;
        }).collect(toList());
        assert menu != null;
        return menu;
    }

    /**
     * @param protein = cauta elementele cu protein dat
     * @return
     */
    @Override
    public ArrayList<MenuItem> searchProtein(int protein){
        assert protein != 0;
        ArrayList<MenuItem> menu;
        menu = (ArrayList<MenuItem>) menuItems.stream().filter(m -> {
            return m.getCalories() == protein;
        }).collect(toList());
        assert menu != null;
        return menu;
    }

    /**
     *
     * @param fat = cauta elementele cu fat dat
     * @return
     */
    @Override
    public ArrayList<MenuItem> searchFat(int fat){
        assert fat != 0;
        ArrayList<MenuItem> menu;
        menu = (ArrayList<MenuItem>) menuItems.stream().filter(m -> {
            return m.getFat() == fat;
        }).collect(toList());
        assert menu != null;
        return menu;
    }

    /**
     *
     * @param sodium = cauta elementele cu sodium dat
     * @return
     */
    @Override
    public ArrayList<MenuItem> searchSodium(int sodium){
        assert sodium != 0;
        ArrayList<MenuItem> menu;
        menu = (ArrayList<MenuItem>) menuItems.stream().filter(m -> {
            return m.getSodium() == sodium;
        }).collect(toList());
        assert menu != null;
        return menu;
    }

    /**
     *
     * @param price = cauta elementele cu price dat
     * @return
     */
    @Override
    public ArrayList<MenuItem> searchPrice(int price){
        assert price != 0;
        ArrayList<MenuItem> menu;
        menu = (ArrayList<MenuItem>) menuItems.stream().filter(m -> {
            return m.getPrice() == price;
        }).collect(toList());
        assert menu != null;
        return menu;
    }

    @Override
    public HashMap<Order, ArrayList<MenuItem>> createOrder(Order order, ArrayList<MenuItem> menu){
        invariant();
        orders.put(order, menu);
        return orders;
    }

    @Override
    public void createReport1(int startHour, int endHour, DeliveryService deliveryService){
        ArrayList<Order> comenzi;
        System.out.println("ana are mere") ;
        comenzi= (ArrayList<Order>) deliveryService.getComenzi().stream().filter(h1 -> {
                return h1.getHour()>= startHour;
            }).filter(h2 -> {
                return h2.getHour() <= endHour;
            }).collect(toList());
        for(Order o:comenzi)
           System.out.println(o.getOrderId());
        FileWriteDoc.report1Create( comenzi);
    }

    @Override
    public void createReport2(int noOfTime, DeliveryService deliveryService){ //face ceva, dar e la limita
        ArrayList<MenuItem> menu = new ArrayList<MenuItem>();
        System.out.println(deliveryService.getOrders().values());
        deliveryService.getMenuItems().stream().forEach(m -> {
            System.out.println(m.toString());
            System.out.println(deliveryService.getOrders().entrySet().stream().filter(s -> s.getValue().contains(m)).count());
            if(deliveryService.getOrders().entrySet().stream().filter(s -> s.getValue().contains(m)).count() >= noOfTime){
                menu.add(m);
            }
        });
        FileWriteDoc.report2Create(menu);
    }

    @Override
    public void createReport3(int noOfTime, int price, DeliveryService deliveryService){ //si asta pare ca merge :))
        ArrayList<Integer> clients = new ArrayList<Integer>();
        ArrayList<Order> retinOrder = new ArrayList<Order>();
        retinOrder = (ArrayList<Order>) deliveryService.getComenzi().stream().filter(o -> {
            for(Order order: deliveryService.getComenzi()){
                if(order.getClientId() == o.getClientId()){
                    o.increment();
                }
            }
            return o.getNrOrders() >= noOfTime;
        }).filter(p -> {
            return p.getPrice() >= price;
        }).collect(toList());
        for(Order o: retinOrder){
            clients.add(o.getClientId());
        }
        FileWriteDoc.report3Create(clients);
    }

    @Override
    public void createReport4(int day, DeliveryService deliveryService){ //nu vrea, efectiv nu vrea
        List<Order> comenziiii;
        HashMap<Order, ArrayList<MenuItem>> orders = new HashMap<Order, ArrayList<MenuItem>>();
        ArrayList<Integer> nrComandat = new ArrayList<Integer>();
        ArrayList<MenuItem> menuItem = new ArrayList<MenuItem>();
        String result = "";
        comenziiii = deliveryService.getOrders().keySet().stream().filter(c -> {
            return c.getDays() == day;
        }).collect(Collectors.toList());

        for(Order o:comenzi)
        {
            System.out.println(o.getOrderId());
            for(MenuItem m:deliveryService.getOrders().get(o))
                System.out.println(m);
        }

        /*
        orders = (HashMap<Order, ArrayList<MenuItem>>) deliveryService.getOrders().forEach(t -> {
            t.keySet().stream().filter(c -> {
                        for(Order com: comenzi){
                            return com.equals(c) == true;
                        }
                        return false;
                    });
                }).collect(Collectors.toList());

        deliveryService.getMenuItems().stream().forEach(o -> {

            if(orders.entrySet().stream().filter(s -> s.getValue().contains(o)).count() >= 1){
                nrComandat.add(orders.entrySet().stream().filter(s -> s.getValue().contains(o)).count());
                menuItem.add(o);
            }
        });
         */
        /*
        deliveryService.getMenuItems().stream().filter(p->
        {
            return comenziiii.stream().filter(c->
            {
                System.out.println(c.getOrderId());
                return Collections.frequency(deliveryService.getOrders().get(c), p) > 0;
            }).count() > 0;
        }).collect(toList()).forEach(pf->
        {
            menuItem.add(pf);
            //nrComandat.add(deliveryService.getOrders().values().stream().map(i -> i.removeIf(n -> (!n.equals(pf)))).collect(toList()).size());
            nrComandat.add(3);
        });
         */
        for(int i = 0; i < nrComandat.size(); i++)
            //result += "Produsul " + menuItem.get(i) + " a fost comandat de " + nrComandat.get(i) + "\n";
            result += "nu o mers";
        FileWriteDoc.report4Create(result);
    }

}
