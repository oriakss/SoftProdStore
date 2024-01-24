<%@ page import="com.softprod.entities.ProductCategory" %>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Create product</title>
</head>
<body>
<table>
    <thead>
    <tr>
        <th>NAME</th>
        <th>BRAND</th>
        <th>CATEGORY</th>
        <th>PRICE</th>
    </tr>
    </thead>
    <tbody>
    <form action="/products/create" method="post">
        <tr>
            <td><input type="text" name="name" placeholder="put product name"></td>
            <td><input type="text" name="brand" placeholder="put product brand"></td>
            <td><select name="category" required>
                <option label="---put category---"></option>
                <c:forEach var="category" items="${ProductCategory.values()}">
                    <option>${category}</option>
                </c:forEach>
            </select></td>
            <td><input type="text" name="price" placeholder="put product price"></td>
            <td><input type="submit" value="Create"></td>
        </tr>
    </form>
    </tbody>
</table>
</body>
</html>