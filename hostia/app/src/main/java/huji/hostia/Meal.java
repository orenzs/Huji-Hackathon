package huji.hostia;

import android.util.LongSparseArray;

import java.util.ArrayList;


public class Meal {
    private String name;
    private Long ID;
    private ArrayList<MealCategory> category;
    private LongSparseArray<Long> orders;  // Map<ID, Number_of_orders>
    private int stock;
    private String description;


    public Meal(String name, Long id, ArrayList<MealCategory> category, int stock, String description) {
        this.name = name;
        ID = id;
        this.category = category;
        this.stock = stock;
        this.description = description;
        this.orders = new LongSparseArray<>();
    }

    public ArrayList<MealCategory> getCategory() {
        return category;
    }

    int getStock() {
        return stock;
    }

    public String getName() {
        return name;
    }

    public void addOrder(Long ID, Long size){
//        if (this.orders.get(ID) != null)
        this.orders.put(ID, size);
    }

    Long getID() {
        return ID;
    }

    String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    enum MealCategory {
        DAIRY,
        MEAT,
        KOSHER,
        VEGAN,
        OTHER
    }
}

