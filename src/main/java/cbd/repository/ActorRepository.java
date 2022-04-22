package cbd.repository;

import javax.persistence.EntityManager;

import cbd.model.Actor;

public class ActorRepository {

	public Actor getActor(String id, EntityManager em) {
		Actor result = new Actor();
		try {
			em.getTransaction().begin();
			result = em.createQuery("SELECT a FROM Actor a WHERE a.id =:id)", Actor.class).setParameter("id", id)
					.getSingleResult();
		} finally {
			if (em.getTransaction().isActive())
				em.getTransaction().rollback();
			em.close();
		}
		return result;
	}
}
