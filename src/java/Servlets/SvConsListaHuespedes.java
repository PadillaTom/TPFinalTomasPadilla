package Servlets;

import Logica.Controladora;
import Logica.Huesped;
import Logica.Reserva;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.text.SimpleDateFormat;
import java.util.List;

@WebServlet(name = "SvConsListaHuespedes", urlPatterns = {"/SvConsListaHuespedes"})
public class SvConsListaHuespedes extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Controladora:
        Controladora myContr = new Controladora();
        List<Huesped> myList = myContr.traerHuespedes();
        
        // Set:
        HttpSession mySess = request.getSession();
        mySess.setAttribute("listaHuespedes", myList);
        
        // Response:
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        // ====== ARMAMOS JSP ======
        String datePattern = "dd/MM/yyyy";                                
        SimpleDateFormat dateFormatter = new SimpleDateFormat(datePattern);
        if(myList != null){
            if (myList.size() > 0){                
                    out.println(
                        "<table>" +
                            "<thead>" +
                                "<tr>" +
                                  "<th>DNI</th>" +
                                  "<th>Nombre</th>" +
                                  "<th>Apellido</th>" +
                                  "<th>Fecha Nac</th>" +
                                  "<th>Direccion</th>" +
                                  "<th>Profesion</th>" +
                                "</tr>" +
                            "</thead>" +                                    
                            "<tbody>" );
                    for(Huesped hues : myList) {
                        String huesNac = dateFormatter.format(hues.getFechaNacHuesped());;
                        out.println(                    
                            "<tr>" +
                                "<td>" + hues.getDniHuesped() + "</td>" +
                                "<td>" + hues.getNombreHuesped() + "</td>"+
                                "<td>" + hues.getApellidoHuesped() + "</td>" +
                                "<td>" + huesNac + "</td>" +
                                "<td>" + hues.getDireccionHuesped() + "</td>" +
                                "<td>" + hues.getProfesionHuesped() + "</td>" +
                            "</tr>"
                        );
                    }
                    out.println(
                            "</tbody>" +
                        "</table>"
                    );
            } else {
                out.println("<h3 class="+"buscador-notFound"+">" + "No se encuentran Huespedes." + "</h2>");
            }           
        }
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
