package cbd.controller;

import java.io.IOException;
import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cbd.model.Comment;
import cbd.model.User;
import cbd.repository.CommentRepository;
import cbd.repository.UserRepository;

public class CommentController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

		EntityManagerFactory emf = (EntityManagerFactory) getServletContext().getAttribute("emf");
		EntityManager em = emf.createEntityManager();

		String id = req.getParameter("idItem");
		String media = req.getParameter("media");
		String comment = req.getParameter("comment");
		String rating = req.getParameter("rating");

		Long token = (Long) req.getSession().getAttribute("aToken");

		if (id != null && !"".equals(id) && comment != null && !"".equals(comment.trim())) {
			// Get user
			UserRepository uResource = new UserRepository();
			User author = uResource.getUserByToken(token, em);

			// Create comment
			em = emf.createEntityManager();
			CommentRepository cResource = new CommentRepository();
			try {
				Comment cm = new Comment();
				cm.setRating(Integer.valueOf(rating));
				cm.setContent(comment);
				cm.setDate(LocalDate.now());
				cm.setUser(author);
				cResource.insertComment(cm, id, media, em);

				req.setAttribute("titleQuery", id);
				req.setAttribute("mediaQuery", media);
				req.setAttribute("message", "Se ha publicado correctamente.");
				req.getRequestDispatcher("/TitleController").forward(req, resp);
			} catch (Exception e) {
				e.printStackTrace();
				req.setAttribute("message", "Debe escribir un comentario válido.");
				req.setAttribute("titleQuery", id);
				req.setAttribute("mediaQuery", media);
				req.setAttribute("rating", rating);
				req.setAttribute("content", comment);
				req.getRequestDispatcher("/TitleController").forward(req, resp);
			}
		} else {
			req.setAttribute("message", "Debe escribir un comentario válido.");
			req.setAttribute("titleQuery", id);
			req.setAttribute("mediaQuery", media);
			req.getRequestDispatcher("/TitleController").forward(req, resp);
		}

	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		doGet(req, resp);
	}

}
