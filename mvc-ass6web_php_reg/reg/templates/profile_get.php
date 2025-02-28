<!-- 
<section>
    <h2 style="margin: 1%;">ช้อมูลนักเรียน</h2>
    <div class="profile">
    <div class="card">
    <table border="1">
        <tr>
            <th>ชื่อ</th>
            <td><?= $data['result']['first_name'] ?></td>
        </tr>
        <tr>
            <th>นามสกุล</th>
            <td><?= $data['result']['last_name'] ?></td>
        </tr>
        <tr>
            <th>วันเกิด</th>
            <td><?= $data['result']['date_of_birth'] ?></td>
        </tr>
        <tr>
            <th>เบอร์โทรศัพท์</th>
            <td><?= $data['result']['phone_number'] ?></td>
        </tr>
    </table>
    </div>
    </div>
    <h2 style="margin: 1%;">วิชาที่ลงทะเบียนเรียน</h2>
    <table border="1">
        <thead>
            <tr>
                <th>รหัสวิชา</th>
                <th>ชื่อวิชา</th>
                <th>อาจารย์ผู้สอน</th>
                <th>วันที่ลงทะเบียน</th>
                <th></th>
            </tr>
        </thead>
        <tbody>
            <?php foreach ($data['enrollments'] as $enrollment): ?>
                <tr>
                    <td><?= $enrollment['course_code'] ?></td>
                    <td><?= $enrollment['course_name'] ?></td>
                    <td><?= $enrollment['instructor'] ?></td>
                    <td><?= $enrollment['enrollment_date'] ?></td>
                    <td><form action="/profile" method="post">
                    <input type="hidden" name="student_id" value="<?= $data['result']['student_id'] ?>">
                    <input type="hidden" name="course_id" value="<?= $enrollment['course_id'] ?>">
                            <input type="submit" class="btn btn-danger" onclick="return confirmSubmission()" value="ถอนรายวิชา">
                        </form>
                    </td>
                </tr>
            <?php endforeach; ?>
        </tbody>
    </table>
</section>
<script>
    function confirmSubmission() {
        return confirm("คุณต้องการถอนรายวิชานี้ใช่หรือไม่?");
    }
</script> -->

<style>
    body {
        margin: 0;
        font-family: Arial, sans-serif;
        background-color: #e0f7fa; /* เปลี่ยนสีพื้นหลัง */
        display: flex;
        justify-content: center;
        align-items: center;
        min-height: 100vh;
    }

    section {
        width: 80%;
        background-color: #ffffff;
        padding: 20px;
        border-radius: 10px;
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        margin: 20px;
    }

    h2 {
        color: #00796b; /* เปลี่ยนสีหัวข้อ */
        margin-bottom: 20px;
    }

    .profile, .card {
        margin-bottom: 20px;
    }

    table {
        width: 100%;
        border-collapse: collapse;
        margin-bottom: 20px;
    }

    table, th, td {
        border: 1px solid #ddd;
    }

    th, td {
        padding: 12px;
        text-align: left;
    }

    th {
        background-color: #00796b;
        color: #ffffff;
    }

    tr:nth-child(even) {
        background-color: #f2f2f2;
    }

    tr:hover {
        background-color: #ddd;
    }

    .btn {
        background-color: #d32f2f;
        color: #ffffff;
        border: none;
        padding: 10px 20px;
        border-radius: 5px;
        cursor: pointer;
    }

    .btn:hover {
        background-color: #c62828;
    }
</style>

<section>
    <h2>ข้อมูลนักเรียน</h2>
    <div class="profile">
        <div class="card">
            <table>
                <tr>
                    <th>ชื่อ</th>
                    <td><?= $data['result']['first_name'] ?></td>
                </tr>
                <tr>
                    <th>นามสกุล</th>
                    <td><?= $data['result']['last_name'] ?></td>
                </tr>
                <tr>
                    <th>วันเกิด</th>
                    <td><?= $data['result']['date_of_birth'] ?></td>
                </tr>
                <tr>
                    <th>เบอร์โทรศัพท์</th>
                    <td><?= $data['result']['phone_number'] ?></td>
                </tr>
            </table>
        </div>
    </div>
    <h2>วิชาที่ลงทะเบียนเรียน</h2>
    <table>
        <thead>
            <tr>
                <th>รหัสวิชา</th>
                <th>ชื่อวิชา</th>
                <th>อาจารย์ผู้สอน</th>
                <th>วันที่ลงทะเบียน</th>
                <th></th>
            </tr>
        </thead>
        <tbody>
            <?php foreach ($data['enrollments'] as $enrollment): ?>
                <tr>
                    <td><?= $enrollment['course_code'] ?></td>
                    <td><?= $enrollment['course_name'] ?></td>
                    <td><?= $enrollment['instructor'] ?></td>
                    <td><?= $enrollment['enrollment_date'] ?></td>
                    <td>
                        <form action="/profile" method="post">
                            <input type="hidden" name="student_id" value="<?= $data['result']['student_id'] ?>">
                            <input type="hidden" name="course_id" value="<?= $enrollment['course_id'] ?>">
                            <input type="submit" class="btn" onclick="return confirmSubmission()" value="ถอนรายวิชา">
                        </form>
                    </td>
                </tr>
            <?php endforeach; ?>
        </tbody>
    </table>
</section>
<script>
    function confirmSubmission() {
        return confirm("คุณต้องการถอนรายวิชานี้ใช่หรือไม่?");
    }
</script>