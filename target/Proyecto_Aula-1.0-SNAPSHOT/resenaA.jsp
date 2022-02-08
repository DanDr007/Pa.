<%-- 
    Document   : resenaA
    Created on : 20/11/2021, 03:55:54 PM
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
       int id = 11;
 List lista = publicacion.buscarAllPublicacionesByLinea(id);
    %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Línea a</title>
    <link rel="stylesheet" href="css/style4.css">
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
        <h1>Línea A</h1>
        <h2>Calificación general: <%=Resena.buscarAllResByIdLin(id)%>/5</h2>
        <br>
        <br>
        <p>Reportes de inseguridad en la línea:<%=lista.size()%></p>
        <br>
        <br>
        <article>
             <% 
                List<publicacion> lista3 = publicacion.buscarAllRepeticiones(id);
                
                List<publicacion> lista2 = publicacion.buscarAllRepeticiones2(id);
                
                for(publicacion e : lista3){
  
                    %>
            <p><%=e.getNom_ins()%>: <%=e.getRepeticiones()%></p>
            
            <%}%>
        </article>
        <aside>
            <%if (lista2.size()<1){
            
        }else{
            %><p>Horario más inseguro:La <%=lista2.get(0).getNom_ins()%></p><%
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
        <p>Califique la seguridad de la línea del 1 al 5: <select name="calificacion">
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
