<?php
include ("db_info.php");

$id = $_POST["id"];
$lbp = $_POST["lbp"];
$dollar = $_POST["dollar"];

$query = $mysqli -> prepare("INSERT INTO `conversions` (`id`, `lbp`, `dollar`) VALUES (?, ?, ?);");
$query -> bind_param("idd", $id, $lbp, $dollar);
$query -> execute();
?>