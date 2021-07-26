package Logica;

public class Controladora {
    // ::: Controladora Persistencia :::

    // ::: Habitaciones :::
        // =Crear Habitacion=
            // Crear HC
            // Recibe de Servlet: NADA
    
    // ::: Huespedes :::
        // =Buscar Huespedes=
    
    // ::: Empleados :::
        // =Crear Empleado=
            // Recibe de Servlet:
                // empUsername, empPassword, empDni, empNombre, empApellido, empFechaNac, empDireccion, empCargo
            // String to Date
            // Crear Objeto Usuario -> setUsuario(Objeto);
    
        // =Buscar Empleados=
    
    
    // ::: Reservas :::
        // =Crear Reservas=
            // Recibe de Servlet: 
                // res-tipoHabitacion, res-cantPersonas, res-fechaDe, res-fechaHasta
                // hues-huesDni, hues-huesNombre, hues-huesApellido, hues-huesFechaNac, hues-huesDireccion, hues-huesProfesion
            // String to Date
            // Calcular Noches
            // Find Habitacion por res-tipoHabitacion -> setHabitacion(Objeto);
            // Find Huesped por hues-huesDni  IFNOT new Huesped() -> setHuesped(Objeto);
            // Find Empleado por Inicio Sesion -> setEmpleado(Objeto);
    
        // =Buscar Reservas=
    
}
