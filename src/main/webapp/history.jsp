<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <!-- Các phần head khác -->
</head>
<body>
<h1>List of Orders</h1>
<c:forEach var="order" items="${shopOrders}">
    <h2>${order.addressShipping}</h2> <!-- Hiển thị thông tin đơn hàng -->
    <table>
        <thead>
        <tr>
            <th>Item</th>
            <th>Quantity</th>
            <th>Price</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="item" items="${order.shopOrderLineItems}">
            <tr>
                <td>${item.itemName}</td> <!-- Hiển thị thông tin mặt hàng -->
                <td>${item.quantity}</td>
                <td>${item.size}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</c:forEach>
</body>
</html>
