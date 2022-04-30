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
import cbd.util.PasswordException;

public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		EntityManagerFactory emf = (EntityManagerFactory) getServletContext().getAttribute("emf");
		EntityManager em = emf.createEntityManager();

		String username = request.getParameter("user");
		String password = request.getParameter("pass");
		String logout = request.getParameter("logout");
		String register = request.getParameter("register");

		RequestDispatcher rd = null;

		UserRepository uc = new UserRepository();
		if (logout != null) {
			request.getSession().removeAttribute("aToken");
			request.getSession().removeAttribute("username");
			rd = request.getRequestDispatcher("/index.jsp");
		} else {
			if (register != null && username != null && !username.trim().equals("") && password != null
					&& !password.trim().equals("")) {
				// Register
				try {
					uc.register(username, password, emf);
					rd = request.getRequestDispatcher("/index.jsp");
				} catch (PasswordException e) {
					request.setAttribute("mensaje",
							"La contraseña debe tener entre 8 y 20 caracteres y contener al menos una mayúscula, una minúscula, un dígito y un carácter especial.");
					rd = request.getRequestDispatcher("/register.jsp");
				} catch (Exception e) {
					e.printStackTrace();
					request.setAttribute("mensaje", "Ya existe un usuario con ese nombre en nuestras bases de datos.");
					rd = request.getRequestDispatcher("/register.jsp");
				}
			} else if (register == null && uc.getUser(username, password, em) != null) {
				// Login
				em = emf.createEntityManager();
				User uResult = uc.getUser(username, password, em);
				rd = request.getRequestDispatcher("/index.jsp");
				request.getSession().setAttribute("aToken", uResult.getToken());
				request.getSession().setAttribute("username", uResult.getUsername());
			} else {
				if (register == null) {
					request.setAttribute("mensaje",
							"El nombre de usuario y la contraseña que ingresaste no coinciden con nuestros registros. Por favor, revisa e inténtalo de nuevo.");
					rd = request.getRequestDispatcher("/login.jsp");
				} else {
					request.setAttribute("mensaje", "No ha introducido un usuario o una contraseña válida");
					rd = request.getRequestDispatcher("/register.jsp");
				}
			}
		}
		rd.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
