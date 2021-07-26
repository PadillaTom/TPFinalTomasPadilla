package Servlets;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "SvEmpleado", urlPatterns = {"/SvEmpleado"})
public class SvEmpleado extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

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
        
        // **** Set HC ****
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

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
