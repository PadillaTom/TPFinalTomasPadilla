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
            <div class="cons-filterMenu" >
                <ul>
                    <li id="porFecha" class="link cons-active" onclick="activeLink(this);">
                        Res. por Fecha
                    </li>
                    <li id="porEmp" class="link" onclick="activeLink(this);">
                        Res. por Empleado
                    </li>
                    <li id="listaHues" class="link" onclick="activeLink(this);">
                        Lista Huespedes
                    </li>
                    <li id="porHyF" class="link" onclick="activeLink(this);">
                        Res. por Huesped y Fechas
                    </li>
                </ul>
            </div>
            
            <!--*** Main Screen ***-->
            <div class="cons-mainScreenContainer">
                
                <!--*************************-->
                <!--****** POR FECHA ******-->
                <!--*************************-->
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
                            <% 
                                    String datePattern = "dd/MM/yyyy";                                
                                    SimpleDateFormat dateFormatter = new SimpleDateFormat(datePattern); 
                                    
                                    List<Reserva> misReservas = (List) mySess.getAttribute("reservasPorFecha");
//                                    System.out.println(misReservas);
                                    if(misReservas != null){
                                        if (misReservas.size() > 0){
                            %>
                            <table>
                                <thead>
                                    <tr>
                                      <th>N° Res</th>
                                      <th>Check-in</th>
                                      <th>Check-out</th>
                                      <th>Habitacion</th>
                                      <th>N° Huespedes</th>
                                      <th>Huesped Dni</th>
                                      <th>Huesped</th>
                                      <th>Empleado</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <%
                                        for(Reserva res : misReservas) {
                                            String resIn = dateFormatter.format(res.getFechaDe());
                                            String resOut = dateFormatter.format(res.getFechaHasta());
                                    %>
                                    <tr>
                                        <td>
                                           <%= res.getId_reserva() %>
                                        </td>
                                        <td>
                                            <%= resIn %>
                                        </td>
                                        <td>
                                            <%= resOut %>
                                        </td>
                                        <td>
                                            <%= res.getResHabitacion().getTipo() %>
                                        </td>
                                        <td>
                                            <%= res.getCantidadPersonas() %>
                                        </td>
                                        <td>
                                            <%= res.getResHuesped().getDniHuesped() %>
                                        </td>
                                        <td>
                                            <%= res.getResHuesped().getNombreCompletoHuesped() %>
                                        </td>
                                        <td>
                                            <%= res.getResUsuario().getUsuEmpleado().getNombreEmpleado() %>
                                        </td>
                                    </tr>
                                    <% } %>                                    
                                    <% } else { %> 
                                    <h3 class="buscador-notFound">No se encuentran Reservas para la fecha seleccionada.</h2>
                                    <% } } %>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
                
                <!--*************************-->
                <!--****** POR EMPLEADO ******-->
                <!--*************************-->
                <div class="cons-singleScreen" id="screenResPorEmpleado">
                    <div class="singleScreen-description">
                        <h1>Reservas Por Empleado</h1>
                        <h3>
                            Ingresar el DNI de un Empleado para obtener sus Reservas.
                        </h3>
                    </div>
                    <div class="singleScreen-buscador">
                        <form action="SvConsResPorEmpleado" method="GET" id="formEmpleadosID">
                            <div class="res-factSingleInput">
                                <label for="buscador">DNI Empelado: </label>
                                <input type="text" required="true" name="buscador"  style="background: none; text-align:center;">
                            </div>
                            <div class="login-formButtons">
                                <input type="submit" class="formBtn" value="Buscar" />
                            </div>
                        </form>
                    </div>
                    <div class="singleScreen-resultsContainer">
                        <div class="section-title-underline"></div>
                        <h2>Resultados</h2>
                        
                        <div class="emp-tableContainer" id="empContent">
                        </div>
                        
                    </div>
                </div>
                
                <!--*************************-->
                <!--****** LISTA HUESPEDES ******-->
                <!--*************************-->
                <div class="cons-singleScreen" id="screenListaHuespedes">
                    <div class="singleScreen-description">
                        <h1>Lista de Huespedes</h1>
                        <h3>
                            Lista de todos los huespedes ingresados en el sistema.
                        </h3>
                    </div>
                    <div class="singleScreen-buscador">
                        <form action="SvConsListaHuespedes" method="GET" id="formListHosts">                            
                            <div class="login-formButtons">
                                <input type="submit" class="formBtn" value="Buscar" />
                            </div>
                        </form>
                    </div>
                    <div class="singleScreen-resultsContainer" style="margin-top: -5rem;">
                        <div class="section-title-underline"></div>
                        <h2>Resultados</h2>  
                        
                        <div class="emp-tableContainer" id="huesContent">                           
                        </div>
                        
                    </div>
                </div>
                
                <!--*************************-->
                <!--***** POR HUESy FECHA *****-->
                <!--*************************-->
                <div class="cons-singleScreen" id="screenResPorHuesyFechas">
                    <div class="singleScreen-description">
                        <h1>Reservas Por Huesped y Fechas</h1>
                        <h3>
                            Ingresar DNI de Huesped y el rango de Fechas deseadas.
                        </h3>
                    </div> 
                    <div class="singleScreen-buscador">
                        <form action="SvConsPorHyF" method="GET" id="formHyF">
                            <div class="res-factSingleInput">
                                <label for="buscador">DNI Huesped </label>
                                <input type="text" required="true" name="hues-dni"  style="background: none; text-align:center;">
                            </div>
                            <div style="margin: 1rem 0rem;" >
                                <div class="res-formTitle">
                                    <h3>
                                        Fechas 
                                    </h3>
                                    <p>Ingresar fechas de Check-in y Check-out.</p>
                                </div> 
                                <div class="datePickerBtnsContainer" style="display: flex; align-items: center; justify-content: space-between; width: 100%;">
                                    <input id="datepickerDeHF" type="text" class="datePickerBtn" placeholder="De" name="res-fechaDe" required="true" style="margin: 0rem 0.7rem;">
                                    <input id="datepickerHastaHF" type="text" class="datePickerBtn" placeholder="Hasta" name="res-fechaHasta" required="true" style="margin: 0rem 0.7rem;">
                                </div>
                            </div>
                            <div class="login-formButtons">
                                <input type="submit" class="formBtn" value="Buscar" />
                            </div>
                        </form>
                    </div>
                    <div class="singleScreen-resultsContainer" style="margin-top: 5rem;">
                        <div class="section-title-underline"></div>
                        <h2>Resultados</h2>  
                        
                        <div class="emp-tableContainer" id="HFContent">                           
                        </div>                        
                    </div>
                </div>
                
            </div>
        </section>                              
                                
        <script
            src="https://code.jquery.com/jquery-3.6.0.min.js"
            integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="
            crossorigin="anonymous">            
        </script>
        
        <!--*** EMPLEADOS ***-->
        <script type="text/javascript">
            var formEmp = $('#formEmpleadosID');
            formEmp.submit(function (event) {
                event.preventDefault();
                $.ajax({
                type: formEmp.attr('method'),
                url: formEmp.attr('action'),
                data: formEmp.serialize(),
                success: function (data) {
                    var result=data;
                    $('#empContent').html(result);
                    }             
                });
                return false;
            }); 
        </script>
        
        <!--*** HUESPEDES ***-->
        <script type="text/javascript">
            var formHues = $('#formListHosts');
            formHues.submit(function (event) {
                event.preventDefault();
                $.ajax({
                type: formHues.attr('method'),
                url: formHues.attr('action'),
                data: formHues.serialize(),
                success: function (data) {
                    var result=data;
                    $('#huesContent').html(result);
                    }             
                });
                return false;
            }); 
        </script>
        
        <!--*** HyF ***-->
        <script type="text/javascript">
            var formHF = $('#formHyF');
            formHF.submit(function (event) {
                event.preventDefault();
                $.ajax({
                type: formHF.attr('method'),
                url: formHF.attr('action'),
                data: formHF.serialize(),
                success: function (data) {
                    var result=data;
                    $('#HFContent').html(result);
                    }             
                });
                return false;
            }); 
        </script>
        
        <!--*** DATE PICKER ***-->
        <script>
            // Date Picker DE:
            const picker1 = MCDatepicker.create({
                el: '#datepicker',
                dateFormat: 'dd-MM-yyyy',
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
            
            // Active Menu:
            let myFormFec = document.getElementById("screenResPorFecha");
            let myFormEmp = document.getElementById("screenResPorEmpleado");
            let myFormHues = document.getElementById("screenListaHuespedes");
            let myFormHyF = document.getElementById("screenResPorHuesyFechas");
            myFormEmp.style.display = "none";                         
            myFormHues.style.display = "none";                         
            myFormHyF.style.display = "none"; 
            function activeLink(id){
                const allLinks = document.getElementsByClassName("link");                
                let myLink = document.getElementById(id.id);
                
                for(i = 0 ; i < allLinks.length; i++){
                    if(allLinks[i].id !== myLink.id){
                        allLinks[i].classList.remove("cons-active");
                    } else { 
                        myLink.classList.add("cons-active");

                        if(myLink.id === "porFecha"){
                            myFormEmp.style.display = "none";                         
                            myFormHues.style.display = "none";                         
                            myFormHyF.style.display = "none"; 
                            myFormFec.style.display = "block";
                        }
                        if(myLink.id === "porEmp") {
                            myFormFec.style.display = "none";                         
                            myFormHues.style.display = "none";                         
                            myFormHyF.style.display = "none"; 
                            myFormEmp.style.display = "block";
                        }
                        if(myLink.id === "listaHues") {
                            myFormFec.style.display = "none";                         
                            myFormEmp.style.display = "none";                         
                            myFormHyF.style.display = "none"; 
                            myFormHues.style.display = "block";
                        }
                        if(myLink.id === "porHyF") {
                            myFormFec.style.display = "none";                         
                            myFormHues.style.display = "none";                         
                            myFormEmp.style.display = "none"; 
                            myFormHyF.style.display = "block";
                        }
                    }
                }                
            }
            
            // DatePicker DeHF:
            const picker2 = MCDatepicker.create({
                el: '#datepickerDeHF',
                dateFormat: 'dd-MM-yyyy',
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
            // Date Picker HastaHF:
            const picker3 = MCDatepicker.create({
                el: '#datepickerHastaHF',
                dateFormat: 'dd-MM-yyyy',
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
