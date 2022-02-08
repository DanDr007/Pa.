<%-- 
    Document   : editarpubli
    Created on : 17/11/2021, 06:55:32 PM
    Author     : PRIDE OTTER
--%>

<%@page import="modelo.Usuarios"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@page import="modelo.Mes"%>
<%@page import="modelo.inseguridad"%>
<%@page import="modelo.Horario"%>
<%@page import="modelo.Parada"%>
<%@page import="java.util.List"%>
<%
    String usuario = "";
    HttpSession sesionusu = request.getSession(true);
    String hola2 = request.getParameter("id1");
    String hola3 = request.getParameter("id2");
    
    
    if(sesionusu.getAttribute("usuario")==null || hola2==null || hola3==null){
    %>
    
    <jsp:forward page="index.html">
        <jsp:param name="Error" value="Es obligatorio identificarse" />
    </jsp:forward>
    
    <%
    }else{
        Usuarios hola = (Usuarios)sesionusu.getAttribute("usuario");
       

    %>
<!DOCTYPE html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/style.css">
    <script type="text/javascript" src="./codigo.js"></script>
    <link rel="stylesheet" href="css/style5.css">
    <title>Editar Publicacion</title>
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
	 <area target="_blank" alt="INGRESAR" title="INGRESAR" href="ingresar.html" coords="1618,2,1903,116" shape="rect">
</map>
<p>
    <div class="container" >
<h1 align="center" style="color:#ffffff"> Editar la publicación </h1>

<hr>
<br>

<form name="formulario" method="post" action="ActPub" onsubmit="return validar()">
    
    <h1 align="center" style="color:#ffffff">Id <%=hola2%> <input type="hidden" name="id" value="<%=hola2%>"></h1>

<h1 align="left" style="color:#ffffff"> Tipo de Altercado:
        <select name="Inseguridad">
            <% 
                List<inseguridad> lista = inseguridad.buscarAllIns();
                
                for(inseguridad e : lista){
                    
                    %>
                    
                      <option value ="<%=e.getId()%>"><%=e.getNombre()%></option>   
 
                      
                    <%
                
                }
                
                %>
                </select>
      </h1>
      
      <p>
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
	
        

<h1 align="left" style="color:#ffffff"> Estacion:
    <select name="Estacion">
            <% 
                int linea = Integer.parseInt(hola3);
                List<Parada> lista2 = Parada.buscarAllParbyLin(linea);
                sesionusu.setAttribute("linea", linea);
                for(Parada e : lista2){
                    
                    %>
                    
                      <option value ="<%=e.getId()%>"><%=e.getNom_est()%></option>   
 
                      
                    <%
                
                }
                
                %>
           
            </select>
  </h1>
<h1 align="right" style="color:#ffffff">Horario: <select name="Horario">
            <% 
                List<Horario> lista3 = Horario. buscarAllhrs();
                
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
	</div>
        <p class="btn"><a align="left" href="index.html"><img src="regresar.PNG" width="190" height="80"></a><input align="right" type="image" src="boton1.PNG" alt="submit" width="190" height="80" onclick="return validar()" /></p>
        
   

	</form>
                
</body>
</html>
<%}%>