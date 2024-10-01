package com.example.ac1guia;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class LocalActivity3 extends AppCompatActivity {

    Button btnAbrirMapa, btnAbrirSite, btnLigar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_local3);


        btnAbrirMapa = findViewById(R.id.btnMapa);
        btnAbrirSite = findViewById(R.id.btnSite);
        btnLigar = findViewById(R.id.btnFazerLigacao);


        btnAbrirMapa.setOnClickListener(v -> {
            Uri uri = Uri.parse("geo:0,0?q=-23.465089854433113,-47.437254342329176");
            Intent mapIntent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(mapIntent);
        });


        btnAbrirSite.setOnClickListener(v -> {
            Uri webpage = Uri.parse("https://meioambiente.sorocaba.sp.gov.br/");
            Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
            startActivity(intent);
        });


        btnLigar.setOnClickListener(v -> {
            Uri uri = Uri.parse("tel:1532351130");
            Intent intent = new Intent(Intent.ACTION_CALL, uri);
            int permissionCheck = ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE);
            if (permissionCheck != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE}, 1);
            } else {
                startActivity(intent);
            }
        });


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}
