<?php
header("Content-Type: application/json");

$conn = new mysqli("localhost", "root", "", "orphan_art_connect");
if ($conn->connect_error) {
    echo json_encode(["status" => "error", "message" => "DB connection failed"]);
    exit;
}

$data = json_decode(file_get_contents("php://input"), true);

$order_id = intval($data['order_id']);
$payment_mode = $data['payment_mode'];
$transaction_id = $data['transaction_id'];

/* Insert payment */
$insert = $conn->prepare(
    "INSERT INTO payments (order_id, payment_mode, transaction_id, payment_status)
     VALUES (?, ?, ?, 'SUCCESS')"
);
$insert->bind_param("iss", $order_id, $payment_mode, $transaction_id);

if (!$insert->execute()) {
    echo json_encode(["status" => "error", "message" => "Payment insert failed"]);
    exit;
}

/* Update order status */
$update = $conn->prepare(
    "UPDATE orders SET status = 'PAID' WHERE id = ?"
);
$update->bind_param("i", $order_id);
$update->execute();

echo json_encode([
    "status" => "success",
    "message" => "Payment successful and order updated"
]);

$conn->close();
?>
