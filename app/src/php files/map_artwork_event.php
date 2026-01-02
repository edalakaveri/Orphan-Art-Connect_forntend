<?php
header("Content-Type: application/json");
$conn = new mysqli("localhost","root","","orphan_art_connect");

$data = json_decode(file_get_contents("php://input"), true);

$sql = "INSERT INTO event_artworks (event_id, artwork_id)
VALUES ({$data['event_id']}, {$data['artwork_id']})";

$conn->query($sql);
echo json_encode(["message"=>"Artwork mapped to event"]);
?>
