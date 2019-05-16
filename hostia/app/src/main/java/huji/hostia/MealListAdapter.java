package huji.hostia;

import android.support.annotation.NonNull;
import android.support.v7.recyclerview.extensions.ListAdapter;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class MealListAdapter extends ListAdapter<Meal, MealListAdapter.MealHolder> {
    private static final int VIEW_TYPE_MESSAGE_SENT = 0;


    MealListAdapter() {
        super(new MealUtils.MealCallback());
    }


    @Override
    public int getItemViewType(int position) {
        // for now, always act as the user is the sender
        return VIEW_TYPE_MESSAGE_SENT;
    }


    @NonNull
    @Override
    public MealHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.meal_item,
                viewGroup, false);
        return new MealHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MealHolder mealHolder, int position) {
        Meal meal = getItem(position);
        mealHolder.name.setText(meal.getName());
        mealHolder.description.setText(meal.getDescription());
        mealHolder.stock.setText(meal.getStock());
    }


    class MealHolder extends RecyclerView.ViewHolder implements View.OnLongClickListener {
        TextView description, name, stock;

        MealHolder(View itemView) {
            super(itemView);
//            description = itemView.findViewById(R.id.meal_description);
            description = itemView.findViewById(R.id.meal_name);
            name = itemView.findViewById(R.id.meal_name);
            stock = itemView.findViewById(R.id.meal_stock);
        }

        @Override
        public boolean onLongClick(View v) {
            return true;
        }
    }
}



