<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cosul de cumparaturi</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<style>
    #grid {
        display: flex;
        flex-wrap: wrap;
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
            <a href="index.jsp" class="btn btn-info btn-lg">
                Autentificare
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
                    <div id="product_cards">
                        <div class="card" style="width: 18rem;margin: 8px">
                            <img class="card-img-top" src="images/<s:property value="product.image"/>" width="200" height="200" alt="product photo">
                            <div class="card-body">
                                <h5 class="card-title"><s:property value="product.name"/></h5>
                                <p class="card-text"><s:property value="product.description"/></p>
                                <p class="card-text">Stoc: <s:property value="product.totalQuantity"/></p>
                                <p class="card-text">Pret: <s:property value="product.price"/> lei</p>
                                <p class="card-text">Cantitate: <s:property value="selectedQuantity"/></p>
                            </div>
                        </div>
                    </div>
                    <br>
                </s:iterator>
            </div>
        </div>
    </div>
    <br>
    <s:form action="placeOrder" class="col">
        <button id="submitButton" type="submit" class="btn btn-primary btn-lg btn-block">
            Plaseaza comanda
        </button>
        <script type="text/javascript">
            if(document.getElementById("grid").childElementCount === 0){
                document.getElementById("submitButton").disabled = true;
            }
        </script>
    </s:form>
    <hr/>
    <div class="row" id="footer">
        <div class="col" style="text-align: center">
            Proiect TPJAD 2021
        </div>
    </div>
</div>
</body>
</html>
