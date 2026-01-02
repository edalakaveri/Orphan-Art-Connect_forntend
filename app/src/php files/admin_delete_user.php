<?php
include "db.php";
$data = json_decode(file_get_contents("php://input"), true);

$id = $data['id'];

$sql = "DELETE FROM users WHERE id=$id";

if($conn->query($sql)){
  echo json_encode(["status"=>"success","message"=>"User deleted"]);
}
?>
