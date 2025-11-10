package com.example.banco_horas.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.banco_horas.R;
import com.example.banco_horas.model.Solicitacao;

import java.io.Serializable;
import java.util.List;

public class ListarReprovadosAdapter extends BaseAdapter implements Serializable {
    private static final long serialVersionUID = 546546546546L;
    private List<Solicitacao> listarReprovados;
    private Context context;
    private LayoutInflater layout;

    public ListarReprovadosAdapter(List<Solicitacao> listarReprovados, Context context) {
        this.listarReprovados = listarReprovados;
        this.context = context;
        layout = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return listarReprovados.size();
    }

    @Override
    public Object getItem(int i) {
        return listarReprovados.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Solicitacao sol = listarReprovados.get(i);
        View v = layout.inflate(R.layout.listlayouttempleatreprovado, null);

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
        TextView MotivoAprovado = v.findViewById(R.id.motivo_ar);
        TextView MotivoA = v.findViewById(R.id.motivo_a);

        txtNome.setText(sol.getColaborador());
        txtArea.setText(sol.getArea());
        txtAtividade.setText(sol.getAtividade());
        txtStatus.setText(sol.getStatus());
        txtSaldo.setText(sol.getSaldo());
        txtPeriodo.setText(sol.getPeriodo());
        MotivoA.setText(sol.getMotivo_recusa());
        Nome.setText("Colaborador:");
        Departamento.setText("Departamento:");
        Status.setText("Status/Saldo");
        Periodo.setText("Periodo:");
        Motivo.setText("Motivo:");
        MotivoAprovado.setText("Motivo Recusa:");

        return v;
    }
}
