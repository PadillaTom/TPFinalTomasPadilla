package Servlets;

import Logica.Controladora;
import Logica.Reserva;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;

@WebServlet(name = "SvConsResPorFecha", urlPatterns = {"/SvConsResPorFecha"})
public class SvConsResPorFecha extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Data:
        String fechaIngresada =  request.getParameter("buscador");
        // Controladora:
        Controladora myContr = new Controladora();
        List<Reserva> myList = myContr.reservasPorFecha(fechaIngresada);
        
        // Set:
        HttpSession mySess = request.getSession();
        mySess.setAttribute("reservasPorFecha", myList);
        
        response.sendRedirect("consultas.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
