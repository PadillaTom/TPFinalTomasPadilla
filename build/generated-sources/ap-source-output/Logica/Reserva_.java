package Logica;

import Logica.Habitacion;
import Logica.Huesped;
import Logica.Usuario;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2021-08-12T16:11:20")
@StaticMetamodel(Reserva.class)
public class Reserva_ { 

    public static volatile SingularAttribute<Reserva, Date> fechaHasta;
    public static volatile SingularAttribute<Reserva, Date> fechaDe;
    public static volatile SingularAttribute<Reserva, Usuario> resUsuario;
    public static volatile SingularAttribute<Reserva, Date> fechaDeCarga;
    public static volatile SingularAttribute<Reserva, Integer> cantidadPersonas;
    public static volatile SingularAttribute<Reserva, Integer> cantidadNoches;
    public static volatile SingularAttribute<Reserva, Habitacion> resHabitacion;
    public static volatile SingularAttribute<Reserva, Integer> id_reserva;
    public static volatile SingularAttribute<Reserva, Double> precioTotal;
    public static volatile SingularAttribute<Reserva, Huesped> resHuesped;

}