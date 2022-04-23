<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="./css/style_title.css">
<title>${requestScope.title}</title>
</head>
<body>
	<header>
		<jsp:include page="header.jsp" />
	</header>
	<form id="id_formList" action="/ItemController" method="post">
		<input type="hidden" value="${requestScope.media}" name="media">
		<input type="hidden" value="${requestScope.id}" name="idItem">
		<select id="id_lista" name="lista" required>
			<option label="Añadir a mi lista" />
			<c:forEach items="${requestScope.lista}" var="list">
				<option value="${list.id}" label="${list.title}" />
			</c:forEach>
		</select>
		<button id="id_anyadir" type="submit" name="añadir">Añadir</button>
	</form>

	<div id="id_foto">
		<img id="id_poster" alt='poster.png'
			onerror="this.src='./img/Poster.png'"
			src='https://image.tmdb.org/t/p/w185${requestScope.poster}' />
	</div>
	<div id="id_datos">
		<h1>${requestScope.title}</h1>
		<p>
			<span>Fecha de estreno:</span> ${requestScope.released}
		</p>
		<p>
			<span>Duración:</span> ${requestScope.runtime}
		</p>
		<c:if
			test="${requestScope.media == 'serie'}">
			<p>
				<span>Estado:</span> ${requestScope.estado}
			</p>
			<p>
				<span>Numero de temporadas:</span> ${requestScope.totalSeasons}
			</p>
			<c:if test="${requestScope.ver != ''}">
				<p>
					<span>Canales: </span>${requestScope.ver}</p>
			</c:if>
		</c:if>
		<p>
			<span>Géneros: </span> ${requestScope.genres}
		</p>
		<p>
			<span>Sinopsis:</span> ${requestScope.plot}
		</p>
	</div>
	<div id="id_youtube">
		<iframe id="id_ytplayer" width="640" height="360"
			src="https://www.youtube.com/embed/?autoplay=0&fs=1&iv_load_policy=3&showinfo=0"
			frameborder="0" allowfullscreen></iframe>
		<form id="id_comment" action="CommentController" method="post">
			<textarea id="id_areaText" rows=3 cols=70
				placeholder="Escriba aquí su comentario" name="comment"></textarea>
			<button id="id_enviarBtn" type="submit">
				<img id="id_enviarImg" title="Enviar comentario"
					alt="Enviar comentario" src="./img/send.png">
			</button>

		</form>
	</div>
	<p>${requestScope.message}</p>

	<c:if test="${requestScope.tamLista != 0}">
		<h1>Actores Destacados</h1>
		<div class="posterActor">
			<table id="other">
				<tr>
					<c:forEach var="i" begin="0" end="${requestScope.tamLista -1}">
						<td>
							<form class="tituloForm" action="ActorController" method="post">
								<input type="hidden" name="idQuery"
									value="${requestScope.idActor.get(i)}" />
								<button id=titleBtn>
									<img alt='poster.png' onerror="this.src='./img/Poster.png'"
										src='https://image.tmdb.org/t/p/w185${requestScope.posterActores.get(i)}' /><br />
									<p>${requestScope.nombreActores.get(i)}</p>
								</button>
							</form>
						</td>
					</c:forEach>
				</tr>
			</table>
		</div>
	</c:if>
</body>
</html>