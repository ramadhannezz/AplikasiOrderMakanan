package com.rama.myapplication2;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

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

        // OnClickListener ketika tombol Login di klik dan akan berpindah ke halaman LoginSuccessActivity
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cekLogin();
            }
        });
        // OnClickListener ketika tombol Register di klik dan akan berpindah ke halaman RegisterActivity
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAlert();
            }});}
            // Class untuk verify login server firebase
            private void cekLogin() {
                email = EmailEditText.getText().toString();
                password = PasswordEditText.getText().toString();

                mAuth.signInWithEmailAndPassword(email,password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                // Sign in success, update UI with the signed-in user's information
                                Toast.makeText(MainActivity.this, "Login Success", Toast.LENGTH_SHORT).show();
                                // jika berhasil login, pindah ke halaman LoginSuccess
                                Intent intent = new Intent(MainActivity.this, LoginSuccessActivity.class);
                                intent.putExtra("email", email);
                                startActivity(intent);
                            } else {
                                Toast.makeText(MainActivity.this, "Login Gagal, Email Atau Password Anda Salah!", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });

    }
            // Class untuk menampilkan alert
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