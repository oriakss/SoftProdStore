<%@ page import="com.softprod.entities.OrderStatus" %>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Create order</title>
</head>
<body>
<table>
    <thead>
    <tr>
        <th>TOTAL PRICE</th>
        <th>PRODUCTS NUM</th>
        <th>STATUS</th>
    </tr>
    </thead>
    <tbody>
    <form action="/orders/create" method="post">
        <tr>
            <td><input type="text" name="totalPrice" placeholder="put order total price"></td>
            <td><input type="text" name="productsNum" placeholder="put order products num"></td>
            <td><select name="status" required>
                <option label="---put status---"></option>
                <c:forEach var="status" items="${OrderStatus.values()}">
                    <option>${status}</option>
                </c:forEach>
            </select></td>
            <td><input type="submit" value="Create"></td>
        </tr>
    </form>
    </tbody>
</table>
</body>
</html>