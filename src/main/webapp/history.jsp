<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>History</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" >
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
    <link href="css/style.css" rel="stylesheet" type="text/css"/>
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.11.2/css/all.css">
    <link rel="stylesheet" href="https://mdbootstrap.com/previews/ecommerce-demo/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://mdbootstrap.com/previews/ecommerce-demo/css/mdb-pro.min.css">
    <link rel="stylesheet" href="https://mdbootstrap.com/previews/ecommerce-demo/css/mdb.ecommerce.min.css">
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
    <link href="css/style.css" rel="stylesheet" type="text/css"/>
    <link href="css/manager.css" rel="stylesheet" type="text/css"/>

</head>
<body>
<main>
    <jsp:include page="views/header.jsp"></jsp:include>
    <div class="container pt-4">
        <section class="mb-4">
            <div class="card">
                <div class="card-header py-3 row">
                    <div class="col-sm-3">
                        <h5 class="mb-0 text-left" id="">
                            <strong>Order history</strong>
                        </h5>
                    </div>
                </div>

                <div class="card-body">
                    <div class="table-responsive">
                        <table class="table table-hover text-nowrap">
                            <thead>
                            <tr>
                                <th scope="col">Invoice ID</th>
                                <th scope="col">Product ID</th>
                                <th scope="col">Address</th>
                                <th scope="col">Price</th>
                                <th scope="col">Order date</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${shopOrders}" var="o">
                                <c:forEach var="lineItem" items="${o.shopOrderLineItems}">
                                <tr>
                                    <td>${o.shopOrderId}</td>
                                    <td>${lineItem.product}</td>
                                    <td>${o.addressShipping}</td>
                                    <td>${o.totalPrice} $</td>
                                    <td>${o.orderDate}</td>
                                </tr>
                                </c:forEach>
                            </c:forEach>
                            </tbody>
                        </table>

                    </div>
                </div>
            </div>
        </section>
    </div>
</main>
</body>
</html>