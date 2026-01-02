<?php
$host = "localhost";
$user = "root";
$pass = ""; 
$dbname = "orphan_art_connect";

$conn = mysqli_connect($host, $user, $pass, $dbname);

if (!$conn) {
    die("Connection failed: " . mysqli_connect_error());
}
?>