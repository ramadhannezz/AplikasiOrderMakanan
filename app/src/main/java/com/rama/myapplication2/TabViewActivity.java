package com.rama.myapplication2;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.rama.myapplication2.model_home.Food;
import com.rama.myapplication2.model_home.FoodAdapter;
import com.rama.myapplication2.model_tabview.MyAdapter;

import java.util.ArrayList;
import java.util.List;

public class TabViewActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager2 viewPager;

    private List<Food> foods;
    private RecyclerView recyclerView;
    private FoodAdapter foodAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabview);

        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPager);

        RecyclerView recyclerView = findViewById(R.id.recyclerview);

        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        foods = new ArrayList<>();
        foods.add(new Food("Nasi Goreng PDI", "Rp 75.000", R.drawable.nasgorpdi));
        foods.add(new Food("Mie Ayam Cacing", "Rp 12.000", R.drawable.mieayamtumpah));
        foods.add(new Food("Bakso Borak", "Rp 100.000", R.drawable.baksokepala));
        foods.add(new Food("Sate Ular", "Rp 20.000", R.drawable.sateular));

        foodAdapter = new FoodAdapter(foods);
        recyclerView.setAdapter(foodAdapter);

        // Set adapter untuk ViewPager2
        viewPager.setAdapter(new MyAdapter(this));

        // Set TabLayoutMediator untuk menghubungkan TabLayout dengan ViewPager2
        TabLayoutMediator tabLayoutMediator = new TabLayoutMediator(tabLayout, viewPager,
                (tab, position) -> {
                    switch (position) {
                        case 0:
                            tab.setText("Home");
                            break;
                        case 1:
                            tab.setText("List Item");
                            break;
                        case 2:
                            tab.setText("History");
                            break;
                    }
                }
        );
        tabLayoutMediator.attach();



    }
}
