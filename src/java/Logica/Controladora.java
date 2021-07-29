package Logica;

import Persistencia.ControladoraPersistencia;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
    
    // =Crear Habitacion=
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
    
    // =Traer Habitacion=
    public List<Habitacion> traerHabitaciones(){
        return myCP.traerHabitaciones();
    }
    
    //::::::::::::::::::::::::
    //::::::: Usuario ::::::
    //::::::::::::::::::::::::
    
    // =Find Usuario by Username=
     // Find all Usuarios, Tratarlos como LIST para getUsername() y compararlos. if Match  .getId_Usuario();
    
    //::::::::::::::::::::::::
    //:::::: Huespedes :::::::
    //::::::::::::::::::::::::
        // =Buscar Huespedes=
    
    //::::::::::::::::::::::::
    //::::::: Empleados ::::::
    //::::::::::::::::::::::::
    
    // =Crear Empleado=
    public void altaPrimerEmpleado() {
        try {
            Empleado myEmp = new Empleado();
            Usuario myUsu = new Usuario();
            
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
            Date empFecha = formatter.parse("01-01-2021");
            
            myUsu.setId_usuario(1);
            myUsu.setUsername("AdminHotel");
            myUsu.setPassword("admin");
            myEmp.setId_empleado(1);
            myEmp.setDniEmpleado("-");
            myEmp.setNombreEmpleado("Admin Hotel");
            myEmp.setApellidoEmpleado("Admin Hotel");
            myEmp.setFechaNacEmpleado(empFecha);
            myEmp.setDireccionEmpleado("-");
            myEmp.setCargoEmpleado("Admin App");
            myEmp.setEmpUsuario(myUsu);
            
            myCP.altaEmpleado(myEmp);
        } catch (ParseException ex) {
            Logger.getLogger(Controladora.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void crearEmpleado(String empUsername, String empPassword, String empDni, String empNombre, String empApellido, String empFechaNac, String empDireccion, String empCargo){
        try {
            // Instanciamos:
            Empleado myEmp = new Empleado();
            Usuario myUsu = new Usuario();
            
            // String to Date:
            SimpleDateFormat formatter = new SimpleDateFormat("dd-mm-yyyy");
            Date empFecha = formatter.parse(empFechaNac);
            
            // Creamos:
            myUsu.setUsername(empUsername);
            myUsu.setPassword(empPassword);
            myEmp.setDniEmpleado(empDni);
            myEmp.setNombreEmpleado(empNombre);
            myEmp.setApellidoEmpleado(empApellido);
            myEmp.setFechaNacEmpleado(empFecha);
            myEmp.setDireccionEmpleado(empDireccion);
            myEmp.setCargoEmpleado(empCargo);
            myEmp.setEmpUsuario(myUsu);
            
            // Metodos:
            myCP.altaEmpleado(myEmp);
        } catch (ParseException ex) {
            Logger.getLogger(Controladora.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    // =Traer Primer Empleado=
    public Empleado primerEmpleado(){
        return myCP.primerEmppleado();
    }
    // =Traer Empleados=
    public List<Empleado> traerEmpleados(){
        return myCP.traerEmpleados();
    }
    
    //::::::::::::::::::::::::
    //::::::: Reservas :::::::
    //::::::::::::::::::::::::
        public void crearReserva(String resTipoHabitacion, String resCantPersonas, String resFechaDe, String resFechaHasta, String huesDni, String huesNombre, String huesApellido, String huesFechaNac, String huesDireccion, String huesProfesion){
        try {
            // Instancias:
            Reserva myRes = new Reserva();
            Huesped myHues = new Huesped();
            
            // String to Date:
            SimpleDateFormat formatter = new SimpleDateFormat("dd-mm-yyyy");
            Date resCheckin = formatter.parse(resFechaDe);
            Date resCheckout = formatter.parse(resFechaHasta);
            Date huesFecha = formatter.parse(huesFechaNac);
            Date resFechaAlta = new Date();
            
            // Cantidad Noches:
            long nochesTime = resCheckout.getTime() - resCheckin.getTime();
            int cantidadNoches = (int) Math.floor(nochesTime / (1000*60*60*24));
            
            // Find Habitacion por ID y Precio Total:
            int myHabId = Integer.parseInt(resTipoHabitacion);
            Habitacion myHab = myCP.traerHabitacionPorId(myHabId);
            double myHabPrecio = myHab.getPrecioPorNoche();
            double precioTotal = myHabPrecio * cantidadNoches;
            
            // Find Huesped o Crearlo:
            myHues.setDniHuesped(huesDni);
            myHues.setNombreHuesped(huesNombre);
            myHues.setApellidoHuesped(huesApellido);
            myHues.setFechaNacHuesped(huesFecha);
            myHues.setDireccionHuesped(huesDireccion);
            myHues.setProfesionHuesped(huesProfesion);
            myCP.altaHuesped(myHues);
            
            // Find Usuario :
            Usuario myUsu = myCP.traerUsuarioPorId(1);
            
            // Creamos Reserva:
            myRes.setResHuesped(myHues);
            myRes.setCantidadNoches(cantidadNoches);
            myRes.setFechaDe(resCheckin);
            myRes.setFechaHasta(resCheckout);
            myRes.setFechaDeCarga(resFechaAlta);
            myRes.setPrecioTotal(precioTotal);
            myRes.setResHabitacion(myHab);
            myRes.setResUsuario(myUsu);
            
            
            myCP.altaReserva(myRes);
            
        } catch (ParseException ex) {
            Logger.getLogger(Controladora.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        }
        // =Buscar Reservas=
    
}
