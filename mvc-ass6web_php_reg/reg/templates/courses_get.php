<?php
$courses = $data['courses'];
$student_id = $data['student_id'];
?>
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
        background-color: #00796b;
        color: #ffffff;
        border: none;
        padding: 10px 20px;
        border-radius: 5px;
        cursor: pointer;
    }

    .btn:hover {
        background-color: #004d40;
    }
</style>

<section>
    <h2>รายวิชาที่เปิดให้ลงทะเบียน</h2>
    <table>
        <thead>
            <tr>
                <th>รหัสวิชา</th>
                <th>ชื่อวิชา</th>
                <th>อาจารย์ผู้สอน</th>
                <th></th>
            </tr>
        </thead>
        <tbody>
            <?php if (empty($courses)): ?>
                <tr>
                    <td colspan="4">ไม่พบข้อมูล</td>
                </tr>
            <?php else: ?>
                <?php foreach ($courses as $course): ?>
                    <tr>
                        <td><?= $course['course_code'] ?></td>
                        <td><?= $course['course_name'] ?></td>
                        <td><?= $course['instructor'] ?></td>
                        <td>
                            <form action="/courses" method="post">
                                <input type="hidden" name="student_id" value="<?= $student_id ?>">
                                <input type="hidden" name="course_id" value="<?= $course['course_id'] ?>">
                                <input type="submit" name="enroll" class="btn" onclick="return confirmSubmission()" value="ลงทะเบียน">
                            </form>
                        </td>
                    </tr>
                <?php endforeach; ?>
            <?php endif; ?>
        </tbody>
    </table>
</section>
<script>
    function confirmSubmission() {
        return confirm("คุณต้องการลงทะเบียนวิชานี้ใช่หรือไม่?");
    }
</script>