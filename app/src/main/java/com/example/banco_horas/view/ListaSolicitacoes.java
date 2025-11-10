package com.example.banco_horas.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.banco_horas.MenuPrincipal;
import com.example.banco_horas.R;
import com.example.banco_horas.adapter.ListarAprovadosAdapter;
import com.example.banco_horas.adapter.ListarSolicitacaoAdapter;
import com.example.banco_horas.banco.AprovadosBanco;
import com.example.banco_horas.banco.SolicitacaoBanco;
import com.example.banco_horas.model.Solicitacao;

import java.time.Period;
import java.util.List;

public class ListaSolicitacoes extends AppCompatActivity {

    Button btnload, btnfech, btnfila;
    ListView listView;
    ListarSolicitacaoAdapter adapter;
    List<Solicitacao> lista;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_solicitacoes);

        btnload = findViewById(R.id.txtmsg);
        btnfech = findViewById(R.id.fechado);
        btnfila = findViewById(R.id.aguardando);
        listView = findViewById(R.id.lista);


        btnfech.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ListaSolicitacoes.this, ListarReprovados.class);
                startActivity(intent);
            }
        });

        btnload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ListaSolicitacoes.this, ListarAprovados.class);
                startActivity(intent);
            }
        });



        preenche();

    }
    private void preenche(){
        SolicitacaoBanco banco = new SolicitacaoBanco();
        lista = banco.getAll();

        adapter = new ListarSolicitacaoAdapter(lista, this);
        listView.setAdapter(adapter);
    }
}