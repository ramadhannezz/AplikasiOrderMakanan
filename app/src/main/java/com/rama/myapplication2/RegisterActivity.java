package com.rama.myapplication2;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {

    private EditText NameEditText, EmailEditText, PasswordEditText, ConfirmPasswordEditText;
    private Button RegisterButton;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        // Inisialisasi views
        NameEditText = findViewById(R.id.name_edittext);
        EmailEditText = findViewById(R.id.email_edittext);
        PasswordEditText = findViewById(R.id.password_edittext);
        ConfirmPasswordEditText = findViewById(R.id.confirmpassword_edittext);
        RegisterButton = findViewById(R.id.register_button);

        // OnClickListener untuk tombol Register
        RegisterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // String untuk menginput text register
                String name = NameEditText.getText().toString().trim();
                String email = EmailEditText.getText().toString().trim();
                String password = PasswordEditText.getText().toString().trim();
                String confirmPassword = ConfirmPasswordEditText.getText().toString().trim();

                if (TextUtils.isEmpty(name) || TextUtils.isEmpty(email) || TextUtils.isEmpty(password)) {
                    Toast.makeText(RegisterActivity.this, "Gagal register. Mohon lengkapi semua field.", Toast.LENGTH_SHORT).show();
                } else if (!password.equals(confirmPassword)) {
                    Toast.makeText(RegisterActivity.this, "Gagal register. Password dan konfirmasi password tidak sama.", Toast.LENGTH_SHORT).show();
                } else {
                    // Jika user berhasil register maka akan berpindah ke halaman MainActivity
                    Toast.makeText(RegisterActivity.this, "Berhasil register.", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }

}
