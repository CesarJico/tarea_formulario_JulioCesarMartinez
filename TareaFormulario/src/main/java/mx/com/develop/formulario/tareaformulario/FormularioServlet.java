/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.develop.formulario.tareaformulario;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Jcesar
 */
@WebServlet(name = "FormularioServlet", urlPatterns = {"/formulario.do"})
public class FormularioServlet extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. */
           /* out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet FormularioServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet FormularioServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");*/
           String nombre = request.getParameter("nombre");
           String apellidoPaterno = request.getParameter("apellido_paterno");
           String apellidoMaterno = request.getParameter("apellido_materno");
           Integer edad =  Integer.parseInt(request.getParameter("edad"));
           String estado = request.getParameter("estado");
            System.out.println(nombre);
            System.out.println(apellidoPaterno);
            System.out.println(apellidoMaterno);
            System.out.println(edad);
            System.out.println(estado); 
            
            request.setAttribute("nombre", nombre);
            request.setAttribute("apellidoPaterno", apellidoPaterno);
            request.setAttribute("apellidoMaterno", apellidoMaterno);
            request.setAttribute("edad", edad);
            request.setAttribute("estado", estado);
            RequestDispatcher rd = request.getRequestDispatcher("/form.jsp");
            rd.forward(request, response);
            
            response.setContentType("text/plain");
            response.setHeader("Content-Disposition",
                             "attachment;filename=downloadname.txt");
            ServletContext ctx = getServletContext();
            InputStream is = ctx.getResourceAsStream("/testing.txt");

            int read=0;
            int BYTES_DOWNLOAD = 1024;
            byte[] bytes = new byte[BYTES_DOWNLOAD];
            OutputStream os = response.getOutputStream();

            while((read = is.read(bytes))!= -1){
                os.write(bytes, 0, read);
            }
            os.flush();
            os.close();
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
