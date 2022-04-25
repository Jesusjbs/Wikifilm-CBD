package cbd.controller;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cbd.model.User;
import cbd.repository.UserRepository;

public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		EntityManagerFactory emf = (EntityManagerFactory) getServletContext().getAttribute("emf");
		EntityManager em = emf.createEntityManager();

		String username = request.getParameter("user");
		String password = request.getParameter("pass");
		String logout = request.getParameter("logout");

		RequestDispatcher rd = null;

		UserRepository uc = new UserRepository();
		if (logout != null) {
			request.getSession().removeAttribute("aToken");
			request.getSession().removeAttribute("username");
			rd = request.getRequestDispatcher("/index.jsp");
		} else {
			User uResult = uc.getUser(username, password, em);
			if (uResult != null) {
				rd = request.getRequestDispatcher("/index.jsp");
				request.getSession().setAttribute("aToken", uResult.getToken());
				request.getSession().setAttribute("username", uResult.getUsername());
			} else {
				request.setAttribute("mensaje",
						"El nombre de usuario y la contraseña que ingresaste no coinciden con nuestros registros. Por favor, revisa e inténtalo de nuevo.");
				rd = request.getRequestDispatcher("/login.jsp");
			}
		}
		rd.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
