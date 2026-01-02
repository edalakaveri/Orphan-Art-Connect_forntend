<?php
include "db.php";
$data = json_decode(file_get_contents("php://input"), true);

$id = $data['id'];
$name = $data['name'];
$role = $data['role'];

$sql = "UPDATE users SET name='$name', role='$role' WHERE id=$id";

if($conn->query($sql)){
  echo json_encode(["status"=>"success","message"=>"User updated"]);
}
?>
