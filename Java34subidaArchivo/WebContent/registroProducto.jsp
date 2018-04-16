<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	Introduce los datos del nuevo producto:
	<br />

	<form method="post" action="ServletRegistroProducto" enctype="multipart/form-data">
		nombre: <input type="text" name="campoNombre" /><br /> 
		precio: <input type="text" name="campoPrecio" /><br />
		imagen: <input type="file" name="campoImagen" /><br />
		<input type="submit" value="REGISTRAR PRODUCTO"/>

	</form>

</body>
</html>