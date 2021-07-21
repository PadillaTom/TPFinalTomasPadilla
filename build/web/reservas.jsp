<%-- 
    Document   : reservas
    Created on : 17 Jul 2021, 11:34:26
    Author     : padillatom
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/mc-datepicker/dist/mc-calendar.min.css" rel="stylesheet" />
        <script src="https://cdn.jsdelivr.net/npm/mc-datepicker/dist/mc-calendar.min.js"></script>
        <link rel="stylesheet" href="./assets/CSS/styles.css" type="text/css" />
        <title>Mi Hotel - Reservas</title>
    </head>
    <body>
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
                        <li class="nav-singleLink nav-linkActivo">
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
                        <li class="nav-singleLink">
                            <a href="index.jsp">
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
                Cargar Nueva Reserva
            </h1>
            
            <!--*** Formulario ***-->
            <div class="res-formContainer">
                <form action="reservas.jsp" method="POST">
                    <div class="res-formCenter">
                        <div class="res-formSection">
                            <div class="res-formTitle">
                                <h3>
                                    Habitacion 
                                </h3>
                                <p>Seleccionar el Tipo de Habitacion y Cantidad de Huespedes.</p>
                            </div> 
                            <div class="res-formInputsContainer">
                                <div class="res-formInputsTop">  
                                    <div class="res-singleInput">
                                        <label for="habitaciones">Habitacion </label>
                                        <select class="res-select" name="habitaciones" id="res-habSelect" onchange="getHabitacion();" required="true">
                                            <option value="single">Single Room</option>
                                            <option value="double">Double Room</option>
                                            <option value="triple">Triple Room</option>
                                            <option value="multiple">Multiple Room</option>
                                        </select>
                                    </div>                                
                                    <div class="res-singleInput">
                                        <label for="cantPers">Cantidad de Personas </label>
                                        <select class="res-select" name="cantPers" required="true">
                                            <option value="1per" id="1per">1</option>
                                            <option value="2pre" id="2per">2</option>
                                            <option value="3per" id="3per">3</option>
                                            <option value="4per" id="4per">4</option>
                                            <option value="5per" id="5per">5</option>
                                            <option value="6per" id="6per">6</option>
                                        </select> 
                                    </div>
                                </div>
                                <div class="res-fechasContainer">
                                    <div class="res-formTitle">
                                        <h3>
                                            Fechas 
                                        </h3>
                                        <p>Ingresar fechas de Check-in y Check-out.</p>
                                    </div> 
                                    <div class="datePickerBtnsContainer">
                                        <input id="datepickerDe" type="text" class="datePickerBtn" placeholder="De" name="resFechaDe" required="true">
                                        <input id="datepickerHasta" type="text" class="datePickerBtn" placeholder="Hasta" name="resFechaHasta" required="true" >
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="res-formSection">
                            <div class="res-formTitle">
                                <h3>
                                    Datos de Facturacion
                                </h3>
                                <p>Ingresar los datos proporcionados por el Huesped.</p>
                            </div> 
                            <div class="res-formInputsContainer res-facturacionContainer">
                                <div class="res-factSingleInput">
                                    <label for="name">
                                        Nombre:
                                    </label>
                                    <input type="text" name="name" required="true" />
                                </div>
                                <div class="res-factSingleInput">
                                    <label for="lastName">
                                        Apellido:
                                    </label>
                                    <input type="text" name="lastName" required="true" />
                                </div>
                                <div class="res-factSingleInput">
                                    <label for="fechaNac">
                                        Fecha Nac:
                                    </label>
                                    <input type="text" name="fechaNac" id="datepickerFechaNac" required="true" placeholder="Seleccionar Fecha" />
                                </div>
                                <div class="res-factSingleInput">
                                    <label for="direccion">
                                        Direccion:
                                    </label>
                                    <input type="text" name="direccion" required="true"/>
                                </div>
                                <div class="res-factSingleInput">
                                    <label for="profesion">
                                        Profesion:
                                    </label>
                                    <input type="text" name="profesion" required="true" />
                                </div>
                            </div>
                        </div>
                        <div class="res-formBtnContainer">
                            <input type="submit" value="Guardar" class="formBtn" />
                        </div>
                    </div>
                </form>
            </div>            
        </section>
        
        <!--*** JAVASCRIPT ***-->
        <script src="./assets/JS/main.js"></script>
        <script>
            // Date Picker DE:
            const picker1 = MCDatepicker.create({
                el: '#datepickerDe',
                dateFormat: 'dd-mmmm-yyyy',
                minDate: new Date(),
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
                  'Septiembre',
                  'Octubre',
                  'Noviembre',
                  'Diciembre',
                ],
                customClearBTN: "Borrar",
                customCancelBTN: "Anular",
            });
            let picker2;
            picker1.onSelect((date)=> { 
                var myMin = new Date(date);
                myMin.setDate(date.getDate() + 1);
                // Date Picker HASTA:
                picker2 = MCDatepicker.create({
                el: '#datepickerHasta',
                minDate: myMin,
                dateFormat: 'dd-mmmm-yyyy',
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
                      'Septiembre',
                      'Octubre',
                      'Noviembre',
                      'Diciembre',
                    ],
                customClearBTN: "Borrar",
                customCancelBTN: "Anular",
            })
        });
        //  Date Picker FECHANAC:
        const picker3 = MCDatepicker.create({
                el: '#datepickerFechaNac',
                dateFormat: 'dd-mmmm-yyyy',
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
                  'Septiembre',
                  'Octubre',
                  'Noviembre',
                  'Diciembre',
                ],
                customClearBTN: "Borrar",
                customCancelBTN: "Anular",
            });

        </script>
    </body>
</html>
