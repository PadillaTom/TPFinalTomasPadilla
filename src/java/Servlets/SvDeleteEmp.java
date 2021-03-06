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

@WebServlet(name = "SvDeleteEmp", urlPatterns = {"/SvDeleteEmp"})
public class SvDeleteEmp extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
     
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                // Get Data:
        int resId = Integer.parseInt(request.getParameter("idRes"));        
        String fechaIngresada = request.getParameter("fechaRes");
        // Controller:
        Controladora myController = new Controladora();
        myController.borrarReserva(resId);
        
        List<Reserva> myList = myController.reservasPorFecha(fechaIngresada);
        // Set:
        HttpSession mySess = request.getSession();
        mySess.setAttribute("reservasPorFecha", myList);
        
        // Response:
        response.sendRedirect("consultas.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Get Data:
        int empId = Integer.parseInt(request.getParameter("idEmp"));
        
        // Controller:
        Controladora myController = new Controladora();
        myController.borrarEmpYUsu(empId);
        
        // Response:
        response.sendRedirect("empleados.jsp");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
