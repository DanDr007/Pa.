<%-- 
    Document   : sesion
    Created on : 18/11/2021, 11:26:37 AM
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
    <link rel="stylesheet" href="css/style1.css">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Fjalla+One&display=swap" rel="stylesheet">
</head>
<%
    String usuario = "";
    HttpSession sesionusu = request.getSession(true);
    
    if(sesionusu.getAttribute("usuario")==null){
    %>
    
    
<body background="https://pbs.twimg.com/media/EmlKW9MWEAE7jhc.jpg">
    <header>
        <section class="menu"><img src="https://upload.wikimedia.org/wikipedia/commons/thumb/3/3b/Metro_de_la_Ciudad_de_M%C3%A9xico_logo.svg/1200px-Metro_de_la_Ciudad_de_M%C3%A9xico_logo.svg.png"
         width="45px" height="45px">
            <a href="index.html"> Metro Seguro</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="Aviso.html" class="ingresar">Aviso de privacidad</a>
           
        </section>
    </header>
    <a href="iniciar.html" > <input type="button" value="Iniciar sesión" class="btn1"></a>
    <a href="registrar.html" > <input type="button" value="Registrar cuenta" class="btn2"></a>
    
</body>
    
    <%
    }else{
        Usuarios hola = (Usuarios)sesionusu.getAttribute("usuario");
       

    %>
<body background="https://pbs.twimg.com/media/EmlKW9MWEAE7jhc.jpg">
    <header>
        <section class="menu"><img src="https://upload.wikimedia.org/wikipedia/commons/thumb/3/3b/Metro_de_la_Ciudad_de_M%C3%A9xico_logo.svg/1200px-Metro_de_la_Ciudad_de_M%C3%A9xico_logo.svg.png"
         width="45px" height="45px">
            <a href="index.html"> Metro Seguro</a>
        </section>
    </header>
    <%if(hola.getRol()==1){
      %>  <a href="Admin.jsp" > <input type="button" value="Administrar" class="btn1"></a><%
    }%>
    
     <form name="formulario" method="post" action = "Cerrar">
         <input type="submit" value="Cerrar Sesión" class="btn2"> 
     </form>    
    
</body>
<%}%>
</html>
