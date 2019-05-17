package huji.hostia;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Random;


public class MealAdder_a extends AppCompatActivity implements View.OnClickListener {

    protected String mealName;
    protected String description;
    protected String quantity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meal_adder_a);
        getSupportActionBar().hide(); //hide the title bar
        View v = findViewById(R.id.sendMeal);
        v.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        View foodName = findViewById(R.id.foodName);
        View desc = findViewById(R.id.description);
        View quan = findViewById(R.id.quantityMeals);
        mealName = ((EditText) foodName).getText().toString();
        description = ((EditText) desc).getText().toString();
        quantity = ((EditText) quan).getText().toString();
        Random rand = new Random();
        long id = rand.nextInt(1000000000);
        Meal meal = new Meal(mealName, id, Integer.parseInt(quantity), description);
        Gson gson = new Gson();
        String mealJson = gson.toJson(meal);

        HashMap<String, String> mealMap = new HashMap<>();
        mealMap.put("meal Json", mealJson);
        FirebaseFirestore.getInstance().collection("meals").document(meal.getId().toString()).set(mealMap)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Log.d("View Model", "Success!!!");
                    }
                });
        // go back:
        Intent myIntent = new Intent(MealAdder_a.this, RestaurantMealsActivity.class);
        myIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(myIntent);
    }
}