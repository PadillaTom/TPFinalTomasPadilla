package Servlets;

import Logica.Controladora;
import Logica.Empleado;
import Logica.Reserva;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "SvBonificacionEmp", urlPatterns = {"/SvBonificacionEmp"})
public class SvBonificacionEmp extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
      
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Get:
        String dniEmp = request.getParameter("dniEmp");
        String fechaEmp = request.getParameter("fechaEmp");
        
        // Control:
        Controladora myController = new Controladora();
        Empleado myEmp = myController.traerEmpleadoPorDni(dniEmp);
        String empleadoName = myEmp.getNombreCompletoEmpleado();
        List<Reserva> myRes = myController.reservasPorFecha(fechaEmp);
        List<Reserva> listaFinal = new ArrayList<>();
        for(Reserva res : myRes){
            if(res.getResUsuario().getUsuEmpleado().getDniEmpleado().equals(dniEmp)){
                listaFinal.add(res);
            }
        }
        
        // Set:
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        // ====== ARMAMOS JSP ======
        String datePattern = "dd/MM/yyyy";                                
        SimpleDateFormat dateFormatter = new SimpleDateFormat(datePattern);
        
            if (listaFinal.size() > 0){     
                out.println(
                "<div class='section-title-underline'></div>" +
                "<h2>Resultados</h2>"
                );
                out.println(
                "<h2 style='color: crimson; margin-top: 0rem;'> Empleado: "+ empleadoName + " </h2>"
                );
                out.println(
                "<h2 style='color: crimson; margin-top: 0rem;'> Cantidad Res: "+ listaFinal.size() + " </h2>"
                );
                out.println(
                    "<table style='margin-bottom: 2rem;'>" +
                        "<thead>" +
                            "<tr>" +
                              "<th>N° Res</th>" +
                              "<th>Check-in</th>" +
                              "<th>Check-out</th>" +
                              "<th>Habitacion</th>" +
                              "<th>Huesped</th>" +
                              "<th>Cant Noches</th>" +
                              "<th>Dni Empleado</th>" +
                              "<th>Empleado</th>" +
                            "</tr>" +
                        "</thead>" +                                    
                        "<tbody>" );
                for(Reserva res : listaFinal) {
                    String resIn = dateFormatter.format(res.getFechaDe());
                    String resOut = dateFormatter.format(res.getFechaHasta());
                    out.println(                    
                        "<tr>" +
                            "<td>" + res.getId_reserva() + "</td>" +
                            "<td>" + resIn + "</td>"+
                            "<td>"+ resOut + "</td>"+
                            "<td>" + res.getResHabitacion().getTipo() + "</td>" +
                            "<td>" + res.getResHuesped().getNombreCompletoHuesped() + "</td>" +
                            "<td>" + res.getCantidadNoches() + "</td>" +
                            "<td>" + res.getResUsuario().getUsuEmpleado().getDniEmpleado() + "</td>" +
                            "<td>" + empleadoName + "</td>" +
                        "</tr>"
                    );
                }
                out.println(
                        "</tbody>" +
                    "</table>"
                );
            } else {
                out.println("<h3 class="+"buscador-notFound"+">" + "No se encuentran Reservas para la Fecha elegida." + "</h2>");
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
