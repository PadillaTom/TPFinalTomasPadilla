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
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.List;

@WebServlet(name = "SvConsPorHyF", urlPatterns = {"/SvConsPorHyF"})
public class SvConsPorHyF extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");     
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Data:
        String huesDni =  request.getParameter("hues-dni");
        String resFechaDe = request.getParameter("res-fechaDe");
        String resFechaHasta = request.getParameter("res-fechaHasta");
        
        // Controladora:
        Controladora myContr = new Controladora();
        List<Reserva> myList = myContr.reservasPorHyF(huesDni, resFechaDe, resFechaHasta);
        
        // Set:
        HttpSession mySess = request.getSession();
        mySess.setAttribute("reservasPorHF", myList);
        
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
                                  "<th>N° Res </th>" +
                                  "<th>Check-in</th>" +
                                  "<th>Check-out</th>" +
                                  "<th>Habitacion</th>" +
                                  "<th>N° Huespedes</th>" +
                                  "<th>Huesped Dni</th>" +
                                  "<th>Huesped</th>" +
                                  "<th>Empleado</th>" +
                                "</tr>" +
                            "</thead>" +                                    
                            "<tbody>" );
                    for(Reserva res : myList) {
                        String resIn = dateFormatter.format(res.getFechaDe());
                        String resOut = dateFormatter.format(res.getFechaHasta());
                        out.println(                    
                            "<tr>" +
                                "<td>" + res.getId_reserva() + "</td>" +
                                "<td>" + resIn + "</td>"+
                                "<td>"+ resOut + "</td>"+
                                "<td>" + res.getResHabitacion().getTipo() + "</td>" +
                                "<td>" + res.getCantidadPersonas() + "</td>" +
                                "<td>" + res.getResHuesped().getDniHuesped() + "</td>" +
                                "<td>" + res.getResHuesped().getNombreCompletoHuesped() + "</td>" +
                                "<td>" + res.getResUsuario().getUsuEmpleado().getNombreEmpleado() + "</td>" +
                            "</tr>"
                        );
                    }
                    out.println(
                            "</tbody>" +
                        "</table>"
                    );
            } else {
                out.println("<h3 class="+"buscador-notFound"+">" + "No se encuentran Reservas para la fecha seleccionada." + "</h2>");
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
