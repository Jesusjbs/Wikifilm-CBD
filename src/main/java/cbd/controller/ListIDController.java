package cbd.controller;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cbd.model.Movie;
import cbd.model.Pair;
import cbd.model.Serie;
import cbd.repository.ListRepository;

public class ListIDController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		EntityManagerFactory emf = (EntityManagerFactory) getServletContext().getAttribute("emf");
		EntityManager em = emf.createEntityManager();

		RequestDispatcher rd = null;
		HttpSession sesion = (HttpSession) request.getSession();

		String idList = request.getParameter("editBtn");
		String idListDelete = request.getParameter("deleteBtn");
		String idSee = request.getParameter("listBtn");
		String description = request.getParameter("description");
		String name = request.getParameter("nameEdit");
		String tipoEdit = request.getParameter("tipoEdit");
		String media = request.getParameter("media");
		String descriptionEdit = request.getParameter("descriptionEdit");
		Long aToken = (Long) sesion.getAttribute("aToken");
		String idItemDelete = request.getParameter("itemDelete");

		ListRepository lr = new ListRepository();
		if (idListDelete != null && !idListDelete.trim().equals("")) {
			lr.deleteList(aToken, Integer.valueOf(idListDelete), em);
			rd = request.getRequestDispatcher("/ListController");
		} else if (idList != null && !idList.trim().equals("")
				&& (description == null || description.trim().equals(""))) {
			request.setAttribute("idLista", idList);
			request.setAttribute("nombre", name);
			request.setAttribute("description", descriptionEdit);
			request.setAttribute("tipo", tipoEdit);
			rd = request.getRequestDispatcher("/editList.jsp");
		} else if (description != null && !description.trim().equals("")) {
			lr.updateList(aToken, Integer.valueOf(idList), description, name, Boolean.valueOf(tipoEdit), em);
			rd = request.getRequestDispatcher("/ListController");
		} else if (idItemDelete != null && !idItemDelete.trim().equals("")) {
			lr.deleteItem(aToken, Integer.valueOf(idSee), Integer.valueOf(idItemDelete), media, em);
			em = emf.createEntityManager();
			Pair<List<Movie>, List<Serie>> result = lr.getListById(aToken, Integer.valueOf(idSee), em);
			request.setAttribute("idLista", idSee);
			request.setAttribute("nombreLista", name);
			request.setAttribute("itemsMovies", result.a);
			request.setAttribute("itemsSeries", result.b);

			rd = request.getRequestDispatcher("/idList.jsp");
		} else if (idSee != null && !idSee.trim().equals("")) {
			Pair<List<Movie>, List<Serie>> result = lr.getListById(aToken, Integer.valueOf(idSee), em);
			request.setAttribute("idLista", idSee);
			request.setAttribute("nombreLista", name);
			request.setAttribute("itemsMovies", result.a);
			request.setAttribute("itemsSeries", result.b);

			rd = request.getRequestDispatcher("/idList.jsp");
		}
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
