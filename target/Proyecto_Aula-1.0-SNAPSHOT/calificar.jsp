<%-- 
    Document   : calificar
    Created on : 19/11/2021, 10:45:07 AM
    Author     : PRIDE OTTER
--%>

<%@page import="modelo.calificacion"%>
<%@page import="modelo.Usuarios"%>
<%@page import="modelo.publicacion"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String usuario = "";
    HttpSession sesionusu = request.getSession(true);
    String hola2 = request.getParameter("id1");
    
    System.out.println(hola2);
    
    if(sesionusu.getAttribute("usuario")==null || hola2==null ){
    %>
    
    <jsp:forward page="index.html">
        <jsp:param name="Error" value="Es obligatorio identificarse" />
    </jsp:forward>
    
    <%
    }else{
        Usuarios hola = (Usuarios)sesionusu.getAttribute("usuario");
       
int hola3 = Integer.parseInt(hola2);
    %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Calificación</title>
    <link rel="stylesheet" href="css/style3.css">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Fjalla+One&display=swap" rel="stylesheet">
    <script type="text/javascript" src="./codigo.js"></script>
    <link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Fjalla+One&display=swap" rel="stylesheet">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Fjalla+One&family=Poppins:wght@100&display=swap" rel="stylesheet">
</head>
<body bgcolor="FF380D">
    <header>
        <section class="menu"><img src="https://upload.wikimedia.org/wikipedia/commons/thumb/3/3b/Metro_de_la_Ciudad_de_M%C3%A9xico_logo.svg/1200px-Metro_de_la_Ciudad_de_M%C3%A9xico_logo.svg.png"
        width="45px" height="45px">
            <a href="index.html" style="font-family: Fjalla One;"> Metro Seguro</a>
            
        </section>
    </header>
    <div class="container">
        <p style="font-family: Fjalla One;">Califica esta publicación en base a su utilidad</p>
        <br>
        <br>
        <table border=0 bordercolor=white align=center width=1400 cellpadding=8 cellspacing=2 background="blanco.jpg" height="200">
        <tr>
        <td>
        <font size=4 class= "letra">
            
               <% 
                publicacion e = publicacion.buscarPublicacionById(hola3);
               float promedio = 0;
                    promedio = calificacion.buscarAllCalByIdpub(e.getId());
                
                    %>
                <hr>
       <p text align=left style="color:black">Usuario: <%=e.getNom_usu()%>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%=e.getNom_est()%>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%=e.getNom_mes()%> <%=e.getNum_ano()%></align></p>                  
        <br>
        <br>
        <p text align=center style="color:black"><%=e.getContenido()%></p>
        <br>
        <br>
        <p text align=left style="color:black">Problema: <%=e.getNom_ins()%>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Utilidad: <%=promedio%>/5&nbsp;&nbsp;&nbsp;
              
    <hr>
        </td>
        </tr>
        </table>
<br>
<br>
        <p style="font-family: Fjalla One;">Califica la utilidad de esta publicación del 1 al 5</p>
        
        <p style="font-family: Poppins">0: Debería ser borrada esta publicación</p>
        <p style="font-family: Poppins">5: Esta publicación no es útil ni inútil</p>
        <br>
<form name="formulario" method="post" action="Calificar" onsubmit="return validar4()">
        
        <input type="number" class="cal" id="cal" name="cal" placeholder="Ingrese su calificacion...">
        <br>
        <br> <input type="hidden" value="<%=hola2%>" class="publicar" name="idpub">
        
        <br>
        <input type="submit" class="publicar" value="Calificar" onclick="return validar4()">
</form>
<a href="index.html"><input type="button" class="cancelar" value="Cancelar"></a>

    </div>
</body>
</html>
<%}%>