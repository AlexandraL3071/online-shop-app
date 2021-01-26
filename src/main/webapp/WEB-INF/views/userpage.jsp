<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<html>
<head>
    <title>Home page</title>
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
            <div>
                <a href="products">
                    <img src="images/main_logo.png" width="400" height="65" alt="main_logo">
                </a>
            </div>
        </div>
        <div class="col-sm" style="text-align: right">
            <div>
                <a href="logout" class="btn btn-info btn-lg">
                    Logout
                </a>
            </div>
            <br/>
            <div>
                <a href="productsInCart" class="btn btn-info btn-lg">
                    <svg xmlns="http://www.w3.org/2000/svg" width="25" height="25" fill="currentColor"
                         class="bi bi-cart-fill" viewBox="0 0 20 20">
                        <path d="M0 1.5A.5.5 0 0 1 .5 1H2a.5.5 0 0 1 .485.379L2.89 3H14.5a.5.5 0 0 1 .491.592l-1.5 8A.5.5 0 0 1 13 12H4a.5.5 0 0 1-.491-.408L2.01 3.607 1.61 2H.5a.5.5 0 0 1-.5-.5zM5 12a2 2 0 1 0 0 4 2 2 0 0 0 0-4zm7 0a2 2 0 1 0 0 4 2 2 0 0 0 0-4zm-7 1a1 1 0 1 1 0 2 1 1 0 0 1 0-2zm7 0a1 1 0 1 1 0 2 1 1 0 0 1 0-2z"/>
                    </svg>
                    Cosul de cumparaturi
                </a>
            </div>
        </div>
    </div>
</div>
<hr/>
</br>
<div class="row" id="content">
    <div class="col-4">
        <div class="list-group">
            <a href="products" class="list-group-item list-group-item-action active">Categorii</a>
            <a href="?category=Telefoane" class="list-group-item list-group-item-action">Telefoane</a>
            <a href="?category=Laptopuri" class="list-group-item list-group-item-action">Laptopuri</a>
            <a href="?category=Periferice" class="list-group-item list-group-item-action">Periferice</a>
            <a href="?category=ComponentePC" class="list-group-item list-group-item-action">Componente PC</a>
            <a href="?category=Monitoare" class="list-group-item list-group-item-action">Monitoare</a>
            <a href="?category=Console" class="list-group-item list-group-item-action">Console</a>
            <a href="?category=Foto/video" class="list-group-item list-group-item-action">Foto/video</a>
        </div>
    </div>
    <div class="col-8">
        <h3><s:iterator value="title">
            <s:property/>
        </s:iterator>
        </h3>
        <div id="grid">
            <s:iterator value="productList">
                <div>
                <s:form action="cartProducts" class="card" style="width: 18rem;margin: 8px" theme="css_xhtml">
                    <s:hidden  value="%{id}" name="productId" />
                    <img class="card-img-top" src="images/<s:property value="image"/>" width="200" height="200"
                         alt="product photo">
                    <div class="card-body">
                        <h5 class="card-title"><s:property value="name"/></h5>
                        <p class="card-text"><s:property value="description"/></p>
                        <p class="card-text">Stoc: <s:property value="totalQuantity"/></p>
                        <p class="card-text">Pret: <s:property value="price"/> lei</p>
                        <p class="card-text">Cantitate: <s:textfield type="number" id="quantity" name="quantity" min="1"
                                                                     max="%{totalQuantity}"/></p>
                        <button type="submit" class="btn btn-primary add-to-cart-button">Adauga in cos</button>
                    </div>
                </s:form>
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
