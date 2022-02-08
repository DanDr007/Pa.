<%-- 
    Document   : registrar2
    Created on : 2/12/2021, 01:47:34 PM
    Author     : PRIDE OTTER
--%>

<%@page import="modelo.Usuarios"%>
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
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Editar Cuenta</title>
    <link rel="stylesheet" href="css/style2.css">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Fjalla+One&display=swap" rel="stylesheet">
    <script type="text/javascript" src="./codigo.js"></script>
</head>
<body bgcolor="FF380D">
    <header>
        <section class="menu"><img src="https://upload.wikimedia.org/wikipedia/commons/thumb/3/3b/Metro_de_la_Ciudad_de_M%C3%A9xico_logo.svg/1200px-Metro_de_la_Ciudad_de_M%C3%A9xico_logo.svg.png"
        width="45px" height="45px">
            <a > Registrar Admin</a>
            <a href="Admin.jsp" class="ingresar">Regresar</a>
        </section>
    </header>
    <div class="iniciar">
        <form name="formulario" method="post" onsubmit="return validar3()" action = "Registrar2">
        <p class="tit">Registra una cuenta</p>
        <hr>
        <br>
        <br>
        <p class="text2">Correo:  <input type="text" class="pass" name="cor" id="cor"></p>
        <br>
        <br>
        <p class="text1">Usuario:  <input type="text" class="usu" name="usuario" id="usuario"></p>
        <br>
        <br>
        <p class="text2">Contraseña:  <input type="text" class="pass" name="con" id="con"></p>
        <br>
        <br>
        <br>
        <input type="submit" class="acceder" value="Registrar">
        </form>
    </div>
</body>
</html>
<%}%>