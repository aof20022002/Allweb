<style>
    body {
        margin: 0;
        font-family: Arial, sans-serif;
        background-color: #e0f7fa; /* เปลี่ยนสีพื้นหลัง */
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
        width: 100vw; /* เพิ่มความกว้างเต็มจอ */
    }

    section {
        display: flex;
        flex-direction: column;
        justify-content: center;
        align-items: center;
        width: 100%; /* เพิ่มความกว้างเต็มจอ */
        height: 100%; /* เพิ่มความสูงเต็มจอ */
        text-align: center;
        background-color: #e0f7fa; /* เปลี่ยนสีพื้นหลัง */
        padding: 40px; /* เพิ่ม padding */
        border-radius: 10px;
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
    }

    h1 {
        font-family: Arial, sans-serif;
        color: #333;
        margin-bottom: 20px;
    }

    p {
        font-family: Arial, sans-serif;
        color: #333;
        margin-bottom: 20px;
    }

    a {
        font-family: Arial, sans-serif;
        color: #00796b;
        text-decoration: none;
        padding: 10px 20px;
        border: 1px solid #00796b;
        border-radius: 5px;
        transition: background-color 0.3s, color 0.3s;
    }

    a:hover {
        background-color: #00796b;
        color: #fff;
    }
</style>

<section>
    <h1>ยินดีต้อนรับ <?= $data['result']['first_name']?> </h1>
    <p>เรายินดีที่ได้พบคุณ</p>
    <a href="/profile">ดูข้อมูลส่วนตัว</a>
</section>