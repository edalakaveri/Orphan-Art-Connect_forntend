<?php
$conn = new mysqli("localhost","root","","orphan_art_connect");
$data = json_decode(file_get_contents("php://input"), true);

$sql = "INSERT INTO artworks (title,description,category,price,image,status)
VALUES (
'{$data['title']}',
'{$data['description']}',
'{$data['category']}',
{$data['price']},
'{$data['image']}',
'approved'
)";

$conn->query($sql);
echo json_encode(["message"=>"Artwork uploaded by admin"]);
?>
