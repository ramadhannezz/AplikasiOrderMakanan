package com.rama.myapplication2;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.rama.myapplication2.model_home.Food;
import com.rama.myapplication2.model_home.FoodAdapter;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    private List<Food> foods;
    private RecyclerView recyclerView;
    private FoodAdapter foodAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        foods = new ArrayList<>();
        foods.add(new Food("Nasi Goreng PDI", "Rp 75.000", R.drawable.nasgorpdi));
        foods.add(new Food("Mie Ayam Cacing", "Rp 12.000", R.drawable.mieayamtumpah));
        foods.add(new Food("Bakso Borak", "Rp 100.000", R.drawable.baksokepala));
        foods.add(new Food("Sate Ular", "Rp 20.000", R.drawable.sateular));

        foodAdapter = new FoodAdapter(foods);
        recyclerView.setAdapter(foodAdapter);
    }
}

