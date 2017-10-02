<%-- 
    Document   : inicio
    Created on : 08-sep-2017, 11:48:14
    Author     : USuario1
--%>

<%@page import="Clases.Conexion"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Archivos</title>
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

    <!-- Aqui esta el form para cargar Archivos, es el div de arriba  -->
    <!-- -->
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div>
        <h1>Carga de Archivos</h1>
        
        <!-- For llama cargarArchivos -->
        <form action="cargarArchivos" method="POST" enctype="multipart/form-data">
            <table>
                <tr>
                    <th align="center">  </th>
                    <input style="color: black" type="file" name="file" class="btn btn-default">
                </tr>
                <tr>
                    <th align="center">  </th>
                    <input style="color: black" type="submit" value="Subir Archivo" class="btn btn-default">
                </tr>
                <tr>
                    
                </tr>
            </table>
        </form>
        <br>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      
    </div>
  </div>
</nav>
  
    <!-- Aqui esta el form para crear Carpeta, div de la izquierda  -->
<div class="container-fluid text-center">    
  <div class="row content">
    <div class="col-sm-2 sidenav">
        <h2>Crear Carpeta</h2>
        
        <!-- For llama crearCarpetas -->
        <form action="crearCarpetas" method="POST">
            <table >
                <tr>
                    <th align="right">  </th>
                    <td> </td>        
                </tr> 
                <br>
                
            <tr>
                <th align="right">  </th>
                <td><input type="text" name="nombreCarpeta" placeholder="Nombre de Carpeta" required=""></td>
            </tr>
            
            <tr>
                <td colspan="2" align="left"><input type="submit" value="Crear Carpeta" class="btn btn-info"></td>
            </tr>
            </table>
        </form>
        <br><br>
        
        
        <form action="cargarCarpetas" method="POST">
            <table align="left">
            <tr>
                <td colspan="2" align="left"><input type="submit" value="Cargar Archivos" class="btn btn-info"></td>
            </tr>
        </table>
        </form> 
        
    </div>
      
    <div class="col-sm-4 text-left"> 
        <br><center><h2>Carpetas </h2></center>
      
      <hr>
         <%if(null != request.getAttribute("carpetas"))
            {
                out.print(request.getAttribute("carpetas"));
            }
         %>
      <hr>
      <br>
    </div>
    <div class="col-sm-6 sidenav">
        <h2>Archivos</h2>
        
        <!-- aqui se va a mostra los valores de los archivos creados en carpeta seleccionada -->
        <%if(null != request.getAttribute("Archivos"))
            {
                out.print(request.getAttribute("Archivos"));
            }
         %>
        
    </div>
  </div>
  
</div>

<footer class="container-fluid text-center">
  <p>USAC Drive, EDD FIUSAC</p>
  <p>Usuario: <%= Conexion.globalUsuario %></p>
</footer>
</body>
</html>
