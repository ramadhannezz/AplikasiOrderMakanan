package com.rama.myapplication2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

public class LoginSuccessActivity extends AppCompatActivity implements InputDialogFragment.InputDialogListener {

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
            InputDialogFragment dialog = new InputDialogFragment(LoginSuccessActivity.this);
            dialog.show(getSupportFragmentManager(), "InputDialogFragment");
            FragmentManager fragmentManager = getSupportFragmentManager();
            CustomDialogFragment customDialogFragment = new CustomDialogFragment();
            customDialogFragment.show(fragmentManager, "CustomDialogFragment");

        });
    }

    @Override
    public void onInputText(String inputText) {
        Toast.makeText(this, "Welcome " + inputText, Toast.LENGTH_SHORT).show();
    }
}

