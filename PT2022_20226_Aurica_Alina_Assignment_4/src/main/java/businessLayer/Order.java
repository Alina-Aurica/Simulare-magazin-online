package businessLayer;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

public class Order implements Serializable { //mai trebuie analizat la formatul de data
    private static final long serialVersionUID = -8693362311902596867l;
    private int orderId;
    private int clientId;
    private Date orderDate;
    private int price;
    private int nrOrders;

    public Order(int orderId, int clientId, String orderDate, int price) throws ParseException {
        this.orderId = orderId;
        this.clientId = clientId;
        this.orderDate = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss").parse(orderDate);
        this.price = price;
        this.nrOrders = 0;
    }

    public int getNrOrders() {
        return this.nrOrders;
    }

    public void setNrOrders(int nrOrders) {
        this.nrOrders = nrOrders;
    }

    public int getOrderId() {
        return this.orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getPrice() {
        return this.price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getClientId() {
        return this.clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public Date getOrderDate() {
        return this.orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    @Override
    public String toString(){
        return "Order " + orderId + " a fost creat de " + clientId + " la data de " + orderDate + " si a costat " + price;
    }

    @Override
    public int hashCode(){
        return clientId + orderId;
    }

    public int getHour()
    {
        String hour = new SimpleDateFormat("HH").format(this.getOrderDate());
        System.out.println("ora la care s-a facut comanda " + hour);
        return Integer.parseInt(hour);
    }

    public int getDays()
    {
        String day = new SimpleDateFormat("dd").format(this.getOrderDate());
        //System.out.println("ora la care s-a facut comanda " + day);
        return Integer.parseInt(day);
    }

    public int increment(){
        return nrOrders++;
    }
}
