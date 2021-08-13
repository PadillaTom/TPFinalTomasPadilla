package Logica;

import Logica.Reserva;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2021-08-12T17:46:44")
@StaticMetamodel(Habitacion.class)
public class Habitacion_ { 

    public static volatile SingularAttribute<Habitacion, Integer> piso;
    public static volatile SingularAttribute<Habitacion, String> tipo;
    public static volatile ListAttribute<Habitacion, Reserva> habReservas;
    public static volatile SingularAttribute<Habitacion, Integer> id_habitacion;
    public static volatile SingularAttribute<Habitacion, String> nombre;
    public static volatile SingularAttribute<Habitacion, Double> precioPorNoche;

}