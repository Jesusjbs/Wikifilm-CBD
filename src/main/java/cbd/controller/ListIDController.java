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
import cbd.repository.ListRepository;

public class ListIDController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = null;
		HttpSession misession = (HttpSession) request.getSession();

		String idList = request.getParameter("editBtn");
		String idListDelete = request.getParameter("deleteBtn");
		String idSee = request.getParameter("listBtn");
		String description = request.getParameter("description");
		String name = request.getParameter("nameEdit");
		String tipoEdit = request.getParameter("tipoEdit");
		String descriptionEdit = request.getParameter("descriptionEdit");
		String aToken = (String) misession.getAttribute("atoken");
		String idItemDelete = request.getParameter("itemDelete");
		
		ListRepository lr = new ListRepository();
		if (idListDelete != "" && idListDelete != null) {
			lr.deleteList(aToken, Integer.valueOf(idListDelete));
			rd = request.getRequestDispatcher("/ListController");
		} 
		else if(idList != "" && idList != null && (description == "" || description == null)) {
			request.setAttribute("idLista", idList);
			request.setAttribute("nombre", name);
			request.setAttribute("description", descriptionEdit);
			request.setAttribute("tipo", tipoEdit);
			rd = request.getRequestDispatcher("/editList.jsp");
		}
		else if(description != "" && description != null) {
			lr.updateList(aToken, Integer.valueOf(idList), description, name, Boolean.valueOf(tipoEdit));
			rd = request.getRequestDispatcher("/ListController");
		}
		else if(idItemDelete != null && idItemDelete != "") {
			lr.deleteItem(aToken, Integer.valueOf(idSee), Integer.valueOf(idItemDelete));
			List<Lista> result = lr.getListById(aToken, Integer.valueOf(idSee));
			request.setAttribute("idLista", idSee);
			request.setAttribute("nombreLista", name);
			request.setAttribute("items", result);
			rd = request.getRequestDispatcher("/idList.jsp");			
		}
		else if(idSee != "" && idSee != null) {
			List<Lista> result = lr.getListById(aToken, Integer.valueOf(idSee));
			
			request.setAttribute("idLista", idSee);
			request.setAttribute("nombreLista", name);
			request.setAttribute("items", result);
			rd = request.getRequestDispatcher("/idList.jsp");
		}
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
