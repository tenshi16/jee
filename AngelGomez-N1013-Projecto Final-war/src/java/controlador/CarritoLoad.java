/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import beans.Carrito;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author clases
 */
public class CarritoLoad extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CarritoLoad</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CarritoLoad at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         HttpSession session=request.getSession();  
         
        if(session.getAttribute("carroData")==null){
            response.sendRedirect("index.jsp");
        }
        else{
        
        Carrito carroACambiar= (Carrito) session.getAttribute("carroData");
        
        int productoACambiar= Integer.parseInt(request.getParameter("productoACambiar"));
        int cantidadACambiar=Integer.parseInt(request.getParameter("cantidadACambiar"));
        
        
        System.out.println("producto a cambiar:"+ productoACambiar);
        System.out.println("cantidad a cambiar:"+ cantidadACambiar);
        int indexProducto =carroACambiar.getProductoCarrito().indexOf(productoACambiar);
        if(cantidadACambiar==0){// quitar Producto
            
       
        carroACambiar.getExistenciaProductoCarrito().remove(indexProducto);
        carroACambiar.getProductoCarrito().remove(indexProducto);
        
        session.setAttribute("carroData",carroACambiar);
       // session.setAttribute("elementosActualesCarrito",carroACambiar.getExistenciaProductoCarrito().size());
        response.sendRedirect("Carrito.jsp");
        }
        
        else{
            int actual= carroACambiar.getExistenciaProductoCarrito().get(indexProducto);
            ArrayList<Integer> existenciaCambioCarrito = new ArrayList<Integer>();
            existenciaCambioCarrito=carroACambiar.getExistenciaProductoCarrito();
            existenciaCambioCarrito.set(indexProducto, cantidadACambiar);
            carroACambiar.setExistenciaProductoCarrito(existenciaCambioCarrito);
            
            session.setAttribute("carroData",carroACambiar);
            response.sendRedirect("Carrito.jsp");
        }
          //processRequest(request, response);
        }   
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
