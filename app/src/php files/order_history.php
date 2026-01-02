<?php
header("Content-Type: application/json");
$conn = new mysqli("localhost","root","","orphan_art_connect");

$user_id = $_GET['user_id'];

$result = $conn->query("SELECT * FROM orders WHERE user_id='$user_id'");
$data = [];

while($row = $result->fetch_assoc()){
  $data[] = $row;
}

echo json_encode($data);
?>
