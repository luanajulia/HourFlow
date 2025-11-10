package com.example.banco_horas.banco;

import android.util.Log;

import com.example.banco_horas.conexao.Conexao;
import com.example.banco_horas.model.Usuario;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UsuarioBanco {

    Connection connect;

    public Usuario selecionarUsuario(String email, String senha) {
        try {
            Connection conn = Conexao.conectar();
            if (conn != null) {
                String sql = "SELECT * FROM [192.168.1.203].[FABautomacao].[dbo].[MRA010] WHERE email = '"+email+"' and senha = '"+senha+"'";
                Statement st = null;
                st = conn.createStatement();

                ResultSet rs = st.executeQuery(sql);
                while (rs.next()){
                    Usuario usu = new Usuario();
                    usu.setId(rs.getInt(1));
                    usu.setEmail(rs.getString(4));
                    usu.setSenha(rs.getString(3));

                    conn.close();
                    return usu;
                }


            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
