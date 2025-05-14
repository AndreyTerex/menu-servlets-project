<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Login</title>
    <link rel="stylesheet" href="static/Styles.css">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>
<div class="container">
    <h1>Sign In</h1>
    <form action="/login" method="post">
        <label for="login">Login</label>
        <input type="text" id="login" name="login" placeholder="Enter your login" required>

        <label for="password">Password</label>
        <input type="password" id="password" name="password" placeholder="Enter your password" required>

        <button type="submit" name="signInButton">Sign In</button>
    </form>
    <form action="/registration" method="get">
        <button type="submit" name="signUpButton">Sign Up</button>
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