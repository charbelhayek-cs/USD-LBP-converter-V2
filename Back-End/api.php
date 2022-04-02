<?php

include("db_info.php");

$query = $mysqli->prepare("SELECT * FROM conversions");
$query -> execute();

?>