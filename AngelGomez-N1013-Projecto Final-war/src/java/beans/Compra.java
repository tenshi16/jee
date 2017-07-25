/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.sql.Timestamp;
import java.util.ArrayList;

/**
 *
 * @author clases
 */
public class Compra {

   
    public Compra(String compraID, Carrito carritoComprado,Timestamp timeStampCompra) {
        this.compraID = compraID;
        this.carritoComprado = carritoComprado;
         this.timeStampCompra = timeStampCompra;
    }

    public String getCompraID() {
        return compraID;
    }

    public void setCompraID(String compraID) {
        this.compraID = compraID;
    }

    public Carrito getCarritoComprado() {
        return carritoComprado;
    }

    public void setCarritoComprado(Carrito carritoComprado) {
        this.carritoComprado = carritoComprado;
    }
    
    private String compraID;
    private Carrito carritoComprado;

    public Timestamp getTimeStampCompra() {
        return timeStampCompra;
    }

    public void setTimeStampCompra(Timestamp timeStampCompra) {
        this.timeStampCompra = timeStampCompra;
    }
    private Timestamp timeStampCompra;
}
