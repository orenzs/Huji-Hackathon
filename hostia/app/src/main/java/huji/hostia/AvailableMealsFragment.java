package huji.hostia;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashMap;


public class AvailableMealsFragment extends Fragment implements MealRecyclerUtils.MealOnClickCallBack {
    private MealRecyclerUtils.MealsAdapter adapter; // = new MealListAdapter();
    RecyclerView recyclerView;
    private final static String TAG = "Ordered meals fragment";
    public AvailableMealsFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_ordered_meals_fragement, container, false);
        adapter = new MealRecyclerUtils.MealsAdapter();
        recyclerView = v.findViewById(R.id.ordered_meals_recycler_view);
//        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);
        adapter.callback = this;

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
                Log.d(TAG, "onChanged");
            }
        });
        return v; //inflater.inflate(R.layout.fragment_ordered_meals_fragement, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }


    @Override
    public void mealOnClick(Meal meal) {
        meal.ordered = true;
        Gson gson = new Gson();
        String mealJson = gson.toJson(meal);

        HashMap<String, String> mealMap = new HashMap<>();
        mealMap.put("meal Json", mealJson);
        FirebaseFirestore.getInstance().collection("meals2").document(meal.getId().toString()).set(mealMap)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Log.d("View Model", "Success!!!");
                    }
                });
    }
}
