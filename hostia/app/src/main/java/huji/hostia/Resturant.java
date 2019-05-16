package huji.hostia;

import android.location.Location;

import java.util.ArrayList;

public class Resturant {
    private Long id;
    private String name;
    private MealCategory category;
    private ArrayList<Meal> meals;
    private String lat, lon;


    public Resturant(long id, String name, MealCategory category, Location location) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.lon = Double.toString(location.getLongitude());
        this.lat = Double.toString(location.getLatitude());
    }

    public ArrayList<Meal> getMeals() {
        return meals;
    }

    public void setMeals(ArrayList<Meal> meals) {
        this.meals = meals;
    }

    public Location getLocation() {
        Location location = null;
        if (lat != null && lon != null) {
            location = new Location(Long.toString(this.id));
            location.setLatitude(Double.parseDouble(lat));
            location.setLongitude(Double.parseDouble(lon));
        }
        return location;
    }


    public MealCategory getCategory() {
        return category;
    }

    public void setCategory(MealCategory category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
