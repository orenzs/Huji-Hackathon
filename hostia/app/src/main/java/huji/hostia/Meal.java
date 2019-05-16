package huji.hostia;

import android.util.LongSparseArray;


public class Meal {
    private final String name;
    private final Long id;
    private LongSparseArray<Long> orders;  // Map<id, Number_of_orders>
    private final int stock;
    private final String description;


    public Meal(String name, Long id, int stock, String description) {
        this.name = name;
        this.id = id;
        this.stock = stock;
        this.description = description;
        this.orders = new LongSparseArray<>();
    }

    public Meal() {
        this.name = "";
        this.id = 0L;
        this.stock = 0;
        this.description = "";
    }


    int getStock() {
        return stock;
    }

    public String getName() {
        return name;
    }

    public void addOrder(Long ID, Long size){
        if (this.orders.get(id) != null)
        this.orders.put(ID, size);
    }

    Long getId() {
        return id;
    }

    String getDescription() {
        return description;
    }

}

