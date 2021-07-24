/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author padillatom
 */
@WebServlet(name = "SvEmpleado", urlPatterns = {"/SvEmpleado"})
public class SvEmpleado extends HttpServlet {

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
        
        // Get Data:
        String empUsername = request.getParameter("empUsername");
        String empPassword = request.getParameter("empPassword");
        String empDni = request.getParameter("empDni");
        String empNombre = request.getParameter("empNombre");
        String empApellido = request.getParameter("empApellido");
        String empFechaNac = request.getParameter("empFechaNac");
        String empDireccion = request.getParameter("empDireccion");
        String empCargo = request.getParameter("empCargo");
        
        // Set HC:
        request.getSession().setAttribute("empUsername", empUsername);
        request.getSession().setAttribute("empPassword", empPassword);
        request.getSession().setAttribute("empDni", empDni);
        request.getSession().setAttribute("empNombre", empNombre);
        request.getSession().setAttribute("empApellido", empApellido);
        request.getSession().setAttribute("empFechaNac", empFechaNac);
        request.getSession().setAttribute("empDireccion", empDireccion);
        request.getSession().setAttribute("empCargo", empCargo);
        
        // Controller:
        
        // Response:
        response.sendRedirect("empleados.jsp");
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
