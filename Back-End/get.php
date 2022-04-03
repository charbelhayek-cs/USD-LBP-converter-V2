<?php
//Import variables from 'db_info.php'
include("db_info.php");

//Execute query to get all values from 'conversions' table in the database
$query = $mysqli -> prepare("SELECT * FROM conversions WHERE id = (SELECT MAX(id) FROM conversions)");
$query -> execute();

//Assign values to an array
$array = $query -> get_result();

$response = [];

while ($conversion = $array -> fetch_assoc())
{
    $response[] = $conversion;
}

$json_response = json_encode($response);
echo $json_response;

?>