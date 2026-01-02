<?php
$conn = new mysqli("localhost","root","","orphan_art_connect");
$data = json_decode(file_get_contents("php://input"), true);

$sql = "UPDATE artworks SET category='{$data['category']}' WHERE id={$data['id']}";

$conn->query($sql);
echo json_encode(["message"=>"Category updated"]);
?>
