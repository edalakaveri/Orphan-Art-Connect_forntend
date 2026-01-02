<?php
$conn = new mysqli("localhost","root","","orphan_art_connect");
$data = json_decode(file_get_contents("php://input"), true);

$sql = "INSERT INTO orders (user_id,amount,payment_status)
VALUES ({$data['user_id']},{$data['amount']},'paid')";

$conn->query($sql);
echo json_encode(["message"=>"Order placed"]);
?>
