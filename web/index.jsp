<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="./assets/CSS/styles.css" type="text/css" />
        <title>Hotel Management</title>
    </head>
    
    <body>
        
        <!--*** HOMEPAGE ***-->
        <section class="Homepage">
            <div class="Home_elements-center">
                <!-- *** Main Title *** -->
                <h1 class="mainTitle">Administración de Hotel</h1>        
                <!-- *** Form *** -->
                <div class="formContainer">  
                    <form action="pagina2.jsp" method="POST">
                        <h2>Formulario</h2>
                        <p class="singleInput">
                            Nombre: <input type="text" name="nombre">
                        </p>
                        <p class="singleInput">
                            Apellido: <input type="text" name="apellido">
                        </p>
                        <p class="singleInput">
                            Color de Pelo: 
                            <select name="colorPelo">
                                <option>Castaño</option>
                                <option>Rubio</option>
                                <option>Pelirrojo</option>
                            </select>
                        </p>
                        <br>
                        <input type="sumit" value="Enviar">           
                    </form>
                </div>
            </div>
        </section>
        
        
        
    </body>
</html>
