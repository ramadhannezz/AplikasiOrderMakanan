package com.rama.myapplication2;

import android.annotation.SuppressLint;
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

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        foods = new ArrayList<>();
        foods.add(new Food("Nasi Goreng", "Rp 15.000", R.drawable.mail));
        foods.add(new Food("Mie Ayam", "Rp 12.000", R.drawable.mail2));
        foods.add(new Food("Bakso", "Rp 10.000", R.drawable.lock));
        foods.add(new Food("Sate Ayam", "Rp 20.000", R.drawable.lockpw));

        foodAdapter = new FoodAdapter(foods);
        recyclerView.setAdapter(foodAdapter);
    }
}

