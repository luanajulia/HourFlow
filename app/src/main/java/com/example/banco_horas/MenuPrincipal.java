package com.example.banco_horas;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.banco_horas.view.ListaSolicitacoes;
import com.example.banco_horas.view.ListarAprovados;
import com.example.banco_horas.view.ListarReprovados;

public class MenuPrincipal extends AppCompatActivity {

    Button  btnload, btnfech, btnfila = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);

        btnload = findViewById(R.id.txtmsg);
        btnfech = findViewById(R.id.fechado);
        btnfila = findViewById(R.id.aguardando);

        btnfila.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MenuPrincipal.this, ListaSolicitacoes.class);
                startActivity(intent);
            }
        });

        btnfech.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MenuPrincipal.this, ListarReprovados.class);
                startActivity(intent);
            }
        });

        btnload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MenuPrincipal.this, ListarAprovados.class);
                startActivity(intent);
            }
        });
    }
}