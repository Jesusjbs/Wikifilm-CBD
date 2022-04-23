package cbd.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cbd.model.Lista;
import cbd.model.Movie;
import cbd.model.Serie;
import cbd.repository.ListRepository;
import cbd.repository.TitleRepository;

public class TitleController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		EntityManagerFactory emf = (EntityManagerFactory) getServletContext().getAttribute("emf");
		EntityManager em = null;

		String id = request.getParameter("titleQuery");
		String media = request.getParameter("mediaQuery");
		String mensaje = request.getParameter("message");
		RequestDispatcher rd = null;

		Long aToken = (Long) request.getSession().getAttribute("aToken");
		if (aToken != null) {
			em = emf.createEntityManager();
			ListRepository lr = new ListRepository();
			List<Lista> lResult = lr.getLists(aToken, em);

			request.setAttribute("lista", lResult);
			request.setAttribute("token", "si");
		}

		TitleRepository tmdb = new TitleRepository();
		Movie mvResult = null;
		Serie sResult = null;
		List<Long> idActores = new ArrayList<>();
		List<String> posterActores = new ArrayList<>();
		List<String> nombreActores = new ArrayList<>();

		if (media.equals("movie")) {
			em = emf.createEntityManager();
			mvResult = tmdb.getMovie(id, em);
			if (mvResult.getActors() != null) {
				mvResult.getActors().forEach(x -> idActores.add(x.getId()));
				mvResult.getActors().forEach(x -> posterActores.add(x.getProfilePath()));
				mvResult.getActors().forEach(x -> nombreActores.add(x.getName()));
			}
		} else {
			em = emf.createEntityManager();
			sResult = tmdb.getSerie(id, em);
			if (sResult.getActors() != null) {
				sResult.getActors().forEach(x -> idActores.add(x.getId()));
				sResult.getActors().forEach(x -> posterActores.add(x.getProfilePath()));
				sResult.getActors().forEach(x -> nombreActores.add(x.getName()));
			}
		}

		if ((mvResult != null || sResult != null)) {
			rd = request.getRequestDispatcher("/title.jsp");
			if (media.equals("movie")) {
				request.setAttribute("title", mvResult.getTitle());
				request.setAttribute("released", mvResult.getReleased());
				request.setAttribute("runtime", mvResult.getRuntime());
				request.setAttribute("genres", mvResult.getGenre());
				request.setAttribute("plot", mvResult.getPlot());
				request.setAttribute("poster", mvResult.getProfilePath());
				request.setAttribute("id", mvResult.getId());
			} else {
				request.setAttribute("title", sResult.getTitle());
				request.setAttribute("released", sResult.getReleased());
				request.setAttribute("runtime", sResult.getRuntime());
				request.setAttribute("genres", sResult.getGenre());
				request.setAttribute("plot", sResult.getPlot());
				request.setAttribute("poster", sResult.getProfilePath());
				request.setAttribute("totalSeasons", sResult.getTotalSeasons());
				request.setAttribute("estado", sResult.getTerminated());
				request.setAttribute("id", sResult.getId());
				request.setAttribute("ver", sResult.getChannel());

			}
			request.setAttribute("idActor", idActores);
			request.setAttribute("posterActores", posterActores);
			request.setAttribute("nombreActores", nombreActores);
			request.setAttribute("tamLista", posterActores.size());
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
