package com.example.crm.dao;

import android.os.StrictMode;
import android.util.Log;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DAO {
    String gURL = "jdbc:mysql://";
    String gIP = "10.195.41.220"; //Direccion Ip de la maquina que aloja la base de datos
    String gPORT = "3306";
    String gDATABASE = "patrones";
    String gUSR = "Rojax10";
    String gPSW = "rojax10";
    String resultado = "";

    public Connection CONN()
    {
        final String class_jdbc = "com.mysql.jdbc.Driver";

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                .permitAll().build();
        StrictMode.setThreadPolicy(policy);
        Connection conn = null;
        try {
            Class.forName(class_jdbc);
            conn = DriverManager.getConnection(gURL + gIP + ":" + gPORT + "/" + gDATABASE, gUSR, gPSW);
        } catch (SQLException se) {
            Log.e("ERROR1", se.getMessage());
        } catch (ClassNotFoundException e) {
            Log.e("ERROR2", e.getMessage());
        } catch (Exception e) {
            Log.e("ERROR3", e.getMessage());
        }
        return conn;
    }

    private String Query_Version()
    {
        String response = "";

        try {
            Connection ConnexionMySQL = CONN();
            Statement st = ConnexionMySQL.createStatement();

            ResultSet rs = st.executeQuery("SELECT * FROM usuario ");
            //ResultSet rs = st.executeQuery("SHOW VARIABLES LIKE \"%version%\"");

            while (rs.next()) {
                response += rs.getString(1) + " - " + rs.getString(2) + " - " + rs.getString(3)
                        + " - " + rs.getString(4) + " - " + rs.getString(5) + "\n";
            }
            rs.close();
            ConnexionMySQL.close();

        } catch (Exception e) {
            e.printStackTrace();

        }
        return response;
    }

    public String DoOnThread()
    {
        Thread thread = new Thread() {
            @Override
            public void run()
            {
                String mResult = Query_Version();
                Log.e("MYSQL Version", mResult);
                resultado = mResult;
            }
        };
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return resultado;
    }
}
