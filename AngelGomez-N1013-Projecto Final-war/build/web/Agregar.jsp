<%-- 
    Document   : Agregar
    Created on : 30/11/2016, 02:40:49 PM
    Author     : clases
--%>

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
        <script>
            function mensaje(){
             if (document.getElementById("cantidadProducto").value.valueOf(!null)){
                 console.log("etehbe");
                // Materialize.toast('Producto Agregado', 4000);
                 return true;   
             }
             else {return false;} 
         }
            
        </script>
        <!-- Inicio de Producto -->
           <%--<c:import url="/ProductLoad" /> --%>
        <%  //Llama los productos
           ArrayList<Producto> productos =(ArrayList<Producto>) session.getAttribute("productsLista"); 
            
        %>
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
        
        <li><a href="<%=inicioHistorial%>">Historial de Compras</a></li>           <!-- //cambia-->
      </ul>
    </div>
      </nav>
        
        
        <% 
        
        int current=Integer.parseInt(session.getAttribute("current").toString());
        
        
        System.out.print("er current" +current);
        %>
        <div id="agregarACarro" class="container">
   
       <div class="row">     
           
               <h4 class="col l6 m8 offset-l4 offset-m4"><%= productos.get(current).getNombre_producto()%></h4>
     <h5 class="col l6 m8 offset-l6 offset-m5">$<%=productos.get(current).getPrecioProducto()%></h5>
     <img class="responsive-img col l6 m8 offset-l3 offset-m2" width="60%" src="<%= productos.get(current).getImagenProducto() %>">
    
     <p class="col l10 offset-l1"><%=productos.get(current).getDescripcionProducto()%></p> 
     
       <div class="col l1 offset-l4"><p>Cantidad: </p></div>
       <form action="AddToCart" method="post">
       <div class="col l2"><input name="cantidad" id="cantidadProducto" type="number" required min="1" max="<%= productos.get(current).getExistenciaProducto()%>"></div>
      <div class="col l2"><button type="submit"  class="waves-effect waves-light btn orange darken-4" onclick="return mensaje()" >Agregar</button></div>
       </form>
        </div>
         
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
