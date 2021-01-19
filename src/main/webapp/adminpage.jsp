<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ taglib uri="/struts-tags" prefix="bean" %>
<%@ taglib uri="/struts-tags" prefix="html" %>
<html>
<head>
    <title>Home page</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<style>

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
            <h1>E-LECTRONIX</h1>
        </div>
        <div class="col-sm" style="text-align: right">
            <a href="#" class="btn btn-info btn-lg">
                <svg xmlns="http://www.w3.org/2000/svg" width="25" height="25" fill="currentColor" class="bi bi-cart-fill" viewBox="0 0 20 20">
                    <path d="M0 1.5A.5.5 0 0 1 .5 1H2a.5.5 0 0 1 .485.379L2.89 3H14.5a.5.5 0 0 1 .491.592l-1.5 8A.5.5 0 0 1 13 12H4a.5.5 0 0 1-.491-.408L2.01 3.607 1.61 2H.5a.5.5 0 0 1-.5-.5zM5 12a2 2 0 1 0 0 4 2 2 0 0 0 0-4zm7 0a2 2 0 1 0 0 4 2 2 0 0 0 0-4zm-7 1a1 1 0 1 1 0 2 1 1 0 0 1 0-2zm7 0a1 1 0 1 1 0 2 1 1 0 0 1 0-2z"/>
                </svg> Shopping Cart
            </a>
        </div>
    </div>
    <hr/>

    <div id="content">
        <a href="addProduct.jsp" class="btn btn-success">Adauga produs</a>
        <h4>Toate produsele:</h4>
        <table class="table table-sm table-hover table-bordered">
            <thead>
            <tr>
                <th scope="col">Id</th>
                <th scope="col">Nume</th>
                <th scope="col">Descriere</th>
                <th scope="col">Cantitate</th>
                <th scope="col">Pret</th>
                <th scope="col">Imagine</th>
                <th scope="col">Categorie</th>
                <th scope="col">Sterge</th>
                <th scope="col">Update</th>
            </tr>
            </thead>
            <tbody>
            <s:iterator value="allProductList">
                <tr>
                    <form id="formd<s:property value="id"/>" action="adminProducts"><input type="hidden" name="id" value="<s:property value="id"/>"/></form>
                    <form id="formu<s:property value="id"/>" action="adminProducts"><input type="hidden" name="id" value="<s:property value="id"/>"/></form>
                    <th scope="row"><form id="formu<s:property value="id"/>" action="adminProducts"><s:property value="id"/></form></th>
                    <td><s:property value="name"/></td>
                    <td><s:property value="description"/></td>
                    <td><input form="formu<s:property value="id"/>" type="number" name="totalQuantity" value="<s:property value="totalQuantity"/>" min="1" required/></td>
                    <td><input form="formu<s:property value="id"/>" type="number" name="price" value="<s:property value="price"/>" min="1" step="0.01" required/></td>
                    <td><s:property value="image"/></td>
                    <td><s:property value="category.getName()"/></td>
                    <td><input form="formd<s:property value="id"/>" class="btn btn-danger" type="submit" value="Sterge" /></td>
                    <td><input form="formu<s:property value="id"/>" class="btn btn-primary" type="submit" value="Update" /></td>
                </tr>
            </s:iterator>
            </tbody>
        </table>
        <h4>Toate comenzile:</h4>
        <table class="table table-sm table-hover table-bordered">
            <thead>
            <tr>
                <th scope="col">Id</th>
                <th scope="col">Username</th>
                <th scope="col">Produse</th>
                <th scope="col">Pret Total</th>
                <th scope="col">Adresa de livrare</th>
            </tr>
            </thead>
            <tbody>
            <s:iterator value="allOrdersList">
                <tr>
                    <th scope="row"><s:property value="id"/></th>
                    <td><s:property value="user.getUsername()"/></td>
                    <td>
                        <table class="table table-sm table-hover table-bordered">
                            <tbody>
                                <s:iterator value="orderProducts">
                                    <td><s:property value="product.getName()"/></td>
                                    <td><s:property value="selectedQuantity"/></td>
                                </s:iterator>
                            </tbody>
                        </table>
                    </td>
                    <td><s:property value="totalPrice"/></td>
                    <td><s:property value="deliveryAddress"/></td>
                </tr>
            </s:iterator>
            </tbody>
        </table>
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
