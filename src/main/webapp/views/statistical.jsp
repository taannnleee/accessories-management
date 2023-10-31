<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 31/10/2023
  Time: 1:58 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Trang Thống Kê</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-oxftz5HRPNYSm8knnzbEBgby4yZlq3U1z0AqGw9sU2vBXYqb2F5PkJr0I5aO5O8kW" crossorigin="anonymous"></script>
</head>
<body>
<div class="container">
    <h1 class="mt-5">Trang Thống Kê</h1>
    <div class="row mt-4">
        <div class="col-md-6">
            <h2>Tài Khoản</h2>
            <table class="table">
                <thead>
                <tr>
                    <th>Tên</th>
                    <th>Email</th>
                    <th>Vai Trò</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td>Lê Tân</td>
                    <td>letan@gmail.com</td>
                    <td>Người Dùng</td>
                </tr>
                <tr>
                    <td>Người Dùng 2</td>
                    <td>user2@example.com</td>
                    <td>Người Dùng</td>
                </tr>
                <!-- Thêm dữ liệu tài khoản khác tại đây -->
                </tbody>
            </table>
        </div>
        <div class="col-md-6">
            <h2>Sản Phẩm Đã Bán</h2>
            <table class="table">
                <thead>
                <tr>
                    <th>Tên Sản Phẩm</th>
                    <th>Doanh Số</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td>Sản Phẩm 1</td>
                    <td>1000</td>
                </tr>
                <tr>
                    <td>Sản Phẩm 2</td>
                    <td>500</td>
                </tr>
                <!-- Thêm dữ liệu sản phẩm khác tại đây -->
                </tbody>
            </table>
        </div>
    </div>
    <div class="row mt-4">
        <div class="col">
            <h2>Biểu Đồ Doanh Thu</h2>
            <canvas id="myChart" width="400" height="200"></canvas>
        </div>
    </div>
</div>

<!-- Thêm mã JavaScript để tạo biểu đồ sử dụng Chart.js -->
<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
<script>
    var ctx = document.getElementById('myChart').getContext('2d');
    var myChart = new Chart(ctx, {
        type: 'bar',
        data: {
            labels: ['Tháng 1', 'Tháng 2', 'Tháng 3', 'Tháng 4', 'Tháng 5'],
            datasets: [{
                label: 'Doanh Thu',
                data: [12000, 18000, 15000, 20000, 22000],
                backgroundColor: 'rgba(75, 192, 192, 0.2)',
                borderColor: 'rgba(75, 192, 192, 1)',
                borderWidth: 1
            }]
        },
        options: {
            scales: {
                y: {
                    beginAtZero: true
                }
            }
        }
    });
</script>
</body>
</html>
