<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DocType html>
<html>
<head>
    <title>Edit Product</title>
</head>
<body>
<h2>Edit Product</h2>
<form action="${pageContext.request.contextPath}/shop" method="post">
    <input type="hidden" name="id" value="${product.id}" />
    Name: <input type="text" name="name" value="${product.name}" required/><br/>
    Price: <input type="number" step="0.01" name="price" value="${product.price}" required/><br/>
    Description: <input type="text" name="description" value="${product.description}" required/><br/>
    Image URL: <input type="text" name="imagePath" value="${product.imagePath}" required/><br/>
    <button type="submit">Update</button>
</form>
</body>
</html>
