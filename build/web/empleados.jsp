<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Logica.*, java.util.*, java.text.*" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="./assets/CSS/styles.css" type="text/css" />
        <link href="https://cdn.jsdelivr.net/npm/mc-datepicker/dist/mc-calendar.min.css" rel="stylesheet" />
        <script src="https://cdn.jsdelivr.net/npm/mc-datepicker/dist/mc-calendar.min.js"></script>
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
                    <form class="emp-addEmpForm" action="SvEmpleado" method="POST" id="myEmpForm" >
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
                                        <input type="text" name="empUsername" required="true" />
                                    </div>
                                    <div class="res-factSingleInput">
                                        <label for="empPassword">
                                            Contraseña:
                                        </label>
                                        <input type="text" name="empPassword" required="true" />
                                    </div>
                                    <div class="res-factSingleInput">
                                        <label for="empDni">
                                            DNI:
                                        </label>
                                        <input type="text" name="empDni" required="true" />
                                    </div>
                                    <div class="res-factSingleInput">
                                        <label for="empNombre">
                                            Nombre:
                                        </label>
                                        <input type="text" name="empNombre" required="true" />
                                    </div>
                                    <div class="res-factSingleInput">
                                        <label for="empApellido">
                                            Apellido:
                                        </label>
                                        <input type="text" name="empApellido" required="true" />
                                    </div>
                                    <div class="res-factSingleInput">
                                        <label for="empFechaNac">
                                            Fecha Nac:
                                        </label>
                                        <input type="text" name="empFechaNac" required="true" id="datepickerEmpFechaNac" placeholder="Seleccionar Fecha" />
                                    </div>
                                    <div class="res-factSingleInput">
                                        <label for="empDireccion">
                                            Direccion:
                                        </label>
                                        <input type="text" name="empDireccion" required="true" />
                                    </div>
                                    <div class="res-factSingleInput">
                                        <label for="empCargo">
                                            Cargo:
                                        </label>
                                        <input type="text" name="empCargo" required="true" />
                                    </div>
                                </div>
                            </div>
                            <div class="emp-addEmpFormBtns">
                                <input type="submit" value="Agregar" class="formBtn" />
                                <button type="button" class="formBtn cancelBtn" onclick="hideForm(); borrarCampos();" >Anular</button>
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
                            <!--*** CONSULTA EMPLEADOS ***-->
                            <% 
                                Controladora myContr = new Controladora();                                
                                String datePattern = "dd/MM/yyyy";                                
                                SimpleDateFormat dateFormatter = new SimpleDateFormat(datePattern);                                 
                                List<Empleado> empLista = myContr.traerEmpleados();
                                for(Empleado emp : empLista) {
                                    Date empDateBefore = emp.getFechaNacEmpleado();
                                    String empDate = dateFormatter.format(empDateBefore);
                                    if(emp.getId_empleado() == 1){                                        
                            %>
                                <tr style="background-color: #DCE9F9">
                                    <td>
                                        <%= emp.getEmpUsuario().getUsername() %>
                                    </td>
                                    <td>
                                        <%= emp.getEmpUsuario().getPassword() %>
                                    </td>
                                    <td>
                                        <%= emp.getDniEmpleado() %>
                                    </td>
                                    <td>
                                        <%= emp.getNombreEmpleado() %>
                                    </td>
                                    <td>
                                        <%= emp.getApellidoEmpleado() %>
                                    </td>
                                    <td>
                                        <%= empDate %>
                                    </td>
                                    <td>
                                        <%= emp.getDireccionEmpleado() %>
                                    </td>
                                    <td>
                                        <%= emp.getCargoEmpleado() %>
                                    </td>
                                    <td class="emp-tableIconsContainer">
                                    </td>
                                </tr>
                                <% } else {%>
                                    <tr>
                                        <td>
                                            <%= emp.getEmpUsuario().getUsername() %>
                                        </td>
                                        <td>
                                            <%= emp.getEmpUsuario().getPassword() %>
                                        </td>
                                        <td><%= emp.getDniEmpleado() %></td>
                                        <td>
                                            <%= emp.getNombreEmpleado() %>
                                        </td>
                                        <td>
                                            <%= emp.getApellidoEmpleado() %>
                                        </td>
                                        <td>
                                            <%= empDate %>
                                        </td>
                                        <td>
                                            <%= emp.getDireccionEmpleado() %>
                                        </td>
                                        <td>
                                            <%= emp.getCargoEmpleado() %>
                                        </td>
                                        <td class="emp-tableIconsContainer">
                                            <img  class="emp-tableIcon" src="./assets/Icons/editEmp.png" alt="Editar Empleado"/>
                                            <img  class="emp-tableIcon" src="./assets/Icons/deleteEmp.png" alt="Editar Empleado"/>
                                        </td>
                                    </tr>
                                    <% } %>
                            <% } %>
                        </tbody>
                    </table>
                </div>
            </div>
        </section>
    <script src="./assets/JS/main.js"></script>
    <script>
        //  Date Picker EMPFECHANAC:
        const picker3 = MCDatepicker.create({
                el: '#datepickerEmpFechaNac',
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
