<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Main menu</title>
    <link rel="stylesheet" href="static/Styles.css">
</head>
<body>
<div class="container">
    <h1>Main Menu</h1>

    <form action="/registration" method="get">
        <button id="menu-signup">Go to Sign Up</button>
    </form>

    <form action="/login" method="get">
        <button id="menu-signIn">Go to Sign In</button>
    </form>

    <form action="/secure/accountMenu" method="get">
        <button id="menu-account">Account Menu</button>
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
