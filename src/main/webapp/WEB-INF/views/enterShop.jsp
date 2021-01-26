<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<head>
    <title>Intra pe site</title>
<%--    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"--%>
<%--          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">--%>
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>
<style>
    *{
        padding: 0;
        margin: 0;
        font-family: sans-serif;
    }
    body{
        background: #002f5f;
    }
    .container{
        text-align: center;
        position: absolute;
        top: 50%;
        left: 50%;
        transform: translate(-50%,-50%);
        width: 100%;
    }
    .container span{
        text-transform: uppercase;
        display: block;
    }
    .mytext1{
        color: white;
        font-size: 60px;
        font-weight: 700;
        letter-spacing: 8px;
        margin-bottom: 20px;
        background: #002f5f;
        position: relative;
        animation: text 3s 1;

    }
    .mytext2{
        font-size: 30px;
        color: #E91E63;
        font-weight: bold;
        font-family: cursive;
    }
    @keyframes text {
        0%{
            color: black;
            margin-bottom: -40px;

        }
        /*30%{*/
        /*    letter-spacing: 25px;*/
        /*    margin-bottom: -40px;*/

        /*}*/
        /*85%{*/
        /*    letter-spacing: 8px;*/
        /*    margin-bottom: -40px;*/

        /*}*/
    }
</style>
<body>
<div class="container">
    <span class="mytext1">Ne bucuram sa te vedem!</span>
    <a class="mytext2" href="products"> Intra pe site </a>
<%--    <a href="products" class="btn btn-primary">Enter</a>--%>
</div>
<%--<div style="text-align: center;">--%>
<%--    <h3 style="color:green">Successful login/registration!:</h3>--%>
<%--    <h3>Enter shop:</h3>--%>
<%--    <a href="products" class="btn btn-primary">Enter</a>--%>
<%--</div>--%>
</body>
</html>
