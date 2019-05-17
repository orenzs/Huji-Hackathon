package huji.hostia;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.recyclerview.extensions.ListAdapter;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import huji.hostia.Meal;
import huji.hostia.R;

public class MealRecyclerUtils {

    interface MealOnClickCallBack {
        void mealOnClick(Meal meal);
    }

    static class MealCallback extends DiffUtil.ItemCallback<Meal> {

        @Override
        public boolean areItemsTheSame(@NonNull Meal m1, @NonNull Meal m2) {
            return m1.equals(m2);
        }

        @Override
        public boolean areContentsTheSame(@NonNull Meal m1, @NonNull Meal m2) {
            return m1.getName().equals(m2.getName());
        }
    }


    static class MealsAdapter extends ListAdapter<Meal, MealHolder> {

        public MealsAdapter() {
            super(new MealCallback());
        }

        public MealOnClickCallBack callback;

        @NonNull
        @Override
        public MealHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
            Context context = parent.getContext();
            View itemView = LayoutInflater.from(context).inflate(R.layout.meal_item, parent,
                    false);
            final MealHolder holder = new MealHolder(itemView);
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Meal meal = getItem(holder.getAdapterPosition());
                    if (callback != null)
                        callback.mealOnClick(meal);
                }
            });
            return holder;
        }

        @Override
        public void onBindViewHolder(@NonNull MealHolder holder, int position) {
            Meal meal = getItem(position);
            holder.text.setText(meal.getDescription());
        }
    }


    static class MealHolder extends RecyclerView.ViewHolder {
        public final TextView text;

        public MealHolder(View itemView) {
            super(itemView);
            text = itemView.findViewById(R.id.meal_description);
        }
    }


}
