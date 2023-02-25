package businessLayer;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

public class CompositeProduct extends MenuItem implements Serializable { //mai trebuie gandit putin si aici
    private static final long serialVersionUID = 2324731997492344933l;

    private ArrayList<BaseProduct> menu;

    public CompositeProduct(String title, float rating, int calories, int protein, int fat, int sodium, int price){
        super(title, rating, calories, protein, fat, sodium, price);
        this.menu = new ArrayList<BaseProduct>();

    }

    public CompositeProduct(){
        super();
        this.menu = new ArrayList<BaseProduct>();
    }

    @Override
    public int computePrice() {
        int result = 0;
        for(BaseProduct p: menu)
        {
            result += p.getPrice();
        }
        return result;
    }

    @Override
    public String toString() {
        return "Product " + this.getTitle() + " " + this.computeRating() + " " + this.computeCalories() + " " + this.computeProtein() + " " + this.computeFat() + " " + this.computeSodium() + " " + this.computePrice();
    }

    public float computeRating(){
        float result = 0.0f;
        for(BaseProduct p: menu)
        {
            result += p.getRating();
        }
        return result/menu.size();
    }

    public int computeCalories() {
        int result = 0;
        for(BaseProduct p: menu)
        {
            result += p.getCalories();
        }
        return result;
    }

    public int computeProtein() {
        int result = 0;
        for(BaseProduct p: menu)
        {
            result += p.getProtein();
        }
        return result;
    }

    public int computeFat() {
        int result = 0;
        for(BaseProduct p: menu)
        {
            result += p.getFat();
        }
        return result;
    }

    public int computeSodium() {
        int result = 0;
        for(BaseProduct p: menu)
        {
            result += p.getSodium();
        }
        return result;
    }

    public ArrayList<BaseProduct> getMenu() {
        return menu;
    }

    public void setMenu(ArrayList<BaseProduct> menu) {
        this.menu = menu;
    }

    public void addProduct(MenuItem p){
        menu.add((BaseProduct) p);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MenuItem menuItem = (MenuItem) o;
        return Objects.equals(this.getTitle(), menuItem.getTitle());
    }
}
