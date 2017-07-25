/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

/**
 *
 * @author tenshi16
 */
public class Producto {
    
    private String id_producto;
    private String nombre_producto;
    private int precioProducto;
    private String descripcionProducto;
    private int existenciaProducto;
    private String imagenProducto;

    public Producto(String id_producto, String nombre_producto, int precioProducto, String descripcionProducto, int existenciaProducto, String imagenProducto) {
        this.id_producto = id_producto;
        this.nombre_producto = nombre_producto;
        this.precioProducto = precioProducto;
        this.descripcionProducto = descripcionProducto;
        this.existenciaProducto = existenciaProducto;
        this.imagenProducto = imagenProducto;
    }

    public String getId_producto() {
        return id_producto;
    }

    public void setId_producto(String id_producto) {
        this.id_producto = id_producto;
    }

    public String getNombre_producto() {
        return nombre_producto;
    }

    public void setNombre_producto(String nombre_producto) {
        this.nombre_producto = nombre_producto;
    }

    public int getPrecioProducto() {
        return precioProducto;
    }

    public void setPrecioProducto(int precioProducto) {
        this.precioProducto = precioProducto;
    }

    public String getDescripcionProducto() {
        return descripcionProducto;
    }

    public void setDescripcionProducto(String descripcionProducto) {
        this.descripcionProducto = descripcionProducto;
    }

    public int getExistenciaProducto() {
        return existenciaProducto;
    }

    public void setExistenciaProducto(int existenciaProducto) {
        this.existenciaProducto = existenciaProducto;
    }

    public String getImagenProducto() {
        return imagenProducto;
    }

    public void setImagenProducto(String imagenProducto) {
        this.imagenProducto = imagenProducto;
    }
}
  
