package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Clases.Conexion;

public final class cargaDeArchivos_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("<head>\n");
      out.write("  <title>Archivos</title>\n");
      out.write("  <meta charset=\"utf-8\">\n");
      out.write("  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("  <link rel=\"stylesheet\" href=\"css/nuevoCSS.css\">\n");
      out.write("  <style>\n");
      out.write("    /* Remove the navbar's default margin-bottom and rounded borders */ \n");
      out.write("    .navbar {\n");
      out.write("      margin-bottom: 0;\n");
      out.write("      border-radius: 0;\n");
      out.write("    }\n");
      out.write("    \n");
      out.write("    /* Set height of the grid so .sidenav can be 100% (adjust as needed) */\n");
      out.write("    .row.content {height: 450px}\n");
      out.write("    \n");
      out.write("    /* Set gray background color and 100% height */\n");
      out.write("    .sidenav {\n");
      out.write("      padding-top: 20px;\n");
      out.write("      background-color: #f1f1f1;\n");
      out.write("      height: 100%;\n");
      out.write("    }\n");
      out.write("    \n");
      out.write("    /* Set black background color, white text and some padding */\n");
      out.write("    footer {\n");
      out.write("      background-color: #555;\n");
      out.write("      color: white;\n");
      out.write("      padding: 15px;\n");
      out.write("    }\n");
      out.write("    \n");
      out.write("    /* On small screens, set height to 'auto' for sidenav and grid */\n");
      out.write("    @media screen and (max-width: 767px) {\n");
      out.write("      .sidenav {\n");
      out.write("        height: auto;\n");
      out.write("        padding: 15px;\n");
      out.write("      }\n");
      out.write("      .row.content {height:auto;} \n");
      out.write("    }\n");
      out.write("  </style>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("\n");
      out.write("    <!-- Aqui esta el form para cargar Archivos, es el div de arriba  -->\n");
      out.write("    <!-- -->\n");
      out.write("<nav class=\"navbar navbar-inverse\">\n");
      out.write("  <div class=\"container-fluid\">\n");
      out.write("    <div>\n");
      out.write("        <h1>Carga de Archivos</h1>\n");
      out.write("        \n");
      out.write("        <!-- For llama cargarArchivos -->\n");
      out.write("        <form action=\"cargarArchivos\" method=\"POST\" enctype=\"multipart/form-data\">\n");
      out.write("            <table>\n");
      out.write("                <tr>\n");
      out.write("                    <th align=\"center\">  </th>\n");
      out.write("                    <input style=\"color: black\" type=\"file\" name=\"file\" class=\"btn btn-default\">\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <th align=\"center\">  </th>\n");
      out.write("                    <input style=\"color: black\" type=\"submit\" value=\"Subir Archivo\" class=\"btn btn-default\">\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    \n");
      out.write("                </tr>\n");
      out.write("            </table>\n");
      out.write("        </form>\n");
      out.write("        <br>\n");
      out.write("    </div>\n");
      out.write("    <div class=\"collapse navbar-collapse\" id=\"myNavbar\">\n");
      out.write("      \n");
      out.write("    </div>\n");
      out.write("  </div>\n");
      out.write("</nav>\n");
      out.write("  \n");
      out.write("    <!-- Aqui esta el form para crear Carpeta, div de la izquierda  -->\n");
      out.write("<div class=\"container-fluid text-center\">    \n");
      out.write("  <div class=\"row content\">\n");
      out.write("    <div class=\"col-sm-2 sidenav\">\n");
      out.write("        <h2>Crear Carpeta</h2>\n");
      out.write("        \n");
      out.write("        <!-- For llama crearCarpetas -->\n");
      out.write("        <form action=\"crearCarpetas\" method=\"POST\">\n");
      out.write("            <table >\n");
      out.write("                <tr>\n");
      out.write("                    <th align=\"right\">  </th>\n");
      out.write("                    <td> </td>        \n");
      out.write("                </tr> \n");
      out.write("                <br>\n");
      out.write("                \n");
      out.write("            <tr>\n");
      out.write("                <th align=\"right\">  </th>\n");
      out.write("                <td><input type=\"text\" name=\"nombreCarpeta\" placeholder=\"Nombre de Carpeta\" required=\"\"></td>\n");
      out.write("            </tr>\n");
      out.write("            \n");
      out.write("            <tr>\n");
      out.write("                <td colspan=\"2\" align=\"left\"><input type=\"submit\" value=\"Crear Carpeta\" class=\"btn btn-info\"></td>\n");
      out.write("            </tr>\n");
      out.write("            </table>\n");
      out.write("        </form>\n");
      out.write("        <br><br>\n");
      out.write("        \n");
      out.write("        \n");
      out.write("        <form action=\"cargarCarpetas\" method=\"POST\">\n");
      out.write("            <table align=\"left\">\n");
      out.write("            <tr>\n");
      out.write("                <td colspan=\"2\" align=\"left\"><input type=\"submit\" value=\"Cargar Archivos\" class=\"btn btn-info\"></td>\n");
      out.write("            </tr>\n");
      out.write("        </table>\n");
      out.write("        </form> \n");
      out.write("        \n");
      out.write("    </div>\n");
      out.write("      \n");
      out.write("    <div class=\"col-sm-4 text-left\"> \n");
      out.write("        <br><center><h2>Carpetas </h2></center>\n");
      out.write("      \n");
      out.write("      <hr>\n");
      out.write("         ");
if(null != request.getAttribute("carpetas"))
            {
                out.print(request.getAttribute("carpetas"));
            }
         
      out.write("\n");
      out.write("      <hr>\n");
      out.write("      <br>\n");
      out.write("    </div>\n");
      out.write("    <div class=\"col-sm-6 sidenav\">\n");
      out.write("        <h2>Archivos</h2>\n");
      out.write("        \n");
      out.write("        <!-- aqui se va a mostra los valores de los archivos creados en carpeta seleccionada -->\n");
      out.write("        \n");
      out.write("    </div>\n");
      out.write("  </div>\n");
      out.write("  \n");
      out.write("</div>\n");
      out.write("\n");
      out.write("<footer class=\"container-fluid text-center\">\n");
      out.write("  <p>USAC Drive, EDD FIUSAC</p>\n");
      out.write("  <p>Usuario: ");
      out.print( Conexion.globalUsuario );
      out.write("</p>\n");
      out.write("</footer>\n");
      out.write("</body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
