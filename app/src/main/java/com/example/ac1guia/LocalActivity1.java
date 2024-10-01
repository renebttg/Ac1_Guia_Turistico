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

public class LocalActivity1 extends AppCompatActivity {

    Button btnAbrirMapa, btnAbrirSite, btnLigar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_local1);

        // Inicializando os botões
        btnAbrirMapa = findViewById(R.id.btnMapa);
        btnAbrirSite = findViewById(R.id.btnSite);
        btnLigar = findViewById(R.id.btnFazerLigacao);

        // Ação para abrir o mapa
        btnAbrirMapa.setOnClickListener(v -> {
            Uri uri = Uri.parse("geo:0,0?q=-23.506650788054404, -47.43809415767081");
            Intent mapIntent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(mapIntent);
        });

        // Ação para abrir o site
        btnAbrirSite.setOnClickListener(v -> {
            Uri webpage = Uri.parse("https://www.sorocaba.sp.gov.br/zoologico");
            Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
            startActivity(intent);
        });

        // Ação para realizar uma chamada
        btnLigar.setOnClickListener(v -> {
            Uri uri = Uri.parse("tel:1599115-4936");
            Intent intent = new Intent(Intent.ACTION_CALL, uri);
            int permissionCheck = ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE);
            if (permissionCheck != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE}, 1);
            } else {
                startActivity(intent);
            }
        });

        // Ajuste de layout para sistema edge-to-edge
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}
