<%-- 
    Document   : Carrito
    Created on : 30/11/2016, 04:42:06 PM
    Author     : clases
--%>

<%@page import="beans.Carrito"%>
<%@page import="java.util.ArrayList"%>
<%@page import="beans.Producto"%>
<%@page import="beans.Usuario"%>
<%@page import="java.lang.Object"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <!--Import Google Icon Font-->
        <link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <!--Import materialize.css-->
        <link type="text/css" rel="stylesheet" href="css/materialize.min.css"  media="screen,projection"/>
         <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.4/jquery.min.js"></script>

        <!--Let browser know website is optimized for mobile-->
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
        <title>Compramelo</title>
    </head>
    <body>
         <!--Import jQuery before materialize.js-->
      <script type="text/javascript" src="js/jquery-3.1.1.min.js"></script>
      <script type="text/javascript" src="js/materialize.min.js"></script>
      <script type="text/javascript" src="js/muhScript.js"></script>
      <!--We do dis -->
        
     <nav>       
    <div class="nav-wrapper orange lighten-1">
      <a href="index.jsp" class="brand-logo">Compramelo</a>
      <ul id="nav-mobile" class="right hide-on-med-and-down">
          
         
          <%
              String inicioONombre="Iniciar Sesion";
              String hrefDeLogin="#loginModal";
              if(session.getAttribute("usuario")!=null){
               inicioONombre="Bienvenido, ";
               inicioONombre+=session.getAttribute("usuario").toString(); 
               hrefDeLogin="#";
              }
             
          
    %>
            
    <li><a href="<%=hrefDeLogin%>"><%=inicioONombre%></a></li>      <!-- //cambia-->
    <% String inicioNombreCarro="Carrito.jsp";
            String href404="Notfound.jsp";
         if(session.getAttribute("carroData")==null){
         inicioNombreCarro=href404;
        }
        %>
        <li><a href="<%=inicioNombreCarro%>">Carrito</a></li>            <!--  //cambia-->
        
         <% String inicioHistorial="Historial.jsp";
         if(session.getAttribute("compra")==null){
         inicioHistorial=href404;
        }
        %>
        
        <li><a href="<%=inicioHistorial%>">Historial de Compras</a></li>             <!-- //cambia-->
      </ul>
    </div>
      </nav>
    
    <!-- MODALS -->        
    <div id="loginModal" class="modal">
    <div class="modal-content">
        <form action="LogInServlet" method="post">
      <div class="input-field col s6">
          <input id="email" name="usuario" type="text" class="validate">
          <label for="email">Correo</label>
        </div>
        <div class="input-field col s6">
          <input id="password" name="contrasena" type="text" class="validate">
          <label for="password">Contraseña</label>
          <button type="submit"  class="waves-effect waves-light btn orange darken-3">Iniciar</button>
    </div>
        </form>
    </div>
    <div class="modal-footer">
        <p>No tienes una cuenta aún?</p>
        <input type="button" class="waves-effect waves-light btn orange darken-4" value="Crear">
     <!-- <a href="#!" class=" modal-action modal-close waves-effect waves-green btn-flat">Agree</a> -->
    </div>
  </div>  
    
    
    <% 
    Carrito carroParaVista = (Carrito) session.getAttribute("carroData");
    
    %>
    <!-- Funcion que regresa el total en el carrito-->
    <%! 
        
        public double total(Carrito e,ArrayList<Producto> d, HttpSession session){
            double total=0;
         for (int i=0;i<e.getProductoCarrito().size();i++){
         
         total+=d.get(e.getProductoCarrito().get(i)).getPrecioProducto()*e.getExistenciaProductoCarrito().get(i) ;
         
        }
         session.setAttribute("totalCarrito",total);
         return total;
    } 
        
        %>
    
    <!-- A LLENAR -->
    <% 
    
        System.out.println("cuantas veces se llama este jsp?");
        
        ArrayList<Producto> productos =(ArrayList<Producto>) session.getAttribute("productsLista"); 
        System.out.println("Vista"+ carroParaVista.getCarritoID().toString());
        System.out.println("Vista"+ carroParaVista.getUsuarioEmail());
        System.out.println("Vista"+ carroParaVista.getProductoCarrito());
        System.out.println("Vista"+ carroParaVista.getExistenciaProductoCarrito());
       
        
        for (int i=0;i<carroParaVista.getProductoCarrito().size();i++){
            
        
    %>
     <div class="divider"></div>
                <div class="section">
                     <div class="row">
                         <div class="col s6 m3 l2"><img class="responsive-img" src="<%= productos.get(carroParaVista.getProductoCarrito().get(i)).getImagenProducto() %>"></div>
                    <div class="col s6 m3 l2"><h5><%= productos.get(carroParaVista.getProductoCarrito().get(i)).getNombre_producto() %></h5></div>
                    <div class="col s6 m3 l2"><p><%= productos.get(carroParaVista.getProductoCarrito().get(i)).getPrecioProducto() %></p></div>
                    <div class="col s6  m3 l2 offset-l4">
                        <p>Cantidad: <%=carroParaVista.getExistenciaProductoCarrito().get(i) %></p>
                        <form method="post" action="CarritoLoad">
                            <input type="hidden" name="productoACambiar" value="<%= carroParaVista.getProductoCarrito().get(i)%>">       
                            <input type="number" name="cantidadACambiar" required>
                    <button class="waves-effect waves-light btn orange darken-3" type="submit">Actualizar</button>
                        </form>
                    </div>
                     </div>
                </div>
     <%} %>
     <!-- A LLENAR -->
     <div id="total">
         <form action="Comprar" method="post">
             <p>Total: </p>
             <input type="hidden" name="totalAPagar">
             <p><%= total(carroParaVista,productos,session)%>$</p>
             <button class="waves-effect waves-light btn orange darken-3" type="submit">Comprar</button>
         </form>
         
         
     </div>
     
      <footer class="page-footer orange darken-4">
          <div class="container">
            <div class="row">
              <div class="col l6 s12">
                <h5 class="white-text">Aplicación MVC</h5>
                <p class="grey-text text-lighten-4">N1013</p>
              </div>    
              <div class="col l4 offset-l2 s12">
                <h5 class="white-text">Navegación</h5>
                <ul>
                  <li><a class="grey-text text-lighten-3" href="index.jsp">Inicio</a></li>
                  <li><a class="grey-text text-lighten-3" href="<%=inicioNombreCarro%>">Carrito</a></li>
                  <li><a class="grey-text text-lighten-3" href="<%=inicioHistorial%>">Historial de Compra</a></li>
                </ul>
              </div>
            </div>
          </div>
          <div class="footer-copyright">
            <div class="container">
            © 2016 Angel Gómez
            <a class="grey-text text-lighten-4 right" href="#!">More Links</a>
            </div>
          </div>
        </footer>
            
    </body>
</html>
