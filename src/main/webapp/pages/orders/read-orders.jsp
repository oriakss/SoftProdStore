<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Read orders</title>
</head>
<body>
    <table>
        <thead>
        <tr>
            <th>ID</th>
            <th>TOTAL PRICE</th>
            <th>PRODUCTS NUM</th>
            <th>STATUS</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="order" items="${orders}">
            <tr>
                <td>${order.id}</td>
                <td>${order.totalPrice}</td>
                <td>${order.productsNum}</td>
                <td>${order.status}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</body>
</html>
