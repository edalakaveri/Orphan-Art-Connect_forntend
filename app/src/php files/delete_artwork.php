<?php
$conn = new mysqli("localhost","root","","orphan_art_connect");
$data = json_decode(file_get_contents("php://input"), true);

$sql = "DELETE FROM artworks WHERE id={$data['id']}";

$conn->query($sql);
echo json_encode(["message"=>"Artwork removed"]);
?>
