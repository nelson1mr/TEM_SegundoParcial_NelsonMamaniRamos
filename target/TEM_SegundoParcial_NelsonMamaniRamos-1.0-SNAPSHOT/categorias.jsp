<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="com.emergentes.modelo.Categoria"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Libros</title>
    </head>
    <body>
        <h1>Listado de categorias</h1>
        <p><a href="CategoriaController?action=add">Nuevo</a></p>
        <table border="1">
            <tr>
                <th>Id</th>
                <th>Categoria</th>
                <th></th>
                <th></th>
            </tr>
            <c:forEach var="item" items="${categorias}">         
            <tr>
                <td>${item.id}</td>
                <td>${item.categoria}</td>
                <td><a href="CategoriaController?action=edit&id=${item.id}">Editar</a></td>
                <td><a href="CategoriaController?action=delete&id=${item.id}">Eliminar</a></td>
            </tr>
            </c:forEach>
        </table>
        <p><a href="index.jsp">Volver al inicio</a></p>
    </body>
</html>
