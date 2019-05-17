package huji.hostia;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class RestaurantMealsActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_meals);
        getSupportActionBar().hide(); //hide the title bar
        View v = findViewById(R.id.addMeal);
        v.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
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
