package Servlets;

import Logica.Controladora;
import Logica.Habitacion;
import Logica.Huesped;
import Logica.Reserva;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "SvEditRes", urlPatterns = {"/SvEditRes"})
public class SvEditRes extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet SvEditRes</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SvEditRes at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
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
            String fechaCargaHidden = request.getParameter("fechaCargaResHidden");
            int idRes = Integer.parseInt(request.getParameter("idResHidden"));
            
            // Controladora:
            Controladora myContr = new Controladora();
            Reserva resModif = myContr.traerReservaPorId(idRes);
            Habitacion myHab = myContr.traerHabPorTipo(resTipoHabitacion);
            Huesped huesModif = resModif.getResHuesped();
            
            // String to Date:
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
            Date resIn = formatter.parse(resFechaDe);
            Date resOut = formatter.parse(resFechaHasta);
            Date huesNac = formatter.parse(huesFechaNac);
            Date resCarga = new Date();            
            
            // Set:
            resModif.setCantidadPersonas(Integer.parseInt(resCantPersonas));
            resModif.setFechaDe(resIn);
            resModif.setFechaHasta(resOut);
            resModif.setFechaDeCarga(resCarga);
            resModif.setResHabitacion(myHab);
          
            
            huesModif.setDniHuesped(huesDni);
            huesModif.setNombreHuesped(huesNombre);
            huesModif.setApellidoHuesped(huesApellido);
            huesModif.setFechaNacHuesped(huesNac);
            huesModif.setDireccionHuesped(huesDireccion);
            huesModif.setProfesionHuesped(huesProfesion);
                        
            // Verif y Modificar:
            String myRes = myContr.verifRes(resTipoHabitacion, resFechaDe, resFechaHasta);            
            if(myRes.equals("no")){
                // Set:
                final HttpSession mySess = request.getSession();
                mySess.setAttribute("noDispoMsg", myRes);
                response.sendRedirect("modificacionReserva.jsp");
                // Timeout:
                new Timer().schedule(new TimerTask() {
                    @Override
                    public void run() {
                        mySess.setAttribute("noDispoMsg", null);
                    }
                }, 5000L); 
            } else if (myRes.equals("yes")){                
                // Controller:
                myContr.modificarReserva(resModif, huesModif);
                List<Reserva> myList = myContr.reservasPorFecha(fechaCargaHidden);
                // Set:
                HttpSession mySess = request.getSession();
                mySess.setAttribute("reservasPorFecha", myList);
                // Response:
                response.sendRedirect("consultas.jsp");
            }
        } catch (ParseException ex) {
            Logger.getLogger(SvEditRes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Get Data:
        int resId = Integer.parseInt(request.getParameter("idRes"));
        
        // Controller:
        Controladora myController = new Controladora();
        Reserva myRes = myController.traerReservaPorId(resId);
        // Set:
        HttpSession mySess = request.getSession();
        mySess.setAttribute("myResModif", myRes);
        
        // Response:
        response.sendRedirect("modificacionReserva.jsp");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
