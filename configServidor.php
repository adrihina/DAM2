<?php
if (isset($_POST["external"])) {
    $external = $_POST["external"];
    $thumb = $_POST["thumb"];
    $gameID = $_POST["gameID"];
    $cheapest = $_POST["cheapest"];
    $servidor = "localhost";
    $usuario = "root";
    $password = "";
    $dbname = "juegos";

    $conexion = mysqli_connect($servidor, $usuario, $password, $dbname);

    if (!$conexion) {
        echo "Error en la conexiona MySQL: " . mysqli_connect_error();
        exit();
    }
    
    //Aqui introduce los valores que recibe de index a la base de datos SQL

    $sql = "INSERT INTO juegos (Nombre, IDJuego, Precio, Imagen) VALUES ('".addslashes($external)."','".addslashes($gameID)."',
     '".addslashes($cheapest)."', '".addslashes($thumb)."')";
    if (mysqli_query($conexion, $sql)) {
        echo "Registro insertado correctamente.";
    } else {
        echo "Error: " . mysqli_error($conexion);
    }
}
?>