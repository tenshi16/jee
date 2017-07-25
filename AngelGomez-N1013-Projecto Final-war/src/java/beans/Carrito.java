/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.util.ArrayList;

/**
 *
 * @author clases
 */
public class Carrito {

    public Carrito(String carritoID, String usuarioEmail, double totalCarrito) {
        this.carritoID = carritoID;
        this.usuarioEmail = usuarioEmail;
        this.totalCarrito = totalCarrito;
    }

   

    public String getCarritoID() {
        return carritoID;
    }

    public void setCarritoID(String carritoID) {
        this.carritoID = carritoID;
    }

    public String getUsuarioEmail() {
        return usuarioEmail;
    }

    public void setUsuarioEmail(String usuarioEmail) {
        this.usuarioEmail = usuarioEmail;
    }

    public ArrayList<Integer> getProductoCarrito() {
        return productoCarrito;
    }

    public void setProductoCarrito(ArrayList<Integer> productoCarrito) {
        this.productoCarrito = productoCarrito;
    }

    public ArrayList<Integer> getExistenciaProductoCarrito() {
        return existenciaProductoCarrito;
    }

    public void setExistenciaProductoCarrito(ArrayList<Integer> existenciaProductoCarrito) {
        this.existenciaProductoCarrito = existenciaProductoCarrito;
    }

    public double getTotalCarrito() {
        return totalCarrito;
    }

    public void setTotalCarrito(double totalCarrito) {
        this.totalCarrito = totalCarrito;
    }
    private String carritoID;
    private String usuarioEmail;
    private ArrayList<Integer> productoCarrito = new ArrayList<>();
    private ArrayList<Integer> existenciaProductoCarrito = new ArrayList<>();
    private double totalCarrito;
    
    
    
}
