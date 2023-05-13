package com.rama.myapplication2;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.rama.myapplication2.model_qrcode.ScanQRActivity;

public class MainActivity extends AppCompatActivity {

    private EditText EmailEditText, PasswordEditText;
    private FirebaseAuth mAuth;
    String email, password;

    @SuppressLint({"MissingInflatedId", "CutPasteId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth = FirebaseAuth.getInstance();
        EmailEditText = findViewById(R.id.email_edittext);
        PasswordEditText = findViewById(R.id.password_edittext);
        Button loginButton = findViewById(R.id.login_button);
        Button registerButton = findViewById(R.id.register_button);
        Button directloginButton = findViewById(R.id.camera_button);
        View forgotpasswordTextView = findViewById(R.id.forgot_button);

        // OnClickListener ketika tombol Login di klik dan akan berpindah ke halaman LoginSuccessActivity (with lambda)
        loginButton.setOnClickListener(v -> cekLogin());

        // OnClickListener ketika tombol Register di klik dan akan berpindah ke halaman RegisterActivity (with lambda)
        registerButton.setOnClickListener(v -> showAlert());

        // OnClickListener ketika tombol DirectLogin via Camera di klik dan akan berpindah ke halaman LoginSuccessActivity (with lambda)
        directloginButton.setOnClickListener(view -> startActivity(new Intent(MainActivity.this, ScanQRActivity.class)));

        // OnClickListener ketika tombol DirectLogin via Camera di klik dan akan berpindah ke halaman LoginSuccessActivity (with lambda)
        forgotpasswordTextView.setOnClickListener(view -> startActivity(new Intent(MainActivity.this, ForgotPasswordActivity.class)));
    }
            // Class untuk verify login server firebase (with lambda)
            private void cekLogin() {
                email = EmailEditText.getText().toString();
                password = PasswordEditText.getText().toString();

                // Memeriksa apakah email dan password tidak kosong
                if (TextUtils.isEmpty(email) || TextUtils.isEmpty(password)) {

                // Menampilkan toast message jika email atau password kosong
                    Toast.makeText(getApplicationContext(), "Login Failed! Please fill in all fields!", Toast.LENGTH_SHORT).show();
                } else {
                    mAuth.signInWithEmailAndPassword(email, password)
                            .addOnCompleteListener(this, task -> {
                                if (task.isSuccessful()) {
                                    // Menampilkan toast message jika email atau password telah diisi sesuai dengan database
                                    Toast.makeText(MainActivity.this, "Login Success!", Toast.LENGTH_SHORT).show();

                                    // jika berhasil login, pindah ke halaman LoginSuccess
                                    Intent intent = new Intent(MainActivity.this, LoginSuccessActivity.class);
                                    intent.putExtra("email", email); startActivity(intent);
                                } else {
                                    Toast.makeText(MainActivity.this, "Login Failed! Wrong email and password!", Toast.LENGTH_SHORT).show();
                                }
                            });
        }
    }
            // Class untuk menampilkan alert (with lambda)
            private void showAlert() {
                AlertDialog.Builder builder = new AlertDialog.Builder(this);

                builder.setMessage("Are you sure you want to create an account?");
                builder.setPositiveButton("Yes", (dialog, which) -> {
                    // Tambahkan logika yang diinginkan di sini
                    Log.d("Alert", "The yes button is clicked");
                    // Intent untuk membuka RegisterActivity
                    Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
                    startActivity(intent);
                });
                AlertDialog dialog = builder.create();
                dialog.show();
    }
}