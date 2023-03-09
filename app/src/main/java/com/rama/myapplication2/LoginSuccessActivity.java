package com.rama.myapplication2;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class LoginSuccessActivity extends AppCompatActivity {

    private TextView usernameTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginsuccess);

        // inisialisasi TextView dan Button pada layout
        usernameTextView = findViewById(R.id.usernameTextView);
        Button homeButton = findViewById(R.id.homeButton);

        // mendapatkan data username dari Intent yang dikirim dari MainActivity
        Intent intent = getIntent();
        String username = intent.getStringExtra("username");

        // menampilkan username pada TextView
        usernameTextView.setText("Selamat datang " + username);

        // menambahkan listener pada tombol untuk berpindah ke halaman MainActivity
        homeButton.setOnClickListener(v -> {
            Intent i = new Intent(LoginSuccessActivity.this, MainActivity.class);
            startActivity(i);
        });
    }
}
