<?php
header("Content-Type: application/json");
$conn = new mysqli("localhost","root","","orphan_art_connect");

$data = json_decode(file_get_contents("php://input"), true);

$sql = "UPDATE events SET 
event_name='{$data['event_name']}', 
location='{$data['location']}', 
event_date='{$data['event_date']}' 
WHERE event_id={$data['event_id']}";

$conn->query($sql);
echo json_encode(["message"=>"Event updated"]);
?>
