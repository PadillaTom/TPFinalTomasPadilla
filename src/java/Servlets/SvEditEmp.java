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
import java.io.PrintWriter;

@WebServlet(name = "SvEditEmp", urlPatterns = {"/SvEditEmp"})
public class SvEditEmp extends HttpServlet {

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
        int empId = Integer.parseInt(request.getParameter("idEmp"));
        
        // Controller:
        Controladora myController = new Controladora();
        Usuario myUsu = myController.traerUsuarioPorId(empId);
        
        // Set:
        HttpSession mySess = request.getSession();
        mySess.setAttribute("myEmpModif", myUsu);
        
        // Response:
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        if(myUsu != null){
        out.println(       
                "<div class='modal-EditEmpFormContainer'>" +
                "<form class='emp-addEmpForm' action='SvUsuario' method='POST' id='myEmpForm' >"+
                        "<div class='res-formCenter'>"+
                        "<div class='res-formSection'>"+
                        "<div class='res-formTitle'>"+
                        " <h3>"+
                        " Editar Empleado"+
                        "</h3>"+
                        "<p>Se Modificaran los datos del empleado.</p>"+
                        "</div> "+
                        "<div class='res-formInputsContainer res-facturacionContainer'>"+
                        "<div class='res-factSingleInput'>"+
                        "<label for='empUsernam'>"+
                        "Usuario:"+
                        "</label>"+
                        "<input type='text' name='empUsername' required='true' />"+
                        "</div>"+
                        "<div class='res-factSingleInput'>"+
                        " <label for='empPassword'>"+
                        " Contraseña:"+
                        "</label>"+
                        "<input type='text' name='empPassword' required='true' />"+
                        "</div>"+
                        "<div class='res-factSingleInput'>"+
                        "<label for='empDni'>"+
                        "DNI:"+
                        "</label>"+
                        "<input type='text' name='empDni' required='true' />"+
                        " </div>"+
                        "<div class='res-factSingleInput'>"+
                        "<label for='empNombre'>"+
                        "Nombre:"+
                        " </label>"+
                        "<input type='text' name='empNombre' required='true' />"+
                        "</div>"+
                        "<div class='res-factSingleInput'>"+
                        "<label for='empApellido'>"+
                        " Apellido:"+
                        "</label>"+
                        "<input type='text' name='empApellido' required='true' />"+
                        "</div>"+
                        " <div class='res-factSingleInput'>"+
                        "<label for='empFechaNac'>"+
                        " Fecha Nac:"+
                        " </label>"+
                        "<input type='text' name='empFechaNac' required='true' id='datepickerEmpFechaNac' placeholder='Seleccionar Fecha' />"+
                        "</div>"+
                        " <div class='res-factSingleInput'>"+
                        " <label for='empDireccion'>"+
                        " Direccion:"+
                        " </label>"+
                        "  <input type='text' name='empDireccion' required='true' />"+
                        " </div>"+
                        "<div class='res-factSingleInput'>"+
                        " <label for='empCargo'>"+
                        "Cargo:"+
                        " </label>"+
                        " <input type='text' name='empCargo' required='true' />"+
                        " </div>"+
                        " </div>"+
                        " </div>"+
                        " <div class='emp-addEmpFormBtns'>"+
                        "<input type='submit' value='Modificar' class='formBtn' />" +
                        " <button type='button' class='formBtn cancelBtn' onclick='closeModalEdit();' >Anular</button>"+
                        "</div>"+
                        " </div>"+
                        " </form>"+
                        " </div>");
    }}

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
