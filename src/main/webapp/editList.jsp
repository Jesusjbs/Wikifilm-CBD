<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="./css/style_editList.css">
<title>Editar Lista</title>
</head>
<body>
	<header>
		<jsp:include page="header.jsp" />
	</header>
	<h1>Editando lista con ID ${requestScope.idLista}</h1>
	<form id="id_formEdit" action="ListIDController" method="post">
		<div id="id_divEdit">
			<label for="nameEdit">Título:</label> 
			<input id="id_nameEdit" type="text" name="nameEdit" size=30 value="${requestScope.nombre}" />
		</div>
		<div id="id_divEdit">
			<label id="label" for="description">Descripción:</label>
			<textarea name="description" id="id_campo" cols="31" rows="2"
				required>${requestScope.description}</textarea>
		</div>
		<div id="id_divEdit">
			<input type="radio" id="tipoEdit1" name="tipoEdit" value="false" checked /> 
			<label for="tipoEdit1">Privada</label> 
			<input type="radio" id="tipoEdit2" name="tipoEdit" value="true" /> 
			<label for="tipoEdit2">Pública</label>
		</div>
		<div id="id_confirm">
			<button id="id_Btn" type="submit" name="editBtn"
				value="${requestScope.idLista}">Confirmar Cambios</button>
		</div>
	</form>

</body>
</html>