<%-- 
    Document   : Estadisticas
    Created on : 4/12/2021, 05:42:56 PM
    Author     : PRIDE OTTER
--%>

<%@page import="modelo.calificacion"%>
<%@page import="modelo.Usuarios"%>
<%@page import="modelo.publicacion"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String usuario = "";
    HttpSession sesionusu = request.getSession(true);
   
    if(sesionusu.getAttribute("usuario")==null){
    %>
    
<jsp:forward page="sesion.jsp">
        <jsp:param name="Error" value="Es obligatorio identificarse" />
    </jsp:forward>
    

    
   <%
    }else{
       Usuarios hola2 = (Usuarios)sesionusu.getAttribute("usuario");
    System.out.println(hola2.getRol());
       if(hola2.getRol()==0){
%><jsp:forward page="sesion.jsp">
        <jsp:param name="Error" value="Es obligatorio identificarse" />
    </jsp:forward><%
}

    %>
<!DOCTYPE html>
<html>
    <html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/style7.css">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Fjalla+One&display=swap" rel="stylesheet">
    <title>Usuarios</title>
</head>
<body bgcolor="FF380D">
    <header>
        <section class="menu">
        
            <img src="https://upload.wikimedia.org/wikipedia/commons/thumb/3/3b/Metro_de_la_Ciudad_de_M%C3%A9xico_logo.svg/1200px-Metro_de_la_Ciudad_de_M%C3%A9xico_logo.svg.png"
            width="45px" height="45px">
               <a href="index.html"> Metro Seguro</a>
                <a href="Admin.jsp" class="ingresar">Regresar</a>
        </section>
    </header><!-- comment -->
    <br><!-- comment -->
    <br><!-- comment -->
    <br><!-- comment -->
    <br><!-- comment -->
    <br><!-- comment -->
    <br><!-- comment -->
    <div class="container">
        <h1 align="center" style="color:#ffffff"> Incidentes por mes </h1>
<hr>
<br>
    <div id="main-container">
    <table >
        <thead>
                <tr>
                    <th>Casos</th>
                    <th>Mes</th>
                   
                    <th>Incidente</th>
                    <th>Horario</th>
                    
                    
                </tr>
            </thead>
            <tbody>
                <% 
                List<publicacion> lista = publicacion.buscarAllRepeticiones3();
                
                for(publicacion e : lista){
                    
                    %>
                    <tr>
                        <td> <%=e.getRepeticiones()%> </td>
                        <td> <%=e.getNom_mes()%> </td>
                        
                        <td> <%=e.getNom_ins()%> </td>
                        <td> <%=e.getNom_hor()%> </td>
                        
                        
                    </tr>    
                    <%
                
               }
                %>
                
            </tbody>
        </table>
    </div>
    </div>
    </body>
</html>
<%}
%>