<%--
  Created by IntelliJ IDEA.
  User: kat
  Date: 02.05.2025
  Time: 11:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Account Menu</title>
    <link rel="stylesheet" href="../static/Styles.css">
</head>
<body>
<div class="container">
    <h1>Account Menu</h1>
    <form action="/secure/product" method="get">
        <button type="submit">Products</button>
    </form>
    <form action="/secure/updatePassword" method="get">
        <button type="submit">Change Password</button>
    </form>

    <form action="/secure/delete" method="get">
        <button type="submit">Delete account</button>
    </form>
    <form action="/secure/accountMenu" method="post">
        <button type="submit">Log out</button>
    </form>
    <form action="/menu" method="get">
        <button type="submit">Main menu</button>
    </form>
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
