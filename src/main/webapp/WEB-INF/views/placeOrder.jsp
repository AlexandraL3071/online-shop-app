<%--
  Created by IntelliJ IDEA.
  User: vchele
  Date: 24/01/2021
  Time: 17:21
  To change this template use File | Settings | File Templates.
--%>
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
            <a href="logout" class="btn btn-info btn-lg">
                Logout
            </a>
        </div>
    </div>
    <hr/>
    </br>
    <div>
        <h3>Summary:</h3>
        <s:form action="sendOrderDetails" theme="css_xhtml">
            <table class="table table-hover">
                <thead>
                <tr>
                    <th scope="col">Image</th>
                    <th scope="col">Name</th>
                    <th scope="col">Description</th>
                    <th scope="col">Quantity</th>
                    <th scope="col">Price</th>
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
            <h5>Total price: <s:textfield name="totalPrice" value="%{totalPrice}" readonly="true"/></h5>
            <br>
            <h3>
                Shipping details:
            </h3>
            <h5>User: <s:textfield name="username" value="%{username}" readonly="true"/></h5>
            <h5>Date: <s:textfield name="date" value="%{date}" readonly="true"/></h5>
            <h5>Address: <s:textfield type="text" id="address" name="address" size="100"
                                      placeholder="Enter your address..."/></h5>
            <button type="submit" class="btn btn-primary btn-lg btn-block" style="margin-top: 8vw">
                Confirm and Submit
            </button>
        </s:form>
    </div>
</div>
</body>
</html>
