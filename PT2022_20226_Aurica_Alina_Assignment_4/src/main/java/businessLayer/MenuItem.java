package businessLayer;

import java.io.Serializable;
import java.util.Objects;

public abstract class MenuItem implements Serializable {
    private static final long serialVersionUID = 3937406880047801389l;
    private String title;
    private float rating;
    private int calories;
    private int protein;
    private int fat;
    private int sodium;
    private int price;
    private int nrOrders;

    public MenuItem(String title, float rating, int calories, int protein, int fat, int sodium, int price){
        this.title = title;
        this.rating = rating;
        this.calories = calories;
        this.protein = protein;
        this.fat = fat;
        this.sodium = sodium;
        this.price = price;
        this.nrOrders = new Integer(0);
    }

    public MenuItem() {
    }

    public abstract int computePrice();

    public abstract String toString();

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public int getProtein() {
        return protein;
    }

    public void setProtein(int protein) {
        this.protein = protein;
    }

    public int getFat() {
        return fat;
    }

    public void setFat(int fat) {
        this.fat = fat;
    }

    public int getSodium() {
        return sodium;
    }

    public void setSodium(int sodium) {
        this.sodium = sodium;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void incrementNrOrders() {
        this.nrOrders++;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MenuItem menuItem = (MenuItem) o;
        return Objects.equals(title, menuItem.title);
    }
}
