package com.rama.myapplication2.model_home;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.rama.myapplication2.R;

public class DetailFoodActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_food);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        int price = intent.getIntExtra("price", 0);
        int image = intent.getIntExtra("image", 0);

        ImageView imageFood = findViewById(R.id.image_food_detail);
        TextView textFoodName = findViewById(R.id.text_food_name_detail);
        TextView textFoodDescription = findViewById(R.id.text_food_description_detail);
        TextView textFoodPrice = findViewById(R.id.text_food_price_detail);

        imageFood.setImageResource(image);
        textFoodName.setText(name);
        textFoodPrice.setText(String.format("Rp %d", price));

        Button buttonBack = findViewById(R.id.button_back);
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
