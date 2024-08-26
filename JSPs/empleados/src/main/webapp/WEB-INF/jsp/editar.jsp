<%@ include file="comunes/cabecero.jsp" %>
<%@ include file="comunes/navegacion.jsp" %>

<div class="container">
    <div class="text-center" style="margin: 30px">
        <h3>Editar Empleado</h3>
    </div>
    <form action="${urlEditar}" modelAttribute="empleadoForma" method="post">
        <input type="hidden" name="idEmpleado" value="${empleado.idEmpleado}">
        <div class="mb-3">
            <label for="nombre" class="form-label">Nombre</label>
            <input type="text" class="form-control" id="nombre" name="nombre" aria-describedby="nameHelp"
                   value="${empleado.nombre}" required>
        </div>
        <div class="mb-3">
            <label for="departamento" class="form-label">Departamento</label>
            <input type="text" class="form-control" id="departamento" name="departamento"
                   aria-describedby="departamentoHelp" value="${empleado.departamento}" required>
        </div>
        <div class="mb-3">
            <label for="sueldo" class="form-label">Sueldo</label>
            <input type="number" step="any" class="form-control" id="sueldo" name="sueldo"
                   aria-describedby="sueldoHelp" value="${empleado.sueldo}" required>

        </div>
        <div class="text-center">
            <button type="submit" class="btn btn-warning btn-sm me-3">Editar</button>
            <a href="${urlInicio}" class="btn btn-danger btn-sm">Regresar</a>
        </div>
    </form>
</div>

<%@ include file="comunes/pie-pagina.jsp" %>