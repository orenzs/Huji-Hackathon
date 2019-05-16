package huji.hostia;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class OrderedMealsFragement extends Fragment {
    private MealListAdapter adapter = new MealListAdapter();

    public OrderedMealsFragement() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
//        RecyclerView recyclerView = findViewById(R.id.chat_message_recycler);
//
//        recyclerView.setLayoutManager(new LinearLayoutManager(
//                this, LinearLayoutManager.VERTICAL, false));
//
//        recyclerView.setAdapter(adapter);
//
//        adapter.callback = this;
        return inflater.inflate(R.layout.fragment_ordered_meals_fragement, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }
}
