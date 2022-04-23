package cbd.repository;

import javax.persistence.EntityManager;

import cbd.model.Movie;
import cbd.model.Serie;

public class TitleRepository {

	public Movie getMovie(String id, EntityManager em) {
		Movie result = null;
		try {
			em.getTransaction().begin();
			result = em.createQuery("SELECT m FROM Movie m WHERE m.id =:id", Movie.class).setParameter("id", Integer.valueOf(id))
					.getSingleResult();
		} finally {
			if (em.getTransaction().isActive())
				em.getTransaction().rollback();
			em.close();
		}
		return result;
	}

	public Serie getSerie(String id, EntityManager em) {
		Serie result = null;
		try {
			em.getTransaction().begin();
			result = em.createQuery("SELECT s FROM Serie s WHERE s.id =:id", Serie.class)
					.setParameter("id", Integer.valueOf(id)).getSingleResult();
		} finally {
			if (em.getTransaction().isActive())
				em.getTransaction().rollback();
			em.close();
		}
		return result;
	}

}