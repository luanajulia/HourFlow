package com.example.banco_horas.banco;

import com.example.banco_horas.conexao.Conexao;
import com.example.banco_horas.model.Solicitacao;
import com.example.banco_horas.model.Usuario;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SolicitacaoBanco {

    private Connection conn = null;

    public void alterar_positivo(Solicitacao s){
        try {
            executeSql("update [192.168.1.203].[DPbancohoras].[dbo].[banco] set aprovacao = 'aprovado', motivo_recusa = '"+s.getMotivo_recusa()+"' where id = '"+s.getId()+"' ");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void alterar_negativo(Solicitacao s){
        try {
            executeSql("update [192.168.1.203].[DPbancohoras].[dbo].[banco] set aprovacao = 'reprovado', motivo_recusa = '"+s.getMotivo_recusa()+"' where id = '"+s.getId()+"' ");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public  Solicitacao carregarPorId(Integer id){
        try {
            conn = Conexao.conectar();
            if (conn != null){
                String sql = " SELECT * FROM [192.168.1.203].[DPbancohoras].[dbo].[banco] where id ="+id;
                Statement st =  conn.createStatement();
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()){
                    Solicitacao sol = new Solicitacao();
                    sol.setId(rs.getInt(1));
                    sol.setColaborador(rs.getString(4));
                    sol.setArea(rs.getString(2));
                    sol.setAtividade(rs.getString(5));
                    sol.setPeriodo(rs.getString(6));
                    sol.setMatricula(rs.getString(8));
                    sol.setAprovacao(rs.getString(9));
                    sol.setMotivo_recusa(rs.getString(10));
                    sol.setResponsavel(rs.getInt(7));

                    conn.close();
                    return sol;
                }
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    private void executeSql(String sql) throws SQLException, ClassNotFoundException {
        conn = Conexao.conectar();
        if (conn != null){
            Statement st = conn.createStatement();
            st.executeQuery(sql);
            conn.close();
        }

    }

    public List<Solicitacao> getAll() {
        List<Solicitacao> lista = new ArrayList<Solicitacao>();
        try {
            Connection conn = Conexao.conectar();
            if (conn != null) {
                String sql = "SELECT TOP 10 *, IIF(LEN(banco.matricula)>4, banco.matricula, concat('00', banco.matricula))  as matriculas, CONCAT((cast((r.Saldo)as int)/60) ,':',  FORMAT(abs((((((cast((r.Saldo)as real)/60)) - (cast((r.Saldo)as int)/60))*60))), '0#')) AS saldo,  IIF(floor(r.Saldo)<0, 'Negativo', 'Positivo') as status FROM [192.168.1.203].[DPbancohoras].[dbo].[banco] LEFT JOIN [192.168.1.203].[DPbancohoras].[dbo].[relatorio] as r ON IIF(LEN(banco.matricula)>4, banco.matricula, concat('00', banco.matricula)) = r.matricula where aprovacao is null and motivo_recusa is null order by banco.id";
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
