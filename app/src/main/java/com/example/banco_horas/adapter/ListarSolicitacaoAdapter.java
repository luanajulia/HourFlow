package com.example.banco_horas.adapter;

import android.content.Context;
import android.content.Intent;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.example.banco_horas.R;
import com.example.banco_horas.banco.SolicitacaoBanco;
import com.example.banco_horas.model.Solicitacao;
import com.example.banco_horas.view.ActivityReprovar;
import com.example.banco_horas.view.ActivitySolicitacao;

import java.io.Serializable;
import java.util.List;

public class ListarSolicitacaoAdapter extends BaseAdapter implements Serializable {
    private static final long serialVersionUID = 546546546546L;

    private List<Solicitacao> listarSolicitacao;
    private Context context;
    private LayoutInflater layout;

    public ListarSolicitacaoAdapter(List<Solicitacao> listarSolicitacao, Context context) {
        this.listarSolicitacao = listarSolicitacao;
        this.context = context;
        layout = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return listarSolicitacao.size();
    }

    @Override
    public Solicitacao getItem(int i) {
        return listarSolicitacao.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Solicitacao sol = listarSolicitacao.get(i);
        View v = layout.inflate(R.layout.listlayouttempleat, null);

        TextView txtNome = v.findViewById(R.id.nome);
        TextView txtArea = v.findViewById(R.id.departamento);
        TextView txtAtividade = v.findViewById(R.id.atividade);
        TextView txtStatus = v.findViewById(R.id.status_saldo);
        TextView txtSaldo = v.findViewById(R.id.saldo);
        TextView txtPeriodo = v.findViewById(R.id.sts);
        TextView Nome = v.findViewById(R.id.textop);
        TextView Departamento = v.findViewById(R.id.Operador);
        TextView Status = v.findViewById(R.id.data);
        TextView Periodo = v.findViewById(R.id.status);
        TextView Motivo = v.findViewById(R.id.maquina);

        txtNome.setText(sol.getColaborador());
        txtArea.setText(sol.getArea());
        txtAtividade.setText(sol.getAtividade());
        txtStatus.setText(sol.getStatus());
        txtSaldo.setText(sol.getSaldo());
        txtPeriodo.setText(sol.getPeriodo());
        Nome.setText("Colaborador:");
        Departamento.setText("Departamento:");
        Status.setText("Status/Saldo");
        Periodo.setText("Periodo:");
        Motivo.setText("Motivo:");

        Button btnAprovar = v.findViewById(R.id.aprovar);
        btnAprovar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ActivitySolicitacao.class);
                intent.putExtra("solicitacao", sol.getId());
                context.startActivity(intent);
            }
        });

        Button btnReprovar = v.findViewById(R.id.reprova);
        btnReprovar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ActivityReprovar.class);
                intent.putExtra("solicitacao", sol.getId());
                context.startActivity(intent);
            }
        });

        return v;
    }
}
