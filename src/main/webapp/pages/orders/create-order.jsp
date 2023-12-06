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
            <td><input type="text" name="status" placeholder="put order status"></td>
            <td><input type="submit" value="Create"></td>
        </tr>
    </form>
    </tbody>
</table>
</body>
</html>
