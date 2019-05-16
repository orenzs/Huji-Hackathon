package huji.hostia;

import android.util.LongSparseArray;

import java.util.ArrayList;


public class Meal {
    private String name;
    private Long ID;
    private ArrayList<MealCategory> category;
    private LongSparseArray<Long> orders;  // Map<ID, Number_of_orders>
    private int stock;


    public Meal(String name, Long id, ArrayList<MealCategory> category, int stock) {
        this.name = name;
        ID = id;
        this.category = category;
        this.stock = stock;
        this.orders = new LongSparseArray<>();
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

    public Long getID() {
        return ID;
    }

    enum MealCategory {
        DAIRY,
        MEAT,
        KOSHER,
        VEGAN,
        OTHER
    }
}

