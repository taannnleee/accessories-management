<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Quản lý sản phẩm</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>


<section class="h-100" style="background-color: #eee;">
    <div class="container h-100 py-5">
        <div class="row d-flex justify-content-center align-items-center h-100">
            <div class="col-10">

                <div class="d-flex justify-content-between align-items-center mb-4">
                    <h3 class="fw-normal mb-0 text-black">Manager Product</h3>
                    <div>
                        <p class="mb-0"><span class="text-muted">Sort by:</span> <a href="#!" class="text-body">price
                            <i
                                    class="fas fa-angle-down mt-1"></i></a></p>
                    </div>
                </div>
                <c:forEach var="product" items="${products}">
                    <div class="card rounded-3 mb-4">
                        <div class="card-body p-4">
                            <div class="row align-items-center">
                                <div class="col-md-2 col-lg-2 col-xl-2">
                                    <img src="${pageContext.request.contextPath}/static/${product.productImage}" alt="Example Image"/>
                                </div>
                                <div class="col-md-3 col-lg-3 col-xl-3">
                                    <div class="row align-items-center">
                                        <div class="col-12">
                                            <a>Name</a>
                                        </div>
                                        <div class="col-12">
                                            <h5 style="position: relative; margin-top: 10px" class="mb-0">
                                                <p><c:out value="${product.productName}"/></p>
                                            </h5>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-3 col-lg-3 col-xl-3">
                                    <div class="row align-items-center">
                                        <div class="col-12">
                                            <a>Description</a>
                                        </div>
                                        <div class="col-12">
                                            <h5 style="position: relative; margin-top: 10px" class="mb-0">
                                                <p><c:out value="${product.productDescription}"/></p>
                                            </h5>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-2 col-lg-2 col-xl-2">
                                    <div class="row align-items-center">
                                        <div class="col-12">
                                            <a>Quantity</a>
                                        </div>
                                        <div class="col-12">
                                            <h5 style="position: relative; margin-top: 10px" class="mb-0">
                                                <p><c:out value="${product.productQuantity}"/></p>
                                            </h5>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-2 col-lg-2 col-xl-2">
                                    <div class="row align-items-center">
                                        <div class="col-12">
                                            <a>Price</a>
                                        </div>
                                        <div class="col-12">
                                            <h5 style="position: relative; margin-top: 10px" class="mb-0">
                                                <p><c:out value="${product.productPrice}"/> VNĐ</p>
                                            </h5>
                                        </div>
                                    </div>
                                </div>
                                    <%-- teem xóa sửa --%>
                            </div>
                        </div>
                    </div>

                </c:forEach>


                <div class="col-md-1 col-lg-1 col-xl-1 text-end">
                    <a href="<c:url value='/add_product'/>">
                        <button type="button" class="btn btn-outline-warning btn-sm ms-2">Add New Product</button>
                    </a>
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
