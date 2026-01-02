<?php
$conn = new mysqli("localhost","root","","orphan_art_connect");
$data = json_decode(file_get_contents("php://input"), true);

$newPass = password_hash($data['password'], PASSWORD_DEFAULT);

$sql = "UPDATE users SET password='$newPass' WHERE id={$data['id']}";

$conn->query($sql);
echo json_encode(["message"=>"Password reset successful"]);
?>
