<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ taglib uri="/struts-tags" prefix="bean" %>
<%@ taglib uri="/struts-tags" prefix="html" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Pagina principala</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<style>
    .inner
    {
        display: inline-block;
    }
    .input {
        width: 100%;
        box-sizing: border-box;
        -webkit-box-sizing:border-box;
        -moz-box-sizing: border-box;
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
        <a href="addProduct" class="inner btn btn-success">Adauga produs</a>
        <a href="#all-orders" class="inner btn btn-primary">Vezi toate comenzile</a>
        <h4>Toate produsele:</h4>
        <table style="width: 100%; table-layout: fixed;" class="table table-sm table-hover table-bordered">
            <thead>
            <tr>
                <th style="width: 5%; word-wrap: break-word;" scope="col">Id</th>
                <th style="width: 15%; word-wrap: break-word;" scope="col">Nume</th>
                <th style="width: 19%; word-wrap: break-word;" scope="col">Descriere</th>
                <th style="width: 15%; word-wrap: break-word;" scope="col">Cantitate</th>
                <th style="width: 15%; word-wrap: break-word;" scope="col">Pret (lei)</th>
                <th style="width: 10%; word-wrap: break-word;" scope="col">Imagine</th>
                <th style="width: 9%; word-wrap: break-word;" scope="col">Categorie</th>
                <th style="width: 6%; word-wrap: break-word;" scope="col">Sterge</th>
                <th style="width: 6%; word-wrap: break-word;" scope="col">Modificare</th>
            </tr>
            </thead>
            <tbody>
            <s:iterator value="allProductList">
                <tr>
                    <form id="formd<s:property value="id"/>" action="adminProducts"><input type="hidden" name="id" value="<s:property value="id"/>"/></form>
                    <form id="formu<s:property value="id"/>" action="adminProducts"><input type="hidden" name="id" value="<s:property value="id"/>"/></form>
                    <th style="word-wrap: break-word" scope="row"><s:property value="id"/></th>
                    <td style="word-wrap: break-word"><s:property value="name"/></td>
                    <td style="word-wrap: break-word"><s:property value="description"/></td>
                    <td><input class="input" form="formu<s:property value="id"/>" type="number" name="totalQuantity" value="<s:property value="totalQuantity"/>" min="1" required/></td>
                    <td><input class="input" form="formu<s:property value="id"/>" type="number" name="price" value="<s:property value="price"/>" min="1" step="0.01" required/></td>
                    <td style="word-wrap: break-word"><s:property value="image"/></td>
                    <td style="word-wrap: break-word"><s:property value="category.getName()"/></td>
                    <td><input form="formd<s:property value="id"/>" class="input btn btn-danger" type="submit" value="Sterge" /></td>
                    <td><input form="formu<s:property value="id"/>" class="input btn btn-primary" type="submit" value="Modificare" /></td>
                </tr>
            </s:iterator>
            </tbody>
        </table>
        <a id="all-orders">
            <h4>Toate comenzile:</h4></a>
        <table style="width: 100%; table-layout: fixed;" class="table table-sm table-hover table-bordered">
            <thead>
            <tr>
                <th style="width: 5%; word-wrap: break-word;" scope="col">Id</th>
                <th style="width: 11%; word-wrap: break-word;" scope="col">Nume de utilizator</th>
                <th style="width: 11%; word-wrap: break-word;" scope="col">Nume</th>
                <th style="width: 34%; word-wrap: break-word;" scope="col">Produse (nume+cantitate)</th>
                <th style="width: 10%; word-wrap: break-word;" scope="col">Pret Total</th>
                <th style="width: 25%; word-wrap: break-word;" scope="col">Adresa de livrare</th>
                <th style="width: 15%; word-wrap: break-word;" scope="col">Data si ora comenzii</th>
            </tr>
            </thead>
            <tbody>
            <s:iterator value="allOrdersList">
                <tr>
                    <th style="word-wrap: break-word" scope="row"><s:property value="id"/></th>
                    <td style="word-wrap: break-word"><s:property value="user.getUsername()"/></td>
                    <td style="word-wrap: break-word"><s:property value="name"/></td>
                    <td>
                        <table style="width: 100%; table-layout: fixed;" class="table table-sm table-hover table-bordered">
                            <tbody>
                            <s:iterator value="orderProducts">
                                <tr>
                                    <td style="width:75%; word-wrap: break-word;"><s:property value="product.getName()"/></td>
                                    <td style="width:25%; word-wrap: break-word;"><s:property value="selectedQuantity"/></td>
                                </tr>
                            </s:iterator>
                            </tbody>
                        </table>
                    </td>
                    <td style="word-wrap: break-word">
                        <s:property value="getText('{0,number,#,##0.00}',{totalPrice})"/> lei</td>
                    <td style="word-wrap: break-word"><s:property value="deliveryAddress"/></td>
                    <td style="word-wrap: break-word"><s:property value="orderDate.toLocaleString()"/></td>
                </tr>
            </s:iterator>
            </tbody>
        </table>
    </div>
    <br>
    <hr/>
    <div class="row" id="footer">
        <div class="col" style="text-align: center">
            Proiect TPJAD 2021
        </div>
    </div>
</div>
</body>
</html>
