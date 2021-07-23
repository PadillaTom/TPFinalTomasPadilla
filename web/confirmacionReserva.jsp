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
        <title>Mi Hotel - Form Enviado</title>
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
            <h1 class="section-title" style="color: green;">
                Reserva cargada con exito!
            </h1>
            <!--*** Formulario ***-->
            <div class="res-formContainer">
                <form>
                    <div class="res-formCenter">
                        <div class="res-formSection">
                            <div class="res-formTitle">
                                <h3>
                                    Reserva 
                                </h3>
                                <p>Habitacion, Cantidad de Personas y Fechas.</p>
                            </div>
                            <div class="res-formInputsContainer res-confirmacionInputsContainer">
                                <div class="res-confSingleInput">
                                    <label>
                                        Habitacion:
                                    </label>
                                    <span>
                                        <%= "Habitacion Simple" %>
                                    </span>
                                </div>
                                <div class="res-confSingleInput">
                                    <label>
                                        Cant. Personas:
                                    </label>
                                    <span>
                                        <%= "5 p." %>
                                    </span>
                                </div>
                                <div class="res-confSingleInput">
                                    <label>
                                        Check-In:
                                    </label>
                                    <span>
                                        <%= "10/09/2021" %>
                                    </span>
                                </div>
                                <div class="res-confSingleInput">
                                    <label>
                                        Check-Out:
                                    </label>
                                    <span>
                                        <%= "15/09/2021" %>
                                    </span>
                                </div>
                            </div>
                        </div>
                        <div class="res-formSection">
                            <div class="res-formTitle">
                                <h3>
                                    Huesped 
                                </h3>
                                <p>Datos Personales del Huesped.</p>
                            </div>
                            <div class="res-formInputsContainer res-confirmacionInputsContainer">
                                <div class="res-confSingleInput">
                                    <label>
                                        DNI:
                                    </label>
                                    <span>
                                        <%= "35161922" %>
                                    </span>
                                </div>
                                <div class="res-confSingleInput">
                                    <label>
                                        Nombre
                                    </label>
                                    <span>
                                        <%= "Nom Hues" %>
                                    </span>
                                </div>
                                <div class="res-confSingleInput">
                                    <label>
                                        Apellido
                                    </label>
                                    <span>
                                        <%= "Apellido Hues" %>
                                    </span>
                                </div>
                                <div class="res-confSingleInput">
                                    <label>
                                        Fecha Nac:
                                    </label>
                                    <span>
                                        <%= "10/10/10" %>
                                    </span>
                                </div>
                                <div class="res-confSingleInput">
                                    <label>
                                        Direccion:
                                    </label>
                                    <span>
                                        <%= "288 Chemin" %>
                                    </span>
                                </div>
                                <div class="res-confSingleInput">
                                    <label>
                                        Profesion:
                                    </label>
                                    <span>
                                        <%= "Profe" %>
                                    </span>
                                </div>
                            </div>
                        </div>
                        <div class="res-formSection">
                            <div class="res-formTitle">
                                <h3>
                                    Precio 
                                </h3>
                                <p>Cantidad de Noches y Precio Total.</p>
                            </div>
                            <div class="res-formInputsContainer res-confirmacionInputsContainer">
                                <div class="res-confSingleInput">
                                    <label>
                                        Total Noches:
                                    </label>
                                    <span>
                                        <%= "5" %> Noches
                                    </span>
                                </div>
                                <div class="res-confSingleInput">
                                    <label>
                                        Precio Estadia:
                                    </label>
                                    <span style="letter-spacing: 1px; color: crimson">
                                        $ <%= "1500" %>.- 
                                    </span>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="res-formSection">
                        <div class="res-formInputsContainer res-confirmacionInputsContainer">
                            <div class="res-confSingleInput" style="justify-content: space-around; width: 50%;">
                                <label>Cargada Por: </label>
                                <span>
                                    <%= "Empleado Apellido" %>
                                </span>
                            </div>
                        </div>
                    </div>
                </form>
            </div>
        </section>
    </body>
</html>
