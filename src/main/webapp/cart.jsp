<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 23/11/2023
  Time: 9:45 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Cart</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css" rel="stylesheet">
</head>

<body>
<jsp:include page="views/header.jsp"></jsp:include>
<%--<form th:action="@{'/customer/pay'}" th:object="${CART_ITEMS}" method="post">--%>

<section class="h-100 h-custom" style="background-color: #d2c9ff;">
    <div class="container py-5 h-100">
        <div class="row d-flex justify-content-center align-items-center h-100">
            <div class="col-12">
                <div class="card card-registration card-registration-2" style="border-radius: 15px;">
                    <div class="card-body p-0">
                        <div class="row g-0">
                            <div class="col-lg-8">
                                <div class="p-5">
                                    <div class="d-flex justify-content-between align-items-center mb-5">
                                        <h1 class="fw-bold mb-0 text-black">Cart</h1>
                                        <h6 class="mb-0 text-muted">Total items:
                                            <span><c:out value="${size}" /></span>
                                        </h6>
                                    </div>
                                    <hr class="my-4">

                                    <c:forEach var="item" items="${productBuys}">
                                        <div class="row mb-4 d-flex justify-content-between align-items-center">
                                            <div class="col-md-2 col-lg-2 col-xl-2">
                                                <img class="img-fluid w-100"
                                                     src="${item.product.productImage }">
                                            </div>
                                            <div class="col-md-2 col-lg-3 col-xl-3">
                                                <a>Name</a>
                                                <input type="hidden" name="name"
                                                       value="<c:out value='${item.product.productName}' />"/>
                                                <h6 class="text-black mb-0"><c:out
                                                        value='${item.product.productName}'/></h6>
                                            </div>

                                            <div class="col-md-2 col-lg-2 col-xl-2 offset-lg-1">
                                                <a>Price</a>
                                                <input type="hidden" name="qty"
                                                       value="<c:out value='${item.product.productPrice}' />"/>
                                                <h6 class="text-black mb-0"><c:out
                                                        value='${item.product.productPrice}'/></h6>

                                            </div>

                                            <div class="col-md-3 col-lg-2 col-xl-2 offset-lg-1">
                                                <a>Quantity</a>
                                                <input type="hidden" name="price"
                                                       value="<c:out value='${item.shoppingCartItemQuantity}' />"/>
                                                <h6 class="text-black mb-0"><c:out
                                                        value='${item.shoppingCartItemQuantity}'/></h6>

                                            </div>
                                            <div class="col-md-2 col-lg-2 col-xl-2 offset-lg-1">
                                                <a>Size</a>
                                                <input type="hidden" name="size"
                                                       value="<c:out value='${item.size}' />"/>
                                                <h6 class="text-black mb-0"><c:out
                                                        value='${item.size}'/></h6>

                                            </div>
                                            <div class="col-md-1 col-lg-1 col-xl-1 text-end">
                                                <a href="remove_item?cid=${item.shoppingCartItemId}"
                                                   class="text-muted"><i class="fas fa-times"></i>
                                                </a>
                                            </div>

                                        </div>
                                        <hr class="my-4">
                                    </c:forEach>

                                    <div class="pt-5">
                                        <h6 class="mb-0"><a href="shop" class="text-body"><i
                                                class="fas fa-long-arrow-alt-left me-2"></i>Back to shop</a></h6>
                                    </div>
                                </div>
                            </div>


                            <div class="col-lg-4 bg-grey">
                                <div class="p-5">
                                    <h3 class="fw-bold mb-5 mt-2 pt-1">Summary</h3>
                                    <hr class="my-4">

                                    <div class="d-flex justify-content-between mb-4">

                                        <input type="hidden" name="TOTAL_PRICE" <c:out value="${totalPrice}" />/>
                                        <p><c:out value="${totalPrice}" /></p>


                                    </div>

                                    <h5 class="text-uppercase mb-3">Shipping</h5>

                                    <div class="mb-4 pb-2">
                                        <select class="select">
                                            <option value="1">Standard-Delivery- €5.00</option>
                                            <option value="2">Two</option>
                                            <option value="3">Three</option>
                                            <option value="4">Four</option>
                                        </select>
                                    </div>

                                    <h5 class="text-uppercase mb-3">Give code</h5>

                                    <div class="mb-5">
                                        <div class="form-outline">
                                            <input type="text" id="form3Examplea2"
                                                   class="form-control form-control-lg"/>
                                            <label class="form-label" for="form3Examplea2">Enter your code</label>
                                        </div>
                                    </div>

                                    <hr class="my-4">

                                    <div class="d-flex justify-content-between mb-5">
                                        <h5 class="text-uppercase">Total price</h5>
                                        <p><c:out value="${totalPrice}" /></p>
                                    </div>

                                    <form action="checkout" method="post">
                                        <input type="hidden" name="action" value="get_information">
                                        <input type="hidden" name="cpid" value="${shoppingCart.shoppingId}">
                                        <button type="submit" class="btn btn-dark btn-block btn-lg"
                                                data-mdb-ripple-color="dark">
                                            Confirm
                                        </button>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>


<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.3/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</body>
</html>
