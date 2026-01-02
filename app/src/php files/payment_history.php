<?php
header("Content-Type: application/json");
$conn = new mysqli("localhost","root","","orphan_art_connect");

$order_id = $_GET['order_id'];

$result = $conn->query("SELECT * FROM payments WHERE order_id='$order_id'");
$data = [];

while($row = $result->fetch_assoc()){
  $data[] = $row;
}

echo json_encode($data);
?>
