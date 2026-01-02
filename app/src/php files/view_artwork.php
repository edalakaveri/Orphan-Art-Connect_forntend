<?php
$conn = new mysqli("localhost","root","","orphan_art_connect");

$id = $_GET['id'];
$result = $conn->query("SELECT * FROM artworks WHERE id=$id");

echo json_encode($result->fetch_assoc());
?>
