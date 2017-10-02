/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.io.FileOutputStream;
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
public class descargar extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        try (PrintWriter out = response.getWriter()) {
                String usuario = Conexion.globalUsuario;
                String contra = Conexion.globalContra;
                String carpetaContenedora = Conexion.globalCarpeta;
                String idCarpeta = Conexion.obtenerCodigoNombreCarpeta(carpetaContenedora);
                
		Conexion con1 = new Conexion();
                String respuestaPython = con1.ConexionPythonRespuestaByte(usuario, contra, idCarpeta, carpetaContenedora, "Archivo_Preuba.txt");
                FileJsonDTO fileObject = ParserJson.parseStrToObject(respuestaPython, FileJsonDTO.class); 
                try (FileOutputStream archivo = new FileOutputStream("C:\\Users\\Usuario1\\Desktop\\"+fileObject.getFileName())) {
                    archivo.write(fileObject.getFileBytes());
                    archivo.close(); 
                }
                out.print(respuestaPython);
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
