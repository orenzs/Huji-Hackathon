package huji.hostia;

import android.util.LongSparseArray;

import java.util.ArrayList;


public class Meal {
    private String name;
    private ArrayList<MealCategory> category;
    private LongSparseArray<Long> orders;  // Map<ID, Number_of_orders>
    private int stock;


    public Meal(String name, ArrayList<MealCategory> category, int stock) {
        this.name = name;
        this.category = category;
        this.stock = stock;
        this.orders = new LongSparseArray<Long>();
    }

    public ArrayList<MealCategory> getCategory() {
        return category;
    }

    public int getStock() {
        return stock;
    }

    public String getName() {
        return name;
    }

    public void addOrder(Long ID, Long size){
//        if (this.orders.get(ID) != null)
        this.orders.put(ID, size);
    }

    enum MealCategory {
        DAIRY,
        MEAT,
        BREAD,
        SOUP,
        VEGTABLES,
        OTHER
    }
}

