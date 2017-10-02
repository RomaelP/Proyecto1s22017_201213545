
package Clases;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class cargarCarpetas extends HttpServlet {

  
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String usuario = Conexion.globalUsuario;
            String contra = Conexion.globalContra;
            String carpetas = "";
            String [] cargar_datos;
            
            Conexion.globalCarpeta = "";
            
            Conexion conexion = new Conexion();
            String nombreArchivo = request.getParameter("nombreCarpeta");
            carpetas = conexion.cargarNombresCarpetas(usuario,contra);	//Llaman al metodo que les va a devolver los nombres de las carpetas

            cargar_datos = carpetas.split("@");
            String valor ="";

            
            /*for(int x=0; x<cargar_datos.length; x++)
            {   //<form action="Login" class="form-signin"> </form>
                valor += "<form action=\"ServletCarpetas\" class=\"form-signin\">"
                        + "<button class=\"btn btn-lg btn-primary btn-block\" type=\"submit\" name=\"nombreCarpetaSeleccionado\" value=\""+cargar_datos[x]+"\">"+cargar_datos[x]+"</button>"
                        + "</form>";
            }*/
            
            request.setAttribute("carpetas", nombreArchivo);
            request.getRequestDispatcher("cargaDeArchivos.jsp").forward(request, response);
            
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
