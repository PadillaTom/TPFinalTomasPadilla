package Logica;

import Logica.Reserva;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2021-08-12T17:46:44")
@StaticMetamodel(Huesped.class)
public class Huesped_ { 

    public static volatile ListAttribute<Huesped, Reserva> huesReserva;
    public static volatile SingularAttribute<Huesped, String> apellidoHuesped;
    public static volatile SingularAttribute<Huesped, String> profesionHuesped;
    public static volatile SingularAttribute<Huesped, String> dniHuesped;
    public static volatile SingularAttribute<Huesped, String> nombreHuesped;
    public static volatile SingularAttribute<Huesped, String> direccionHuesped;
    public static volatile SingularAttribute<Huesped, Date> fechaNacHuesped;
    public static volatile SingularAttribute<Huesped, Integer> id_huesped;

}