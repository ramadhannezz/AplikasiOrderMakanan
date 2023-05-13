package com.rama.myapplication2.model_home;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.rama.myapplication2.HomeActivity;
import com.rama.myapplication2.R;

import java.util.List;

public class CheckoutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        List<Food> foods = HomeActivity.getCart();

        ListView listViewCheckout = findViewById(R.id.list_view_checkout);
        TextView textTotalPrice = findViewById(R.id.text_total_price);

        int totalPrice = 0;
        for (Food food : foods) {
            if (food.getQuantity() > 0) {
                totalPrice += food.getPrice() * food.getQuantity();
            }
        }

        textTotalPrice.setText(String.format("Total: Rp %d", totalPrice));

        ArrayAdapter<Food> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, foods);
        listViewCheckout.setAdapter(adapter);

        Button buttonBack = findViewById(R.id.button_back);
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
