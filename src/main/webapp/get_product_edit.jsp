<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 19/11/2023
  Time: 11:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Quản lý sản phẩm</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>

<form action="edit_product" method="post">
    <div>
        <input type="hidden" name="product_id" value="${productEditDTO.productID}">
        <input type="hidden" name="action" value="eidtProduct">
    </div>
    <div class="card rounded-3 mb-4">
        <div class="card-body p-4">
            <div class="row d-flex justify-content-between align-items-center">
                <div class="col-md-2 col-lg-2 col-xl-2">
                    <img src="${pageContext.request.contextPath}/static/${productEditDTO.productImage}"
                         alt="Example Image"/>
                </div>
                <div class="col-md-3 col-lg-3 col-xl-3">
                    <a for="name">Name</a>
                    <p class="lead fw-normal mb-2">
                        <input id="form1" min="0" name="name" value="<c:out value='${productEditDTO.productName}'/>" type="text"
                               class="form-control form-control-sm"/>
                </div>
                <div class="col-md-3 col-lg-2 col-xl-2 offset-lg-1">
                    <a for="quantity" style="display: flex; margin-left: 25px">Quantity</a>
                    <div style="display: flex; align-items: center;">
                        <button type="button" class="btn btn-link px-2"
                                onclick="this.parentNode.querySelector('input[type=number]').stepDown()">
                            <i class="fas fa-minus"></i>
                        </button>
                        <input id="form1" min="0" name="quantity" value="<c:out value='${productEditDTO.productQuantity}'/>"
                               type="number"
                               class="form-control form-control-sm"/>
                        <button type="button" class="btn btn-link px-2"
                                onclick="this.parentNode.querySelector('input[type=number]').stepUp()">
                            <i class="fas fa-plus"></i>
                        </button>
                    </div>
                </div>
                <div class="col-md-3 col-lg-2 col-xl-2 offset-lg-1">
                    <a for="price">Price</a>
                    <input id="form1" min="0" name="price" value="<c:out value='${productEditDTO.productPrice}'/>" type="number"
                           class="form-control form-control-sm"/>
                </div>
                <div class="col-md-1 col-lg-1 col-xl-1 text-end" style="position: relative; margin-top: 20px">
                    <div class="d-flex flex-column align-items-end">
                        <button type="submit" class="btn btn-primary">Submit</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</form>


<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.3/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
