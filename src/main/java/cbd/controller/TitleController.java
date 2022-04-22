package cbd.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cbd.model.Lista;
import cbd.model.Movie;
import cbd.model.Serie;
import cbd.repository.ListRepository;
import cbd.repository.TitleRepository;

public class TitleController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("titleQuery");
		String media = request.getParameter("mediaQuery");
		String tipo = request.getParameter("tipoQuery");
		String mensaje = request.getParameter("message");
		RequestDispatcher rd = null;
		HttpSession misession = (HttpSession) request.getSession();

		if (id == null) { // Si no se ha accedido desde búsqueda...
			id = (String) request.getSession().getAttribute("titleQuery");
			media = (String) request.getSession().getAttribute("mediaQuery");
			tipo = (String) request.getSession().getAttribute("tipoQuery");
		}

		String aToken = (String) request.getSession().getAttribute("atoken");
		if (aToken != "" && aToken != null) {
			String aId = (String) misession.getAttribute("accountId");
			String sId = (String) misession.getAttribute("sessionId");

			ListRepository lr = new ListRepository();
			List<Lista> lResult = lr.getLists(aId, sId);

			request.setAttribute("lista", lResult);
			request.setAttribute("token", "si");
		}

		// Search for movie in TMDB and YouTube
		TitleRepository tmdb = new TitleRepository();
		Movie mvResult = null;
		Serie sResult = null;
		if (media.equals("movie") || tipo.equals("movie")) {
			mvResult = tmdb.getMovie(id);
		} else {
			sResult = tmdb.getSerie(id);
		}

		if ((mvResult != null || sResult != null)) {
			rd = request.getRequestDispatcher("/title.jsp");
			if (media.equals("movie") || tipo.equals("movie")) {
				request.setAttribute("title", mvResult.getTitle());
				request.setAttribute("released", mvResult.getReleased());
				request.setAttribute("runtime", mvResult.getRuntime());
				request.setAttribute("genres", mvResult.getGenre());
				request.setAttribute("plot", mvResult.getPlot());
//				request.setAttribute("poster", mvResult.getProfilePath());
				request.setAttribute("id", mvResult.getId());
//				request.setAttribute("posterActores", posterActores);
//				request.setAttribute("nombreActores", nombreActores);
//				request.setAttribute("tamLista", posterActores.size());
			} else {
				request.setAttribute("title", sResult.getTitle());
				request.setAttribute("released", sResult.getReleased());
				request.setAttribute("runtime", sResult.getRuntime());
				request.setAttribute("genres", sResult.getGenre());
				request.setAttribute("plot", sResult.getPlot());
//				request.setAttribute("poster", sResult.getProfilePath());
				request.setAttribute("totalSeasons", sResult.getTotalSeasons());
				request.setAttribute("estado", sResult.getTerminated());
				request.setAttribute("id", sResult.getId());
				request.setAttribute("ver", sResult.getChannel());
//				request.setAttribute("posterActores", posterActores);
//				request.setAttribute("nombreActores", nombreActores);
//				request.setAttribute("tamLista", posterActores.size());

			}
			request.setAttribute("type", tipo);
			request.setAttribute("media", media);
			request.setAttribute("message", mensaje);
		} else {
			rd = request.getRequestDispatcher("/error.jsp");
		}
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
