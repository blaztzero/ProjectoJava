/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Libro;

/**
 *
 * @author Camilo
 */
public class RegistroBiblioteca {
     Conexion con = new Conexion();
    
    public int agregar(Libro libro) 
            throws ClassNotFoundException, SQLException{
        con.acceder();
        String query="insert into libro(codigo, nombre, formato, pagina,categoria,autor,nuevo) "
                +"values(?,?,?,?,?,?,?);";
        PreparedStatement  consulta = 
                con.get().prepareStatement(query);
        consulta.setString(1, libro.getCodigo());
        consulta.setString(2, libro.getNombre());
        consulta.setString(3, libro.getFormato());
        consulta.setInt(4, libro.getPaginas());
        consulta.setString(5, libro.getCategoria());
        consulta.setString(6, libro.getAutor());
        consulta.setBoolean(7, libro.isNuevo());
        
        
        consulta.execute();
        
        return 1;
        
    }
    
   public ArrayList<Libro> mostrar() 
            throws ClassNotFoundException, SQLException,
            Exception{
        con.acceder();
        String query ="select codigo, nombre, formato, pagina,categoria,autor,nuevo "
                + "from libro ";
        PreparedStatement consulta = 
                con.get().prepareStatement(query);
        ResultSet resultado = consulta.executeQuery();
        ArrayList<Libro> libros = new ArrayList<>();
        while (resultado.next()) {
            String codigo = resultado.getString(1);
            String nombre=resultado.getString(2);
            String formato=resultado.getString(3);
            int pagina = resultado.getInt(4);
            String categoria=resultado.getString(5);
            String autor=resultado.getString(6);
            boolean nuevo=resultado.getBoolean(7);
            
            Libro libro = new Libro(codigo, nombre, formato, pagina, categoria, autor, nuevo);
                    
            libros.add(libro);
        }
        con.cerrar();
        return libros;
    } 
   
    
    
    public int actualizar(Libro libro)
            throws ClassNotFoundException, SQLException{
        con.acceder();
        String query= "UPDATE libro SET nombre=?"
                + ", formato=? "
                + ", pagina=?"
                + ", categoria=? "
                + ", autor=? "
                + ", nuevo=? "
                + "where codigo=?";
                
               
        PreparedStatement consulta = con.get().prepareStatement(query);
                                     
       
        consulta.setString(1, libro.getNombre());
        consulta.setString(2, libro.getFormato());
        consulta.setInt(3, libro.getPaginas());
        consulta.setString(4, libro.getCategoria());
        consulta.setString(5, libro.getAutor());
        consulta.setBoolean(6, libro.isNuevo());
        consulta.setString(7, libro.getCodigo());
         
        consulta.executeUpdate();
        return 1;
    }
    
    public int eliminar(String codigo) 
            throws ClassNotFoundException, SQLException{
        con.acceder();
        String query="delete from libro where codigo=?";
        
        PreparedStatement consulta=
                con.get().prepareStatement(query);
        consulta.setString(1, codigo);
        consulta.execute();
        return 1;
    }
    public Libro buscar(String codigo) 
            throws ClassNotFoundException, SQLException, Exception{
        con.acceder();
        String query=" select *  from libro where codigo=?";
        
        PreparedStatement consulta=
                con.get().prepareStatement(query);
        consulta.setString(1, codigo);
        
        ResultSet resultado = consulta.executeQuery();
        while (resultado.next()) {
            String codigoB = resultado.getString(1);
            String nombre=resultado.getString(2);
            String formato = resultado.getString(3);
            int paginas = resultado.getInt(4);
            String categoria=resultado.getString(5);
            String autor=resultado.getString(6);
            boolean nuevo=resultado.getBoolean(7);
            Libro libro;
            libro = new Libro(codigoB, nombre, formato, paginas, categoria,autor,nuevo);
            return libro;
        }
         return null;
        
        
    }

}
