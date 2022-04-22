package cbd.controller;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cbd.model.Actor;
import cbd.repository.ActorRepository;

public class ActorController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		EntityManagerFactory emf = (EntityManagerFactory) getServletContext().getAttribute("emf");
		EntityManager em = emf.createEntityManager();
		
		String id = request.getParameter("idQuery");
		RequestDispatcher rd = null;

		ActorRepository ac = new ActorRepository();
		Actor aResult = ac.getActor(id, em);
				
		if (aResult != null) {
			rd = request.getRequestDispatcher("/actor.jsp");
			request.setAttribute("nombre", aResult.getName());
			request.setAttribute("poster", aResult.getProfilePath());
			request.setAttribute("nacimiento", aResult.getBirthday());
			request.setAttribute("muerte", aResult.getDeathday());
			request.setAttribute("edad", aResult.getAge());
			request.setAttribute("biografia", aResult.getBiography());
			request.setAttribute("lugar", aResult.getPlaceOfBirth());
			request.setAttribute("genero", aResult.getGender());
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
