<?php

session_start(); // เริ่มต้นเซสชัน

$student_id = (int)$_POST['student_id'];
$course_id = (int)$_POST['course_id'];

if (isset($_POST['enroll'])) {
    if (enrollCourse($student_id, $course_id)) {
        $_SESSION['alert'] = 'ลงทะเบียนสำเร็จ';
    } else {
        $_SESSION['alert'] = 'มีวิชานี้อยู่ในรายการลงทะเบียนแล้ว';
    }
}

    header('Location: /profile');
    exit;
?>