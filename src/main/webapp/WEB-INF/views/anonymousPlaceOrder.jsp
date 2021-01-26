<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<html>
<head>
    <title>Place Order</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
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
    <div style="margin-left: 20%; margin-right: 20%">
        <h3>Sumar:</h3>
        <s:form action="sendOrderDetails" theme="css_xhtml">
            <table class="table table-hover">
                <thead>
                <tr>
                    <th scope="col">Imagine</th>
                    <th scope="col">Nume</th>
                    <th scope="col">Descriere</th>
                    <th scope="col">Cantitate</th>
                    <th scope="col">Pret</th>
                </tr>
                </thead>
                <tbody>
                <s:iterator value="products">
                    <tr>
                        <td><img src="images/<s:property value="product.image"/>" width="50"
                                 height="50" alt="product photo"></td>
                        <td><s:property value="product.name"/></td>
                        <td><s:property value="product.description"/></td>
                        <td><s:property value="selectedQuantity"/></td>
                        <td><s:property value="product.price"/></td>
                    </tr>
                </s:iterator>
                </tbody>
            </table>
            <h5>Pret total: <s:textfield style="border: none" name="totalPrice" value="%{totalPrice}" readonly="true"/></h5>
            <br>
            <h3>
                Detalii privind livrarea:
            </h3>
            <h5>Nume de utilizator: <s:textfield style="border: none" id="username" name="username" value="%{username}" readonly="true"/></h5>
            <script type="text/javascript">
                if(document.getElementById("username").value === "anonymous"){
                    document.getElementById("username").setAttribute("value", "Not an user");
                }
            </script>
            <h5>Data: <s:textfield style="border: none" name="date" value="%{date}" readonly="true"/></h5>
            <h5>Nume: <s:textfield style="border: none" type="text" id="name" name="name" size="50"
                                   placeholder="Introdu numele..."/></h5>
            <h5>Adresa: <s:textfield style="border: none" type="text" id="address" name="address" size="50"
                                      placeholder="Introdu adresa..."/></h5>
            <button type="submit" class="btn btn-primary btn-lg btn-block" style="margin-top: 8vw">
                Confirma si trimite
            </button>
        </s:form>
    </div>
</div>
</body>
</html>
