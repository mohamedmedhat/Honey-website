<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DocType html>
<html lang="en">
<head>
    <title>Honey Shop</title>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/res.css" />
        <link rel="icon" href="${pageContext.request.contextPath}/img/p4.png" />

        <!-- icons url -->
        <link rel="stylesheet"
      href="https://unpkg.com/boxicons@latest/css/boxicons.min.css">

      <!-- fonts url -->
      <link rel="preconnect" href="https://fonts.googleapis.com">
     <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
     <link href="https://fonts.googleapis.com/css2?family=Poppins:ital,wght@0,300;0,400;0,500;0,600;0,700;0,800;1,500&display=swap" rel="stylesheet">

</head>
<body>
<%@ include file="header.jsp" %>
<%@ include file="home.jsp" %>
<%@ include file="container.jsp" %>
<%@ include file="about.jsp" %>
<%@ include file="ourshop.jsp" %>
<%@ include file="review.jsp" %>
<%@ include file="contact.jsp" %>
    <h1>Honey Products</h1>
    <div class="products">
        <c:forEach var="p" items="${products}">
            <div class="product">
                <img src="${p.imagePath}" width="100" alt="product img"/>
                <h3>${p.name}</h3>
                <p>$${p.price}</p>
                <a href="${pageContext.request.contextPath}/shop?action=edit&id=${p.id}">Edit</a> |
                <a href="${pageContext.request.contextPath}/shop?action=delete&id=${p.id}" onclick="return confirm('Delete this product?');">Delete</a>
            </div>
        </c:forEach>
    </div>

     <a href="#" class="scroll">
            <i class='bx bx-up-arrow-alt' ></i>
        </a>

        <script src="https://unpkg.com/scrollreveal"></script>

        <script src="${pageContext.request.contextPath}/js/res.js"></script>
</body>
</html>
