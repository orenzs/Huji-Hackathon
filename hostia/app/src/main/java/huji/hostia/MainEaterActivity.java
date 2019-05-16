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

import java.util.ArrayList;

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
    }

    public void onClickOrderedMeal(Meal meal) {
        //TODO: implement
    }
}
