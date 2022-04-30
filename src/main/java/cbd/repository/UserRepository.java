package cbd.repository;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import cbd.model.User;
import cbd.util.PasswordException;

public class UserRepository {

	public User getUser(String username, String password, EntityManager em) {
		User result = new User();
		try {
			em.getTransaction().begin();
			result = em.createQuery("SELECT u FROM User u WHERE u.username =:user and u.password =:pass", User.class)
					.setParameter("user", username).setParameter("pass", password).getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
			result = null;
		} finally {
			if (em.getTransaction().isActive())
				em.getTransaction().rollback();
			em.close();
		}
		return result;
	}

	public User getUserByToken(Long token, EntityManager em) {
		User result = new User();
		try {
			em.getTransaction().begin();
			result = em.createQuery("SELECT u FROM User u WHERE u.token =:token", User.class)
					.setParameter("token", token).getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
			result = null;
		} finally {
			if (em.getTransaction().isActive())
				em.getTransaction().rollback();
			em.close();
		}
		return result;
	}

	public void register(String username, String password, EntityManagerFactory emf) throws PasswordException, NoSuchAlgorithmException {
		EntityManager em = emf.createEntityManager();
		System.out.println("Usuario1");
		if (!password.matches("^(?=.*\\d)(?=.*[A-Z])(?=.*[a-z])(?=.*[^\\w\\d\\s:])([^\\s]){8,20}$")) {
			throw new PasswordException();
		}
		Long token = null;
		Long repetitions = 1l;
		while (repetitions != 0) {
			em = emf.createEntityManager();
			token = SecureRandom.getInstance("SHA1PRNG").nextLong();
			repetitions = (Long) em.createQuery("SELECT count(u) FROM User u WHERE u.token =:token", Long.class)
					.setParameter("token", token).getSingleResult();
		}
		em.getTransaction().begin();
		em.persist(new User(username.toLowerCase(), password, true, token));
		em.getTransaction().commit();
		if (em.getTransaction().isActive())
			em.getTransaction().rollback();
		em.close();
	}

}
