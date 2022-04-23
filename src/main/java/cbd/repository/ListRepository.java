package cbd.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import cbd.model.Lista;
import cbd.model.Movie;
import cbd.model.Pair;
import cbd.model.Serie;
import cbd.model.User;

public class ListRepository {

	public List<Lista> getLists(String aToken, EntityManager em) {
		List<Lista> result = new ArrayList<>();
		try {
			em.getTransaction().begin();
			result = em.createQuery("SELECT l FROM Lista l WHERE l.user.username =:aToken", Lista.class)
					.setParameter("aToken", aToken).getResultList();
		} finally {
			if (em.getTransaction().isActive())
				em.getTransaction().rollback();
			em.close();
		}
		return result;
	}

	public Lista createList(String aToken, String title, EntityManager em) {
		Lista result = new Lista(title);
		try {
			em.getTransaction().begin();
			result.setUser(em.createQuery("SELECT u FROM User u WHERE u.username =:aToken", User.class)
					.setParameter("aToken", aToken).getSingleResult());
			em.persist(result);
			em.getTransaction().commit();

		} finally {
			if (em.getTransaction().isActive())
				em.getTransaction().rollback();
			em.close();
		}
		return result;
	}

	public void deleteList(String aToken, Integer listId, EntityManager em) {
		em.getTransaction().begin();
		em.createQuery("DELETE l FROM Lista l WHERE l.user.username =: aToken and l.id = :listId")
				.setParameter("aToken", aToken).setParameter("listId", listId).executeUpdate();
		em.getTransaction().commit();
	}

	public void updateList(String aToken, Integer listId, String description, String nombre, Boolean tipo,
			EntityManager em) {
		em.getTransaction().begin();
		Lista l = em
				.createQuery("SELECT l FROM Lista l WHERE l.user.username =: aToken and l.id = :listId", Lista.class)
				.setParameter("aToken", aToken).setParameter("listId", listId).getSingleResult();
		l.setDescription(description);
		l.setTitle(nombre);
		l.setPrivateList(tipo);
		em.getTransaction().commit();
	}

	public Pair<List<Movie>, List<Serie>> getListById(String aToken, Integer listId, EntityManager em) {
		List<Movie> movies = new ArrayList<>();
		List<Serie> series = new ArrayList<>();

		try {
			em.getTransaction().begin();
			movies = em.createQuery("SELECT l.movies FROM Lista l WHERE l.user.username =: aToken and l.id = :listId",
					Movie.class).setParameter("aToken", aToken).setParameter("listId", listId).getResultList();
			series = em.createQuery("SELECT l.series FROM Lista l WHERE l.user.username =: aToken and l.id = :listId",
					Serie.class).setParameter("aToken", aToken).setParameter("listId", listId).getResultList();
		} finally {
			if (em.getTransaction().isActive())
				em.getTransaction().rollback();
			em.close();
		}
		return new Pair<List<Movie>, List<Serie>>(movies, series);
	}

	public void addItem(String aToken, Integer listId, Integer itemId, String tipo, EntityManager em) {
		em.getTransaction().begin();
		Lista l = em.createQuery("SELECT l FROM Lista l WHERE l.user.username =: aToken and l.id =:listId", Lista.class)
				.setParameter("aToken", aToken).setParameter("listId", listId).getSingleResult();
		if (tipo == "movie") {
			l.addMovies(em.createQuery("SELECT m FROM Movie m WHERE m.id =: itemId", Movie.class)
					.setParameter("itemId", itemId).getSingleResult());
		} else {
			l.addSeries(em.createQuery("SELECT s FROM Serie s WHERE s.id =: itemId", Serie.class)
					.setParameter("itemId", itemId).getSingleResult());
		}
		em.getTransaction().commit();
	}

	public void deleteItem(String aToken, Integer idList, Integer idItem, String tipo, EntityManager em) {
		em.getTransaction().begin();
		Lista l = em.createQuery("SELECT l FROM Lista l WHERE l.user.username =: aToken and l.id =:listId", Lista.class)
				.setParameter("aToken", aToken).setParameter("listId", idList).getSingleResult();
		if (tipo == "movie") {
			l.addMovies(em.createQuery("SELECT m FROM Movie m WHERE m.id =: idItem", Movie.class)
					.setParameter("itemId", idItem).getSingleResult());
		} else {
			l.addSeries(em.createQuery("SELECT s FROM Serie s WHERE s.id =: idItem", Serie.class)
					.setParameter("itemId", idItem).getSingleResult());
		}		em.getTransaction().commit();
	}
}
