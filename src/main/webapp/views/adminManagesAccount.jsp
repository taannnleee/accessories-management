<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 30/10/2023
  Time: 9:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
    <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
</head>
<body>


<div class="container">
    <div class="container-fluid">
        <div class="row">
            <div class="col-md-5">

            </div>

            <div class="col-md-3">
                <div class="input-group rounded">
                    <input type="search" class="form-control rounded" placeholder="Search" aria-label="Search" aria-describedby="search-addon" />
                    <button class="btn btn-outline-secondary" type="button" id="search-addon">
                        <i class="fas fa-search"></i>
                    </button>
                </div>
            </div>

            <div class="col-md-2">
                <a class="nav-link text-center" href="/home/login">
                    <i class="fas fa-sign-in-alt"></i> Đăng nhập
                </a>
            </div>
            <div class="col-md-2 ">
                <a class="nav-link text-left" href="/home/signup">
                    <i class="fas fa-user"></i> Đăng kí
                </a>
            </div>
        </div>
    </div>

    <div class="container-fluid">
        <div class="row">
            <nav class="col-md-2 d-none d-md-block bg-light sidebar"
                 style="position: fixed;top: 0;
                        left: 0;
                        height: 100%;
                        overflow-y: auto;">
                <div class="position-sticky">
                    <ul class="nav flex-column">
                        <li class="nav-item">
                            <a class="nav-link active" href="#">
                                <i class="fas fa-home"></i> Trang chủ
                            </a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#" data-toggle="modal" data-target="#addUserModal">
                                <i class="fas fa-plus"></i> Thêm
                            </a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">
                                <i class="fas fa-cog"></i> Cài đặt
                            </a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">
                                <i class="fas fa-sign-out-alt"></i> Đăng xuất
                            </a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#" id="showChart">
                                <i class="fas fa-chart-bar"></i> Biểu đồ
                            </a>
                        </li>
                    </ul>
                </div>
            </nav>
            <div class="col-md-2"></div>
            <div class="col-md-8">
                <!-- Bảng hiển thị danh sách tài khoản người dùng -->
                <table class="table">
                    <thead>
                    <tr>
                        <th>Tên người dùng</th>
                        <th>Mật khẩu</th>
                        <th>Thao tác</th>
                    </tr>
                    </thead>
                    <tbody>
                    <!-- Mỗi hàng là một tài khoản -->
                    <tr>
                        <td>LeTan</td>
                        <td>190212736</td>
                        <td>
                            <button type="button" class="btn btn-success" data-toggle="modal" data-target="#editUserModal">Sửa</button>
                            <button type="button" class="btn btn-danger" data-toggle="modal" data-target="#deleteUserModal">Xóa</button>
                        </td>
                    </tr>
                    <tr>
                        <td>HuyDieu</td>
                        <td>12435567</td>
                        <td>
                            <button type="button" class="btn btn-success" data-toggle="modal" data-target="#editUserModal">Sửa</button>
                            <button type="button" class="btn btn-danger" data-toggle="modal" data-target="#deleteUserModal">Xóa</button>
                        </td>
                    </tr>
                    <tr>
                        <td>ThanhHau</td>
                        <td>13435647564423</td>
                        <td>
                            <button type="button" class="btn btn-success" data-toggle="modal" data-target="#editUserModal">Sửa</button>
                            <button type="button" class="btn btn-danger" data-toggle="modal" data-target="#deleteUserModal">Xóa</button>
                        </td>
                    </tr>
                    <tr>
                        <td>ThanhTun</td>
                        <td>4334656546</td>
                        <td>
                            <button type="button" class="btn btn-success" data-toggle="modal" data-target="#editUserModal">Sửa</button>
                            <button type="button" class="btn btn-danger" data-toggle="modal" data-target="#deleteUserModal">Xóa</button>
                        </td>
                    </tr>
                    <!-- Thêm các hàng tài khoản khác ở đây -->
                    </tbody>
                </table>
                <!-- Nút thêm tài khoản -->
                <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#addUserModal">Thêm tài khoản</button>
            </div>


        </div>
    </div>
</div>

<!-- Modal thêm tài khoản -->
<div class="modal fade" id="addUserModal" tabindex="-1" role="dialog" aria-labelledby="addUserModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="addUserModalLabel">Thêm tài khoản</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <!-- Thêm nội dung form thêm tài khoản ở đây -->
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Đóng</button>
                <button type="button" class="btn btn-primary">Lưu</button>
            </div>
        </div>
    </div>
</div>

<!-- Modal sửa tài khoản -->
<div class="modal fade" id="editUserModal" tabindex="-1" role="dialog" aria-labelledby="editUserModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="editUserModalLabel">Sửa tài khoản</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <!-- Thêm nội dung form sửa tài khoản ở đây -->
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Đóng</button>
                <button type="button" class="btn btn-primary">Lưu</button>
            </div>
        </div>
    </div>
</div>

<!-- Modal xóa tài khoản -->
<div class="modal fade" id="deleteUserModal" tabindex="-1" role="dialog" aria-labelledby="deleteUserModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="deleteUserModalLabel">Xóa tài khoản</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <!-- Thêm nội dung xác nhận xóa tài khoản ở đây -->
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Hủy</button>
                <button type="button" class="btn btn-danger">Xóa</button>
            </div>
        </div>
    </div>
</div>




<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.1/dist/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
