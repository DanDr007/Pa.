<%-- 
    Document   : crearpubli
    Created on : 17/11/2021, 12:15:10 AM
    Author     : PRIDE OTTER
--%>

<%@page import="modelo.Usuarios"%>
<%@page import="modelo.Mes"%>
<%@page import="modelo.inseguridad"%>
<%@page import="modelo.Horario"%>
<%@page import="modelo.Parada"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8" session="true" %>
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
       

    %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/style.css">
    <script type="text/javascript" src="./codigo.js"></script>
    <title>Crear Publicacion</title>
    <link rel="stylesheet" href="css/style5.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Fjalla+One&display=swap" rel="stylesheet">
</head>
<body bgcolor="FF380D">
    
   

	
<header>
        <section class="menu">
        
            <img src="https://upload.wikimedia.org/wikipedia/commons/thumb/3/3b/Metro_de_la_Ciudad_de_M%C3%A9xico_logo.svg/1200px-Metro_de_la_Ciudad_de_M%C3%A9xico_logo.svg.png"
            width="45px" height="45px">
                <a href="index.html"> Metro Seguro</a>
                <a href="sesion.jsp" class="ingresar">Ingresar</a>
        </section>
    </header>
    <div class="container" >
<h1 align="center" style="color:#ffffff"> Crear la publicacion </h1>
<hr>
<br>

<form name="formulario" method="get" action="Publicar" onsubmit="return validar()">
    
    
<h1 align="left" style="color:#ffffff"> Tipo de Altercado:
        <select name="Inseguridad">
            <% 
                String hola = request.getParameter("id");
                int id = Integer.parseInt(hola);
                sesionusu.setAttribute("linea", id);
                List<inseguridad> lista = inseguridad.buscarAllIns();
                if(hola==null){
                 id=1;
                } 
                for(inseguridad e : lista){
                    
                    %>
                    
                      <option value ="<%=e.getId()%>"><%=e.getNombre()%></option>   
 
                      
                    <%
                
                }
                
                %>
                </select>
      </h1>
      
      
      <h1 style="color:#ffffff" align="right">Mes del acontencimiento:   <select name="mes">
            <% 
                List<Mes> lista4 = Mes.buscarAllMes();
                
                for(Mes e : lista4){
                    
                    %>
                    
                      <option value ="<%=e.getId()%>"><%=e.getNombre()%></option>   
 
                      
                    <%
                
                }
                
                %>
                </select></h1>
	
    

<h1 style="color:#ffffff"  align="left"> Estacion:
    <select name="Estacion">
            <% 
                List<Parada> lista2 = Parada.buscarAllParbyLin(id);
                
                for(Parada e : lista2){
                    
                    %>
                    
                      <option value ="<%=e.getId()%>"><%=e.getNom_est()%></option>   
 
                      
                    <%
                
                }
                
                %>
           
            </select>
  </h1>
<h1 align="right" style="color:#ffffff" >Horario: <select name="Horario">
            <% 
                List<Horario> lista3 = Horario.buscarAllhrs();
                
                for(Horario e : lista3){
                    
                    %>
                    
                      <option value ="<%=e.getId()%>"><%=e.getNombre()%> (<%=e.getNombrehrs()%>)</option>   
 
                      
                    <%
                
                }
                
                %>
           
            </select></h1>
            <br>
            <br>
        <h1 align="center" style="color:#ffffff">Describe tu opinion</h1>
	<p align="center"><textarea name="textarea" rows="10" cols="50" id="texto" placeholder="Ingresa tu mensaje..."></textarea>
	
        <p class="btn"><a align="left" href="linea<%=id%>.jsp"><img src="regresar.PNG" width="190" height="80"></a><input align="right" type="image" src="boton1.PNG" alt="submit" width="190" height="80" onclick="return validar()" /></p>
	</form>
             </div>   
</body>
</html>
<%}%>