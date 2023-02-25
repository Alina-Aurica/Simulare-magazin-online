package businessLayer;

import java.io.Serializable;
import java.util.Objects;

public class BaseProduct extends MenuItem implements Serializable {
    private static final long serialVersionUID = -4795955850706887470l;

    public BaseProduct(String title, float rating, int calories, int protein, int fat, int sodium, int price){
        super(title, rating, calories, protein, fat, sodium, price);
    }

    public BaseProduct() {
        super();
    }

    @Override
    public int computePrice() {
        return this.getPrice();
    }

    @Override
    public String toString() {
        return "Product "+ " " + this.getTitle() + " " + this.getRating() + " " + this.getCalories() + " " + this.getProtein() + " " + this.getFat() + " " + this.getSodium() + " " + this.getPrice();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MenuItem menuItem = (MenuItem) o;
        return Objects.equals(this.getTitle(), menuItem.getTitle());
    }


}
