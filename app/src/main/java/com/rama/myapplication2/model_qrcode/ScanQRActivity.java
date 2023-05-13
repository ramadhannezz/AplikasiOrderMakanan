package com.rama.myapplication2.model_qrcode;


import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.google.zxing.Result;
import com.rama.myapplication2.LoginSuccessActivity;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class ScanQRActivity extends AppCompatActivity implements ZXingScannerView.ResultHandler {
    private ZXingScannerView scannerView;
    private static final int CAMERA_REQUEST_CODE = 200;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        scannerView = new ZXingScannerView(this);
        setContentView(scannerView);

        // meminta izin akses kamera
        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[] { android.Manifest.permission.CAMERA }, CAMERA_REQUEST_CODE);
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        scannerView.setResultHandler(this);
        scannerView.startCamera();
    }

    @Override
    public void onPause() {
        super.onPause();
        scannerView.stopCamera();
    }

    @Override
    public void handleResult(Result result) {
        String qrText = result.getText();
        if (qrText.equals("RamApps") || qrText.equals("rama")) {
            Intent intent = new Intent(this, LoginSuccessActivity.class);
            startActivity(intent);
            finish();
        } else {
            Toast.makeText(this, "QR code tidak valid", Toast.LENGTH_SHORT).show();
            scannerView.resumeCameraPreview(this);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == CAMERA_REQUEST_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // izin akses kamera diberikan
                scannerView.setResultHandler(this);
                scannerView.startCamera();
            } else {
                // izin akses kamera ditolak
                Toast.makeText(this, "Izin akses kamera diperlukan", Toast.LENGTH_SHORT).show();
                finish();
            }
        }
    }
}
