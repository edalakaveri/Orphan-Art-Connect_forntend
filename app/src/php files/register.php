<?php
$conn = new mysqli("localhost","root","","orphan_art_connect");
$data = json_decode(file_get_contents("php://input"), true);

$password = password_hash($data['password'], PASSWORD_DEFAULT);

$sql = "INSERT INTO users (name,email,password,role)
VALUES ('{$data['name']}','{$data['email']}','$password','{$data['role']}')";

$conn->query($sql);
echo json_encode(["message"=>"User registered"]);
?>
