<%--
  Created by IntelliJ IDEA.
  User: mirun
  Date: 24.01.2021
  Time: 10:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cart</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<style>
    #grid {
        display: flex;
        flex-wrap: wrap;
    }

    .add-to-cart-button {
        margin-top: 5px;
    }
</style>
<body>
<div class="container-fluid p-3 mb-2 bg-light text-dark">
    <div class="row" id="header">
        <div class="col-sm">
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
    </br>
    <div class="row" id="content">
        <div class="col-8">
            <h3><s:iterator value="title">
                <s:property/>
            </s:iterator>
            </h3>
            <div id="grid">
                <s:iterator value="products">
                    <div>
                        <div class="card" style="width: 18rem;margin: 8px">
                            <img class="card-img-top" src="images/<s:property value="image"/>" width="200" height="200" alt="product photo">
                            <div class="card-body">
                                <h5 class="card-title"><s:property value="name"/></h5>
                                <p class="card-text"><s:property value="description"/></p>
                                <p class="card-text">Stoc: <s:property value="totalQuantity"/></p>
                                <p class="card-text">Pret: <s:property value="price"/> lei</p>
                                <label for="quantity">Cantitate:</label>
                                <input type="number" id="quantity" name="quantity" min="1"
                                       max="<s:property value="totalQuantity"/>">
                            </div>
                        </div>
                    </div>
                    <br>
                </s:iterator>
            </div>
        </div>
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
