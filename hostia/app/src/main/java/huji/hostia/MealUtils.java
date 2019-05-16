package huji.hostia;

import android.support.annotation.NonNull;
import android.support.v7.util.DiffUtil;

class MealUtils {
    static class MealCallback extends DiffUtil.ItemCallback<Meal> {

        @Override
        public boolean areItemsTheSame(@NonNull Meal meal1, @NonNull Meal meal2) {
            return meal1.equals(meal2);
        }

        @Override
        public boolean areContentsTheSame(@NonNull Meal msg1, @NonNull Meal msg2) {
            return msg1.getID().equals(msg2.getID());
        }
    }
}
