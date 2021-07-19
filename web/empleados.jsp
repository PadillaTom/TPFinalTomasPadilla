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
                    <input type="submit" class="emp-addEmp formBtn" value="Nuevo Empleado" id="displayAddEmpForm"  onclick="showForm();" />
                </div>
                    
                <!--*** Add Empleado ***-->
                <div class="emp-addEmpHiddenForm" id="empForm">
                    <form class="emp-addEmpForm" action="" method="POST">
                        <div class="res-formCenter">
                            <div class="res-formSection">
                                <div class="res-formTitle">
                                    <h3>
                                        Nuevo Empleado
                                    </h3>
                                    <p>Ingresar los datos del nuevo empleado.</p>
                                </div> 
                                <div class="res-formInputsContainer res-facturacionContainer">
                                    <div class="res-factSingleInput">
                                        <label for="empUsername">
                                            Usuario:
                                        </label>
                                        <input type="text" name="empUsername" />
                                    </div>
                                    <div class="res-factSingleInput">
                                        <label for="empPassword">
                                            Contraseña:
                                        </label>
                                        <input type="text" name="empPassword" />
                                    </div>
                                    <div class="res-factSingleInput">
                                        <label for="empDni">
                                            DNI:
                                        </label>
                                        <input type="text" name="empDNI" />
                                    </div>
                                    <div class="res-factSingleInput">
                                        <label for="empNombre">
                                            Nombre:
                                        </label>
                                        <input type="text" name="empNombre" />
                                    </div>
                                    <div class="res-factSingleInput">
                                        <label for="empApellido">
                                            Apellido:
                                        </label>
                                        <input type="text" name="empApellido" />
                                    </div>
                                    <div class="res-factSingleInput">
                                        <label for="empFechaNac">
                                            Fecha Nac:
                                        </label>
                                        <input type="text" name="empFechaNac" />
                                    </div>
                                    <div class="res-factSingleInput">
                                        <label for="empDireccion">
                                            Direccion:
                                        </label>
                                        <input type="text" name="empDireccion" />
                                    </div>
                                    <div class="res-factSingleInput">
                                        <label for="empCargo">
                                            Cargo:
                                        </label>
                                        <input type="text" name="empCargo" />
                                    </div>
                                </div>
                            </div>
                            <div class="emp-addEmpFormBtns">
                                <input type="submit" value="Agregar" class="formBtn" />
                                <input type="submit" value="Anular" class="formBtn cancelBtn" onclick="preventDefault(); hideForm();" />
                            </div>
                        </div>
                    </form>
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
                                    <img  class="emp-tableIcon" src="./assets/Icons/deleteEmp.png" alt="Editar Empleado" />
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </section>
        <script>
            const displayAddEmpForm = document.getElementById("displayAddEmpForm");
            const hideAddEmpForm = document.getElementById("hideAddEmpForm");
            const empForm = document.getElementById("empForm");
            
            function showForm() {
                empForm.style.display = "grid";                
            }            
            function hideForm() {
                empForm.
                empForm.style.display = "none";
            }           
        </script>
    </body>
</html>
