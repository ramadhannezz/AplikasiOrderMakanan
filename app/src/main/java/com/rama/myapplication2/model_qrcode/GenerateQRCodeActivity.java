package com.rama.myapplication2.model_qrcode;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;
import com.rama.myapplication2.MainActivity;
import com.rama.myapplication2.R;

public class GenerateQRCodeActivity extends AppCompatActivity {

    private EditText editCode;
    private Button btnGenerate;
    private Button btnBackToHome;
    private ImageView imageQr;
    private MultiFormatWriter multi = new MultiFormatWriter();

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generateqrcode);
        editCode = findViewById(R.id.edit_code);
        btnGenerate = findViewById(R.id.btn_generate);
        imageQr = findViewById(R.id.image_qr);
        btnBackToHome = findViewById(R.id.btn_backtohome);

        btnGenerate.setOnClickListener(v -> {
            try {
                String code = editCode.getText().toString();
                BitMatrix bitMatrix = multi.encode(code, BarcodeFormat.QR_CODE, 300, 300);

                BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
                Bitmap bitmap = barcodeEncoder.createBitmap(bitMatrix);
                imageQr.setImageBitmap(bitmap);
            } catch (WriterException e){
                Toast.makeText(getApplicationContext(), e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        btnBackToHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(GenerateQRCodeActivity.this, MainActivity.class));
            }
        });
    }
}