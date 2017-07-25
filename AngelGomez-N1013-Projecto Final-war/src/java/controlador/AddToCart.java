/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import beans.Carrito;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author clases
 */
public class AddToCart extends HttpServlet {

       public Carrito carroActual;
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
            out.println("<title>Servlet AddToCart</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AddToCart at " + request.getContextPath() + "</h1>");
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
        System.out.println("pasaporAddtoCart");
        
          ArrayList<Integer> productoParaCarrito= new ArrayList<Integer>();
          ArrayList<Integer> existenciaCarrito= new ArrayList<Integer>();
          HttpSession session=request.getSession();  
          if (session.getAttribute("carrito")==null){
                // no hay una sesion de carrito, creacion de carrito desde cero con su ID
          
          String usuario= (String) session.getAttribute("usuario");
          String articulo= (String) session.getAttribute("current");
          String aexistencia =( String) request.getParameter("cantidad");
          int existencia = Integer.parseInt(aexistencia);
          productoParaCarrito.add(Integer.parseInt(articulo));
          existenciaCarrito.add(existencia);
          
          String carritoID= "asdasd";
          Timestamp timeStamp = new Timestamp(System.currentTimeMillis());  
          
          System.out.println("usuario: "+usuario);
          System.out.println("articulo: "+articulo);
          System.out.println("carritoID: "+carritoID);
          System.out.println("time stamp "+timeStamp);
          
          carroActual= new Carrito(carritoID,usuario,12);
          
          carroActual.setExistenciaProductoCarrito(existenciaCarrito);
          carroActual.setProductoCarrito(productoParaCarrito);
          
          session.setAttribute("carrito", carritoID);
          session.setAttribute("carritoArticulo", productoParaCarrito);
          session.setAttribute("carritoExistencia", existenciaCarrito);
          
         
          }
          else{
              
              
              
         // aqui ya hay una sesion de carrito (update a la base de datos)
          String usuario= (String) session.getAttribute("usuario");
          String articulo= (String) session.getAttribute("current");
          
          
          ArrayList<Integer> productoParaCarrito2 =(ArrayList<Integer>) session.getAttribute("carritoArticulo");
          ArrayList<Integer> existenciaCarrito2 =(ArrayList<Integer>) session.getAttribute("carritoExistencia");
          
          if(productoParaCarrito2.contains(Integer.parseInt(articulo))){ // Aqui se validan que no se agreguen(sumen) mas de los que hay en stock
          
             int indexArticuloCambiarCantidad= productoParaCarrito2.indexOf(Integer.parseInt(articulo));
             
             int nuevoValor=existenciaCarrito2.get(indexArticuloCambiarCantidad)+ Integer.parseInt(request.getParameter("cantidad").toString());
             
             existenciaCarrito2.set(indexArticuloCambiarCantidad, nuevoValor);
              carroActual.setExistenciaProductoCarrito(existenciaCarrito2);
               System.out.println("ya creado------");
                System.out.println("Productos en el carrito"+productoParaCarrito2);
                 System.out.println("Cantidad en el carrito"+existenciaCarrito2);   
                
          }
             else {
          
          
          
          productoParaCarrito2.add(Integer.parseInt(articulo));
           String aexistencia =( String) request.getParameter("cantidad");
           int existencia = Integer.parseInt(aexistencia);
          existenciaCarrito2.add(existencia);
          
          //actualizar valores
          
          carroActual.setExistenciaProductoCarrito(existenciaCarrito2);
          carroActual.setProductoCarrito(productoParaCarrito2);
          
          //String carritoID= "asdasd"; // es un update por lo tanto el id se mantiene
          Timestamp timeStamp = new Timestamp(System.currentTimeMillis());
          session.setAttribute("carritoArticulo", productoParaCarrito2);
          session.setAttribute("carritoExistencia", existenciaCarrito2);
          
          System.out.println("ya creado------");
          System.out.println("Productos en el carrito"+productoParaCarrito2);
          System.out.println("Cantidad en el carrito"+existenciaCarrito2);
         
          
          }
          }
          session.setAttribute("productoAgregado", "si");
          session.setAttribute("carroData",carroActual);
          
         //RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
         //rd.forward(request, response);
         response.sendRedirect("index.jsp");

//processRequest(request, response);
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
