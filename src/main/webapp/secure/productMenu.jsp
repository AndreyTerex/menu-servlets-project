<%--
  Created by IntelliJ IDEA.
  User: kat
  Date: 05.05.2025
  Time: 19:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Products</title>|
    <link rel="stylesheet" href="../static/Styles.css">
</head>
<body>
<div class="container">
    <h1>Add Product</h1>
    <form action="/secure/product" method="post">
        <label for="product-name">Product name</label>
        <input type="text" id="product-name" name="productName" placeholder="Enter product name" required>
        <label for="product-price">Product price</label>
        <input type="text" id="product-price" name="productPrice" placeholder="Enter product price">
        <label for="product-image">Product image</label>
        <input type="text" id="product-image" name="productImage" placeholder="Enter image URL">
        <button type="submit">Add</button>
    </form>
    <h2>Your Products</h2>
    <ul>
        <c:forEach var="product" items="${products}">
            <strong>${product.productName}</strong> — ${product.productPrice}<br>
            <img src="${product.productImageUrl}" width="100" alt="None"><br>
            <form action="/secure/product" method="post">
                <input type="hidden" name="_method" value="DELETE">
                <input type="hidden" name="product-id" value="${product.productId}">
                <button type="submit" name="remove-button">Delete</button>
            </form>
        </c:forEach>
    </ul>
</div>
<script>
    // Плавное исчезновение перед переходом
    document.querySelectorAll("form").forEach(form => {
        form.addEventListener("submit", function (e) {
            document.body.classList.add("fade-out");
        });
    });

    // Плавное появление при загрузке
    window.addEventListener("DOMContentLoaded", () => {
        document.body.classList.add("fade-in");
    });
</script>
</body>
</html>
