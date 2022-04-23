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

import cbd.model.Lista;
import cbd.repository.ListRepository;

public class ListController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		EntityManagerFactory emf = (EntityManagerFactory) getServletContext().getAttribute("emf");
		EntityManager em = emf.createEntityManager();

		RequestDispatcher rd = null;
		HttpSession misession = (HttpSession) request.getSession();

		if ((String) misession.getAttribute("atoken") == null || (String) misession.getAttribute("atoken") == "") {
			rd = request.getRequestDispatcher("/AuthController");
		} else {
			String aId = (String) misession.getAttribute("accountId");
			String titleList = request.getParameter("titleList");

			ListRepository lr = new ListRepository();
			List<Lista> lResult = lr.getLists(aId, em);

			if (titleList == "" || titleList == null) {
				rd = request.getRequestDispatcher("/list.jsp");
			} else {
				Lista lcResult = lr.createList((String) misession.getAttribute("atoken"), titleList, em);
				request.setAttribute("mensaje",
						"La lista " + titleList + " fue creada correctamente con id " + lcResult.getId());
				rd = request.getRequestDispatcher("/createList.jsp");
			}
			request.setAttribute("lista", lResult);
		}
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
