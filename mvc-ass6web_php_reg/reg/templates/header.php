<!doctype html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>ระบบลงทะเบียนเรียน</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous"> 
    <link rel="stylesheet" href="/Style/Style.css">
</head>
<style>
    .navbar, footer {
        width: 100%;
    }

    .navbar-brand {
        font-size: 1.5em;
        font-weight: bold;
    }

    .navbar-nav .nav-link {
        font-size: 1.1em;
        margin-right: 15px;
        transition: color 0.3s, background-color 0.3s;
    }

    .navbar-nav .nav-link:hover {
        color: #00796b;
        background-color: #f8f9fa;
        border-radius: 5px;
    }

    .navbar-toggler {
        border: none;
    }

    .navbar-toggler:focus {
        outline: none;
        box-shadow: none;
    }

    .navbar-toggler-icon {
        background-image: url("data:image/svg+xml;charset=utf8,%3Csvg viewBox='0 0 30 30' xmlns='http://www.w3.org/2000/svg'%3E%3Cpath stroke='rgba%28255, 255, 255, 0.5%29' stroke-width='2' stroke-linecap='round' stroke-miterlimit='10' d='M4 7h22M4 15h22M4 23h22'/%3E%3C/svg%3E");
    }
</style>
<body>
    <?php if (isset($_SESSION['alert'])): 
        echo $_SESSION['alert']; 
        unset($_SESSION['alert']); // ลบข้อความแจ้งเตือนหลังจากแสดงแล้ว 
        ?>
    <?php endif; ?>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script> 
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <div class="container-fluid">
            <a class="navbar-brand" href="/main">ระบบลงทะเบียนเรียน</a> <!-- เปลี่ยน href เป็น /main -->
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav ms-auto">
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="/main">หน้าแรก</a>
                    </li>
                    <?php if (isset($_SESSION['timestamp'])): ?>
                        <li class="nav-item">
                            <a class="nav-link" href="/profile">ข้อมูลนักเรียน</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/courses">รายวิชา</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/logout">ออกจากระบบ</a>
                        </li>
                    <?php else: ?>
                        <li class="nav-item">
                            <a class="nav-link" href="/login">เข้าสู่ระบบ</a>
                        </li>
                    <?php endif; ?>
                </ul>
            </div>
        </div>
    </nav>
</body>

</html>