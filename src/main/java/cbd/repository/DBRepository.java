package cbd.repository;

import java.time.LocalDate;
import java.util.Arrays;

import javax.persistence.EntityManager;

import cbd.model.Actor;
import cbd.model.Movie;
import cbd.model.Serie;

public class DBRepository {

	public static void populateDB(EntityManager em) {
		try {
			// Drop DB
			em.getTransaction().begin();
			em.createQuery("DELETE FROM Object").executeUpdate();
			em.getTransaction().commit();

			em.getTransaction().begin();
			// Populate Actors
			Actor a1 = new Actor("Katheryn Winnick", LocalDate.of(1977, 12, 17), null, 44,
					"Winnick nació en Etobicoke, Ontario. De ascendencia ucraniana, habla con fluidez varios idiomas: ucraniano, ruso, francés, italiano e inglés.\r\n"
							+ "\r\n"
							+ "Comenzó a entrenarse en artes marciales a los 7 años y logró su primer cinturón negro a los 13. Es cinturón negro (tercer dan) en taekwondo, cinturón negro (segundo dan) en karate, y guardaespaldas con licencia. Gracias a sus escuelas de artes marciales, comenzó a entrenar actores y actrices, lo que le permitió ingresar en el ambiente.",
					"Toronto, Ontario, Canada", "Femenino", "/vQSqH3ybDWZHZIqX4NZKhOCXAhQ.jpg");
			em.persist(a1);
			Actor a2 = new Actor("Travis Fimmel", LocalDate.of(1979, 7, 15), null, 42,
					"Travis Fimmel es un actor de cine y televisión y modelo australiano.​\r\n" + "\r\n"
							+ "Saltó a la fama en 2002, por ser la imagen de la campaña de modelaje de ropa interior para Calvin Klein​ Y atrajo la atención de la industria de la televisión internacional al interpretar el papel protagonista de la serie Vikings (2013), interpretando al rey nórdico, legendario del siglo IX, Ragnar Lothbrok.​ En el mundo cinematográfico, su primer papel importante fue interpretar a Anduin Lothar en la película Warcraft: El Origen (2016), protagonizando uno de los roles principales.​",
					"Echuca, Victoria, Australia", "Masculino", "/3feVQYAZXNHduKdtw3oMMAnUbQg.jpg");
			em.persist(a2);

			// Populate Movies
			Movie m1 = new Movie("Soy leyenda", LocalDate.of(2007, 12, 19), "1h 40m",
					"Año 2012. Robert Neville es el último hombre vivo que hay sobre la Tierra, pero no está solo. Los demás seres humanos se han convertido en unos mutantes nocturnos llamados \"Darkseekers\" y todos ansían beber su sangre. Durante el día vive en estado de alerta, como un cazador, y busca a los muertos vivientes mientras duermen; pero durante la noche debe esconderse de ellos y esperar el amanecer. Esta pesadilla empezó hace tres años: Neville era un brillante científico, pero no pudo impedir la expansión de un terrible virus creado por el hombre. Él ha sobrevivido porque es inmune al virus; todos los días envía mensajes por radio con la esperanza de que haya otros supervivientes, pero es inútil. Lo único que puede hacer es buscar una fórmula que le permita utilizar su sangre inmune para devolverles a los hombres su naturaleza. Pero está en inferioridad de condiciones y el tiempo se acaba.",
					"Drama, Ciencia ficción, Suspense", "/suoz4D4dctVraPhC8HqD5xnpfsa.jpg");
			em.persist(m1);

			// Populate Series
			Serie s1 = new Serie("Vikingos", LocalDate.of(2013, 3, 3), "45m",
					"Sigue las aventuras de Ragnar Lothbrok, el héroe más grande de su época. La serie narra las sagas de la banda de hermanos vikingos de Ragnar y su familia, cuando él se levanta para convertirse en el rey de las tribus vikingas. Además de ser un guerrero valiente, Ragnar encarna las tradiciones nórdicas de la devoción a los dioses, la leyenda dice que él era un descendiente directo de Odín, el dios de la guerra y los guerreros.",
					6, "Action & Adventure, Drama, War & Politics", "Netflix, Prime Video, History", true,
					"/uNFSCxeZsZVIQ1TrD6mzu6uMQEb.jpg");
			s1.setActors(Arrays.asList(a1,a2));
			em.persist(s1);

			em.getTransaction().commit();
		} finally {
			if (em.getTransaction().isActive())
				em.getTransaction().rollback();
			em.close();
		}
	}
}
