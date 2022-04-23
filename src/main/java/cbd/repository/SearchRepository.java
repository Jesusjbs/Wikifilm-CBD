package cbd.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import cbd.model.Movie;
import cbd.model.Pair;
import cbd.model.Serie;

public class SearchRepository {

	public List<Movie> getMovies(String query, EntityManager em) {
		List<Movie> result = new ArrayList<>();
		try {
			em.getTransaction().begin();
			result = em.createQuery("SELECT m FROM Movie m WHERE UPPER(m.title) LIKE UPPER(:query)", Movie.class)
					.setParameter("query", "%" + query + "%").getResultList();
		} finally {
			if (em.getTransaction().isActive())
				em.getTransaction().rollback();
			em.close();
		}
		return result;
	}

	public List<Serie> getSeries(String query, EntityManager em) {
		List<Serie> result = new ArrayList<>();
		try {
			em.getTransaction().begin();
			result = em.createQuery("SELECT s FROM Serie s WHERE UPPER(s.title) LIKE UPPER(:query)", Serie.class)
					.setParameter("query", "%" + query + "%").getResultList();
		} finally {
			if (em.getTransaction().isActive())
				em.getTransaction().rollback();
			em.close();
		}
		return result;
	}

	public Pair<List<Movie>, List<Serie>> getTitles(String query, EntityManager em) {
		List<Movie> resultM = new ArrayList<>();
		List<Serie> resultS = new ArrayList<>();

		try {
			em.getTransaction().begin();
			resultM = em.createQuery("SELECT m FROM Movie m WHERE UPPER(m.title) LIKE UPPER(:query)", Movie.class)
					.setParameter("query", "%" + query + "%").getResultList();
			resultS = em.createQuery("SELECT s FROM Serie s WHERE UPPER(s.title) LIKE UPPER(:query)", Serie.class)
					.setParameter("query", "%" + query + "%").getResultList();
		} finally {
			if (em.getTransaction().isActive())
				em.getTransaction().rollback();
			em.close();
		}
		return new Pair<List<Movie>, List<Serie>>(resultM, resultS);
	}
}
