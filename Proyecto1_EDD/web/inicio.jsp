<%-- 
    Document   : inicio
    Created on : 08-sep-2017, 11:48:14
    Author     : USuario1
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Inicio USAC Drive</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="css/nuevoCSS.css">
  <style>
    /* Remove the navbar's default margin-bottom and rounded borders */ 
    .navbar {
      margin-bottom: 0;
      border-radius: 0;
    }
    
    /* Set height of the grid so .sidenav can be 100% (adjust as needed) */
    .row.content {height: 450px}
    
    /* Set gray background color and 100% height */
    .sidenav {
      padding-top: 20px;
      background-color: #f1f1f1;
      height: 100%;
    }
    
    /* Set black background color, white text and some padding */
    footer {
      background-color: #555;
      color: white;
      padding: 15px;
    }
    
    /* On small screens, set height to 'auto' for sidenav and grid */
    @media screen and (max-width: 767px) {
      .sidenav {
        height: auto;
        padding: 15px;
      }
      .row.content {height:auto;} 
    }
  </style>
</head>
<body>

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div>
      <h1 > Bienvenido: <%=request.getAttribute("usuario")%></h1>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      
    </div>
  </div>
</nav>
  
<div class="container-fluid text-center">    
  <div class="row content">
    <div class="col-sm-2 sidenav">
        <h2>MENU</h2>
        <br>
        <form action="cargaDeArchivos.jsp" method="GET">
            <table align="left">
            <tr>
                <th align="left">     </th>
                <td><input type="submit" value ="Cargar Archivo" class="btn btn-block" ></td>
            </tr>    
        </table>
        </form>  
        <hr>
        <br>
        <form action="descargarArchivo.jsp" method="GET">
             <table align="left">
                <tr>
                    <th align="left">     </th>
                    <td><input type="submit" value ="Descargar Archivo" class="btn btn-block" ></td>
                </tr>    
            </table>   
        </form>
    </div>
      
    <div class="col-sm-9 text-left"> 
      <h1> Bienvenido: <%=request.getAttribute("usuario")%></h1>  
      <hr>
            <h3>Aqui se van a mostrar las carpetas y todo</h3>
             
            
      <br><br>
      <hr>
    </div>
    <div class="col-sm-1 sidenav">
     <!aqui se puede agregar a la columna de la derecha componentes!>
    </div>
  </div>
</div>

<footer class="container-fluid text-center">
  <p>USAC Drive, EDD FIUSAC</p>
</footer>
</body>
</html>
