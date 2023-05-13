package com.rama.myapplication2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.rama.myapplication2.model_home.CheckoutActivity;
import com.rama.myapplication2.model_home.Food;
import com.rama.myapplication2.model_home.FoodAdapter;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    private static List<Food> foods = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        foods.add(new Food("Air Aki","Burger Bangor",15000, R.drawable.air_aki));
        foods.add(new Food("Bakso Kepala", "Burger Bangor",10000, R.drawable.baksokepala));
        foods.add(new Food("Es Teh Panas", "Burger Bangor",30000, R.drawable.es_teh_panas));
        foods.add(new Food("Mie Ayam Tumpah", "Burger Bangor",20000, R.drawable.mieayamtumpah));
        foods.add(new Food("Nasi Goreng PDI", "Burger Bangor",25000, R.drawable.nasgorpdi));
        foods.add(new Food("Sate Ular", "Burger Bangor",40000, R.drawable.sateular));

        ListView listViewFood = findViewById(R.id.list_view_food);

        FoodAdapter adapter = new FoodAdapter(this, foods);
        listViewFood.setAdapter(adapter);

        Button buttonCheckout = findViewById(R.id.button_checkout);
        buttonCheckout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, CheckoutActivity.class);
                startActivity(intent);
            }
        });
    }

    public static List<Food> getCart() {
        return foods;
    }
}