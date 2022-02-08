/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.Usuarios;

/**
 *
 * @author PRIDE OTTER
 */
public class ActUsu extends HttpServlet {

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
            HttpSession idsesion = request.getSession(true);
            String nom, con, cor;
            nom = request.getParameter("usuario");
            con = request.getParameter("con");
            cor = request.getParameter("cor");
            Usuarios hola = (Usuarios)idsesion.getAttribute("usuario");
            Usuarios e = new Usuarios();
            
            e.setNombre(nom);
            e.setPas(con);
            e.setEmail(cor);
            e.setId(hola.getId());
            
            
            System.out.println(nom);
            System.out.println(con);
            System.out.println(cor);
            
            ArrayList <Usuarios> lista = Usuarios.buscarAllEmpleados();
             
           
            String hola2 = lista.get(0).getNombre();
            System.out.println(hola);
            System.out.println("holi");
           int estatus1 = 1;
            for(Usuarios i : lista){
            if(cor.equals(i.getEmail())){
              System.out.println("hola2");
               estatus1 = 0;
               if(hola.getId()==i.getId()){
                  estatus1 = 1; 
               }
            }   
            }
            if(estatus1 > 0){
               int estatus = Usuarios.actualizarEmpleado(e);
            
            
            if(estatus > 0){
                idsesion.setAttribute("usuario", e);
                idsesion.setAttribute("nomusuario", e.getNombre());
                idsesion.setAttribute("idusuario", e.getId());
                
                response.sendRedirect("index.html");
                
            }else{
                response.sendRedirect("error.jsp");
                
            } 
            }else{
                response.sendRedirect("error.jsp");
                
            }
            
            
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ActUsu</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ActUsu at " + request.getContextPath() + "</h1>");
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
