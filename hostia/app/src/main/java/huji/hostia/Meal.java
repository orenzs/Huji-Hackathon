package huji.hostia;

import java.util.ArrayList;


public class Meal {
    private String name;
    private ArrayList<MealCategory> category;
    private int stock;


    public Meal(String name, ArrayList<MealCategory> category, int stock) {
        this.name = name;
        this.category = category;
        this.stock = stock;
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

    enum MealCategory {
        DAIRY,
        MEAT,
        BREAD,
        SOUP,
        VEGTABLES,
        OTHER
    }
}

