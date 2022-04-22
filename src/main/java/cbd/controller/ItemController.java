package cbd.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cbd.repository.ListRepository;

public class ItemController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = null;
		HttpSession misession = (HttpSession) request.getSession();

		String tipo = request.getParameter("media");
		String tipo2 = request.getParameter("tipo");		
		String idItem = request.getParameter("idItem");
		String idLista = request.getParameter("lista");
		String aToken = (String) misession.getAttribute("atoken");

		ListRepository lr = new ListRepository();
		if(tipo.contains("tv") || tipo2.contains("serie")) {
			lr.addItem(aToken, Integer.valueOf(idLista), Integer.valueOf(idItem), "tv");
		}
		else {
			lr.addItem(aToken, Integer.valueOf(idLista), Integer.valueOf(idItem), "movie");
		}
		rd = request.getRequestDispatcher("/ListController");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
