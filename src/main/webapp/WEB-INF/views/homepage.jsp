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
            <a href="adminProducts" class="btn btn-info btn-lg">
                <svg xmlns="http://www.w3.org/2000/svg" width="25" height="25" fill="currentColor"
                     class="bi bi-clipboard-data" viewBox="0 0 20 20">
                    <path d="M4 11a1 1 0 1 1 2 0v1a1 1 0 1 1-2 0v-1zm6-4a1 1 0 1 1 2 0v5a1 1 0 1 1-2 0V7zM7 9a1 1 0 0 1 2 0v3a1 1 0 1 1-2 0V9z"/>
                    <path d="M4 1.5H3a2 2 0 0 0-2 2V14a2 2 0 0 0 2 2h10a2 2 0 0 0 2-2V3.5a2 2 0 0 0-2-2h-1v1h1a1 1 0 0 1 1 1V14a1 1 0 0 1-1 1H3a1 1 0 0 1-1-1V3.5a1 1 0 0 1 1-1h1v-1z"/>
                    <path d="M9.5 1a.5.5 0 0 1 .5.5v1a.5.5 0 0 1-.5.5h-3a.5.5 0 0 1-.5-.5v-1a.5.5 0 0 1 .5-.5h3zm-3-1A1.5 1.5 0 0 0 5 1.5v1A1.5 1.5 0 0 0 6.5 4h3A1.5 1.5 0 0 0 11 2.5v-1A1.5 1.5 0 0 0 9.5 0h-3z"/>
                </svg>
                Admin
            </a>
        </div>
        <div class="col-sm" style="text-align: center">
            <div>
                <a href="products">
                    <img src="images/main_logo.png" width="400" height="65" alt="main_logo">
                </a>
            </div>
        </div>
        <div class="col-sm" style="text-align: right">
            <a href="logout" class="btn btn-info btn-lg">
                Logout
            </a>
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
                    <div class="card" style="width: 18rem;margin: 8px">
                        <img class="card-img-top" src="images/<s:property value="image"/>" width="200" height="200"
                             alt="product photo">
                        <div class="card-body">
                            <h5 class="card-title"><s:property value="name"/></h5>
                            <p class="card-text"><s:property value="description"/></p>
                            <p class="card-text">Stoc: <s:property value="totalQuantity"/></p>
                            <p class="card-text">Pret: <s:property value="price"/> lei</p>
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
        Proiect TPJAD 2021
    </div>
</div>
</div>
</body>
</html>
