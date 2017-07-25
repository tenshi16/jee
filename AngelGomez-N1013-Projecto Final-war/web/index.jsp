<%-- 
    Document   : index
    Created on : 24/11/2016, 03:00:25 PM
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
        
            
           <!-- Inicio de Producto -->
     <c:import url="/ProductLoad" /> 
        <%  //Llama los productos
            ArrayList<Producto> productos =(ArrayList<Producto>) session.getAttribute("productsLista"); 
            //session.setAttribute("productos", productos);
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
  </div>     <!-- //cambia-->
  
  <script type="text/javascript">
    
   /* 
    function myFunction(idClickeado){
        console.log(idClickeado);
       document.getElementById("idCurrent").value = idClickeado;
       //console.log(document.getElementById("idCurrent").value);
       //document.getElementById("productBuyOcult").submit();
        $.ajax({
                    type: "post",
                    url: "ProductLoad", //this is my servlet
                    data: {idCurrent:idClickeado},
                    success: function(){      
                            console.log("ayyy");
                           
                         }
                });
       return true;
    }
    */
</script>


<!--
    <div id="agregarACarroModal" class="modal">
    <div class="modal-content">
      <center>
     <h4 id="productoTituloModal"></h4>
     <h5 id="productoPrecioModal">$399.99</h5>
     <img id="productoImagenModal" class="responsive-img" width="60%" src="">
      </center>
        <div class="container">
        <div class="row">
       <div class="col l1"><p>Cantidad: </p></div>
       <div class="col l2 offset-l1"><input type="number"></div>
      <div class="col l2 offset-l6"><p>Total: </p></div>
      <div class="col l2"><input type="button" class="waves-effect waves-light btn orange darken-4" value="Agregar"></div>
        </div>
        </div>
    </div>
  </div>     <!-- //cambia-->
  <!--  
    <div id="carritoModal" class="modal modal-fixed-footer">
    <div class="modal-content">
       
            <div class="divider"></div>
                <div class="section">
                     <div class="row">
                    <div class="col s6 m3 l2"><img class="responsive-img" src="http://www.evga.com/products/images/gallery/06G-P4-2790-KR_XL_4.jpg"></div>
                    <div class="col s6 m3 l2"><h5>Section 1</h5></div>
                    <div class="col s6 m3 l2"><p>Stuff</p></div>
                    <div class="col s6  m3 l2 offset-l4">
                    <p>Cantidad: </p>
                    <input type="number">
                    </div>
                     </div>
                </div>
           <div class="divider"></div>
                <div class="section">
                     <div class="row">
                    <div class="col s6 m3 l2"><img class="responsive-img" src="http://www.evga.com/products/images/gallery/06G-P4-2790-KR_XL_4.jpg"></div>
                    <div class="col s6 m3 l2"><h5>Section 1</h5></div>
                    <div class="col s6 m3 l2"><p>Stuff</p></div>
                    <div class="col s6 m3 l2 offset-l4">
                    <p>Cantidad: </p>
                    <input type="number">
                    </div>
                     </div>
                </div>
           <div class="divider"></div>
                <div class="section">
                     <div class="row">
                    <div class="col s6 m3 l2"><img class="responsive-img" src="http://www.evga.com/products/images/gallery/06G-P4-2790-KR_XL_4.jpg"></div>
                    <div class="col s6 m3 l2"><h5>Section 1</h5></div>
                    <div class="col s6 m3 l2"><p>Stuff</p></div>
                    <div class="col s6 m3 l2 offset-l4">
                    <p>Cantidad: </p>
                    <input type="number">
                    </div>
                     </div>
                </div> 
    </div>
    <div class="modal-footer">
        <div class="row">
        <input type="button" class="waves-effect waves-light btn orange darken-4" value="Comprar">
        <input type="button" class="waves-effect waves-light btn orange darken-3" value="Limpiar Carrito">
        <p>Total: </p>
  
        <!-- <a href="#!" class=" modal-action modal-close waves-effect waves-green btn-flat">Agree</a> 
    </div>
    </div>
  </div>     <!-- //cambia
    -->

         
 
  
  <div class="container">
      <div class="row">
       
   <% 
    // Carga los productos
    
   for(int i=0;i<productos.size();i++){
       
       
   %>
  
   
    <div class="col s12 m4 l3">
            <div class="card medium sticky-action" style="overflow: hidden;">
              <div class="card-image waves-effect waves-block waves-light">
                  <img class="activator responsive-img" src="<%= productos.get(i).getImagenProducto() %>">
              </div>
              <div class="card-content">
                  <p><%= productos.get(i).getNombre_producto()%></p>

                  <p class="precio"><%=productos.get(i).getPrecioProducto()%>$</p>
              </div>

              <div class="card-action">
                <!--<a href="#">Este es un enlace</a>-->
                <!--<a href="#">Este es un enlace</a> -->
            
                <form id="productBuyOcult" action="ProductLoad" method="post">
                 <input type="hidden" name="idCurrent" value="<%=i%>" id="idCurrent"/>
                  
        
                 <button class="waves-effect waves-light btn orange darken-3" type="submit" name="botonComprar">Comprar</button>
              </form>
              </div>

              <div class="card-reveal" style="display: none; transform: translateY(0px);">
                <span class="card-title grey-text text-darken-4">Descripción<i class="material-icons right">close</i></span>
                <p><%=productos.get(i).getDescripcionProducto()%></p>
              </div>
            </div>
          </div>
          <!-- Final de Producto -->
          <% }%>
      </div> <!--row -->
      </div> <!--container -->
      
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
