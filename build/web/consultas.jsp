<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Logica.*, java.util.*, java.text.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/mc-datepicker/dist/mc-calendar.min.css" rel="stylesheet" />
        <script src="https://cdn.jsdelivr.net/npm/mc-datepicker/dist/mc-calendar.min.js"></script>
        <link rel="stylesheet" href="./assets/CSS/styles.css" type="text/css" />
        <title>Mi Hotel - Consultas</title>
    </head>
    <body>
    <%
        HttpSession mySess = request.getSession();
        String myUsu = (String)mySess.getAttribute("usuUsername");
        if(myUsu == null){
            response.sendRedirect("index.jsp");
        }
    %>
        <!-- *** Navigation *** -->
        <nav class="navigationContainer">
            <div class="navigationCenter">
                
                <div class="nav-logoContainer">
                    <h1>Mi Hotel</h1>
                </div>
                <div class="nav-linksContainer">
                    <ul class="nav-links">
                        <li class="nav-singleLink">
                            <a href="dashboard.jsp">
                                Inicio
                            </a>
                        </li>
                        <li class="nav-singleLink">
                            <a href="reservas.jsp">
                                Reservas
                            </a>
                        </li>
                        <li class="nav-singleLink nav-linkActivo">
                            <a href="consultas.jsp">
                                Consultas
                            </a>
                        </li>
                        <li class="nav-singleLink">
                            <a href="empleados.jsp">
                                Empleados
                            </a>
                        </li>
                        <li class="nav-singleLink singleLink-logout">
                            <a href="SvLogout">
                                Cerrar Sesión
                            </a>
                        </li>
                    </ul>
                </div>
                
            </div>
        </nav>
        
        <!-- *** Seccion Principal *** -->        
        <section class="section main-sect">
            <h1 class="section-title">
                Consultas
            </h1>
            
            <!--*** Menu ***-->
            <div class="cons-filterMenu">
                <ul>
                    <li>
                        Res. por Fecha
                    </li>
                    <li>
                        Res. por Empleado
                    </li>
                    <li>
                        Lista Huespedes
                    </li>
                    <li>
                        Res. por Huesped y Fechas
                    </li>
                </ul>
            </div>
            
            <!--*** Main Screen ***-->
            <div class="cons-mainScreenContainer">
                
                <!--*** Single Screen ***-->
                <div class="cons-singleScreen" id="screenResPorFecha">
                    <div class="singleScreen-description">
                        <h1>Reservas Por Fecha</h1>
                        <h3>
                            Seleccionar una fecha para mostrar todas las Reservas cargadas dicho dia.
                        </h3>
                    </div>
                    <div class="singleScreen-buscador">
                        <form action="SvConsResPorFecha" method="GET" >
                            <div class="res-factSingleInput">
                                <label for="buscador">Fecha: </label>
                                <input id="datepicker" type="text" required="true" name="buscador" placeholder="Calendario" style="background: none; text-align:center;">
                            </div>
                            <div class="login-formButtons">
                                <input type="submit" class="formBtn" value="Buscar" />
                            </div>
                        </form>
                    </div>
                    <div class="singleScreen-resultsContainer">
                        <div class="section-title-underline"></div>
                        <h2>Resultados</h2>
                        
                        <div class="emp-tableContainer">
                            <table>
                                <thead>
                                    <tr>
                                      <th>ID Reserva</th>
                                      <th>Check-in</th>
                                      <th>Check-out</th>
                                      <th>Habitacion</th>
                                      <th>N° Huespedes</th>
                                      <th>Huesped Dni</th>
                                      <th>Huesped</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <% 
                                    String datePattern = "dd/MM/yyyy";                                
                                    SimpleDateFormat dateFormatter = new SimpleDateFormat(datePattern); 
                                    List<Reserva> misReservas = (List) mySess.getAttribute("listaResPorFecha");
                                    if (misReservas != null){
                                    System.out.println(misReservas);
                                        for(Reserva res : misReservas) {
                                            Date dateString = res.getFechaDeCarga();
                                            String resDate = dateFormatter.format(dateString);
                                    %>
                                    <tr>
                                        <td>
                                           <%= res.getId_reserva() %>
                                        </td>
                                        <td>
                                            asd
                                        </td>
                                        <td>
                                            asd
                                        </td>
                                        <td>
                                            asd
                                        </td>
                                        <td>
                                            asd
                                        </td>
                                        <td>
                                            asd
                                        </td>
                                        <td>
                                            asd
                                        </td>
                                    </tr>
                                    <% 
                                        }}
                                    %>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
                
                <!--*** Single Screen ***-->
                <div class="cons-singleScreen" id="screenResPorEmpleado">
                    
                </div>
                
                <!--*** Single Screen ***-->
                <div class="cons-singleScreen" id="screenListaHuespedes">
                    
                </div>
                
                <!--*** Single Screen ***-->
                <div class="cons-singleScreen" id="screenResPorHuesyFechas">
                    
                </div>
                
            </div>
        </section>
        <script>
            // Date Picker DE:
            const picker1 = MCDatepicker.create({
                el: '#datepicker',
                dateFormat: 'dd-mm-yyyy',
                customWeekDays: ['Domingo', 'Lunes', 'Martes', 'Miercoles', 'Jueves', 'Viernes', 'Sabado'],
                customMonths: [
                  'Enero',
                  'Febrero',
                  'Marzo',
                  'Abril',
                  'Mayo',
                  'Junio',
                  'Julio',
                  'Agosto',
                  'Sept.',
                  'Oct.',
                  'Nov.',
                  'Dic.',
                ],
                customClearBTN: "Borrar",
                customCancelBTN: "Anular",
            });
        </script>
    </body>
</html>
