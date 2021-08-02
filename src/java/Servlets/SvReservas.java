package Servlets;

import Logica.Controladora;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.Timer;
import java.util.TimerTask;

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

            // Controladora:
            Controladora myContr = new Controladora();
            String myRes = myContr.verifRes(resTipoHabitacion, resFechaDe, resFechaHasta);
            if(myRes.equals("no")){
                // Set:
                final HttpSession mySess = request.getSession();
                mySess.setAttribute("noDispoMsg", myRes);
                response.sendRedirect("reservas.jsp");
                // Timeout:
                new Timer().schedule(new TimerTask() {
                    @Override
                    public void run() {
                        mySess.setAttribute("noDispoMsg", null);
                    }
                }, 5000L); 
            } else if (myRes.equals("yes")){
            myContr.crearReserva(resTipoHabitacion, resCantPersonas, resFechaDe, resFechaHasta, huesDni, huesNombre, huesApellido, huesFechaNac, huesDireccion, huesProfesion, usuUsername);
            // Response:
            response.sendRedirect("confirmacionReserva.jsp");
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
