<?php

session_start(); // เริ่มต้นเซสชัน

if ($_SERVER['REQUEST_METHOD'] === 'POST') {
    if (isset($_POST['student_id']) && isset($_POST['course_id'])) {
        $student_id = $_POST['student_id'];
        $course_id = $_POST['course_id'];

        if (dropCourse($student_id, $course_id)) {
            $_SESSION['alert'] = 'ถอนรายวิชาสำเร็จ';
            
        } else {
            $_SESSION['alert'] = 'ไม่สามารถถอนรายวิชาได้';
        }
    } else {
        $_SESSION['alert'] = 'ข้อมูลไม่ถูกต้อง';
    }
    header('Location: /profile');
    exit;
}