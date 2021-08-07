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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "SvBonusGanancias", urlPatterns = {"/SvBonusGanancias"})
public class SvBonusGanancias extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Get:
        String fechaElegida = request.getParameter("fechaDiarias");
        // Controladora:
        Controladora myController = new Controladora();
        List<Reserva> myRes = myController.reservasPorFecha(fechaElegida);
        
        // Monto Total:
        List<Double> subTotal = new ArrayList<>();
        for (Reserva singleRes : myRes){
            double singleAmount = singleRes.getPrecioTotal();
            subTotal.add(singleAmount);
        }
        double montoTotal= 0;
        for (double i : subTotal){
            montoTotal += i;
        }
        
        // Set:
        HttpSession mySess = request.getSession();
        mySess.setAttribute("resGanDiarias", myRes);
        
        // Response:
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
                // ====== ARMAMOS JSP ======
        String datePattern = "dd/MM/yyyy";                                
        SimpleDateFormat dateFormatter = new SimpleDateFormat(datePattern);
        if(myRes != null){
            if (myRes.size() > 0){     
                out.println(
                "<div class='section-title-underline'></div>" +
                "<h2>Resultados</h2>"
                );
                out.println(
                "<h2 style='color: crimson; margin-top: 0rem;'> Ganancias: "+ montoTotal + "- CHF </h2>"
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
                              "<th>Cantidad Noches</th>" +
                              "<th>Precio Total</th>" +
                            "</tr>" +
                        "</thead>" +                                    
                        "<tbody>" );
                for(Reserva res : myRes) {
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
                            "<td>" + res.getPrecioTotal() + " CHF</td>" +
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
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Get:
        String fechaElegida = request.getParameter("fechaMensual");
        // Controladora:
        Controladora myController = new Controladora();
        
        double myTotal = myController.gananciasMensuales(fechaElegida);
        List<Reserva> misRes = myController.reservasMensuales(fechaElegida);
        // Set:
        HttpSession mySess = request.getSession();
        mySess.setAttribute("resGanMensuales", fechaElegida);
        // Response:
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        // ====== ARMAMOS JSP ======
        String datePattern = "dd/MM/yyyy";
        SimpleDateFormat dateFormatter = new SimpleDateFormat(datePattern);
        
        if(misRes != null){
            if (misRes.size() > 0){     
                out.println(
                "<div class='section-title-underline'></div>" +
                "<h2>Resultados</h2>"
                );
                out.println(
                "<h2 style='color: crimson; margin-top: 0rem;'> Ganancias: "+ myTotal + "- CHF </h2>"
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
                              "<th>Cantidad Noches</th>" +
                              "<th>Precio Total</th>" +
                            "</tr>" +
                        "</thead>" +                                    
                        "<tbody>" );
                for(Reserva res : misRes) {
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
                            "<td>" + res.getPrecioTotal() + " CHF</td>" +
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
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
