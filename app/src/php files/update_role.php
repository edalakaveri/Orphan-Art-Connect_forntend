<?php
$conn = new mysqli("localhost","root","","orphan_art_connect");
$data = json_decode(file_get_contents("php://input"), true);

$sql = "UPDATE users SET role='{$data['role']}' WHERE id={$data['id']}";

$conn->query($sql);
echo json_encode(["message"=>"Role updated"]);
?>
