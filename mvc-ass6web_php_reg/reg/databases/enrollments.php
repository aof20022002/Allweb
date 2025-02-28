<?php



function getStudentEnrollmentByStudentId(int $studentId): mysqli_result|bool
{
    $conn = getConnection();
    $sql = 'SELECT
    c.course_id,
    c.course_name,
    c.course_code,
    c.instructor,
    e.enrollment_id,
    e.enrollment_date,
    s.student_id
    FROM
    enrollment.courses c
    INNER JOIN enrollment.enrollment e ON
    c.course_id = e.course_id
    INNER JOIN enrollment.students s ON
    e.student_id = s.student_id where s.student_id = ?';
    $stmt = $conn->prepare($sql);
    $stmt->bind_param("i", $studentId);
    $stmt->execute();
    $result = $stmt->get_result();
    return $result;
}
function enrollCourse(int $student_id, int $course_id): bool
{
    $conn = getConnection(); 
    if ($conn->connect_error) {
        die("Connection failed: " . $conn->connect_error);
    }

    // ตรวจสอบว่านักศึกษาลงทะเบียนวิชานี้แล้วหรือยัง
    $check_sql = 'SELECT * FROM enrollment WHERE student_id = ? AND course_id = ?';
    $check_stmt = $conn->prepare($check_sql);
    $check_stmt->bind_param('ii', $student_id, $course_id);
    $check_stmt->execute();
    $check_result = $check_stmt->get_result();

    // ถ้ามีข้อมูลอยู่แล้ว
    if ($check_result->num_rows > 0) {
        $check_stmt->close();
        $conn->close();
        return false; // ลงทะเบียนซ้ำ
    }

    // ถ้ายังไม่ลงทะเบียน ให้เพิ่มข้อมูลใหม่
    $sql = 'INSERT INTO enrollment (student_id, course_id, enrollment_date) VALUES (?, ?, NOW())';
    $stmt = $conn->prepare($sql);
    $stmt->bind_param('ii', $student_id, $course_id);

    if ($stmt->execute()) {
        $stmt->close();
        $conn->close();
        return true; // ลงทะเบียนสำเร็จ
    } else {
        error_log("Error enrolling course: " . $stmt->error); // บันทึกข้อผิดพลาด
        $stmt->close();
        $conn->close();
        return false; // ลงทะเบียนล้มเหลว
    }
}
