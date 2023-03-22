package com.rama.myapplication2;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity {

    private EditText NameEditText, EmailEditText, PasswordEditText, ConfirmPasswordEditText;
    TextView log;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        mAuth = FirebaseAuth.getInstance();
        log = findViewById(R.id.unregister_button);

        // OnClickListener untuk tombol sudah punya akun
        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RegisterActivity.this, MainActivity.class));
            }
        });

        // Inisialisasi views pada saat melakukan input
        NameEditText = findViewById(R.id.name_edittext);
        EmailEditText = findViewById(R.id.email_edittext);
        PasswordEditText = findViewById(R.id.password_edittext);
        ConfirmPasswordEditText = findViewById(R.id.confirmpassword_edittext);
        Button registerButton = findViewById(R.id.register_button);

        // OnClickListener untuk tombol Register
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performRegistration();
                }
            });}

    // Deklarasi string untuk penginputan, fungsi, dan notifikasi pada saat register
    public void performRegistration(){
        String name = NameEditText.getText().toString();
        String email = EmailEditText.getText().toString();
        String password = PasswordEditText.getText().toString();
        String confirmPassword = ConfirmPasswordEditText.getText().toString();

        if (TextUtils.isEmpty(name) || TextUtils.isEmpty(email) || TextUtils.isEmpty(password) || TextUtils.isEmpty(confirmPassword)) {
            // Jika ada kolom yang kosong
            Toast.makeText(getApplicationContext(), "Register Failed! Please fill in all fields", Toast.LENGTH_SHORT).show();
        } else if (!password.equals(confirmPassword)) {
            // Jika password dan confirm password tidak sama
            Toast.makeText(getApplicationContext(), "Register Failed! Password and Confirm Password are not the same", Toast.LENGTH_SHORT).show();
        } else {
            // Melakukan pendaftaran database dimasukan ke Firebase
            mAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(task -> {
                        if (task.isSuccessful()) {
                            // Jika pendaftaran berhasil
                            Toast.makeText(getApplicationContext(), "Register Success, Come In!", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                            startActivity(intent);
                            finish();
                        } else {
                            // Jika pendaftaran gagal karena penginputan tidak benar
                            Toast.makeText(getApplicationContext(), "Registrasi Failed! Fill all field is correct!", Toast.LENGTH_SHORT).show();
                        }
                    });
        }
    }
}

