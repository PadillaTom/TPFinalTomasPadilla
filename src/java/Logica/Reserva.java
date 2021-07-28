package Logica;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;

@Entity
public class Reserva implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id_reserva;
    
    @Basic 
    @Temporal(javax.persistence.TemporalType.DATE)
    Date fechaDe;
    @Temporal(javax.persistence.TemporalType.DATE)
    Date fechaHasta;
    @Temporal(javax.persistence.TemporalType.DATE)
    Date fechaDeCarga;
    int cantidadNoches;
    double precioTotal;
    
    // One Huesped:
    @OneToOne
    Huesped resHuesped;
    
    // ManyToOne Empleados:
    @ManyToOne
    Empleado resEmpleado;
    
    // ManyToOne Habitacion:
    @ManyToOne
    Habitacion resHabitacion;

    public Reserva() {
    }

    public Reserva(int id_reserva, Date fechaDe, Date fechaHasta, int cantidadNoches, double precioTotal, Huesped resHuesped, Empleado resEmpleado, Habitacion resHabitacion) {
        this.id_reserva = id_reserva;
        this.fechaDe = fechaDe;
        this.fechaHasta = fechaHasta;
        this.cantidadNoches = cantidadNoches;
        this.precioTotal = precioTotal;
        this.resHuesped = resHuesped;
        this.resEmpleado = resEmpleado;
        this.resHabitacion = resHabitacion;
    }

    public int getId_reserva() {
        return id_reserva;
    }

    public void setId_reserva(int id_reserva) {
        this.id_reserva = id_reserva;
    }

    public Date getFechaDe() {
        return fechaDe;
    }

    public void setFechaDe(Date fechaDe) {
        this.fechaDe = fechaDe;
    }

    public Date getFechaHasta() {
        return fechaHasta;
    }

    public void setFechaHasta(Date fechaHasta) {
        this.fechaHasta = fechaHasta;
    }

    public int getCantidadNoches() {
        return cantidadNoches;
    }

    public void setCantidadNoches(int cantidadNoches) {
        this.cantidadNoches = cantidadNoches;
    }

    public double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(double precioTotal) {
        this.precioTotal = precioTotal;
    }

    public Huesped getResHuesped() {
        return resHuesped;
    }

    public void setResHuesped(Huesped resHuesped) {
        this.resHuesped = resHuesped;
    }

    public Empleado getResEmpleado() {
        return resEmpleado;
    }

    public void setResEmpleado(Empleado resEmpleado) {
        this.resEmpleado = resEmpleado;
    }

    public Habitacion getResHabitacion() {
        return resHabitacion;
    }

    public void setResHabitacion(Habitacion resHabitacion) {
        this.resHabitacion = resHabitacion;
    }
    
}
