package businessLayer;

import presentationLayer.EmployeeView;
import presentationLayer.Observer;

import java.util.ArrayList;

public class Observable {
    ArrayList<Order> comenzi = new ArrayList<Order>();
    ArrayList<Observer> obsComenzi = new ArrayList<Observer>();

    public void addComanda(Order comanda){
        this.comenzi.add(comanda);
        setMesaj("Avem o comanda de procesat!");
        System.out.println("avem o comanda de procesat!");
    }

    public void addObserver(Observer obsComenzi){
        this.obsComenzi.add(obsComenzi);
    }

    public void removeObserver(Observer obsComenzi){
        this.obsComenzi.remove(obsComenzi);
    }

    public void setMesaj(String mesaj){
        for(Observer o : obsComenzi) {
            o.update(mesaj);
            EmployeeView employeeView = new EmployeeView();
            employeeView.update(mesaj);
            employeeView.setVisible(true);
            System.out.println("PROGRESSSS!");
        }
    }
}
