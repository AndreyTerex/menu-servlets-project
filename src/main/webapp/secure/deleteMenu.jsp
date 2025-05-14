<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Account Menu</title>
    <link rel="stylesheet" href="../static/Styles.css">
    <link rel="stylesheet" href="static/modal.css">
</head>
<body>
<div class="container">
    <h1>Delete Menu</h1>
    <form id="deleteForm" action="/secure/delete" method="post">

        <label for="LoginForDelete">Login</label>
        <input type="text" id="LoginForDelete" name="login" placeholder="Enter your login">

        <label for="PasswordForDelete">Password</label>
        <input type="password" id="PasswordForDelete" name="password" placeholder="Enter your password">
        <button type="submit">Delete account</button>
    </form>
</div>

<!-- Модальное окно -->
<div id="modalOverlay" class="modal-overlay">
    <div class="modal">
        <p>Are you sure you want to delete your account? This action cannot be undone.</p>
        <button id="confirmDelete">Yes, delete</button>
        <button id="cancelDelete">Cancel</button>
    </div>
</div>

<script>
    const form = document.getElementById("deleteForm");
    const modalOverlay = document.getElementById("modalOverlay");
    const confirmBtn = document.getElementById("confirmDelete");
    const cancelBtn = document.getElementById("cancelDelete");

    // Перехватываем кнопку отправки, чтобы не отправлялась форма сразу
    form.addEventListener("submit", function (e) {
        e.preventDefault(); // Останавливаем стандартную отправку
        modalOverlay.style.display = "flex"; // Показываем модальное окно
    });

    confirmBtn.addEventListener("click", function () {
        modalOverlay.style.display = "none";
        form.submit(); // Только теперь реально отправляем форму
    });

    cancelBtn.addEventListener("click", function () {
        modalOverlay.style.display = "none";
    });
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