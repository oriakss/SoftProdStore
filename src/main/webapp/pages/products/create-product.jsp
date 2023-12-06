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
            <td><input type="text" name="category" placeholder="put product category"></td>
            <td><input type="text" name="price" placeholder="put product price"></td>
            <td><input type="submit" value="Create"></td>
        </tr>
    </form>
    </tbody>
</table>
</body>
</html>
