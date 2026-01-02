<?php
header("Content-Type: application/json");

$conn = new mysqli("localhost", "root", "", "orphan_art_connect");
if ($conn->connect_error) {
    echo json_encode(["error" => "DB connection failed"]);
    exit;
}

$data = json_decode(file_get_contents("php://input"), true);

/* USE id — NOT order_id */
$id = $data['id'] ?? null;
$status = $data['status'] ?? null;

if ($id === null || $status === null) {
    echo json_encode(["error" => "id and status required"]);
    exit;
}

$stmt = $conn->prepare("UPDATE orders SET status = ? WHERE id = ?");
$stmt->bind_param("si", $status, $id);

if ($stmt->execute()) {
    echo json_encode([
        "success" => true,
        "message" => "Order status updated"
    ]);
} else {
    echo json_encode(["error" => "Update failed"]);
}

$stmt->close();
$conn->close();
?>
