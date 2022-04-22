package cbd.repository;

import java.time.LocalDate;

import javax.persistence.EntityManager;

import cbd.model.Actor;
import cbd.model.Movie;

public class DBRepository {

	public static void populateDB(EntityManager em) {
		try {
			em.getTransaction().begin();
			// Populate Movies
			em.persist(new Movie("Soy leyenda", LocalDate.of(2007, 12, 19), "1h 40m",
					"Año 2012. Robert Neville es el último hombre vivo que hay sobre la Tierra, pero no está solo. Los demás seres humanos se han convertido en unos mutantes nocturnos llamados \"Darkseekers\" y todos ansían beber su sangre. Durante el día vive en estado de alerta, como un cazador, y busca a los muertos vivientes mientras duermen; pero durante la noche debe esconderse de ellos y esperar el amanecer. Esta pesadilla empezó hace tres años: Neville era un brillante científico, pero no pudo impedir la expansión de un terrible virus creado por el hombre. Él ha sobrevivido porque es inmune al virus; todos los días envía mensajes por radio con la esperanza de que haya otros supervivientes, pero es inútil. Lo único que puede hacer es buscar una fórmula que le permita utilizar su sangre inmune para devolverles a los hombres su naturaleza. Pero está en inferioridad de condiciones y el tiempo se acaba.",
					"Drama, Ciencia ficción, Suspense"));
			// Populate Actors
			em.persist(new Actor("Katheryn Winnick", LocalDate.of(1977, 12, 17), null, 44,
					"Winnick nació en Etobicoke, Ontario. De ascendencia ucraniana, habla con fluidez varios idiomas: ucraniano, ruso, francés, italiano e inglés.\r\n"
							+ "\r\n"
							+ "Comenzó a entrenarse en artes marciales a los 7 años y logró su primer cinturón negro a los 13. Es cinturón negro (tercer dan) en taekwondo, cinturón negro (segundo dan) en karate, y guardaespaldas con licencia. Gracias a sus escuelas de artes marciales, comenzó a entrenar actores y actrices, lo que le permitió ingresar en el ambiente.",
					"Toronto, Ontario, Canada", "Femenino"));

			em.getTransaction().commit();
		} finally {
			if (em.getTransaction().isActive())
				em.getTransaction().rollback();
			em.close();
		}
	}
}
