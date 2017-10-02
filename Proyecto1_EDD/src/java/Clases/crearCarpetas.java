
package Clases;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class crearCarpetas extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
           
           Conexion.globalCarpeta = "";//limpiar la variable del nombre de la Carpeta
            
           String nombre = request.getParameter("nombreCarpeta");
           String id = obtenerCodigoNombreCarpeta(nombre);
           
           System.out.println("Valores para mandar par crear carpeta: "+Conexion.globalUsuario+" "+Conexion.globalContra+" "+nombre+" "+id);
           Conexion con1 =  new Conexion();
           
           //Conexion.globalCarpeta = request.getParameter("nombreCarpeta"); 
           
           String mAgregarCarpeta = con1.metodoCrearCarpeta(Conexion.globalUsuario, Conexion.globalContra, nombre, id);
           
           String RespuestaCarpetasArbolB = con1.RecuperarCarpeta(Conexion.globalUsuario, Conexion.globalContra);
           String carpetas = RespuestaCarpetasArbolB;
           String [] cargar_datos;
            
           cargar_datos = carpetas.split("@");
           String valor ="";
            
            for(int x=0; x<cargar_datos.length; x++)
            {   
                valor += "<form action=\"SeleccionarCarpeta\" class=\"form-signin\">"
                        + "<button class=\"btn btn-lg btn-link\" type=\"submit\" name=\"nombreCarpetaSeleccionado\" value=\""+cargar_datos[x]+"\">"+cargar_datos[x]+"</button>"
                        + "</form>";
            }
            request.setAttribute("carpetas", valor);
            request.getRequestDispatcher("cargaDeArchivos.jsp").forward(request, response);
           
            //System.out.println("nombre de Carpeta"+ Conexion.globalCarpeta);
        }
    }
    
    public String obtenerCodigoNombreCarpeta(String nombre) {
       String codigoNombreCarpeta = "";
       String numero = "";
       int posicion = 0;
       int codigoAscii;
       
       for(posicion = 0; posicion < nombre.length(); posicion++){
           codigoAscii = nombre.charAt(posicion);
           numero = Integer.toString(codigoAscii);
           codigoNombreCarpeta = codigoNombreCarpeta + numero;
       }
    return codigoNombreCarpeta;//To change body of generated methods, choose Tools | Templates.
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
