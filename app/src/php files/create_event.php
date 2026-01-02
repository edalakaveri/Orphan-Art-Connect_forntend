<?php
$conn = new mysqli("localhost","root","","orphan_art_connect");
$data = json_decode(file_get_contents("php://input"), true);

$sql = "INSERT INTO events (event_name,location,event_date)
VALUES ('{$data['name']}','{$data['location']}','{$data['date']}')";

$conn->query($sql);
echo json_encode(["message"=>"Event created"]);
?>
