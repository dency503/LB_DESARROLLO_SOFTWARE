<%@page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Iniciar Sesión</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css">
    <link rel="stylesheet" href="styles.css"> <!-- Tu archivo de estilos personalizados -->
    <style>
        body {
            background-color: #f8f9fa;
        }
        .cuenta-content {
            background-color: #ffffff;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0px 0px 10px 0px rgba(0,0,0,0.1);
        }
        .password-toggle {
            position: relative;
        }
        .password-toggle input[type="password"] {
            padding-right: 30px;
        }
        .password-toggle .toggle {
            position: absolute;
            top: 50%;
            right: 10px;
            transform: translateY(-50%);
            cursor: pointer;
        }
        .link {
            color: #007bff;
        }
    </style>
</head>
<body class="h-100">
    <div class="container-fluid h-100" >
        <div class="row h-100 justify-content-center align-items-center">
            <!--<div class="col-md-3 banner d-none d-md-block">
                <img src="https://i.pinimg.com/736x/2c/f1/4e/2cf14e4d89bc824aa0d30c2eebcac127.jpg" alt="Banner de Ferretería">
            </div>-->
            <div class="col-md-9">
                <div class="cuenta-content">
                    <h1 class="text-center mb-3 text-uppercase">Iniciar Sesión</h1>
                    <p class="h4 font-weight-light mb-4 text-center">¡Bienvenido de vuelta!</p>

                    <form action="/Ferreteria/ServletPrincipal?accion=Login" method="post">
                        <div class="mb-3">
                            <label class="form-label">Usuario</label>
                            <input class="form-control" aria-label="Email" aria-describedby="input-email" autofocus="" required="" type="text" name="tfUsuario">
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Tu Contraseña</label>
                            <div class="password-toggle">
                                <input type="password" class="form-control" aria-label="Password" aria-describedby="input-password" autocomplete="off" required="" id="Password" name="tfContrasenia">
                                <span class="toggle"><i class="fas fa-eye"></i></span>
                            </div>                                    
                        </div>

                        <div class="mb-3 form-check">
                            <input type="checkbox" class="form-check-input" id="rememberPsw" name="RememberLogin" value="true">
                            <label class="form-check-label" for="rememberPsw">Recordarme</label>
                        </div>

                        <div class="row">
                            <div class="col-md-6">
                                <button name="button" type="submit" value="login" class="btn btn-primary btn-block">Iniciar Sesión</button>
                            </div>
                            <div class="col-md-6">
                                <button name="button" value="cancel" class="btn btn-outline-dark btn-block">Cancelar</button>
                            </div>
                        </div>
                    </form>

                    <div class="pt-4 text-center">
                        <p><a class="link" href="/Account/ForgotPassword">¿No recuerdas tu contraseña?</a></p>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/js/all.min.js"></script>
    <script src="main.js"></script> <!-- Tu archivo de scripts personalizados -->
    <script>
        // Script para mostrar/ocultar la contraseña
        const togglePassword = document.querySelector('.toggle');
        const password = document.getElementById('Password');
        togglePassword.addEventListener('click', function() {
            if (password.type === 'password') {
                password.type = 'text';
            } else {
                password.type = 'password';
            }
        });
    </script>
</body>
</html>
