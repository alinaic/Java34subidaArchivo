<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<a href="index.jsp">volver al inicio</a><br/>
<c:forEach items="${productos}" var="producto">
<div style="margen: 8px">
nombre:${producto.nombre}<br/>
precio:${producto.precio}<br/>
<img src="${producto.rutaImagen }"
height="200"/>

</div>



</c:forEach>

</body>
</html>