package huji.hostia;

import android.support.annotation.NonNull;
import android.support.v7.recyclerview.extensions.ListAdapter;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


public class MealListAdapter extends ListAdapter<Meal, MealListAdapter.MealHolder> {
    private static final int VIEW_TYPE_MESSAGE_SENT = 0;
    OnClickCallBack onClickCallBack;


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
        final MealHolder holder = new MealHolder(view);
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Meal meal = getItem(holder.getAdapterPosition());
                if (onClickCallBack != null)
                    onClickCallBack.onMealClick(meal);
                return true;
            }
        });

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MealHolder mealHolder, int position) {
        Meal meal = getItem(position);
        mealHolder.name.setText(meal.getName());
        mealHolder.description.setText(meal.getDescription());
        mealHolder.stock.setText(meal.getStock());
//        mealHolder.logo.setImageDrawable(meal.getStock());
    }


    class MealHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView description, name, stock;
        ImageView logo;

        MealHolder(View itemView) {
            super(itemView);
            description = itemView.findViewById(R.id.meal_description);
            name = itemView.findViewById(R.id.meal_name);
            stock = itemView.findViewById(R.id.meal_stock);
//            logo = itemView.findViewById(R.id.restaurant_logo);
        }

        @Override
        public void onClick(View v) {
        }
    }
}


interface OnClickCallBack {
    void onMealClick(Meal meal);
}




