package huji.hostia;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.MenuItem;

import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashMap;

public class MainEaterActivity extends AppCompatActivity {



    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.available_meals_tab:
                    changeToAvailableMeals();
                    return true;

                case R.id.ordered_meals_tab:
                    changeToOrderedMeals();
                    return true;
            }
            return false;
        }
    };

    private void changeToAvailableMeals() {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        AvailableMealsFragment availableMealsFragment = new AvailableMealsFragment();

        transaction.replace(R.id.fragment_container, availableMealsFragment);
        transaction.addToBackStack(null);
        transaction.commit();

        Log.d("MainEaterActivity", "available meals tab: yeah!!");
    }

    private void changeToOrderedMeals() {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        OrderedMealsFragement orderedMealsFragement = new OrderedMealsFragement();

        transaction.replace(R.id.fragment_container, orderedMealsFragement);
        transaction.addToBackStack(null);
        transaction.commit();

        Log.d("MainEaterActivity", "ordered meals tab: yeah!!");
    }

        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_available_meals);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        Meal meal = new Meal("hamburger", 16L, 3, "yam yam");
        Log.d("View Model", "blablabla");
        Log.d("View Model", meal.getDescription());

        Gson gson = new Gson();
        String mealJson = gson.toJson(meal);

        HashMap<String, String > mealMap = new HashMap<>();
        mealMap.put("meal Json", mealJson);
        FirebaseFirestore.getInstance().collection("meals2").document(meal.getId().toString()).set(mealMap)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Log.d("View Model", "Success!!!");
                    }
                });



    }

    public void onClickOrderedMeal(Meal meal) {
        //TODO: implement
    }
}
