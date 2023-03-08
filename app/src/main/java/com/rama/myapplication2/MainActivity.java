package com.rama.myapplication2;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {

    private EditText mUsernameEditText;
    private EditText mPasswordEditText;
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

                if (username.equals("admin") && password.equals("admin")) {
                    Toast.makeText(MainActivity.this, "Login Berhasil", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Login Gagal", Toast.LENGTH_SHORT).show();
                }

                // cek apakah username dan password sudah diisi
                if (username.isEmpty() || password.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Mohon lengkapi semua field!", Toast.LENGTH_SHORT).show();
                } else {
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

