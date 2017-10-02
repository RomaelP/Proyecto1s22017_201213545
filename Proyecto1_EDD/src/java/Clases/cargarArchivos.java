package Clases;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import org.apache.commons.fileupload.*;
import org.apache.commons.fileupload.disk.*;
import org.apache.commons.fileupload.servlet.*;

/**
 *
 * @author USuario1
 */
public class cargarArchivos extends HttpServlet {

  
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String usuario = Conexion.globalUsuario;
        String contra = Conexion.globalContra;
        String carpetaContenedora = Conexion.globalCarpeta;
        String idCarpeta = Conexion.obtenerCodigoNombreCarpeta(carpetaContenedora);
          
        try (PrintWriter out = response.getWriter()) {
            
            FileItemFactory itemfactory = new DiskFileItemFactory(); 
            ServletFileUpload upload = new ServletFileUpload(itemfactory);
            String JSONString = "";
            try{
                List<FileItem>  items = upload.parseRequest(request);
                for(FileItem item:items)
                {
                  FileItem archivoItem = (FileItem) item;
                  if(!archivoItem.isFormField()){
                  BufferedInputStream buffer = new BufferedInputStream(archivoItem.getInputStream());
                  byte[] ArregloBytes = new byte[(int) archivoItem.getSize()];
                  buffer.read(ArregloBytes);
                  buffer.close();
                  
                  FileJsonDTO JSON = new FileJsonDTO();
                  JSON.setFileBytes(ArregloBytes);
                  JSON.setFileName(archivoItem.getName());
                  JSONString = ParserJson.parseObjectToStr(JSON);
                  /*Conexion conectar = new Conexion();
                  conectar.PruebaByte(JSONString); */                  
                      
                    Conexion con3 = new Conexion();
                    String respuesta = con3.metodoCargarArchivos(usuario, contra, Conexion.globalCarpeta, idCarpeta, JSONString );
                    out.print(respuesta);
                }
                }
                
            }
            catch(FileUploadException e){
                out.println("Carga Sin Exito");
            }
            catch(Exception ex){
                out.println("No se puede Guardar");
            }
        
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
