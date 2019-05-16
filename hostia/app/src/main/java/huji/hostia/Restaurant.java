package huji.hostia;

import android.location.Location;

import java.util.ArrayList;

public class Restaurant {
    private Long id;
    private String name;
    private ArrayList<Meal> meals;
    private String lat, lon;


    public Restaurant(long id, String name, Location location) {
        this.id = id;
        this.name = name;
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


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
