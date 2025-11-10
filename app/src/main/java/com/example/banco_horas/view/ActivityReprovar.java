package com.example.banco_horas.view;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.banco_horas.R;
import com.example.banco_horas.banco.SolicitacaoBanco;
import com.example.banco_horas.model.Solicitacao;

public class ActivityReprovar extends AppCompatActivity {

    EditText name_col, depart_col, ativ_col, perio_col, motivo;
    Button btn_enter;

    Solicitacao solicitarEditando = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reprovar);

        carregarFormulario();

        carregarBundle();
    }

    private void carregarFormulario(){
        name_col = findViewById(R.id.name_col);
        depart_col = findViewById(R.id.depart_col);
        ativ_col = findViewById(R.id.ativ_col);
        perio_col = findViewById(R.id.perio_col);
        motivo = findViewById(R.id.motivo);
        btn_enter = findViewById(R.id.btn_enter);

        btn_enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reprovar();
            }
        });

    }

    private void carregarBundle(){
        SolicitacaoBanco banco = new SolicitacaoBanco();
        Bundle b = getIntent().getExtras();
        if(b != null){
            if (b.get("solicitacao") != null ){
                Integer idS = (Integer) b.get("solicitacao");
                solicitarEditando = banco.carregarPorId(idS);
                if(solicitarEditando != null){
                    mostra(solicitarEditando);
                }
            }
        }
    }

    private void mostra(Solicitacao s){
        name_col.setText(s.getColaborador());
        depart_col.setText(s.getArea());
        ativ_col.setText(s.getAtividade());
        perio_col.setText(s.getPeriodo());
        motivo.setText(s.getMotivo_recusa());
    }

    private void reprovar(){
        Solicitacao s = new Solicitacao();

        if (solicitarEditando != null){
            s = solicitarEditando;
        }
        s.setColaborador(name_col.getText().toString());
        s.setArea(depart_col.getText().toString());
        s.setAtividade(ativ_col.getText().toString());
        s.setPeriodo(perio_col.getText().toString());
        s.setMotivo_recusa(motivo.getText().toString());

        SolicitacaoBanco dao = new SolicitacaoBanco();
        dao.alterar_negativo(s);
    }
}