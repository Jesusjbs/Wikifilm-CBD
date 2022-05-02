package cbd.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import cbd.model.Lista;
import cbd.model.Movie;
import cbd.model.Pair;
import cbd.model.Serie;
import cbd.model.User;

public class ListRepository {

	public List<Lista> getLists(Long aToken, EntityManager em) {
		List<Lista> result = new ArrayList<>();
		try {
			em.getTransaction().begin();
			result = em.createQuery("SELECT l FROM Lista l WHERE l.user.token =:aToken", Lista.class)
					.setParameter("aToken", aToken).getResultList();
		} finally {
			if (em.getTransaction().isActive())
				em.getTransaction().rollback();
			em.close();
		}
		return result;
	}

	public void createList(Long aToken, String title, EntityManager em) {
		Lista result = new Lista(title);

		try {
			em.getTransaction().begin();
			result.setUser(em.createQuery("SELECT u FROM User u WHERE u.token =:aToken", User.class)
					.setParameter("aToken", aToken).getSingleResult());
			em.persist(result);
			em.getTransaction().commit();

		} finally {
			if (em.getTransaction().isActive())
				em.getTransaction().rollback();
			em.close();
		}
	}

	public void deleteList(Long aToken, Integer listId, EntityManager em) {
		em.getTransaction().begin();
		em.createQuery("DELETE FROM Lista l WHERE l.user.token =: aToken and l.id = :listId")
				.setParameter("aToken", aToken).setParameter("listId", listId).executeUpdate();
		em.getTransaction().commit();
	}

	public void updateList(Long aToken, Integer listId, String description, String nombre, Boolean tipo,
			EntityManager em) {
		em.getTransaction().begin();
		Lista l = em.createQuery("SELECT l FROM Lista l WHERE l.user.token =: aToken and l.id = :listId", Lista.class)
				.setParameter("aToken", aToken).setParameter("listId", listId).getSingleResult();
		l.setDescription(description);
		l.setTitle(nombre);
		l.setPrivateList(tipo);
		em.getTransaction().commit();
		em.close();
	}

	public Pair<List<Movie>, List<Serie>> getListById(Long aToken, Integer listId, EntityManager em) {
		List<Movie> movies = new ArrayList<>();
		List<Serie> series = new ArrayList<>();

		try {
			em.getTransaction().begin();
			Lista lmov = em
					.createQuery("SELECT l FROM Lista l WHERE l.user.token =: aToken and l.id = :listId", Lista.class)
					.setParameter("aToken", aToken).setParameter("listId", listId).getSingleResult();
			Lista lser = em
					.createQuery("SELECT l FROM Lista l WHERE l.user.token =: aToken and l.id = :listId", Lista.class)
					.setParameter("aToken", aToken).setParameter("listId", listId).getSingleResult();
			if (lmov.getMovies() != null)
				movies = lmov.getMovies().stream().collect(Collectors.toList());
			if (lser.getSeries() != null)
				series = lser.getSeries().stream().collect(Collectors.toList());
		} finally {
			if (em.getTransaction().isActive())
				em.getTransaction().rollback();
			em.close();
		}
		return new Pair<List<Movie>, List<Serie>>(movies, series);
	}

	public void addItem(Long aToken, Integer listId, Integer itemId, String tipo, EntityManager em) {
		em.getTransaction().begin();
		Lista l = em.createQuery("SELECT l FROM Lista l WHERE l.user.token =: aToken and l.id =:listId", Lista.class)
				.setParameter("aToken", aToken).setParameter("listId", listId).getSingleResult();
		if (tipo == "movie") {
			l.addMovies(em.createQuery("SELECT m FROM Movie m WHERE m.id =: itemId", Movie.class)
					.setParameter("itemId", itemId).getSingleResult());
		} else {
			l.addSeries(em.createQuery("SELECT s FROM Serie s WHERE s.id =: itemId", Serie.class)
					.setParameter("itemId", itemId).getSingleResult());
		}
		em.getTransaction().commit();
		em.close();
	}

	public void deleteItem(Long aToken, Integer idList, Integer idItem, String tipo, EntityManager em) {
		em.getTransaction().begin();
		Lista l = em.createQuery("SELECT l FROM Lista l WHERE l.user.token =: aToken and l.id =:listId", Lista.class)
				.setParameter("aToken", aToken).setParameter("listId", idList).getSingleResult();
		TypedQuery<Movie> m = null;
		TypedQuery<Serie> s = null;
		try {
			m = em.createQuery("SELECT m FROM Movie m WHERE m.id =: itemId", Movie.class).setParameter("itemId",
					idItem);
			l.deleteMovie(m.getSingleResult());
		} catch (Exception e) {
		}
		try {
			s = em.createQuery("SELECT s FROM Serie s WHERE s.id =: itemId", Serie.class).setParameter("itemId",
					idItem);
			l.deleteSerie(s.getSingleResult());
		} catch (Exception e) {
		}
		em.getTransaction().commit();
		em.close();
	}
}