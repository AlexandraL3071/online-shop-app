<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<head>
    <title>Autentificare</title>
</head>
<style>
    table {
        margin: 20px;
        border: none
    }

    .cell {
        padding: 10px;
    }
</style>
<body>
<form method="POST" action="register">
    <table style="margin: 20px; border: none">
        <tr>
            <td><label class="cell" for="username">Nume de utilizator: </label></td>
            <td><input class="cell" type="text" id="username" name="username"></td>
        </tr>
        <tr>
            <td><label class="cell" for="password">Parola: </label></td>
            <td><input class="cell" type="password" id="password" name="password"></td>
        </tr>
        <tr>
            <td><input type="submit" value="Register"/>
        </tr>
    </table>
</form>
</body>
</html>
