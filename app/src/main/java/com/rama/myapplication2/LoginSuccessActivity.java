package com.rama.myapplication2;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.rama.myapplication2.model_alertdialog.InputDialog;

public class LoginSuccessActivity extends AppCompatActivity implements InputDialog.InputDialogListener {

    private TextView EmailTextView;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginsuccess);

        // inisialisasi TextView dan Button pada layout
        EmailTextView = findViewById(R.id.email_textview);
        Button homeButton = findViewById(R.id.homeButton);

        // mendapatkan data username dari Intent yang dikirim dari MainActivity
        // Terima data ekstra "userName" dari Intent
        String email = getIntent().getStringExtra("email");

        // Tampilkan nama pengguna di tampilan TextView
        TextView welcomeMessageTextView = findViewById(R.id.textView);
        welcomeMessageTextView.setText("Welcome, " + email + "!");

        // menambahkan listener pada tombol untuk berpindah ke halaman MainActivity
        homeButton.setOnClickListener(v -> {
            InputDialog dialog = new InputDialog(LoginSuccessActivity.this);
            dialog.show(getSupportFragmentManager(), "InputDialog");

        });
    }

    @Override
    public void onInputText(String inputText) {
        Toast.makeText(this, "Welcome " + inputText, Toast.LENGTH_SHORT).show();
    }
}

