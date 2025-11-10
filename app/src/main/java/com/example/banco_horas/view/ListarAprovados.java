package com.example.banco_horas.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.banco_horas.MenuPrincipal;
import com.example.banco_horas.R;
import com.example.banco_horas.adapter.ListarAprovadosAdapter;
import com.example.banco_horas.adapter.ListarReprovadosAdapter;
import com.example.banco_horas.adapter.ListarSolicitacaoAdapter;
import com.example.banco_horas.banco.AprovadosBanco;
import com.example.banco_horas.banco.ReprovadosBanco;
import com.example.banco_horas.model.Solicitacao;

import java.util.List;

public class ListarAprovados extends AppCompatActivity {

    Button btnload, btnfech, btnfila;
    ListView listView;
    ListarAprovadosAdapter adapter;
    List<Solicitacao> lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_aprovados);
        btnload = findViewById(R.id.txtmsg);
        btnfech = findViewById(R.id.fechado);
        btnfila = findViewById(R.id.aguardando);
        listView = findViewById(R.id.lista);

        btnfila.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ListarAprovados.this, ListaSolicitacoes.class);
                startActivity(intent);
            }
        });

        btnfech.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ListarAprovados.this, ListarReprovados.class);
                startActivity(intent);
            }
        });

        preenche();
    }

    private void preenche(){
        AprovadosBanco banco = new AprovadosBanco();
        lista = banco.getAll();

        adapter = new ListarAprovadosAdapter(lista, this);
        listView.setAdapter(adapter);
    }

}