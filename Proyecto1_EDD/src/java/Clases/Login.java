package Clases;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author USuario1
 */
public class Login extends HttpServlet {

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
                request.setAttribute("usuario", request.getParameter("usuario"));
                request.setAttribute("contra", request.getParameter("contra"));
                //se le asigna valor a Usuari y contraseña global
                Conexion.globalUsuario = request.getParameter("usuario");
                Conexion.globalContra = request.getParameter("contra");
                //System.out.println("usuario Logueado "+Conexion.globalUsuario);
                
                Conexion Con1 = new Conexion();
                
                String mVerificar = Con1.metodoVerificarUsuario(request.getParameter("usuario"), request.getParameter("contra"));
                System.out.println("**conecto "+mVerificar);
                if(mVerificar.equals("True")){
                    request.getRequestDispatcher("inicio.jsp").forward(request, response);
                }
                else{
                    request.setAttribute("errorMessage", "Usuario o Contraseña invalido");
                    request.getRequestDispatcher("index.jsp").forward(request, response);
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
