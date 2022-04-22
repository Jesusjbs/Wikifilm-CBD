package cbd.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cbd.model.Comment;
import cbd.repository.CommentRepository;

public class CommentController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

		String idtmDb = (String) req.getSession().getAttribute("titleQuery");
		String titleTrailer = (String) req.getSession().getAttribute("trailerQuery");
		String yearTrailer = (String) req.getSession().getAttribute("yearTrailerQuery");
		String media = (String) req.getSession().getAttribute("mediaQuery");
		String tipo = (String) req.getSession().getAttribute("tipoQuery");
		String id = (String) req.getSession().getAttribute("idvideo");
		String comment = (String) req.getParameter("comment");

		req.setAttribute("titleQuery", idtmDb);
		req.setAttribute("trailerQuery", titleTrailer);
		req.setAttribute("yearTrailerQuery", yearTrailer);
		req.setAttribute("tipoQuery", tipo);
		req.setAttribute("mediaQuery", media);
		req.setAttribute("idvideo", id);

		if (id != null && !"".equals(id) && comment != null && !"".equals(comment)) {
			CommentRepository cResource = new CommentRepository();
			Comment cm = new Comment();
			cResource.insertComment(cm);

			req.setAttribute("message", "Se ha publicado correctamente");
			req.getRequestDispatcher("/TitleController").forward(req, resp);
		} else {
			req.setAttribute("message", "Debe escribir un comentario válido.");
			req.setAttribute("content", comment);
			req.getRequestDispatcher("/TitleController").forward(req, resp);
		}

	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		doGet(req, resp);
	}

}
