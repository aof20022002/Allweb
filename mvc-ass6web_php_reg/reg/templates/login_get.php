
<style>
    body {
        margin: 0;
        font-family: Arial, sans-serif;
        background-color: #e0f7fa; /* เปลี่ยนสีพื้นหลัง */
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
    }

    .login-container {
        max-width: 400px;
        width: 100%;
        background-color: #ffffff;
        padding: 20px;
        border-radius: 10px;
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        text-align: center;
    }

    .login-container h1 {
        color: #00796b; /* เปลี่ยนสีหัวข้อ */
        margin-bottom: 20px;
    }

    .login-container label {
        display: block;
        margin-bottom: 5px;
        color: #333;
        text-align: left;
    }

    .login-container input[type="email"],
    .login-container input[type="password"] {
        width: 100%;
        padding: 10px;
        margin-bottom: 10px;
        border: 1px solid #ddd;
        border-radius: 5px;
    }

    .login-container input[type="submit"] {
        width: 100%;
        padding: 10px;
        background-color: #00796b;
        color: #ffffff;
        border: none;
        border-radius: 5px;
        cursor: pointer;
    }

    .login-container input[type="submit"]:hover {
        background-color: #004d40;
    }

    .login-container .message {
        color: red;
        margin-top: 10px;
    }
</style>

<section class="login-container">
    <h1>เข้าสู่ระบบ</h1>
    <form action="/login" method="post">
        <label for="email">อีเมล:</label>
        <input type="email" id="email" name="email">
        <label for="password">รหัสผ่าน:</label>
        <input type="password" id="password" name="password">
        <input type="submit" value="เข้าสู่ระบบ">
    </form>
    <?php
    if (isset($_SESSION['message'])) {
        echo '<div class="message">' . $_SESSION['message'] . '</div>';
    }
    ?>
</section>