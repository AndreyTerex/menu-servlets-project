<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Registration</title>
    <link rel="stylesheet" href="static/Styles.css">
</head>
<body>
<div class="container">
    <h1>Sign Up</h1>
    <form action="/registration" method="post">
        <label for="login">Login</label>
        <input type="text" id="login" name="login" placeholder="Login for registration" required>

        <label for="password">Password</label>
        <input type="password" id="password" name="password" placeholder="Password for registration" required>

        <button type="submit">Sign Up</button>
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