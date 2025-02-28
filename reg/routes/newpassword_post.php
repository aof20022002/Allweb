<?php
    $id = $_POST['id'];
    $password = $_POST['password'];

    $newpassword = password_hash($password, PASSWORD_DEFAULT);

    $conn = getConnection();
    if ($conn->connect_error) {
        die("Connection failed: " . $conn->connect_error);
    }

    $sql = 'UPDATE students SET password = ? WHERE student_id = ?';
    $stmt = $conn->prepare($sql);
    $stmt->bind_param('si', $newpassword, $id);

    if ($stmt->execute()) {
        echo "Password updated successfully.";
        header("Location: /login");
    } else {
        echo "Error updating password: " . $stmt->error;
    }

    $stmt->close();
    $conn->close();
    ?>
