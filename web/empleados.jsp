<%-- 
    Document   : Empleados
    Created on : 17 Jul 2021, 11:38:43
    Author     : padillatom
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="./assets/CSS/styles.css" type="text/css" />
        <title>Mi Hotel - Empleados</title>
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
                        <li class="nav-singleLink nav-linkActivo">
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
                Lista de Empleados
            </h1>
            <div class="emp-mainCenter">                
                <div class="section-title-underline"></div>

                <!--*** Add Empleado ***-->
                <div class="emp-currentSession">
                    <h1>
                        Usuario Actual: <span> <%= session.getAttribute("username") %> </span>
                    </h1>
                </div>
                <div class="emp-addEmpContainer">
                    <input type="submit" class="emp-addEmp formBtn" value="Nuevo Empleado" />
                </div>
                    
                <!--*** Table ***-->
                <div class="emp-tableContainer">
                    <table>
                        <thead>
                            <tr>
                              <th>Usuario</th>
                              <th>Contraseña</th>
                              <th>DNI</th>
                              <th>Nombre</th>
                              <th>Apellido</th>
                              <th>Fecha de Nac.</th>
                              <th>Direccion</th>
                              <th>Cargo</th>
                              <th>Acciones</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>TomasPadilla</td>
                                <td>Password</td>
                                <td>35161922</td>
                                <td>Tomas</td>
                                <td>Padilla</td>
                                <td>26/09/1989</td>
                                <td>288 Chemin de la Ramasse</td>
                                <td>Jefe</td>
                                <td class="emp-tableIconsContainer">
                                    <img  class="emp-tableIcon" src="./assets/Icons/editEmp.png" alt="Editar Empleado"/>
                                    <img  class="emp-tableIcon" src="./assets/Icons/deleteEmp.png" alt="Editar Empleado"/>
                                </td>
                            </tr>
                            <tr>
                                <td>TomasPadilla</td>
                                <td>Password</td>
                                <td>35161922</td>
                                <td>Tomas</td>
                                <td>Padilla</td>
                                <td>26/09/1989</td>
                                <td>288 Chemin de la Ramasse</td>
                                <td>Jefe</td>
                                <td class="emp-tableIconsContainer">
                                    <img  class="emp-tableIcon" src="./assets/Icons/editEmp.png" alt="Editar Empleado"/>
                                    <img  class="emp-tableIcon" src="./assets/Icons/deleteEmp.png" alt="Editar Empleado"/>
                                </td>
                            </tr>
                            <tr>
                                <td>TomasPadilla</td>
                                <td>Password</td>
                                <td>35161922</td>
                                <td>Tomas</td>
                                <td>Padilla</td>
                                <td>26/09/1989</td>
                                <td>288 Chemin de la Ramasse</td>
                                <td>Jefe</td>
                                <td class="emp-tableIconsContainer">
                                    <img  class="emp-tableIcon" src="./assets/Icons/editEmp.png" alt="Editar Empleado"/>
                                    <img  class="emp-tableIcon" src="./assets/Icons/deleteEmp.png" alt="Editar Empleado"/>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </div>
                    
            </div>
        </section>
    </body>
</html>
