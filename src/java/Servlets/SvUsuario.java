package Servlets;

import Logica.Controladora;
import Logica.Usuario;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.Timer;
import java.util.TimerTask;

@WebServlet(name = "SvUsuario", urlPatterns = {"/SvUsuario"})
public class SvUsuario extends HttpServlet {

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
        
        // Controller:
        Controladora myControladora = new Controladora();
        String verifUsu = myControladora.verifUsuario(empUsername);
        if(verifUsu.equals("true")){
            final HttpSession mySess = request.getSession(true);
            mySess.setAttribute("errorMsg", verifUsu);
            new Timer().schedule(new TimerTask() {
                    @Override
                    public void run() {
                        mySess.setAttribute("errorMsg", null);
                    }
                }, 5000L); 
        } else if (verifUsu.equals("false")){
            myControladora.altaUsuario(empUsername, empPassword, empDni, empNombre, empApellido, empFechaNac, empDireccion, empCargo);
            response.sendRedirect("empleados.jsp");
        }
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
