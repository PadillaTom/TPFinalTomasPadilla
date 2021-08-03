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
    // Find: 
    public Empleado traerEmpleadoPorDni(String dniIngresado){
        List<Empleado> myList = empJPA.findEmpleadoEntities();
            for (Empleado emp : myList){
                if(emp.getDniEmpleado().equals(dniIngresado)){
                    return emp;
                }     
        } return null;
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
    public Habitacion traerHabitacionPorTipo(String resTipoHabitacion){
        List<Habitacion> myList = habJPA.findHabitacionEntities();
            for (Habitacion hab : myList){
                if(hab.getTipo().equals(resTipoHabitacion)){
                    return hab;
                }     
        } return null;
    }    
    
    //::::::::::::::::::::::::
    //::::::: Huesped ::::::::
    //::::::::::::::::::::::::
    
    // Alta:
    public void altaHuesped(Huesped hues){
        huesJPA.create(hues);
    }
    // Find:
    public Huesped traerHuespedPorDni(String huesDni){
        List<Huesped> myList = huesJPA.findHuespedEntities();
            for (Huesped hues : myList){
                if(hues.getDniHuesped().equals(huesDni)){
                    return hues;
                }     
        } return null;
    }   
    public List<Huesped> traerHuespedes(){
        return huesJPA.findHuespedEntities();
    }
    
    //::::::::::::::::::::::::
    //::::::: Reserva ::::::::
    //::::::::::::::::::::::::
    
    // Alta:
    public void altaReserva(Reserva res){
        resJPA.create(res);
    }       
    // Find:
    public List<Reserva> traerTodasLasReservas(){
        return resJPA.findReservaEntities();
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
    
    public Usuario traerUsuarioPorUsername(String usuUsername){
        List<Usuario> myList = usuJPA.findUsuarioEntities();
            for (Usuario usu : myList){
                if(usu.getUsername().equals(usuUsername)){
                    return usu;
                }     
        } return null;
    }    
}
