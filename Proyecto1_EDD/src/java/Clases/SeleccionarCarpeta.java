/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author USuario1
 */
public class SeleccionarCarpeta extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            Conexion.globalCarpeta = request.getParameter("nombreCarpetaSeleccionado");
            Conexion con1 =  new Conexion();
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
            String idCarpeta = Conexion.obtenerCodigoNombreCarpeta(Conexion.globalCarpeta);
            Conexion con2 = new Conexion();
            String archivos = con2.recuperarArchivos(Conexion.globalUsuario, Conexion.globalContra, idCarpeta);
            
             String [] cargar_archivos;
            
           cargar_archivos = archivos.split("@");
           String valor1 ="";
            
            for(int x=0; x<cargar_archivos.length; x++)
            {   
                valor1 += "<form action=\"SeleccionarArchivos\" class=\"form-signin\">"
                        + "<button class=\"btn btn-lg btn-link\" type=\"submit\" name=\"nombreArchivoSeleccionado\" value=\""+cargar_archivos[x]+"\">"+cargar_archivos[x]+"</button>"
                        + "</form>";
            }
            
            request.setAttribute("Archivos", valor1);            
            request.setAttribute("carpetas", valor);
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
