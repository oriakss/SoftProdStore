<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>PRODUCTS MENU</title>
</head>
<body>
<table>
    <thead>
    <tr>
        <th>ID</th>
        <th>NAME</th>
        <th>BRAND</th>
        <th>CATEGORY</th>
        <th>PRICE</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="product" items="${products}">
        <form method="post">
            <tr>
                <td><input type="text" name="id" value="${product.id}" readonly size="1"></td>
                <td><input type="text" name="name" value="${product.name}" required></td>
                <td><input type="text" name="brand" value="${product.brand}" required></td>
                <td><input type="text" name="category" value="${product.category}" required></td>
                <td><input type="text" name="price" value="${product.price}" required></td>
                <td><input type="submit" formaction="/products/delete" value="Delete"></td>
                <td><input type="submit" formaction="/products/update" value="Update"></td>
            </tr>
        </form>
    </c:forEach>
    </tbody>
</table>
<form method="get">
    <button formaction="/products/create">Create product</button>
    <button formaction="/products/read">Get product list</button>
    <div><br><a href="/admin-menu">Go to ADMIN MENU</a></div>
</form>
</body>
</html>