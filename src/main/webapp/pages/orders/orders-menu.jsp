<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.softprod.entities.OrderStatus" %>
<html>
<head>
    <title>ORDERS MENU</title>
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
        <form method="post">
            <tr>
                <td><input type="text" name="id" value="${order.id}" readonly size="1"></td>
                <td><input type="text" name="totalPrice" value="${order.totalPrice}" readonly></td>
                <td><input type="text" name="productsNum" value="${order.productsNum}" readonly></td>
                <td><select name="status" required>
                    <option>${order.status}</option>
                    <c:forEach var="status" items="${OrderStatus.values()}">
                        <option>${status}</option>
                    </c:forEach>
                </select></td>
                <td><input type="submit" formaction="/orders/delete" value="Delete"></td>
                <td><input type="submit" formaction="/orders/update" value="Update"></td>
            </tr>
        </form>
    </c:forEach>
    </tbody>
</table>
<form method="get">
    <button formaction="/orders/create">Create order</button>
    <button formaction="/orders/read">Get order list</button>
    <div><br><a href="/admin-menu">Go to ADMIN MENU</a></div>
</form>
</body>
</html>