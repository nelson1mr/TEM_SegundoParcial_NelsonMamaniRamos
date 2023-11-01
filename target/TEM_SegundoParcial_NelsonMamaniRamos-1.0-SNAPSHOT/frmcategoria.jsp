<%@page import="com.emergentes.modelo.Categoria"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registro de categoria</title>
    </head>
    <body>
        <h1>Registro de categoria</h1>
        <form action="CategoriaController" method="post">
            <input type="hidden" name="id" value="${categoria.id}"/>
            <table>
                <tr>
                    <td>Categoria</td>
                    <td><input type="text" name="categoria" value="${categoria.categoria}" /></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit"/></td>
                </tr>
            </table>
        </form>
        <a href="CategoriaController">Volver</a>
    </body>
</html>
