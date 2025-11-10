package com.example.banco_horas.banco;

import com.example.banco_horas.conexao.Conexao;
import com.example.banco_horas.model.Solicitacao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ReprovadosBanco {

    public List<Solicitacao> getAll() {
        List<Solicitacao> lista = new ArrayList<Solicitacao>();
        try {
            Connection conn = Conexao.conectar();
            if (conn != null) {
                String sql = "SELECT TOP 10 *, IIF(LEN(banco.matricula)>4, banco.matricula, concat('00', banco.matricula))  as matriculas, CONCAT((cast((r.Saldo)as int)/60) ,':',  FORMAT(abs((((((cast((r.Saldo)as real)/60)) - (cast((r.Saldo)as int)/60))*60))), '0#')) AS saldo,  IIF(floor(r.Saldo)<0, 'Negativo', 'Positivo') as status FROM [192.168.1.203].[DPbancohoras].[dbo].[banco] LEFT JOIN [192.168.1.203].[DPbancohoras].[dbo].[relatorio] as r ON IIF(LEN(banco.matricula)>4, banco.matricula, concat('00', banco.matricula)) = r.matricula where aprovacao = 'reprovado'";
                Statement st = null;
                st = conn.createStatement();

                ResultSet rs = st.executeQuery(sql);
                while (rs.next()){
                    Solicitacao pro = new Solicitacao();
                    pro.setId(rs.getInt(1));
                    pro.setColaborador(rs.getString(4));
                    pro.setArea(rs.getString(2));
                    pro.setAtividade(rs.getString(5));
                    pro.setPeriodo(rs.getString(6));
                    pro.setMatricula(rs.getString(8));
                    pro.setAprovacao(rs.getString(9));
                    pro.setMotivo_recusa(rs.getString(10));
                    pro.setResponsavel(rs.getInt(7));
                    pro.setStatus(rs.getString(19));
                    pro.setSaldo(rs.getString(18));

                    lista.add(pro);
                }

                conn.close();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return lista;
    }
}
