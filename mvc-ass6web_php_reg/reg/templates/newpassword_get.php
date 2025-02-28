
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

    .password-container {
        max-width: 400px;
        width: 100%;
        background-color: #ffffff;
        padding: 20px;
        border-radius: 10px;
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        text-align: center;
    }

    .password-container h1 {
        color: #00796b; /* เปลี่ยนสีหัวข้อ */
        margin-bottom: 20px;
    }

    .password-container label {
        display: block;
        margin-bottom: 5px;
        color: #333;
        text-align: left;
    }

    .password-container input[type="text"],
    .password-container input[type="password"] {
        width: 100%;
        padding: 10px;
        margin-bottom: 10px;
        border: 1px solid #ddd;
        border-radius: 5px;
    }

    .password-container input[type="submit"] {
        width: 100%;
        padding: 10px;
        background-color: #00796b;
        color: #ffffff;
        border: none;
        border-radius: 5px;
        cursor: pointer;
    }

    .password-container input[type="submit"]:hover {
        background-color: #004d40;
    }
</style>

<section class="password-container">
    <h1>อัปเดตรหัสผ่าน</h1>
    <form action="/newpassword" method="post">
        <label for="id">ID</label>
        <input type="text" id="id" name="id">
        <label for="password">รหัสผ่าน:</label>
        <input type="password" id="password" name="password">
        <input type="submit" value="อัปเดตรหัสผ่าน">
    </form>
</section>