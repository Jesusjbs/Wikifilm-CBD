package cbd.repository;

import javax.persistence.EntityManager;

import cbd.model.Comment;
import cbd.model.Movie;
import cbd.model.Serie;

public class CommentRepository {

	public void insertComment(Comment comentario, String idItem, String tipo, EntityManager em) {
		em.getTransaction().begin();
		try {
			if (tipo.equals("movie")) {
				Movie movie = em.createQuery("SELECT m FROM Movie m WHERE m.id =: idItem", Movie.class)
						.setParameter("idItem", Integer.valueOf(idItem)).getSingleResult();
				comentario.setMovie(movie);
				em.persist(comentario);
				movie.addComment(comentario);
			} else {
				Serie serie = em.createQuery("SELECT s FROM Serie s WHERE s.id =: idItem", Serie.class)
						.setParameter("idItem", Integer.valueOf(idItem)).getSingleResult();
				comentario.setSerie(serie);
				em.persist(comentario);
				serie.addComment(comentario);
			}
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		em.close();
	}
}
