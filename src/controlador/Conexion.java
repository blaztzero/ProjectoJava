/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author tallerespa
 */

public class Conexion {
    
    private Connection con;
    
    public boolean acceder() throws ClassNotFoundException, SQLException{
         Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://Localhost/libreria";
        String user = "root";
        String pass = "";
        con = DriverManager.getConnection(url, user, pass);
        return true;
    }
    public Connection get(){
        return con;
    }
    public void cerrar()throws Exception{
        con.close();
    }
}

