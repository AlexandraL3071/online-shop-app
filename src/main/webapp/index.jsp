<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<head>
    <title>Autentificare</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<style>
    table {
        margin: 20px;
        border: none
    }

    .cell {
        padding: 10px;
    }
    form {
        width: 300px;
        margin: 0 auto;
    }
</style>
<body>
<div style="text-align: center;">
<h3>Autentificare:</h3>
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
    </table>
    <input class="btn btn-primary" type="submit" value="Register"/>
</form>
</div>
</body>
</html>
