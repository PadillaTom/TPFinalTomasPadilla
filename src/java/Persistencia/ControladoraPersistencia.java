package Persistencia;

import Logica.Empleado;
import Logica.Habitacion;
import Logica.Huesped;
import Logica.Reserva;
import Logica.Usuario;
import Persistencia.exceptions.NonexistentEntityException;
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
 
    // Borrar:
    public void borrarEmpYUsu(int idEmp, int idUsu){
        try {
            usuJPA.destroy(idUsu);
            empJPA.destroy(idEmp);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    // Editar:
    public void modificarEmpleado(Usuario usu, Empleado emple){
        try {
            usuJPA.edit(usu);
            empJPA.edit(emple);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //::::::::::::::::::::::::
    //:::::: Habitacion ::::::
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
    // Borrar:
    public void borrarHuesped(int hues){
        try {
            huesJPA.destroy(hues);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
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
    
    public Reserva traerResPorId(int id){
        return resJPA.findReserva(id);
    }
    // Modificacion:
    public void modifResDirecto(Reserva res, Huesped hues){
        try {
            huesJPA.edit(hues);            
            resJPA.edit(res);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void modifReserva(Reserva res){
        try {            
            resJPA.edit(res);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    // Borrar:
    public void borrarRes(int id){
        try {
            resJPA.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //::::::::::::::::::::::::
    //::::::: Usuario ::::::::
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
