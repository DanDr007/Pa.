<%-- 
    Document   : resenaB
    Created on : 20/11/2021, 04:21:44 PM
    Author     : PRIDE OTTER
--%>

<%@page import="modelo.Resena"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@page import="modelo.calificacion"%>
<%@page import="modelo.Usuarios"%>
<%@page import="modelo.publicacion"%>
<%@page import="java.util.List"%>

<!DOCTYPE html>

<%
    String usuario = "";
    HttpSession sesionusu = request.getSession(true);
    
    
    
    
        Usuarios hola2 = (Usuarios)sesionusu.getAttribute("usuario");
       int id = 12;
 List lista = publicacion.buscarAllPublicacionesByLinea(id);
    %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Línea B</title>
    <link rel="stylesheet" href="css/style4.css">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Fjalla+One&display=swap" rel="stylesheet">
</head>
<body background="linea<%=id%>.png">
    <header>
        <section class="menu">
        
            <img src="https://upload.wikimedia.org/wikipedia/commons/thumb/3/3b/Metro_de_la_Ciudad_de_M%C3%A9xico_logo.svg/1200px-Metro_de_la_Ciudad_de_M%C3%A9xico_logo.svg.png"
            width="45px" height="45px">
                <a href="index.html"> Metro Seguro</a>
                <a href="sesion.jsp" class="ingresar">Ingresar</a>
        </section>
    </header>
    <div class="container">
        <br>
        <br>
        <h1>Línea B</h1>
        <h2>Calificación general: <%=Resena.buscarAllResByIdLin(id)%>/5</h2>
        <br>
        <br>
        <%  String mensaje = "";
    if(lista.size()>= 20){
    mensaje = " (Son demasiados, evite pasar por esta línea)";
}
if(lista.size() >= 10||lista.size() < 20){
    mensaje = " (Se encuentra en el promedio de reportes, tome precauciones al tomar esta línea)";
}
if(lista.size() <= 10){
    mensaje = " (Esta línea es segura, no necesita tomar muchas precauciones)";
}%>
        <p>Reportes de inseguridad en la línea:<%=lista.size()+ mensaje%></p>
        <br>
        <br>
        <article>
             <% 
                List<publicacion> lista3 = publicacion.buscarAllRepeticiones(id);
                
                List<publicacion> lista2 = publicacion.buscarAllRepeticiones2(id);
                
                for(publicacion e : lista3){
        String cantidad ="";  
        String cantidad2 = "";
  if(e.getRepeticiones()>= 10){
     cantidad = "Tiene demasiados casos de ";
     cantidad2 = " (Más de 10 en total), trate de evitar esta línea";
  }
  
  if(e.getRepeticiones() > 5||e.getRepeticiones() < 10){
     cantidad = "Tiene abundantes casos de ";
     cantidad2 = " (Entre 10 y 20 en total), se puede considerar más inseguro de lo normal";
  }
  if(e.getRepeticiones() <= 5 ){
     cantidad = "Tiene pocos casos de: ";
     cantidad2 = " (Menos de 10 casos) Es preocupante, pero se encuentra dentro del promedio";
  }
                    %>
            <p><%=cantidad + e.getNom_ins()%></p>
            
            <%}%>
        </article>
        <aside>
            <%if (lista2.size()<1){
            
        }else{
            %><p>Evite pasar por esta línea en la <%=lista2.get(0).getNom_ins()%></p><%
}%>
            
            
        </aside>
        <br>
        <br>
        <br>
        <%if (lista3.size()<1){
            
        }else{
            %><h1>La línea destaca por: <%=lista3.get(0).getNom_ins()%></h1><%
}%>
<br>
<br>
<br>
<br>
<br>
<h1>Inicia sesión para calificar la línea</h1>
<%
    
       if(hola2==null){
           %>

            <%
       }
       else{
           
       
    %>
        <form name="formulario" method="post" action="Resenas">
        <br>
        <input type="hidden" value="<%=id%>" class="publicar" name="idlin">
        <p>Califique su experiencia en la línea del 1 al 5: <select name="calificacion">
            <option value="1">1</option>
            <option value="2">2</option>
            <option value="3">3</option>
            <option value="4">4</option>
            <option value="5">5</option>
              
            </select></p>
            <input type="submit" class="publicar" value="Reseñar">
        </form>
        <%}%>
    </div>
</body>
</html>