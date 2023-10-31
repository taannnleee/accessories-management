<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 31/10/2023
  Time: 12:28 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
    <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
    <link rel="stylesheet" href="test.css">
    <style>
        .img-container {
            position: relative;
        }
        .image-overlay {
            position: absolute;
            top: 50%;
            left: 50%;
            transform: translate(-50%, -50%);
            background: rgba(0, 0, 0, 0.5);
            color: white;
            text-align: center;
            opacity: 0;
            transition: opacity 0.3s;
            padding: 10px;
        }
        .img-container:hover .image-overlay {
            opacity: 1;
        }
        .btn {
            margin: 5px;
        }
    </style>
</head>
<body>
<div class="container-fluid">
    <h4>Item</h4>
    <div class="row">
        <div class="col-12 col-sm-6 col-md-4 img-container">
            <img src="https://ananas.vn/wp-content/uploads/Pro_AV00204_2-500x500.jpeg" alt="Sản phẩm 1">
            <div class="image-overlay">
                <button class="btn btn-danger btn-delete">Xóa</button>
                <button class="btn btn-primary btn-edit">Sửa</button>
            </div>
        </div>

        <div class="col-12 col-sm-6 col-md-4 img-container">
            <img src="https://ananas.vn/wp-content/uploads/Pro_AV00180_2-500x500.jpeg" alt="Sản phẩm 1">
            <div class="image-overlay">
                <button class="btn btn-danger btn-delete">Xóa</button>
                <button class="btn btn-primary btn-edit">Sửa</button>
            </div>
        </div>

        <div class="col-12 col-sm-6 col-md-4 img-container">
            <img src="https://ananas.vn/wp-content/uploads/Pro_A6T015_2-500x500.jpeg" alt="Sản phẩm 1">
            <div class="image-overlay">
                <button class="btn btn-danger btn-delete">Xóa</button>
                <button class="btn btn-primary btn-edit">Sửa</button>
            </div>
        </div>
    </div>
    <br>
    <div class="row">
        <div class="col-12 col-sm-6 col-md-4 img-container">
            <img src="https://ananas.vn/wp-content/uploads/Pro_AV00154_2-500x500.jpg" alt="Sản phẩm 1">
            <div class="image-overlay">
                <button class="btn btn-danger btn-delete">Xóa</button>
                <button class="btn btn-primary btn-edit">Sửa</button>
            </div>
        </div>

        <div class="col-12 col-sm-6 col-md-4 img-container">
            <img src="https://ananas.vn/wp-content/uploads/Pro_AHCS004_2-500x500.jpg" alt="Sản phẩm 1">
            <div class="image-overlay">
                <button class="btn btn-danger btn-delete">Xóa</button>
                <button class="btn btn-primary btn-edit">Sửa</button>
            </div>
        </div>

        <div class="col-12 col-sm-6 col-md-4 img-container">
            <img src="https://ananas.vn/wp-content/uploads/Pro_A6T016_2-500x500.jpeg" alt="Sản phẩm 1">
            <div class="image-overlay">
                <button class="btn btn-danger btn-delete">Xóa</button>
                <button class="btn btn-primary btn-edit">Sửa</button>
            </div>
        </div>
    </div>
</div>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.1/dist/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>

