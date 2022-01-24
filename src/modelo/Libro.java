/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author tallerespa
 */
public class Libro {
    
    
    String codigo;
    String nombre;
    String formato;
    int paginas;
    String categoria;
    String autor;
    boolean nuevo;

    public Libro() {
        this.codigo = "";
        this.nombre = "";
        this.formato = "";
        this.paginas = 0;
        this.categoria = "";
        this.autor = "";
        this.nuevo = false;
    }

    public Libro(String codigo, String nombre, String formato, int paginas, String categoria, String autor, boolean nuevo) {
        setCodigo(codigo);
        setNombre(nombre);
        setFormato(formato);
        setPaginas(paginas);
        setCategoria(categoria);
        setAutor(autor);
        setNuevo(nuevo);
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    public int getPaginas() {
        return paginas;
    }

    public void setPaginas(int paginas) {
        this.paginas = paginas;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public boolean isNuevo() {
        return nuevo;
    }

    public void setNuevo(boolean nuevo) {
        this.nuevo = nuevo;
    }

    @Override
    public String toString() {
        return "Libro: " + "codigo=" + codigo + ", nombre=" + nombre + ", formato=" + formato + ", paginas=" + paginas + ", categoria=" + categoria + ", autor=" + autor + ", nuevo=" + nuevo ;
    }
    
}
