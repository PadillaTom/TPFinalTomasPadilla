package Logica;

import Persistencia.ControladoraPersistencia;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Controladora {
    // ::: Controladora Persistencia :::
    ControladoraPersistencia myCP = new ControladoraPersistencia();
    
    //::::::::::::::::::::::::
    //:::::::: Log In ::::::::
    //::::::::::::::::::::::::    
    public boolean verificarLogin(String usuUsuario, String usuPassword){
        List<Usuario> listaUsuarios = myCP.traerUsuarios();
        if(listaUsuarios != null) {
            for (Usuario usu : listaUsuarios){
                if(usu.getUsername().equals(usuUsuario) && usu.getPassword().equals(usuPassword)){
                    return true;
                }
            }
        }
        return false;
    }
    
    //::::::::::::::::::::::::
    //::::: Habitaciones :::::
    //::::::::::::::::::::::::   
    public void crearHabitaciones() {
        Habitacion myHab1 = new Habitacion(1, 1, "Habitacion Simple", "Single Room",150);
        Habitacion myHab2 = new Habitacion(2, 2, "Habitacion Doble", "Double Room",250);
        Habitacion myHab3 = new Habitacion(3, 2, "Habitacion Triple", "Triple Room",300);
        Habitacion myHab4 = new Habitacion(4, 3, "Habitacion Multiple", "Multiple Room",450);
        
        myCP.altaHabitacion(myHab1);
        myCP.altaHabitacion(myHab2);
        myCP.altaHabitacion(myHab3);
        myCP.altaHabitacion(myHab4);
    }  
    
    //::::::::::::::::::::::::
    //::::::: Usuario ::::::::
    //::::::::::::::::::::::::
    public void altaPrimerUsuario(){       
        try {
            Empleado myEmp = new Empleado();
            Usuario myUsu = new Usuario();
            
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
            Date empFecha = formatter.parse("01-01-2021");
                       
            myEmp.setDniEmpleado("-");
            myEmp.setNombreEmpleado("Admin Hotel");
            myEmp.setApellidoEmpleado("Admin Hotel");
            myEmp.setFechaNacEmpleado(empFecha);
            myEmp.setDireccionEmpleado("-");
            myEmp.setCargoEmpleado("Admin App");
                        
            myUsu.setUsername("AdminHotel");
            myUsu.setPassword("admin");
            myUsu.setUsuEmpleado(myEmp);
            
            myCP.altaUsuario(myUsu);
        } catch (ParseException ex) {
            Logger.getLogger(Controladora.class.getName()).log(Level.SEVERE, null, ex);
        }
    }  
    
    public void altaUsuario(String empUsername, String empPassword, String empDni, String empNombre, String empApellido, String empFechaNac, String empDireccion, String empCargo){
        try {
            // Instanciamos:
            Empleado myEmp = new Empleado();
            Usuario myUsu = new Usuario();
            
            // String to Date:
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
            Date empFecha = formatter.parse(empFechaNac);
            
            // Creamos:            
            myEmp.setDniEmpleado(empDni);
            myEmp.setNombreEmpleado(empNombre);
            myEmp.setApellidoEmpleado(empApellido);
            myEmp.setFechaNacEmpleado(empFecha);
            myEmp.setDireccionEmpleado(empDireccion);
            myEmp.setCargoEmpleado(empCargo);
           
            myUsu.setUsername(empUsername);
            myUsu.setPassword(empPassword);
            myUsu.setUsuEmpleado(myEmp);
            
            myCP.altaUsuario(myUsu);
            
        } catch (ParseException ex) {
            Logger.getLogger(Controladora.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String verifUsuario(String usuUsername){
        Usuario myUsu = myCP.traerUsuarioPorUsername(usuUsername);
        if (myUsu != null){
            return "true";
        } else {
            return "false";
        }
    }
    // Find: 
    public Usuario primerUsuario(String usuUsername){
        return myCP.traerUsuarioPorUsername(usuUsername);
    }
    public List<Usuario> traerUsuarios(){
        return myCP.traerUsuarios();
    }
    public Usuario usuarioPorSession(String usuUsername){
        return myCP.traerUsuarioPorUsername(usuUsername);
    }   
    public Usuario traerUsuarioPorId(int id){
        return myCP.traerUsuarioPorId(id);
    }
    
    //::::::::::::::::::::::::
    //::::::: Reservas :::::::
    //::::::::::::::::::::::::
    public String verifRes(String resTipoHabitacion, String resFechaDe, String resFechaHasta){
        try {
            // String to Date:
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
            Date resCheckin = formatter.parse(resFechaDe);
            Date resCheckout = formatter.parse(resFechaHasta);
            
            // Find Habitacion por Tipo y Precio Total:
            Habitacion myHab = myCP.traerHabitacionPorTipo(resTipoHabitacion);
            List<Reserva> resDeMyHab = myHab.getHabReservas();                
            if(resDeMyHab.size() > 0){
                for(Reserva res : resDeMyHab){
                    Date fechaDesde = res.getFechaDe();
                    Date fechaHasta = res.getFechaHasta();
                    if((resCheckin.before(fechaDesde) && resCheckout.before(fechaDesde)) || (resCheckin.after(fechaHasta) && resCheckout.after(fechaHasta))){
                        return "yes";
                    } else {
                        return "no";
                    }
                }                
            } else {
                return "yes";
            }
        } catch (ParseException ex) {
            Logger.getLogger(Controladora.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "return";
    }
    
    public void crearReserva(String resTipoHabitacion, String resCantPersonas, String resFechaDe, String resFechaHasta, String huesDni, String huesNombre, String huesApellido, String huesFechaNac, String huesDireccion, String huesProfesion, String usuUsername){
        try {
            // Instancias:
            Reserva myRes = new Reserva();
            Huesped myHues = new Huesped();

            // String to Date:
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
            Date resCheckin = formatter.parse(resFechaDe);
            Date resCheckout = formatter.parse(resFechaHasta);
            Date huesFecha = formatter.parse(huesFechaNac);
            
            Date resFechaAlta = new Date();

            // Cantidad Noches:
            long nochesTime = resCheckout.getTime() - resCheckin.getTime();
            int cantidadNoches = (int) Math.floor(nochesTime / (1000*60*60*24));

            // Find Habitacion por Tipo y Precio Total:
            Habitacion myHab = myCP.traerHabitacionPorTipo(resTipoHabitacion);
            List<Reserva> resDeMyHab = myHab.getHabReservas();
            if(resDeMyHab.size() > 0){                
                for(Reserva res : resDeMyHab){
                    Date fechaDesde = res.getFechaDe();
                    Date fechaHasta = res.getFechaHasta();
                    if((resCheckin.before(fechaDesde) && resCheckout.before(fechaDesde)) || (resCheckin.after(fechaHasta) && resCheckout.after(fechaHasta))){
                        myRes.setResHabitacion(myHab);
                    } else {
                        myRes.setResHabitacion(null);
                    }
                }                
            } else {
                myRes.setResHabitacion(myHab);
            }
               
            
            double myHabPrecio = myHab.getPrecioPorNoche();
            double precioTotal = myHabPrecio * cantidadNoches;

            // Find Huesped o Crearlo:
            myHues.setDniHuesped(huesDni);
            myHues.setNombreHuesped(huesNombre);
            myHues.setApellidoHuesped(huesApellido);
            myHues.setFechaNacHuesped(huesFecha);
            myHues.setDireccionHuesped(huesDireccion);
            myHues.setProfesionHuesped(huesProfesion);            
            Huesped myHuesEncontrado = myCP.traerHuespedPorDni(huesDni);
            if(myHuesEncontrado != null){
                myRes.setResHuesped(myHuesEncontrado);
            } else {
                myCP.altaHuesped(myHues);
                myRes.setResHuesped(myHues);                
            }
            // Cantidad Personas:
            int cantPers = Integer.parseInt(resCantPersonas);
            myRes.setCantidadPersonas(cantPers);
            // *** VERIFICAR CANT PERSONAS ***
            
            // Creamos Reserva: 
            myRes.setCantidadNoches(cantidadNoches);            
            myRes.setFechaDe(resCheckin);
            myRes.setFechaHasta(resCheckout);
            myRes.setFechaDeCarga(resFechaAlta);
            myRes.setPrecioTotal(precioTotal); 
            
            // Find Usuario :
            Usuario myUsu = myCP.traerUsuarioPorUsername(usuUsername);
            myRes.setResUsuario(myUsu);
            
            myCP.altaReserva(myRes);   
            
        } catch (ParseException ex) {
            Logger.getLogger(Controladora.class.getName()).log(Level.SEVERE, null, ex);
        }    
    }
    
    // Find:
    public List<Reserva> reservasPorFecha (String fechaIngresada){
        // Instancias:
        List<Reserva> resAll = myCP.traerTodasLasReservas();
        List <Reserva> listaFinal = new ArrayList<>();
//        System.out.println("TODAS LAS RESERVAS: " + resAll);
        // All Dates to String and Compare:
        if(resAll != null) {
            for (Reserva res : resAll){
                Date fechaDate = res.getFechaDeCarga();
                String datePattern = "dd-MM-yyyy";                                
                SimpleDateFormat dateFormatter = new SimpleDateFormat(datePattern); 
                String fechaRes = dateFormatter.format(fechaDate);
                if(fechaIngresada.equals(fechaRes)){
                    listaFinal.add(res);
                }
            }
        }
        return listaFinal;
    }
    
    public List<Reserva> reservasPorHyF(String huesDni, String resFechaDe, String resFechaHasta){
        try {
            // Instancias:
            List<Reserva> resAll = myCP.traerTodasLasReservas();
            List<Reserva> listaFinal = new ArrayList<>();
            
            // String to Date:
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
            Date resFechaIn = formatter.parse(resFechaDe);
            Date resFechaOut = formatter.parse(resFechaHasta);
            
            // Lista Reservas Por Huesped:
            if(resAll != null) {
                for (Reserva res : resAll){
                    String myResHuesDni = res.getResHuesped().getDniHuesped();
                    if(myResHuesDni.equals(huesDni)){
                        List<Reserva> tempList = new ArrayList<>();
                        tempList.add(res);
                        for(Reserva resFinal : tempList){
                            Date resIn = resFinal.getFechaDe();
                            Date resOut = resFinal.getFechaHasta();
                            if( ( (resIn.after(resFechaIn) && resIn.before(resFechaOut)) || (resOut.after(resFechaIn) && resOut.before(resFechaOut)) ) || (resIn.before(resFechaOut)&&(resOut.after(resFechaIn))) ){
                                System.out.println(resFinal.getId_reserva());
                                listaFinal.add(resFinal); 
                            }
                        } 
                    }
                }
            return listaFinal;
            }
             
        } catch (ParseException ex) {
            Logger.getLogger(Controladora.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
       
    //::::::::::::::::::::::::
    //:::::: Huespedes :::::::
    //::::::::::::::::::::::::
    public List<Huesped> traerHuespedes(){
        return myCP.traerHuespedes();
    }
    
    //::::::::::::::::::::::::
    //::::::: Empleados ::::::
    //::::::::::::::::::::::::
    // Get emp by DNI:
    public List<Reserva> traerResPorEmpleadoDni(String dniIngresado ){
         // Instancias:
        List<Reserva> resAll = myCP.traerTodasLasReservas();
        List <Reserva> listaFinal = new ArrayList<>();
        
        // All Dates to String and Compare:
        if(resAll != null) {
            for (Reserva res : resAll){
                String myResDni = res.getResUsuario().getUsuEmpleado().getDniEmpleado();
                if(myResDni.equals(dniIngresado)){
                    listaFinal.add(res);
                }
            }
        }
        return listaFinal;
    }    
    
    // Borrar:
    public void borrarEmpYUsu(int idUsu){
        Usuario miUsu = myCP.traerUsuarioPorId(idUsu);
        int idEmp = miUsu.getUsuEmpleado().getId_empleado();
        myCP.borrarEmpYUsu(idEmp, idUsu);
    }
    // Editar:
    public void modificarEmpleado(Usuario usu, Empleado emple){
        myCP.modificarEmpleado(usu, emple);
        
    }
    
}
