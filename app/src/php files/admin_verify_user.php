<?php
include "db.php";
$data = json_decode(file_get_contents("php://input"), true);

$id = $data['id'];

$sql = "UPDATE users SET is_verified=1 WHERE id=$id";

if($conn->query($sql)){
  echo json_encode(["status"=>"success","message"=>"User verified"]);
}
?>
