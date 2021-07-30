package Servlets;

import Logica.Controladora;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "SvReservas", urlPatterns = {"/SvReservas"})
public class SvReservas extends HttpServlet {

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
        String resTipoHabitacion = request.getParameter("res-tipoHabitacion");
        String resCantPersonas = request.getParameter("res-cantPersonas");
        String resFechaDe = request.getParameter("res-fechaDe");
        String resFechaHasta = request.getParameter("res-fechaHasta");
        String huesDni = request.getParameter("hues-dni");
        String huesNombre = request.getParameter("hues-nombre");
        String huesApellido = request.getParameter("hues-apellido");
        String huesFechaNac = request.getParameter("hues-fechaNac");
        String huesDireccion = request.getParameter("hues-direccion");
        String huesProfesion = request.getParameter("hues-profesion");
        String usuUsername = (String) request.getSession().getAttribute("usuUsername");
        
        //  **** Mandarla a Confirm: HARDCODED ****        
        request.getSession().setAttribute("resTipoHabitacion", resTipoHabitacion);
        request.getSession().setAttribute("resCantPersonas", resCantPersonas);
        request.getSession().setAttribute("resFechaDe", resFechaDe);
        request.getSession().setAttribute("resFechaHasta", resFechaHasta);
        request.getSession().setAttribute("huesDni", huesDni);
        request.getSession().setAttribute("huesNombre", huesNombre.substring(0, 1).toUpperCase()+ huesNombre.substring(1));
        request.getSession().setAttribute("huesApellido", huesApellido.substring(0, 1).toUpperCase()+ huesApellido.substring(1));
        request.getSession().setAttribute("huesFechaNac", huesFechaNac);
        request.getSession().setAttribute("huesDireccion", huesDireccion);
        request.getSession().setAttribute("huesProfesion", huesProfesion.substring(0, 1).toUpperCase()+ huesProfesion.substring(1));       
        
        // Controladora:
        Controladora myContr = new Controladora();
        myContr.crearReserva(resTipoHabitacion, resCantPersonas, resFechaDe, resFechaHasta, huesDni, huesNombre, huesApellido, huesFechaNac, huesDireccion, huesProfesion, usuUsername);
        
        // Response:
        response.sendRedirect("confirmacionReserva.jsp");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
