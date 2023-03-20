package com.rama.myapplication2;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
public class MainActivity extends AppCompatActivity {

    private EditText UsernameEditText, PasswordEditText;
    private Button LoginButton, RegisterButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        UsernameEditText = findViewById(R.id.username_edittext);
        PasswordEditText = findViewById(R.id.password_edittext);
        LoginButton = findViewById(R.id.login_button);
        RegisterButton = findViewById(R.id.register_button);
        LoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Syarat login harus input username dan password (contoh diset default loginnya sebagai admin)
                String username = UsernameEditText.getText().toString().trim();
                String password = PasswordEditText.getText().toString().trim();

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
        RegisterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAlert();
            }
        });
    }
            private void showAlert() {
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("Alert");
                builder.setMessage("Apakah anda yakin ingin membuat akun!?");
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Tambahkan logika yang diinginkan di sini
                        Log.d("Alert", "Tombol OK diklik.");
                        // Intent untuk membuka RegisterActivity
                        Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
                        startActivity(intent);
            }
        });
                AlertDialog dialog = builder.create();
                dialog.show();
    }
}

