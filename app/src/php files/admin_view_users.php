<?php
include "db.php";

$result = $conn->query("SELECT id,name,email,role,is_verified FROM users");
$users = [];

while($row = $result->fetch_assoc()){
  $users[] = $row;
}

echo json_encode($users);
?>
