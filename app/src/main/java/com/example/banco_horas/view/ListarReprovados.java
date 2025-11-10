package com.example.banco_horas.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
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
import com.example.banco_horas.banco.SolicitacaoBanco;
import com.example.banco_horas.model.Solicitacao;

import java.util.List;

public class ListarReprovados extends AppCompatActivity {

    Button btnload, btnfech, btnfila;
    ListView listView;
    ListarReprovadosAdapter adapter;
    List<Solicitacao> lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_reprovados);
        btnload = findViewById(R.id.txtmsg);
        btnfech = findViewById(R.id.fechado);
        btnfila = findViewById(R.id.aguardando);
        listView = findViewById(R.id.lista);


        preenche();
        btnfila.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ListarReprovados.this, ListaSolicitacoes.class);
                startActivity(intent);
            }
        });



        btnload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ListarReprovados.this, ListarAprovados.class);
                startActivity(intent);
            }
        });
    }

    private void preenche(){
        ReprovadosBanco banco = new ReprovadosBanco();
        lista = banco.getAll();

        adapter = new ListarReprovadosAdapter(lista, this);
        listView.setAdapter(adapter);
    }

}