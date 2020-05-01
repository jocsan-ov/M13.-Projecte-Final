<?php

	$servername = "localhost";
	$username =  "root";
	$password = "";
	$dbName = "proyecto";
		
	$usuario = $_POST["usuario"];
	$passwdUsuario = $_POST["passwd"];
	$tipoUsuario = $_POST["tipoUsuario"];


	//Make Connection
	$conn = new mysqli($servername, $username, $password, $dbName);
	//Check Connection
	if(!$conn){
		die("Connection Failed. ". mysqli_connect_error());
	}

	$consulta = "INSERT INTO usuarios (nombre, passwd, tipo_usuario)
			VALUES ('".$usuario."','".$passwdUsuario."','"$tipoUsuario"')";

    $result = mysqli_query($conn ,$consulta);
    
    
    $num = mysqli_affected_rows($conn);
    
    if ($num>0)
    {
    echo "El seu registre es correcte. Gracies";
    }
    else
    {
    echo "Error!!! El seu registre no està realitzat";
    }
    
    mysqli_close($conn);
?>