/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.Usuarios;
import modelo.publicacion;

/**
 *
 * @author PRIDE OTTER
 */
public class Publicar extends HttpServlet {

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
            Calendar fecha = Calendar.getInstance();
        int año = fecha.get(Calendar.YEAR);
        int mes = fecha.get(Calendar.MONTH) + 1;
            System.out.println(año);
            HttpSession sesionusu = request.getSession(true);
            Usuarios hola2 = (Usuarios)sesionusu.getAttribute("usuario");
            int id_ins = Integer.parseInt(request.getParameter("Inseguridad"));
            int id_mes = Integer.parseInt(request.getParameter("mes"));
            int id_hor = Integer.parseInt(request.getParameter("Horario"));
            int id_par = Integer.parseInt(request.getParameter("Estacion"));
            int id_anio = año-2020;
            int id_usu = hola2.getId();
            
            String contenido = request.getParameter("textarea");
            
            publicacion e = new publicacion();
            e.setContenido(contenido);
            e.setId_anio(id_anio);
            e.setId_mes(id_mes);
            e.setId_par(id_par);
            e.setId_ins(id_ins);
            e.setId_usu(id_usu);
            e.setId_hor(id_hor);
            System.out.println(id_mes);
            System.out.println(id_hor);
            int estatus =publicacion.registrarPublicacion(e);
            int linea = (int) sesionusu.getAttribute("linea");
            if(estatus > 0){
                response.sendRedirect("linea"+linea+".jsp");
            }else{
                response.sendRedirect("error.jsp");
            }
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Publicar</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Publicar at " + request.getContextPath()+ id_ins + contenido + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
