<?php
header("Content-Type: application/json");

$conn = new mysqli("localhost","root","","orphan_art_connect");

if ($conn->connect_error) {
    die(json_encode(["error" => "Database connection failed"]));
}

/*
 Optional JSON input for filtering
 Example:
 {
   "category": "Wall Art"
 }
*/
$data = json_decode(file_get_contents("php://input"), true);

$query = "SELECT id, title, category, price, image 
          FROM artworks 
          WHERE status='approved'";

if (!empty($data['category'])) {
    $category = $conn->real_escape_string($data['category']);
    $query .= " AND category='$category'";
}

$result = $conn->query($query);

$artworks = [];
while ($row = $result->fetch_assoc()) {
    $artworks[] = $row;
}

echo json_encode($artworks);
?>
