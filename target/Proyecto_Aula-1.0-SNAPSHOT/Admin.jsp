<%-- 
    Document   : Admin
    Created on : 1/12/2021, 05:14:03 PM
    Author     : PRIDE OTTER
--%>

<%@page import="modelo.Usuarios"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Sesión</title>
    <link rel="stylesheet" href="css/style6.css">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Fjalla+One&display=swap" rel="stylesheet">
</head>
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
<body background="https://pbs.twimg.com/media/EmlKW9MWEAE7jhc.jpg">
    <header>
        <section class="menu"><img src="https://upload.wikimedia.org/wikipedia/commons/thumb/3/3b/Metro_de_la_Ciudad_de_M%C3%A9xico_logo.svg/1200px-Metro_de_la_Ciudad_de_M%C3%A9xico_logo.svg.png"
         width="45px" height="45px">
            <a href="index.html"> Metro Seguro</a>
        </section>
    </header>
     <a href="usuarios.jsp" > <input type="button" value="Administrar Usuarios" class="btn1"></a>
    <a href="publicaciones.jsp" > <input type="button" value="Administrar Publicacion" class="btn2"></a>
    <a href="registrar2.jsp" > <input type="button" value="Registrar Administrador" class="btn3"></a>
    <a href="Estadisticas.jsp" > <input type="button" value="Estadísticas" class="btn4"></a>
    
</body>
<%}%>
</html>
