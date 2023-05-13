package com.rama.myapplication2;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class ForgotPasswordActivity extends AppCompatActivity {

    private EditText emailEditText;
    private Button resetPasswordButton;
    private FirebaseAuth mAuth;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgotpassword);

        // Mendapatkan referensi dari elemen UI pada layout XML
        emailEditText = findViewById(R.id.emailEditText);
        resetPasswordButton = findViewById(R.id.resetpassword);

        // Mendapatkan instance dari Firebase Authentication
        mAuth = FirebaseAuth.getInstance();

        // Menambahkan onClickListener pada tombol reset password
        resetPasswordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Mendapatkan email yang dimasukkan oleh pengguna
                String email = emailEditText.getText().toString().trim();

                // Memeriksa apakah email tidak kosong atau null
                if (!TextUtils.isEmpty(email)) {
                    // Mengirim email reset password ke pengguna
                    mAuth.sendPasswordResetEmail(email)
                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()) {
                                        Toast.makeText(ForgotPasswordActivity.this, "Password reset email has been sent!", Toast.LENGTH_SHORT).show();
                                        // jika berhasil login, pindah ke halaman LoginSuccess
                                        Intent intent = new Intent(ForgotPasswordActivity.this, MainActivity.class);
                                        startActivity(intent);
                                        finish();
                                    } else {
                                        Toast.makeText(ForgotPasswordActivity.this, "Failed to send password reset email!", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                } else {
                    Toast.makeText(ForgotPasswordActivity.this, "Please enter your email first!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
