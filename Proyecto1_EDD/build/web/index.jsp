<!DOCTYPE html>
<html lang="en">
<head>
  <title>USAC Drive</title>
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
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
      <a class="navbar-brand" href="">Logo</a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
        <li class="active"><a href="">Agregar Usuario</a></li>
        <li><a href="#">Contacto</a></li>
      </ul>
    </div>
  </div>
</nav>
  
<div class="container-fluid text-center">    
  <div class="row content">
    <div class="col-sm-3 sidenav">
        <h3>Agregar Nuevo</h3>
        <h3>   Usuario   </h3>
        <br>
        <form action="registrar" method="POST">
            <table align="center">
            <tr>
                <th align="right">     </th>
                <td><input type="text" name="usuario" placeholder="Nombre de Usuario" required=""></td>
            </tr>
            <tr>
                <th align="right">  </th>
                <td><input type="password" name="contra" placeholder="Contraseña" required=""></td>
            </tr>
            <tr>
                <td colspan="2" align="left"><input type="submit" value="Agregar" class="btn btn-primary"></td>
            </tr>
        </table>
        </form>    
        <h3 style="color: #2D3B55; text-align: center"><%
                        if(null!= request.getAttribute("informaMessage"))
                        {
                            out.print(request.getAttribute("informaMessage"));
                        }
                        %></h3>
    </div>
      
    <div class="col-sm-7 text-left"> 
      <h1>USAC Drive</h1>
      <center><h2>Login</h2></center>
      <br>
      <form action="Login" method="POST">
          <table align="center">
            <tr>
                <th align="right">     </th>
                <td><input type="text" name="usuario" placeholder="Nombre de Usuario" required=""></td>
            </tr>
            <tr>
                <th align="right">  </th>
                <td><input type="password" name="contra" placeholder="Contraseña" required=""></td>
            </tr>
            <tr>
                <td colspan="2" align="left"><input type="submit" value="Enviar" class="btn btn-primary"></td>
            </tr>
        </table>
      </form>
      <br>
      <hr>
      <br>
      <h3 style="color: #2D3B55; text-align: center"><%
                        if(null!= request.getAttribute("errorMessage"))
                        {
                            out.print(request.getAttribute("errorMessage"));
                        }
                        %></h3>
      <br>
      <hr>
    </div>
    <div class="col-sm-2 sidenav">
     <!aqui se puede agregar a la columna de la derecha componentes!>
    </div>
  </div>
</div>

<footer class="container-fluid text-center">
  <p>USAC Drive, EDD FIUSAC</p>
</footer>
</body>
</html>