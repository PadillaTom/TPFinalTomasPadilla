package Servlets;

import Logica.Controladora;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(name = "SvLogin", urlPatterns = {"/SvLogin"})
public class SvLogin extends HttpServlet {

       protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
      
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException { 
        
            // Tomar Data:
            String usuUsername = request.getParameter("username");
            String usuPassword = request.getParameter("password"); 
            
            // Controladora:
            Controladora myContr = new Controladora();
            boolean isAutorizado = myContr.verificarLogin(usuUsername, usuPassword);
            
//          *** Session y Redirect ***
            if(isAutorizado == true) {
                HttpSession mySess = request.getSession(true);
                mySess.setAttribute("usuUsername", usuUsername);
                mySess.setAttribute("usuPassword", usuPassword);
                
                response.sendRedirect("dashboard.jsp");  
            } else {
                String errorMsg = "Ingreso Fallido, verificar Usuario y Contraseña";
                request.getSession().setAttribute("errorMsg", errorMsg);
                response.sendRedirect("index.jsp");
            }
            
    }
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
