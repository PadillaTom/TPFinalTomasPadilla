package Persistencia;

import Logica.Empleado;
import Logica.Habitacion;
import Logica.Huesped;
import Logica.Reserva;
import Logica.Usuario;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ControladoraPersistencia {
    // ::: Instancias :::
    EmpleadoJpaController empJPA = new EmpleadoJpaController();
    HabitacionJpaController habJPA = new HabitacionJpaController();
    HuespedJpaController huesJPA = new HuespedJpaController();
    ReservaJpaController resJPA = new ReservaJpaController();
    UsuarioJpaController usuJPA = new UsuarioJpaController();
    
    //::::::::::::::::::::::::
    //::::::: Empleado :::::::
    //::::::::::::::::::::::::
    
    // Alta:
    public void altaEmpleado(Empleado emp) {
        empJPA.create(emp);
    }
    // Find:
    public List<Empleado> traerEmpleados(){
        return empJPA.findEmpleadoEntities();
    }
    
    //::::::::::::::::::::::::
    //::::: Habitacion :::::
    //::::::::::::::::::::::::
    
    // Alta:
    public void altaHabitacion(Habitacion hab){
        try {
            habJPA.create(hab);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    // Find:
    public List<Habitacion> traerHabitaciones(){
        return habJPA.findHabitacionEntities();
    }
    public Habitacion traerHabitacionPorId(int habId){
        return habJPA.findHabitacion(habId);
    }
    
    //::::::::::::::::::::::::
    //::::: Huesped :::::
    //::::::::::::::::::::::::
    
    // Alta:
    public void altaHuesped(Huesped hues){
        huesJPA.create(hues);
    }
    // Find:
    
    
    //::::::::::::::::::::::::
    //::::: Reserva :::::
    //::::::::::::::::::::::::
    
    // Alta:
    public void altaReserva(Reserva res){
        resJPA.create(res);
    }
    
    //::::::::::::::::::::::::
    //::::: Usuario :::::
    //::::::::::::::::::::::::
    
    // Alta:
    public void altaUsuario(Usuario usu){
        usuJPA.create(usu);
    } 
    
    // Find:
    public Usuario primerUsuario(){
        return usuJPA.findUsuario(1);
    }
    public List<Usuario> traerUsuarios(){
        return usuJPA.findUsuarioEntities();
    }
    public Usuario traerUsuarioPorId(int usuId){
        return usuJPA.findUsuario(usuId);
    }
    
    
}
