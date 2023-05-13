package com.rama.myapplication2.model_home;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.rama.myapplication2.R;

import java.util.List;

public class FoodAdapter extends ArrayAdapter<Food> {

    private Context context;
    private List<Food> foods;

    public FoodAdapter(Context context, List<Food> foods) {
        super(context, 0, foods);
        this.context = context;
        this.foods = foods;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.layout_food, parent, false);
        }

        ImageView imageFood = convertView.findViewById(R.id.image_food);
        TextView textFoodName = convertView.findViewById(R.id.text_food_name);
        TextView textFoodPrice = convertView.findViewById(R.id.text_food_price);
        Button buttonDetailFood = convertView.findViewById(R.id.button_detail_food);
        Button buttonAddFood = convertView.findViewById(R.id.button_add_food);
        TextView textFoodQty = convertView.findViewById(R.id.text_food_qty);
        Button buttonSubtractFood = convertView.findViewById(R.id.button_subtract_food);

        final Food food = foods.get(position);

        imageFood.setImageResource(food.getImage());
        textFoodName.setText(food.getName());
        textFoodPrice.setText(String.format("Rp %d", food.getPrice()));

        buttonDetailFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailFoodActivity.class);
                intent.putExtra("name", food.getName());
                intent.putExtra("price", food.getPrice());
                intent.putExtra("image", food.getImage());
                context.startActivity(intent);
            }
        });

        buttonAddFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int qty = food.getQuantity();
                food.setQuantity(qty + 1);
                textFoodQty.setText(String.format("%d", food.getQuantity()));
            }
        });

        buttonSubtractFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int qty = food.getQuantity();
                if (qty > 0) {
                    food.setQuantity(qty - 1);
                    textFoodQty.setText(String.format("%d", food.getQuantity()));
                }
            }
        });

        return convertView;
    }
}
