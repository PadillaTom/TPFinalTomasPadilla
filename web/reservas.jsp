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
                <form action="formEnviado.jsp" method="POST">
                    <div class="res-formCenter">
                        <div class="res-formSection">
                            <div class="res-formTitle">
                                <h3>
                                    Habitacion 
                                </h3>
                                <p>Seleccionar el tipo de Habitacion, Cantidad de personas y Fechas solicitadas por el huesped.</p>
                            </div> 
                            <div class="res-formInputsContainer">
                                <div class="res-formInputsTop">  
                                    <div class="res-singleInput">
                                        <label for="habitaciones">Habitacion </label>
                                        <select class="res-select" name="habitaciones" id="res-habSelect" onchange="getHabitacion();">
                                            <option value="single">Single Room</option>
                                            <option value="double">Double Room</option>
                                            <option value="triple">Triple Room</option>
                                            <option value="multiple">Multiple Room</option>
                                        </select>
                                    </div>                                
                                    <div class="res-singleInput">
                                        <label for="cantPers">Cantidad de Personas </label>
                                        <select class="res-select" name="cantPers">
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
                                    <p>Fechas</p>
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
                                    <input type="text" name="name" />
                                </div>
                                <div class="res-factSingleInput">
                                    <label for="lastName">
                                        Apellido:
                                    </label>
                                    <input type="text" name="lastName" />
                                </div>
                                <div class="res-factSingleInput">
                                    <label for="fechaNac">
                                        Fecha Nac:
                                    </label>
                                    <input type="text" name="fechaNac" />
                                </div>
                                <div class="res-factSingleInput">
                                    <label for="direccion">
                                        Direccion:
                                    </label>
                                    <input type="text" name="direccion" />
                                </div>
                                <div class="res-factSingleInput">
                                    <label for="profesion">
                                        Profesion:
                                    </label>
                                    <input type="text" name="profesion" />
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
        <script>
            function getHabitacion(){
                var habitacionElegida = document.getElementById("res-habSelect").value;
                
                if(habitacionElegida === "single") {
                    document.getElementById("2per").style.display = "none";
                    document.getElementById("3per").style.display = "none";
                    document.getElementById("4per").style.display = "none";
                    document.getElementById("5per").style.display = "none";
                    document.getElementById("6per").style.display = "none";
                    
                } else if (habitacionElegida === "double"){
                    document.getElementById("2per").style.display = "block";
                    document.getElementById("3per").style.display = "none";
                    document.getElementById("4per").style.display = "none";
                    document.getElementById("5per").style.display = "none";
                    document.getElementById("6per").style.display = "none";
                    
                } else if (habitacionElegida === "triple") {
                    document.getElementById("2per").style.display = "block";
                    document.getElementById("3per").style.display = "block";
                    document.getElementById("4per").style.display = "none";
                    document.getElementById("5per").style.display = "none";
                    document.getElementById("6per").style.display = "none";
                    
                } else if (habitacionElegida === "multiple") {
                    document.getElementById("2per").style.display = "block";
                    document.getElementById("3per").style.display = "block";
                    document.getElementById("4per").style.display = "block";
                    document.getElementById("5per").style.display = "block";
                    document.getElementById("6per").style.display = "block";
                }
            };
            getHabitacion();
        </script>
    </body>
</html>
