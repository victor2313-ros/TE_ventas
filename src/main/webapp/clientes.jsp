<%
    if(session.getAttribute("login") != "Ok"){
        response.sendRedirect("login.jsp");
    }
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
        <a href="Logout" class="btn btn-danger">Cerrar Session</a>
        <br>
        <a href="ClienteControlador?action=add" class="btn btn-primary btn-sm"><i class="bi bi-plus-circle"></i> Nuevo</a>
        <table class="table table-striped">
            <tr>
                <th>Id</th>
                <th>Nombre</th>
                <th>Descripcion</th>
                <th>Precio</th>
                <th></th>
                <th></th>
            </tr>
            <c:forEach var="item" items="${clientes}">
            <tr>
                <td>${item.id}</td>
                <td>${item.nombre}</td>
                <td>${item.correo}</td>
                <td>${item.celular}</td>
                <td><a href="ClienteControlador?action=edit&id=${item.id}"><i class="bi bi-pencil-square"></i></a></td>
               <td><a href="ClienteControlador?action=delete&id=${item.id}" class="btn btn-sm btn-outline-danger" onclick="return confirm('¿ESTÁ SEGURO?')"><i class="bi bi-trash3-fill"></i></a></td>
                </tr>
            </c:forEach>
        </table>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>
