<%-- 
    Document   : gestionar2
    Created on : 18/11/2021, 11:27:59 PM
    Author     : PRIDE OTTER
--%>

<%@page import="modelo.Usuarios"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%
    String usuario = "";
    HttpSession sesionusu = request.getSession(true);
    String hola2 = request.getParameter("id1");
    String hola3 = request.getParameter("id2");
     System.out.println(hola2);
     System.out.println(hola3);
    if(sesionusu.getAttribute("usuario")==null || hola2==null || hola3==null){
    %>
    
    <jsp:forward page="index.html">
        <jsp:param name="Error" value="Es obligatorio identificarse" />
    </jsp:forward>
    
    <%
    }else{
        Usuarios hola = (Usuarios)sesionusu.getAttribute("usuario");
       

    %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Gestionar Publicación</title>
    <link rel="stylesheet" href="css/style1.css">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Fjalla+One&display=swap" rel="stylesheet">
</head>
<body background="https://pbs.twimg.com/media/EmlKW9MWEAE7jhc.jpg">
    <header>
        <section class="menu"><img src="https://upload.wikimedia.org/wikipedia/commons/thumb/3/3b/Metro_de_la_Ciudad_de_M%C3%A9xico_logo.svg/1200px-Metro_de_la_Ciudad_de_M%C3%A9xico_logo.svg.png"
         width="45px" height="45px">
            <a href="index.html"> Metro Seguro</a>
        </section>
    </header>
    <a href="editarpubli.jsp?id1=<%=hola2%>&id2=<%=hola3%>"> <input type="button" value="Editar Publicación" class="btn1"></a>
    <form name="formulario" method="post" action = "BorrarPub"> <input type="submit" value="Borrar Publicación" class="btn2"> <input type="hidden" value="<%=hola2%>" name="pub" class="btn2"></form>
</body>
</html>
<%}%>
