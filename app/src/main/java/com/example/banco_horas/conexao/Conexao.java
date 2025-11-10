package com.example.banco_horas.conexao;

import android.os.StrictMode;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    public static Connection conectar() throws ClassNotFoundException, SQLException {
        Connection conn = null;

        StrictMode.ThreadPolicy politica;
        politica = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(politica);

        Class.forName("net.sourceforge.jtds.jdbc.Driver");

        String ip = "192.168.1.196";
        String port = "1433";
        String db = "FABautomacao";
        String un = "desenvolvimento";
        String password = "desenvolvimento@1505";

        String connString = "jdbc:jtds:sqlserver://"+ip+":"+port+";"+ db;
        conn = DriverManager.getConnection(connString, un, password);

        return conn;
    }
}
