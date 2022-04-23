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

import cbd.model.Movie;
import cbd.model.Pair;
import cbd.model.Serie;
import cbd.repository.SearchRepository;

/**
 * Servlet implementation class SearchController
 */
public class SearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		EntityManagerFactory emf = (EntityManagerFactory) getServletContext().getAttribute("emf");
		EntityManager em = emf.createEntityManager();

		String query = request.getParameter("searchQuery");
		String media = request.getParameter("mediaQuery");

		RequestDispatcher rd = request.getRequestDispatcher("/busqueda.jsp");

		SearchRepository resource = new SearchRepository();
		List<Movie> moviesResults = new ArrayList<>();
		List<Serie> seriesResults = new ArrayList<>();
		if (media.equals("movie")) {
			moviesResults = resource.getMovies(query, em);
		} else if (media.equals("serie")) {
			seriesResults = resource.getSeries(query, em);
		} else {
			Pair<List<Movie>, List<Serie>> aux = resource.getTitles(query, em);
			moviesResults = aux.a;
			seriesResults = aux.b;
		}

		if (!moviesResults.isEmpty() && !seriesResults.isEmpty()) {
			request.setAttribute("movies", moviesResults);
			request.setAttribute("series", seriesResults);
			request.setAttribute("resultados", moviesResults.size() + seriesResults.size());
			request.setAttribute("busqueda", query);
		} else if (!moviesResults.isEmpty() && seriesResults.isEmpty()) {
			request.setAttribute("movies", moviesResults);
			request.setAttribute("resultados", moviesResults.size());
			request.setAttribute("busqueda", query);
		} else {
			request.setAttribute("series", seriesResults);
			request.setAttribute("resultados", seriesResults.size());
			request.setAttribute("busqueda", query);
		}
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
