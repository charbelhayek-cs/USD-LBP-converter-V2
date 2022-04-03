<?php

//Import variables from 'db_info.php'
include("db_info.php");

date_default_timezone_set('Asia/beirut');

$year = intval(date('Y'));
$month = intval(date('m'));
$day = intval(date('d'));
$hour = intval(date('H'));

$var = "$year$month$day$hour";

$url = "https://lirarate.org/wp-json/lirarate/v2/omt?currency=LBP&_ver=t$var";

$ch = curl_init();
curl_setopt($ch, CURLOPT_URL, $url);
curl_setopt($ch, CURLOPT_RETURNTRANSFER, 1);
$json_response = curl_exec($ch);
curl_close($ch);

echo $json_response;
?>