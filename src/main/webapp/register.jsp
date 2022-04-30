<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="./css/style_login.css">
<title>Registrarse</title>
</head>
<body>

	<c:if test="${sessionScope.username != null}">
		<jsp:forward page="/index.jsp"></jsp:forward>
	</c:if>

	<header>
		<jsp:include page="header.jsp" />
	</header>

	<div id="id_div">
		<h1>Registro</h1>
		<form id="loginForm" action="UserController" method="post">
			<input type="hidden" name="register" value="register" checked /> <input
				size=30 id="id_user" type="text" placeholder="Inserte usuario"
				name="user" required /> <input size=30 id="id_pass" type="password"
				placeholder="Inserte contraseña" name="pass" required />
			<button id="id_Btn" title="Iniciar Sesión" type="submit">Registrarse</button>
		</form>
	</div>
	<div id="id_divMensaje">
		<p style="font-size: large;">${requestScope.mensaje}</p>
	</div>
</body>
</html>