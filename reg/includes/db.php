<?php

function getConnection():mysqli
{
    $servername = "localhost";
    $username = "reg"; // Update this
    $password = "reg"; // Update this
    $dbname = "enrollment";

    // Create connection
    $conn = new mysqli($servername, $username, $password, $dbname);

    // Check connection
    if ($conn->connect_error) {
        die("Connection failed: " . $conn->connect_error);
        error_log("Connection failed: " . $conn->connect_error);
    }

    return $conn;
    
}

require_once DATABASE_DIR . '/students.php';
require_once DATABASE_DIR . '/authen.php';
require_once DATABASE_DIR . '/courses.php';
require_once DATABASE_DIR . '/enrollments.php';