<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<html>
<head>
    <title>Home page</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<style>
    td {
        padding: 7px;
    }
</style>
<body>
<div class="container-fluid p-3 mb-2 bg-light text-dark">
    <div class="row" id="header">
        <div class="col-sm">
            <a href="adminProducts" class="btn btn-info btn-lg">
                <svg xmlns="http://www.w3.org/2000/svg" width="25" height="25" fill="currentColor" class="bi bi-clipboard-data" viewBox="0 0 20 20">
                    <path d="M4 11a1 1 0 1 1 2 0v1a1 1 0 1 1-2 0v-1zm6-4a1 1 0 1 1 2 0v5a1 1 0 1 1-2 0V7zM7 9a1 1 0 0 1 2 0v3a1 1 0 1 1-2 0V9z"/>
                    <path d="M4 1.5H3a2 2 0 0 0-2 2V14a2 2 0 0 0 2 2h10a2 2 0 0 0 2-2V3.5a2 2 0 0 0-2-2h-1v1h1a1 1 0 0 1 1 1V14a1 1 0 0 1-1 1H3a1 1 0 0 1-1-1V3.5a1 1 0 0 1 1-1h1v-1z"/>
                    <path d="M9.5 1a.5.5 0 0 1 .5.5v1a.5.5 0 0 1-.5.5h-3a.5.5 0 0 1-.5-.5v-1a.5.5 0 0 1 .5-.5h3zm-3-1A1.5 1.5 0 0 0 5 1.5v1A1.5 1.5 0 0 0 6.5 4h3A1.5 1.5 0 0 0 11 2.5v-1A1.5 1.5 0 0 0 9.5 0h-3z"/>
                </svg> Admin
            </a>
        </div>
        <div class="col-sm" style="text-align: center">
            <a href="products">
                <img src="images/main_logo.png" width="400" height="65" alt="main_logo">
            </a>
        </div>
        <div class="col-sm" style="text-align: right">
            <a href="logout" class="btn btn-info btn-lg">
                Logout
            </a>
        </div>
    </div>
    <hr/>

    <div id="content">
        <h3>Adauga produs nou:</h3>
        <h3 style="color:red"><s:property value="errorMessage"/></h3>
        <form action="adminProducts">
            <table style="margin: 15px; border: none">
                <tr>
                    <td><label for="name">Nume:</label></td>
                    <td><input type="text" id="name" name="name" required></td>
                </tr>
                <tr>
                    <td><label for="description">Descriere:</label></td>
                    <td><input type="text" id="description" name="description" required></td>
                </tr>
                <tr>
                    <td><label for="totalQuantity">Cantitate:</label></td>
                    <td><input type="number" id="totalQuantity" name="totalQuantity" min="1" required></td>
                </tr>
                <tr>
                    <td><label for="price">Pret:</label></td>
                    <td><input type="number" id="price" name="price" min="1" step="0.01" required></td>
                </tr>
                <tr>
                    <td><label for="image">Imagine:</label></td>
                    <td><input type="text" id="image" name="image" required></td>
                </tr>
                <tr>
                    <td><label for="category">Categorie:</label></td>
                    <td><input type="text" id="category" name="category" required></td>
                </tr>
                <tr>
                    <td><input class="btn btn-success" type="submit" value="Adauga produs"></td>
                </tr>
            </table>
        </form>
        <a href="adminProducts" class="btn btn-primary">Inapoi</a>
    </div>
    <br>
    <hr/>
    <div class="row" id="footer">
        <div class="col" style="text-align: center">
            TPJAD Project 2021
        </div>
    </div>
</div>
</body>
</html>
