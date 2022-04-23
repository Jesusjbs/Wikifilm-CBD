package cbd.repository;

import javax.persistence.EntityManager;

import cbd.model.User;

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

}
