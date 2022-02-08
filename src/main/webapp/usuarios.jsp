<%-- 
    Document   : usuarios
    Created on : 2/12/2021, 12:04:45 AM
    Author     : PRIDE OTTER
--%>
<%@page import="modelo.calificacion"%>
<%@page import="modelo.Usuarios"%>
<%@page import="modelo.publicacion"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
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
        <h1 align="center" style="color:#ffffff"> Administrar usuarios </h1>
<hr>
<br>
    <div id="main-container">
    <table >
        <thead>
                <tr>
                    <th>ID</th>
                    <th>Nombre</th>
                   
                    <th>Email</th>
                    <th>Rol</th>
                    
                    <th></th>
                </tr>
            </thead>
            <tbody>
                <% 
                List<Usuarios> lista = Usuarios.buscarAllEmpleados();
                String rol = "";
                for(Usuarios e : lista){
                    if (e.getRol()==1){
                        rol = "administrador";
                    }
                    else{
                        rol = "usuario";
                    }
                    %>
                    <tr>
                        <td> <%=e.getId()%> </td>
                        <td> <%=e.getNombre()%> </td>
                        
                        <td> <%=e.getEmail()%> </td>
                        <td> <%=rol%> </td>
                        
                        <td> <a href="BorrarCuen2?id=<%=e.getId()%>" style="color:blue" >Borrar</a> </td>
                    </tr>    
                    <%
                
                }
}
                %>
                
            </tbody>
        </table>
    </div>
    </div>
    </body>
</html>
