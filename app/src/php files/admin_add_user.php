<?php
include "db.php";
$data = json_decode(file_get_contents("php://input"), true);

$name = $data['name'];
$email = $data['email'];
$password = password_hash($data['password'], PASSWORD_DEFAULT);
$role = $data['role'];

$sql = "INSERT INTO users (name,email,password,role,is_verified)
        VALUES ('$name','$email','$password','$role',1)";

if($conn->query($sql)){
  echo json_encode(["status"=>"success","message"=>"User added by admin"]);
}else{
  echo json_encode(["status"=>"error","message"=>"User already exists"]);
}
?>
