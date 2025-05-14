<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport"
        content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>Account Menu</title>
  <link rel="stylesheet" href="../static/Styles.css">
</head>
<body>
<div class="container">
  <h1>Update Password Menu</h1>
  <form id="updateForm" action="/secure/updatePassword" method="post">
    <label for="LoginForUpdatePassword">Login</label>
    <input type="text" id="LoginForUpdatePassword" name="login" placeholder="Enter your login" required>

    <label for="CurrentPassword">Current Password</label>
    <input type="password" id="CurrentPassword" name="currentPassword" placeholder="Enter your current password" required>

    <label for="NewPassword">New Password</label>
    <input type="password" id="NewPassword" name="newPassword" placeholder="Enter your NEW password" required>

    <label for="confirmNewPassword">Confirm Password</label>
    <input type="password" id="confirmNewPassword" placeholder="Confirm your NEW password" required>

    <!-- Сообщение об ошибке -->
    <div id="passwordError" class="error-message"></div>

    <button type="submit">Update account</button>
  </form>
</div>

<!-- Модальное окно подтверждения -->
<div class="modal-overlay" id="modalOverlay">
  <div class="modal">
    <p>Are you sure you want to change your password?</p>
    <button id="confirmUpdate">Yes, update</button>
    <button id="cancelUpdate">Cancel</button>
  </div>
</div>

<script>
  const form = document.getElementById("updateForm");
  const modalOverlay = document.getElementById("modalOverlay");
  const confirmBtn = document.getElementById("confirmUpdate");
  const cancelBtn = document.getElementById("cancelUpdate");
  const errorDiv = document.getElementById("passwordError");

  form.addEventListener("submit", function (e) {
    e.preventDefault();

    const newPassword = document.getElementById("NewPassword").value;
    const confirmPassword = document.getElementById("confirmNewPassword").value;

    if (newPassword !== confirmPassword) {
      errorDiv.textContent = "Passwords do not match.";
      errorDiv.style.display = "block";
      return;
    }

    errorDiv.style.display = "none"; // скрыть, если всё нормально
    modalOverlay.style.display = "flex";
  });

  confirmBtn.addEventListener("click", function () {
    modalOverlay.style.display = "none";
    form.submit();
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
