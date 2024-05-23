<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
        <title>Punto de venta</title>
    </head>
    <body>
        <div class="container">
            <h1>Clientes</h1>
            <jsp:include page="WEB-INF/menu.jsp">
                <jsp:param name="opcion" value="clientes"/>
            </jsp:include >
            <br>
            <form action="ClienteControlador" method="post">
                    <input type="hidden" name="id" value="${cliente.id}">
                    <div class="mb-3">
                        <label for="" class="form-label">Nombre</label>
                        <input type="text" class="form-control" name="nombre" placeholder="Escriba su nombre" value="${cliente.nombre}">
                    </div>
                    <div class="mb-3">
                        <label for="" class="form-label">Correo</label>
                        <input type="email" class="form-control" name="correo" placeholder="Escriba su correo electronico" value="${cliente.correo}">
                    </div>
                    <div class="mb-3">
                        <label for="" class="form-label">Celular</label>
                        <input type="text" class="form-control" name="celular" placeholder="Escriba su celular" value="${cliente.celular}">
                    </div>
                    <button type="submit" class="btn btn-primary">Enviar</button>
                </form>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
    </body>
</html>
