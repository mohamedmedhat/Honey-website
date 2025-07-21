<%@ page contentType="text/html;charset=UTF-8" %>
<!DocType html>
<html lang="en">
<head>
    <title>Add Product</title>
</head>
<body>
    <h2>Add New Product</h2>
    <form action="${pageContext.request.contextPath}/shop" method="post">
        Name: <input type="text" name="name" required/><br/>
        Price: <input type="number" name="price" step="0.01" required/><br/>
        Description: <input type="text" name="description" required/><br/>
        Image URL: <input type="text" name="imagePath" required/><br/>
        <button type="submit">Save</button>
    </form>
</body>
</html>
