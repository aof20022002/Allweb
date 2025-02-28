<?php

function getCourses(): mysqli_result|bool
{
    $conn = getConnection();
    $sql = 'select * from courses';
    $result = $conn->query($sql);
    return $result;
}

function dropCourse(int $student_id, int $course_id): bool
{
    $conn = getConnection();
    if ($conn->connect_error) {
        die("Connection failed: " . $conn->connect_error);
    }

    $sql = 'DELETE FROM enrollment WHERE student_id = ? AND course_id = ?';
    $stmt = $conn->prepare($sql);
    $stmt->bind_param('ii', $student_id, $course_id);

    if ($stmt->execute()) {
        $stmt->close();
        $conn->close();
        return true;
    } else {
        error_log("Error dropping course: " . $stmt->error);
        $stmt->close();
        $conn->close();
        return false;
    }
}