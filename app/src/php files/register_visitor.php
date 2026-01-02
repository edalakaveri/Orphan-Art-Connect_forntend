<?php
header("Content-Type: application/json");
$conn = new mysqli("localhost","root","","orphan_art_connect");

$data = json_decode(file_get_contents("php://input"), true);

$sql = "INSERT INTO event_visitors (event_id, visitor_name, visitor_email)
VALUES ({$data['event_id']}, '{$data['visitor_name']}', '{$data['visitor_email']}')";

$conn->query($sql);
echo json_encode(["message"=>"Visitor registered"]);
?>
