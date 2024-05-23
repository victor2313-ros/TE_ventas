<%
    String opcion = request.getParameter("opcion");
%>
<ul class="nav nav-tabs">
    <li class="nav-item">
        <a class="nav-link <%= (opcion.equals("usuarios") ? "active" : "" )%>" href="UsuarioControlador">Usuarios</a>
    </li>
        <li class="nav-item">
        <a class="nav-link <%= (opcion.equals("productos") ? "active" : "" )%>" href="ProductoControlador">Producto</a>
    </li>
    <li class="nav-item">
        <a class="nav-link <%= opcion.equals("clientes") ? "active" : "" %>" href="ClienteControlador">Clientes</a>
    </li>
    <li class="nav-item">
        <a class="nav-link <%= opcion.equals("ventas") ? "active" : "" %>" href="VentaControlador">Ventas</a>
    </li>
</ul>
