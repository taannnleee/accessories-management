<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 19/11/2023
  Time: 11:17 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Thêm sản phẩm</title>

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<h1>Thêm sản phẩm</h1>
<form action="add_product" method="post"  enctype="multipart/form-data">

    <div class="form-group">
        <label for="productCategory">Danh mục sản phẩm:</label>
        <select class="form-control" id="productCategory" name="categoryId">
            <c:forEach var="category" items="${CATEGORY}">
                <option value="${category.productCategoryID}">${category.categoryName}</option>
            </c:forEach>
        </select>
    </div>


    <div class="form-group">
        <label for="name">Tên sản phẩm:</label>
        <input type="text" class="form-control" id="name" name="name">
    </div>
    <div class="form-group">
        <label for="description">Mô tả sản phẩm:</label>
        <textarea class="form-control" id="description" name="description"></textarea>
    </div>
    <div class="form-group">
        <label for="price">Giá sản phẩm:</label>
        <input  type="number" class="form-control" id="price" name="price">
    </div>
    <div class="form-group">
        <label for="image_multipart">Hình ảnh sản phẩm:</label>
        <input  type="file" class="form-control" id="image_multipart" name="image_multipart" placeholder="image_url">
    </div>
    <div class="form-group">
        <label for="quantity">Số lượng sản phẩm:</label>
        <input type="number" class="form-control" id="quantity" name="quantity">
    </div>

    <button type="submit" class="btn btn-primary">Thêm sản phẩm</button>
</form>
</body>
</html>
