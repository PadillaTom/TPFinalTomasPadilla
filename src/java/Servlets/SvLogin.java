package Servlets;

import Logica.Controladora;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

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
            
            // Send to Dashboard:
            request.getSession().setAttribute("usuUsername", usuUsername);
            
            // Controladora:
            Controladora myContr = new Controladora();
            
//          *** Redirect ***
            response.sendRedirect("dashboard.jsp");  
            
    }
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
