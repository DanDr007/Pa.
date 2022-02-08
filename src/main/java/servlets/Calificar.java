/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.Usuarios;
import modelo.calificacion;

/**
 *
 * @author PRIDE OTTER
 */
public class Calificar extends HttpServlet {

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
            System.out.println("hola");
            HttpSession sesionusu = request.getSession(true);
             Usuarios hola = (Usuarios)sesionusu.getAttribute("usuario");
             
            String  cal;
            
            String id_pub = request.getParameter("idpub");
            System.out.println(id_pub);
            int id_pub2 = Integer.parseInt(id_pub);
            int id_usu = hola.getId();
            System.out.println(id_usu);
            cal = request.getParameter("cal");
            System.out.println(cal);
            int cal2 = Integer.parseInt(cal);
            System.out.println("hola");
            System.out.println(id_pub);
            System.out.println(id_usu);
            System.out.println(cal);
            calificacion e = new calificacion();
            e.setId_usu(id_usu);
            e.setId_pub(id_pub2);
            e.setNum(cal2);
            
            
            
            
             List <calificacion> lista = calificacion.buscarAllCalById(id_pub2);
           
            
            System.out.println(hola);
            System.out.println("holi");
           int estatus1 = 1;
            for(calificacion i : lista){
                
            if(id_usu==i.getId_usu()){
              System.out.println(id_usu);
               estatus1 = 0;
               System.out.println(i.getId_usu());
            }   
             System.out.println(i.getId_usu());
             System.out.println(id_usu);
            }
            
            if(estatus1 > 0){
               int estatus =calificacion.registrarCalificacion(e);
            
            
            if(estatus > 0){
                
                response.sendRedirect("index.html");
                
            }else{
                response.sendRedirect("error.jsp");
                
            } 
            }else{
                response.sendRedirect("index.html");
                
            }
            
            
            
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Calificar</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Calificar at " + request.getContextPath() + "</h1>");
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
