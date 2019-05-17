package huji.hostia;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;

public class RestaurantMealsActivity extends AppCompatActivity {

    private MealRecyclerUtils.MealsAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_meals);
        getSupportActionBar().hide(); //hide the title bar
        findViewById(R.id.add_meal_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doStuff();
            }
        });

        // Inflate the layout for this fragment
        adapter = new MealRecyclerUtils.MealsAdapter();
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
//        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
//        adapter.callback = this;

        MyViewModel viewModel = ViewModelProviders.of(this).get(MyViewModel.class);
        viewModel.getMeals().observe(this, new Observer<ArrayList<Meal>>() {
            @Override
            public void onChanged(@Nullable ArrayList<Meal> meals) {
                ArrayList<Meal> availableMeals = new ArrayList<>();
                for (Meal meal : meals) {
                    if (!meal.ordered)
                        availableMeals.add(meal);
                }
                adapter.submitList(availableMeals);
            }
        });
    }

    public void doStuff() {
        Log.d("rests", "onClick: ");
        try {
            Intent myIntent = new Intent(RestaurantMealsActivity.this, MealAdder_a.class);
            myIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(myIntent);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

}
