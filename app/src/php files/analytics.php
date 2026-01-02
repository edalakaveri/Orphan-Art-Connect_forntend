<?php
$conn = new mysqli("localhost","root","","orphan_art_connect");

$users = $conn->query("SELECT COUNT(*) total FROM users")->fetch_assoc();
$artworks = $conn->query("SELECT COUNT(*) total FROM artworks")->fetch_assoc();
$orders = $conn->query("SELECT COUNT(*) total FROM orders")->fetch_assoc();

echo json_encode([
  "total_users"=>$users['total'],
  "total_artworks"=>$artworks['total'],
  "total_orders"=>$orders['total']
]);
?>
