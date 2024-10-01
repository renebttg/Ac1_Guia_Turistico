package com.example.ac1guia;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button btnLocal1, btnLocal2, btnLocal3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Agora que setContentView foi chamado, podemos inicializar os botões
        btnLocal1 = findViewById(R.id.btnLocal1);
        btnLocal2 = findViewById(R.id.btnLocal2);
        btnLocal3 = findViewById(R.id.btnLocal3);

        // Configurando os listeners para os botões
        btnLocal1.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, LocalActivity1.class);
            startActivity(intent);
        });

        btnLocal2.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, LocalActivity2.class);
            startActivity(intent);
        });

        btnLocal3.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, LocalActivity3.class);
            startActivity(intent);
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}
