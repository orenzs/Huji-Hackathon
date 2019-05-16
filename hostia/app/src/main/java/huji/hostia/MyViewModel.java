package huji.hostia;

import android.arch.lifecycle.*;
import android.arch.lifecycle.ViewModel;
import android.support.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.*;
import com.google.firebase.firestore.EventListener;

import java.util.*;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import javax.annotation.Nullable;

public class MyViewModel extends ViewModel {

    FirebaseFirestore db = FirebaseFirestore.getInstance();

    Executor executor = Executors.newSingleThreadExecutor();

    private MutableLiveData<ArrayList<Meal>> meals;
    private MutableLiveData<ArrayList<User>> users;
    private MutableLiveData<ArrayList<Restaurant>> restaurants;

    public LiveData<ArrayList<User>> getUsers() {
        if (users == null) {
            users = new MutableLiveData<>();
            loadUsers();
        }
        return users;
    }

    private void loadUsers() {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                db.collection("users").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        ArrayList<User> usersFromDB = new ArrayList<>();
                        if (task.isSuccessful()) {
                            for(DocumentSnapshot document : task.getResult()) {
                                usersFromDB.add(document.toObject(User.class));
                            }
                            users.setValue(usersFromDB);
                        }
                    }
                });
            }
        });

        executor.execute(new Runnable() {
            @Override
            public void run() {
                db.collection("users").addSnapshotListener(new EventListener<QuerySnapshot>() {
                    @Override
                    public void onEvent(@Nullable QuerySnapshot queryDocumentSnapshots, @Nullable FirebaseFirestoreException e) {
                        ArrayList<User> usersFromDB = new ArrayList<>();
                        for (DocumentSnapshot document : queryDocumentSnapshots) {
                            usersFromDB.add(document.toObject(User.class));
                        }
                        users.setValue(usersFromDB);
                    }
                });
            }
        });
    }

    public LiveData<ArrayList<Restaurant>> getRestaurants() {
        if (restaurants == null) {
            restaurants = new MutableLiveData<>();
            loadRestaurants();
        }
        return restaurants;
    }

    private void loadRestaurants() {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                db.collection("donors").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        ArrayList<Restaurant> restaurantsFromDB = new ArrayList<>();
                        if (task.isSuccessful()) {
                            for(DocumentSnapshot document : task.getResult()) {
                                restaurantsFromDB.add(document.toObject(Restaurant.class));
                            }
                            restaurants.setValue(restaurantsFromDB);
                        }
                    }
                });
            }
        });

        executor.execute(new Runnable() {
            @Override
            public void run() {
                db.collection("donors").addSnapshotListener(new EventListener<QuerySnapshot>() {
                    @Override
                    public void onEvent(@Nullable QuerySnapshot queryDocumentSnapshots, @Nullable FirebaseFirestoreException e) {
                        ArrayList<Restaurant> restaurantsFromDB = new ArrayList<>();
                        for (DocumentSnapshot document : queryDocumentSnapshots) {
                            restaurantsFromDB.add(document.toObject(Restaurant.class));
                        }
                        restaurants.setValue(restaurantsFromDB);
                    }
                });
            }
        });
    }

    public LiveData<ArrayList<Meal>> getMeals() {
        if (meals == null) {
            meals = new MutableLiveData<>();
            loadMeals();
        }
        return meals;
    }

    private void loadMeals() {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                db.collection("meals").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        ArrayList<Meal> mealsFromDB = new ArrayList<>();
                        if (task.isSuccessful()) {
                            for(DocumentSnapshot document : task.getResult()) {
                                mealsFromDB.add(document.toObject(Meal.class));
                            }
                            meals.setValue(mealsFromDB);
                        }
                    }
                });
            }
        });

        executor.execute(new Runnable() {
            @Override
            public void run() {
                db.collection("meals").addSnapshotListener(new EventListener<QuerySnapshot>() {
                    @Override
                    public void onEvent(@Nullable QuerySnapshot queryDocumentSnapshots, @Nullable FirebaseFirestoreException e) {
                        ArrayList<Meal> mealsFromDB = new ArrayList<>();
                        for (DocumentSnapshot document : queryDocumentSnapshots) {
                            mealsFromDB.add(document.toObject(Meal.class));
                        }
                        meals.setValue(mealsFromDB);
                    }
                });
            }
        });
    }
}