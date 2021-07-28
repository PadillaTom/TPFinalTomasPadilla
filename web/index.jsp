<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Logica.*, java.util.*, java.sql.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="./assets/CSS/styles.css" type="text/css" />
        <title>Hotel Management</title>
    </head>
    
    <body>
        <!--*** HOMEPAGE ***-->
        <section class="section login-sect">
            <div class="loginElements-center">
                <!-- *** Login Form *** -->
                <div class="login-formContainer">  
                    <form action="SvLogin" method="POST">
                        <div class="login-formTitle">
                            <h2>Mi Hotel</h2>
                        </div>
                        <div class="login-formContent">
                            <div class="login-formInputs">
                                <p class="login-singleInput">
                                    Usuario: <input type="text" name="username">
                                </p>
                                <p class="login-singleInput">
                                    Contraseña: <input type="password" name="password">
                                </p>
                            </div>
                            <div class="login-formButtons">
                                <input type="submit" class="formBtn" value="Login" />
                            </div>
                        </div>
                    </form>
                </div>
                
            </div>
        </section>
        <%
            Controladora myContr = new Controladora();
            if(myContr.primerEmpleado() == null) {
                myContr.altaPrimerEmpleado();
                myContr.crearHabitaciones();
            } else {
                return;
            }
        %>
    </body>
</html>
