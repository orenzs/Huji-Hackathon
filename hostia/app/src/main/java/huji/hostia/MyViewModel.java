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

import huji.hostia.Meal;

public class MyViewModel extends ViewModel {

    FirebaseFirestore db = FirebaseFirestore.getInstance();

    Executor executor = Executors.newSingleThreadExecutor();

    private MutableLiveData<ArrayList<Meal>> meals;

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