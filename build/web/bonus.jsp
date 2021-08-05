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
                        <li class="nav-singleLink">
                            <a href="consultas.jsp">
                                Consultas
                            </a>
                        </li>
                        <li class="nav-singleLink">
                            <a href="empleados.jsp">
                                Empleados
                            </a>
                        </li>
                        <li class="nav-singleLink  nav-linkActivo">
                            <a href="bonus.jsp">
                                Bonus
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
                    <li id="porEmpFecha" class="link cons-active" onclick="activeLink(this);">
                        Res. por Empleado y Fecha
                    </li>
                    <li id="ganDiarias" class="link" onclick="activeLink(this);">
                        Ganancias Diarias
                    </li>
                    <li id="ganMensuales" class="link" onclick="activeLink(this);">
                        Ganancias Mensuales
                    </li>
                </ul>
            </div>
            
            <!--*************************-->
            <!--**** POR Emp y Fecha ****-->
            <!--*************************-->
            <div class="cons-singleScreen" id="screenPorEmpleadoFecha">
                <div class="cons-mainScreenContainer" style="padding-bottom: 0;"> 
                    <div class="singleScreen-description">
                        <h1>Reservas Diarias por Empleado</h1>
                        <h3>
                            Ingresar DNI de Empleado y el la Fecha deseada.
                        </h3>
                    </div> 
                    <div class="singleScreen-buscador">
                        <form action="SvConsBonus" method="GET" id="">
                            <div class="res-factSingleInput">
                                <label for="buscador">DNI Empleado </label>
                                <input type="text" required="true" name="hues-dni"  style="background: none; text-align:center;">
                            </div>
                            <div style="margin: 1rem 0rem; margin-bottom: 2rem;" >
                                <div class="res-factSingleInput">
                                    <label for="buscador">Fecha: </label>
                                    <input id="datepickerEmpFecha" type="text" required="true" name="buscador"  style="background: none; text-align:center;">
                                </div>
                            </div>
                            <div class="login-formButtons">
                                <input type="submit" class="formBtn" value="Buscar" />
                            </div>
                        </form>
                    </div>
                    
                    <!--*** Tabla AJAX y armado HTML en Servlet ***-->
                    <div style="margin-top: 5rem;">
                        <div class="emp-tableContainer singleScreen-resultsContainer" id="">                           
                        </div>                        
                    </div>
                    
                </div>
            </div>

            <!--************************-->
            <!--*** Ganancias Diarias ***-->
            <!--************************-->
            <div class="cons-singleScreen" id="screenGanDiarias">
                <div class="cons-mainScreenContainer" style="padding-bottom: 0;"> 
                    <div class="singleScreen-description">
                        <h1>Ganancias Diarias</h1>
                        <h3>
                            Seleccionar Fecha para ver un Resumen de ganancias.
                        </h3>
                    </div>
                    <div class="singleScreen-buscador">
                        <form action="SvConsBonus" method="GET" id="formEmpleadosID">
                            <div class="res-factSingleInput">
                                <label for="buscador">Fecha: </label>
                                <input id="datepickerGanDiarias" type="text" required="true" name="buscador"  style="background: none; text-align:center;">
                            </div>
                            <div class="login-formButtons">
                                <input type="submit" class="formBtn" value="Buscar" />
                            </div>
                        </form>
                    </div>
                    
                    <!--*** Tabla AJAX y armado HTML en Servlet ***-->
                    <div class="emp-tableContainer singleScreen-resultsContainer" id="">
                    </div>
                    
                </div>
            </div>
            
            <!--*************************-->
            <!--*** Ganancias Mensuales ***-->
            <!--*************************-->
            <div class="cons-singleScreen" id="screenGanMensuales">
                <div class="cons-mainScreenContainer" style="padding-bottom: 0;"> 
                    <div class="singleScreen-description">
                        <h1>Ganancias Mensuales</h1>
                        <h3>
                            Seleccionar un mes para obtener un Resumen de las ganancias mensuales.
                        </h3>
                    </div>
                    <div class="singleScreen-buscador" >
                        <form action="SvConsBonus" method="GET" id="formListHosts">                            
                            <div class="login-formButtons">
                                <input type="submit" class="formBtn" value="Buscar" />
                            </div>
                        </form>
                    </div>
                    
                    <!--*** Tabla AJAX y armado HTML en Servlet ***-->
                    <div style="margin-top: -5rem;">
                        <div class="emp-tableContainer singleScreen-resultsContainer" id="">                           
                        </div>
                    </div>
                    
                </div>
            </div>    

            
            
        </section>                              
         
        <!--*** JAVASCRIPT ***-->
        <script
            src="https://code.jquery.com/jquery-3.6.0.min.js"
            integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="
            crossorigin="anonymous">            
        </script>        
        <!--*** Emp y Fecha ***-->
        <script type="text/javascript">
            var formEmp = $('#');
            formEmp.submit(function (event) {
                event.preventDefault();
                $.ajax({
                type: formEmp.attr('method'),
                url: formEmp.attr('action'),
                data: formEmp.serialize(),
                success: function (data) {
                    var result=data;
                    $('#').html(result);
                    }             
                });
                return false;
            }); 
        </script>        
        <!--*** Ganancias Diarias ***-->
        <script type="text/javascript">
            var formHues = $('#');
            formHues.submit(function (event) {
                event.preventDefault();
                $.ajax({
                type: formHues.attr('method'),
                url: formHues.attr('action'),
                data: formHues.serialize(),
                success: function (data) {
                    var result=data;
                    $('#').html(result);
                    }             
                });
                return false;
            }); 
        </script>        
        <!--*** Ganancias Mensuales ***-->
        <script type="text/javascript">
            var formHF = $('#');
            formHF.submit(function (event) {
                event.preventDefault();
                $.ajax({
                type: formHF.attr('method'),
                url: formHF.attr('action'),
                data: formHF.serialize(),
                success: function (data) {
                    var result=data;
                    $('#').html(result);
                    }             
                });
                return false;
            }); 
        </script>
        
        <!--*** DATE PICKER ***-->
        <script>
            // Date Picker: Empleado Fecha
            const pickerEmpFecha = MCDatepicker.create({
                el: '#datepickerEmpFecha',
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
                  'Dic.'
                ],
                customClearBTN: "Borrar",
                customCancelBTN: "Anular"
            });
            
            // Active Menu: NO ME DEJABA IMPORTARLO DE "main.js"
            let myFormEmpFecha = document.getElementById("screenPorEmpleadoFecha");
            let myFormGanDiarias = document.getElementById("screenGanDiarias");
            let myFormGanMensuales = document.getElementById("screenGanMensuales");
            myFormGanDiarias.style.display = "none";                         
            myFormGanMensuales.style.display = "none";       
            function activeLink(id){
                const allLinks = document.getElementsByClassName("link");                
                let myLink = document.getElementById(id.id);
                
                for(i = 0 ; i < allLinks.length; i++){
                    if(allLinks[i].id !== myLink.id){
                        allLinks[i].classList.remove("cons-active");
                    } else { 
                        myLink.classList.add("cons-active");

                        if(myLink.id === "porEmpFecha"){
                            myFormGanDiarias.style.display = "none";                         
                            myFormGanMensuales.style.display = "none";      
                            myFormEmpFecha.style.display = "block";
                        }
                        if(myLink.id === "ganDiarias") {
                           myFormEmpFecha.style.display = "none";                         
                            myFormGanMensuales.style.display = "none";      
                            myFormGanDiarias.style.display = "block";
                        }
                        if(myLink.id === "ganMensuales") {
                            myFormEmpFecha.style.display = "none";                         
                            myFormGanDiarias.style.display = "none";      
                            myFormGanMensuales.style.display = "block";
                        }
                    }
                }                
            };
            
            // Date Picker: Ganancias Diarias
            let pickerGanDiarias = MCDatepicker.create({
                el: '#datepickerGanDiarias',
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
                  'Dic.'
                ],
                customClearBTN: "Borrar",
                customCancelBTN: "Anular"                    
        });
        // Date Picker: Ganancias Mensuales
        let pickerGanMensuales = MCDatepicker.create({
            el: '#datepickerGanMensuales',
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
              'Dic.'
            ],
            customClearBTN: "Borrar",
            customCancelBTN: "Anular"                      
        });
        </script>
    </body>
</html>
