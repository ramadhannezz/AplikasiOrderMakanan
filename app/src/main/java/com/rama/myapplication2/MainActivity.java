package com.rama.myapplication2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
public class MainActivity extends AppCompatActivity {

    private EditText mUsernameEditText, mPasswordEditText;
    private Button mLoginButton, mRegisterButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mUsernameEditText = findViewById(R.id.username_edittext);
        mPasswordEditText = findViewById(R.id.password_edittext);
        mLoginButton = findViewById(R.id.login_button);
        mRegisterButton = findViewById(R.id.register_button);
        mLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Syarat login harus input username dan password (contoh diset default loginnya sebagai admin)
                String username = mUsernameEditText.getText().toString().trim();
                String password = mPasswordEditText.getText().toString().trim();

                if (username.isEmpty() || password.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Mohon lengkapi semua field!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Login Berhasil!", Toast.LENGTH_SHORT).show();
                    // jika berhasil login, pindah ke halaman LoginSuccess
                    Intent i = new Intent(MainActivity.this, LoginSuccessActivity.class);
                    i.putExtra("username", username);
                    startActivity(i);
                }


            }
        });

        // OnClickListener ketika tombol Register di klik dan akan berpindah ke halaman RegisterActivity
        mRegisterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Intent untuk membuka RegisterActivity
                Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
    }
}

