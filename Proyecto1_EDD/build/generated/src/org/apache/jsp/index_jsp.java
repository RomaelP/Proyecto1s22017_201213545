package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("<head>\n");
      out.write("  <title>USAC Drive</title>\n");
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
      out.write("<nav class=\"navbar navbar-inverse\">\n");
      out.write("  <div class=\"container-fluid\">\n");
      out.write("    <div class=\"navbar-header\">\n");
      out.write("      <button type=\"button\" class=\"navbar-toggle\" data-toggle=\"collapse\" data-target=\"#myNavbar\">\n");
      out.write("        <span class=\"icon-bar\"></span>\n");
      out.write("        <span class=\"icon-bar\"></span>\n");
      out.write("        <span class=\"icon-bar\"></span>                        \n");
      out.write("      </button>\n");
      out.write("      <a class=\"navbar-brand\" href=\"\">Logo</a>\n");
      out.write("    </div>\n");
      out.write("    <div class=\"collapse navbar-collapse\" id=\"myNavbar\">\n");
      out.write("      <ul class=\"nav navbar-nav\">\n");
      out.write("        <li class=\"active\"><a href=\"\">Agregar Usuario</a></li>\n");
      out.write("        <li><a href=\"#\">Contacto</a></li>\n");
      out.write("      </ul>\n");
      out.write("    </div>\n");
      out.write("  </div>\n");
      out.write("</nav>\n");
      out.write("  \n");
      out.write("<div class=\"container-fluid text-center\">    \n");
      out.write("  <div class=\"row content\">\n");
      out.write("    <div class=\"col-sm-3 sidenav\">\n");
      out.write("        <h3>Agregar Nuevo</h3>\n");
      out.write("        <h3>   Usuario   </h3>\n");
      out.write("        <br>\n");
      out.write("        <form action=\"registrar\" method=\"POST\">\n");
      out.write("            <table align=\"center\">\n");
      out.write("            <tr>\n");
      out.write("                <th align=\"right\">     </th>\n");
      out.write("                <td><input type=\"text\" name=\"usuario\" placeholder=\"Nombre de Usuario\" required=\"\"></td>\n");
      out.write("            </tr>\n");
      out.write("            <tr>\n");
      out.write("                <th align=\"right\">  </th>\n");
      out.write("                <td><input type=\"password\" name=\"contra\" placeholder=\"Contraseña\" required=\"\"></td>\n");
      out.write("            </tr>\n");
      out.write("            <tr>\n");
      out.write("                <td colspan=\"2\" align=\"left\"><input type=\"submit\" value=\"Agregar\" class=\"btn btn-primary\"></td>\n");
      out.write("            </tr>\n");
      out.write("        </table>\n");
      out.write("        </form>    \n");
      out.write("        <h3 style=\"color: #2D3B55; text-align: center\">");

                        if(null!= request.getAttribute("informaMessage"))
                        {
                            out.print(request.getAttribute("informaMessage"));
                        }
                        
      out.write("</h3>\n");
      out.write("    </div>\n");
      out.write("      \n");
      out.write("    <div class=\"col-sm-7 text-left\"> \n");
      out.write("      <h1>USAC Drive</h1>\n");
      out.write("      <center><h2>Login</h2></center>\n");
      out.write("      <br>\n");
      out.write("      <form action=\"Login\" method=\"POST\">\n");
      out.write("          <table align=\"center\">\n");
      out.write("            <tr>\n");
      out.write("                <th align=\"right\">     </th>\n");
      out.write("                <td><input type=\"text\" name=\"usuario\" placeholder=\"Nombre de Usuario\" required=\"\"></td>\n");
      out.write("            </tr>\n");
      out.write("            <tr>\n");
      out.write("                <th align=\"right\">  </th>\n");
      out.write("                <td><input type=\"password\" name=\"contra\" placeholder=\"Contraseña\" required=\"\"></td>\n");
      out.write("            </tr>\n");
      out.write("            <tr>\n");
      out.write("                <td colspan=\"2\" align=\"left\"><input type=\"submit\" value=\"Enviar\" class=\"btn btn-primary\"></td>\n");
      out.write("            </tr>\n");
      out.write("        </table>\n");
      out.write("      </form>\n");
      out.write("      <br>\n");
      out.write("      <hr>\n");
      out.write("      <br>\n");
      out.write("      <h3 style=\"color: #2D3B55; text-align: center\">");

                        if(null!= request.getAttribute("errorMessage"))
                        {
                            out.print(request.getAttribute("errorMessage"));
                        }
                        
      out.write("</h3>\n");
      out.write("      <br>\n");
      out.write("      <hr>\n");
      out.write("    </div>\n");
      out.write("    <div class=\"col-sm-2 sidenav\">\n");
      out.write("     <!aqui se puede agregar a la columna de la derecha componentes!>\n");
      out.write("    </div>\n");
      out.write("  </div>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("<footer class=\"container-fluid text-center\">\n");
      out.write("  <p>USAC Drive, EDD FIUSAC</p>\n");
      out.write("</footer>\n");
      out.write("</body>\n");
      out.write("</html>");
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
