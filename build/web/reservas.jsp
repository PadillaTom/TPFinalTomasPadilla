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
                            </div> 
                            <div class="res-formInputsContainer">
                                <div class="res-singleInput">
                                    <label for="habitaciones">Habitacion:</label>
                                    <select class="res-select" name="habitaciones">
                                        <option value="single">Single Room</option>
                                        <option value="double">Double Room</option>
                                        <option value="triple">Triple Room</option>
                                        <option value="multiple">Multiple Room</option>
                                    </select>
                                </div>
                                <div class="res-singleInput">
                                    <p>Fechas</p>
                                </div>
                                <div class="res-singleInput">
                                    <p>Cantidad Huespedes</p>
                                </div>
                            </div>
                        </div>
                        <div class="res-formSection">
                            <div class="res-formTitle">
                                <h3>
                                    Datos de Facturacion
                                </h3>
                            </div> 
                            <div class="res-formInputsContainer">
                                <div class="res-singleInput">
                                    <label for="name">
                                        Nombre
                                    </label>
                                    <input type="text" name="name" />
                                </div>
                                <div class="res-singleInput">
                                    <label for="lastName">
                                        Apellido
                                    </label>
                                    <input type="text" name="lastName" />
                                </div>
                                <div class="res-singleInput">
                                    <label for="fechaNac">
                                        Fecha Nac
                                    </label>
                                    <input type="text" name="fechaNac" />
                                </div>
                                <div class="res-singleInput">
                                    <label for="direccion">
                                        Direccion
                                    </label>
                                    <input type="text" name="direccion" />
                                </div>
                                <div class="res-singleInput">
                                    <label for="profesion">
                                        Profesion
                                    </label>
                                    <input type="text" name="profesion" />
                                </div>
                            </div>
                        </div>
                        <div class="res-formBtnContainer">
                            <input type="submit" value="Guardar" />
                        </div>
                    </div>
                </form>
            </div>
            
        </section>
    </body>
</html>
