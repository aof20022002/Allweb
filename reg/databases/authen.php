<?php

function login(String $username, String $password): array|bool
{
    $conn = getConnection();
    $sql = 'select * from students where email = ?';
    $stmt = $conn->prepare($sql);
    $stmt->bind_param("s", $username);
    $stmt->execute();
    $result = $stmt->get_result();
    if ($conn->connect_error) {
        die("Connection failed: " . $conn->connect_error);
    }
    
    if($result->num_rows == 0)
    {
        error_log("ไม่พบผู้ใช้ที่มีอีเมล: $username");
        return false;
    }
    $row = $result->fetch_assoc();
    error_log("Password from DB: " . $row['password']);
    error_log("Password from user: " . $password);
    if(password_verify($password, $row['password']))
    {
        return $row;
    }else
    {
        error_log("การตรวจสอบรหัสผ่านล้มเหลวสำหรับผู้ใช้: $username");
        return false;
    }
}

function logout():void
{
    unset($_SESSION['timestamp']);
}
