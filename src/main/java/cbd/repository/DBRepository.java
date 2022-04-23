package cbd.repository;

import java.security.SecureRandom;
import java.time.LocalDate;
import java.util.Arrays;

import javax.persistence.EntityManager;

import cbd.model.Actor;
import cbd.model.Movie;
import cbd.model.Serie;
import cbd.model.User;

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
			Actor a3 = new Actor("Will Smith", LocalDate.of(1968, 9, 25), null, 53,
					"Willard Carroll «Will» Smith, Jr., (25 de septiembre de 1968, Filadelfia, Pensilvania, Estados Unidos), mejor conocido como Will Smith, es un actor y rapero estadounidense que ha tenido éxito en sus dos facetas artísticas: ha sido nominado a cuatro Premios Globo de Oro y a dos Premios Óscar, y ha ganado Premios Grammy. A finales de los años 1980, alcanzó una modesta fama como rapero, con el nombre de The Fresh Prince. En 1990, su fama aumentó drásticamente, cuando protagonizó la serie de televisión The Fresh Prince of Bel-Air, que se transmitió durante más de media década (1990 - 1996) en la NBC y se ha retransmitido de forma permanente en diversas cadenas. A mediados de los 90, pasó de la televisión al cine, y actuó en numerosas películas que lograron un gran éxito de taquilla. También recibió un premio especial por su aportación a la música dentro del cine, en la Gala de los Premios Principales del 2007.",
					"Philadelphia, Pennsylvania, USA", "Masculino", "/6a6cl4ZNufJzrx5HZKWPU1BjjRF.jpg");
			em.persist(a3);
			Actor a4 = new Actor("Robert Pattinson", LocalDate.of(1986, 5, 13), null, 35,
					"Robert Thomas Pattinson (13 de mayo de 1986) es un actor, modelo, productor y cantante británico.\r\n" + 
					"\r\n" + 
					"Comenzó su carrera actoral interpretando a Cedric Diggory en Harry Potter y el cáliz de fuego (2005) y luego alcanzó un reconocimiento mundial por interpretar a Edward Cullen en las adaptaciones cinematográficas de las novelas de La Saga Crepúsculo (2008-2012) de Stephenie Meyer,​ por lo tanto se establece entre los actores más estables y de mejor paga de Hollywood.​\r\n" + 
					"\r\n" + 
					"En 2010, Pattinson fue nombrado entre las 100 personas más influyentes del mundo por la revista Time,​ y en el mismo año la revista Forbes nombró a Pattinson como una de las celebridades más poderosas del mundo en el Forbes Celebrity 100.",
					"Barnes, London, England, UK", "Masculino", "/6RVxNlNmc0DIfZzaJKCJM43If3M.jpg");
			em.persist(a4);
			Actor a5 = new Actor("Marlon Brando", LocalDate.of(1924, 4, 3), LocalDate.of(2004, 7, 1), 80,
					"Actor estadounidense, uno de los intérpretes más importantes de su generación y paradigma de la técnica de interpretación del Actor's Studio de Nueva York. Nació en Omaha, Nebraska, el 3 de abril de 1924 en el seno de una familia muy humilde. Debutó en Broadway en 1944. Fue descubierto gracias a su trabajo como Stanley Kowalski en Un tranvía llamado deseo (1947), de Tennessee Williams, personaje a medida para el estilo de interpretación naturalista del método de Lee Strasberg. Esta obra fue llevada a la pantalla en 1951 por el director Elia Kazan con gran éxito. Desde entonces mostró su versatilidad interpretativa encarnando muy distintos personajes, desde Marco Antonio en Julio César (1953, de Joseph Mankiewicz) hasta el motorista gamberro de ¡Salvaje! (1954, de Laszlo Benedek). Recibió el Oscar al mejor actor por La ley del silencio (1954), de Elia Kazan, y aunque lo ganó de nuevo por su interpretación en El padrino (1972), de Francis Ford Coppola, lo rechazó en señal de protesta por la explotación a la que eran sometidos los indígenas americanos por parte de la industria del cine. Otras películas señaladas de su filmografía son: Viva Zapata (1952), también de Elia Kazan; La casa de té de la luna de agosto (1956), de Daniel Mann; El rostro impenetrable (1961), que dirigió él mismo; Rebelión a bordo (1962), de Lewis Milestone, nueva versión del clásico de 1935 dirigido por Frank Lloyd; El último tango en París (1972), de Bernardo Bertolucci; Missouri (1976), de Arthur Penn; Apocalypse now (1979), de Francis Ford Coppola; Una árida estación blanca (1989), de Euzhan Palcy, y El novato (1990), de Andrew Bergman. Los últimos años de su carrera estuvieron marcados por la tragedia en el ámbito familiar. Durante esos años, sus intervenciones en el cine fueron escasas y poco relevantes. Falleció el 1 de julio de 2004 en Los Ángeles, EEUU.",
					"Omaha, Nebraska, USA", "Masculino", "/fuTEPMsBtV1zE98ujPONbKiYDc2.jpg");
			em.persist(a5);
			Actor a6 = new Actor("Tom Hanks", LocalDate.of(1956, 7, 9), null, 65,
					"Thomas Jeffrey Hanks (nacido el 9 de julio de 1956) es un actor y cineasta estadounidense. Conocido por sus papeles cómicos y dramáticos, Hanks es una de las estrellas de cine más populares y reconocibles en todo el mundo, y es ampliamente considerado como un ícono cultural estadounidense.\r\n" + 
					"\r\n" + 
					"Hanks hizo su gran avance con papeles principales en las comedias Splash (1984) y Big (1988). Ganó dos premios consecutivos de la Academia al Mejor Actor por interpretar a un abogado gay que padecía SIDA en Filadelfia (1993) y un joven con un coeficiente intelectual inferior al promedio en Forrest Gump (1994). Hanks colaboró ​​con el director de cine Steven Spielberg en cinco películas: Saving Private Ryan (1998), Catch Me If You Can (2002), The Terminal (2004), Bridge of Spies (2015) y The Post (2017), así como la miniserie de 2001 Band of Brothers, que lo lanzó como director, productor y guionista.\r\n" + 
					"\r\n" + 
					"Otras películas notables de Hanks incluyen las comedias románticas Sleepless in Seattle (1993) y You Have Got Mail (1998); los dramas Apollo 13 (1995), The Green Mile (1999), Cast Away (2000), Road to Perdition (2002) y Cloud Atlas (2012); y los dramas biográficos Saving Mr. Banks (2013), Captain Phillips (2013), Sully (2016) y A Beautiful Day in the Neighborhood (2019). También ha aparecido como el personaje principal en la serie de películas Robert Langdon, y ha expresado al Sheriff Woody en la serie de películas Toy Story.",
					"Concord, California, United States", "Masculino", "/xndWFsBlClOJFRdhSt4NBwiPq2o.jpg");
			em.persist(a6);
			Actor a7 = new Actor("Tim Robbins", LocalDate.of(1958, 10, 16), null, 63,
					"Tim Robbins nació en West Covina, California, y se crio en Nueva York. Es hijo de la actriz Mary Robbins y del cantante y músico Gil Robbins.​ Comenzó a actuar desde los 12 años en el Theatre New City cuando se encontraba en el instituto Stuyvesant.\r\n" + 
					"\r\n" + 
					"Estudió interpretación en UCLA. Cuando se graduó formó en 1981 un grupo teatral denominado Actor´s Gang, mediante el cual comenzó a representar obras teatrales vanguardistas de contenido sociopolítico.\r\n" + 
					"\r\n" + 
					"En los años 80, trabajó en series de televisión. En el cine comenzó a hacer pequeños papeles en películas como \"Click, click\" dirigida por Jerry Schatzberg y protagonizada por Demi Moore. Más tarde fue haciendo papeles secundarios más importantes como una breve aparición en \"Top Gun\" (1986) dirigida por Tony Scott.\r\n" + 
					"\r\n" + 
					"En 1988 comenzó una relación con la actriz Susan Sarandon, a quien había conocido en el rodaje de la película \"Los búfalos de Durham\".\r\n" + 
					"\r\n" + 
					"En 1992 debutó como director y guionista con la sátira política \"Ciudadano Bob Roberts\". En 1994, interpretó magistralmente al convicto Andy Dufresne en The Shawshank Redemption, junto a Morgan Freeman.\r\n" + 
					"\r\n" + 
					"Posteriormente ha hecho muchos papeles como protagonista o secundario de lujo. En 2003, ganó el premio Óscar al mejor actor de reparto por su actuación \"Mystic River\", dirigida por Clint Eastwood. En 2005 protagoniza la película de Isabel Coixet \"La vida secreta de las palabras\", ganadora del premio a la mejor película en la XX edición de los Premios Goya.\r\n" + 
					"\r\n" + 
					"Se ha caracterizado por sus fuertes ideales contrarios a la política internacional establecida por George Bush, y ha apoyado actos contra él junto a su entonces pareja Susan Sarandon, o junto al también actor, Sean Penn.\r\n" + 
					"\r\n" + 
					"Dirigió una versión teatral de la novela 1984, de George Orwell, que se representó en Madrid y Barcelona a finales de septiembre de 2009.\r\n" + 
					"\r\n" + 
					"En diciembre de 2009 anuncia con Susan Sarandon el fin de su relación, tras 23 años de vida en común en los que nunca llegaron a casarse.",
					"West Covina, California, USA", "Masculino", "/hsCu1JUzQQ4pl7uFxAVFLOs9yHh.jpg");
			em.persist(a7);
			Actor a8 = new Actor("Morgan Freeman", LocalDate.of(1937, 6, 1), null, 84,
					"Morgan Freeman (1 de junio de 1937) es un actor y director estadounidense, ganador del premio Óscar en 2005 por Million Dollar Baby. Además ha recibido otras nominaciones por sus actuaciones en El reportero de la calle 42 (1987), Paseando a Miss Daisy (1989), Cadena perpetua (1994) e Invictus (2009). También ha ganado los premios Globo de Oro y SAG. Es el narrador de Through the Wormhole.\r\n" + 
					"\r\n" + 
					"Su extensa carrera incluye otros éxitos de taquilla como Brubaker (1980), Sin perdón (1992), Tiempos de gloria (1989), Se7en (1995), Deep Impact (1998), Pánico nuclear (2002), Bruce Almighty (2003), The Bucket List (2007), Wanted (2008), tres entregas de la saga de Batman (Batman Begins, 2005; The Dark Knight, 2008 y The Dark Knight Rises, 2012) Lucy (2014) y la comedia Ted 2 (2015).",
					"Memphis, Tennessee, USA", "Masculino", "/905k0RFzH0Kd6gx8oSxRdnr6FL.jpg");
			em.persist(a8);
			Actor a9 = new Actor("Adrien Brody", LocalDate.of(1973, 4, 14), null, 49,
					"Adrien Brody (n. Nueva York, 14 de abril de 1973) es un actor y productor estadounidense. Ganador del premio Óscar a mejor actor por su actuación en la película El Pianista en el 2002, convirtiéndose en el actor más joven de la historia en haber ganado en esa categoría (tenía 29 años). Por esta misma película ganó el Premio César, lo cual lo convirtió en el único actor estadounidense que ha recibido este premio.",
					"New York City, New York, USA", "Masculino", "/1dBItgLFBNGEXnI48VvnnN2vFaX.jpg");
			em.persist(a9);
			Actor a10 = new Actor("Bryan Cranston", LocalDate.of(1956, 3, 7), null, 66,
					"Bryan Lee Cranston (Los Ángeles, 7 de marzo de 1956) es un actor, actor de voz, guionista, productor y director estadounidense, reconocido por su interpretación de Hal Wilkerson (el padre de familia de la serie de FOX Malcolm in the middle), de Walter White (en la serie de AMC Breaking Bad) y del doctor Tim Whatley en la comedia de NBC Seinfeld. Este papel le ha convertido en uno de los grandes en el panorama del cine y la televisión habiendo sido galardonado con numerosos premios como los Emmy y los Globos de Oro. En la última década ha pasado de ser un actor de papeles menores a ser uno de los más reconocidos en la industria cinematográfica, llegando a ser nominado a los Premios Óscar el año 2016.",
					"San Fernando Valley, California, USA", "Masculino", "/7Jahy5LZX2Fo8fGJltMreAI49hC.jpg");
			em.persist(a10);
			Actor a11 = new Actor("Aaron Paul", LocalDate.of(1979, 8, 27), null, 42,
					"Aaron Paul es un actor y productor estadounidense. Nació el 27 de agosto de 1979 en Emmett, Idaho. Cuenta con una carrera de más de 20 años entre cine y televisión. Su papel más conocido es el de Jesse Pinkman en la exitosa serie 'Breaking Bad', con la que consiguió grandes hitos como el premio a mejor actor de reparto en los Emmys.\r\n" + 
					"\r\n" + 
					"Sus primeras escenas en la televisión fueron en 1998 en series como 'Even the Losers' o 'Locust Valley', en las que se encargaría de papeles secundarios y de poco peso en la trama. En 1999 aparecería en una de las series más conocidas de esa década: 'Beverly Hills, 90210', aunque no tuvo un rol protagonista. No sería la única ocasión en la que tuviera un papel en una serie icónica. Ese mismo año también salió en un episodio de 'Melrose Place'. Durante 1999 coleccionó apariciones en diferentes capítulos de muchas series como 'Suddenly Susan' o '3rd Rock from the Sun'.\r\n" + 
					"\r\n" + 
					"Fue en el año 2000 cuando dio el salto a la gran pantalla con la película 'Whatever It Takes', protagonizada por James Franco. En 2001 volvió a aparecer en varios episodios de diferentes series. Una de las series más conocidas en las que participó ese año fue en 'Expediente X' (X-files), donde conoció a la también actriz Samaire Armstrong. Estuvieron saliendo desde principios de ese mismo año pero acabaron cortando la relación.\r\n" + 
					"\r\n" + 
					"En los siguientes años estuvo mezclando apariciones en series y películas. Algunas series tan conocidas como, 'The Guardian', 'Bones', 'CSI: Miami' o 'CSI: Crime Scene Investigation'. En cuanto a las películas se le pudo ver en 'Misión Imposible 3' o 'Daydreamer'.\r\n" + 
					"\r\n" + 
					"En 2008 llegaría su gran oportunidad con ?Breaking Bad?, siendo el papel de Jesse Pinkman el más conocido de la carrera de Aaron Paul. El actor encarnó este personaje desde su estreno en enero de 2008 hasta la finalización de la serie en 2013. Con este papel recibió toda clase de reconocimientos como Critics' Choice Television Award a mejor actor de reparto en 2014, un Satellite Award por mejor actor de reparto en 2013 y el Emmy a mejor actor de reparto en los años 2010, 2012 y 2014.\r\n" + 
					"\r\n" + 
					"En marzo de 2009 inició una relación que duró apenas un año con la actriz y cantante canadiense Jessica Lowndes. Ese mismo año conoció en el festival de Coachella a Lauren Parsekian, actriz y directora de cine estadounidense. Un año después, en el mismo festival, empezarían a salir. Acabaron comprometiéndose en enero de 2012 y se casaron en marzo de 2013. En febrero de 2018 nació su primera hija, llamada Story Annabelle.\r\n" + 
					"\r\n" + 
					"Después de la finalización de 'Breaking Bad', protagonizó la película 'Need For Speed' en marzo de 2014. También ese año comenzó a poner voz al personaje Todd Chavez en la serie de Netflix: 'BoJack Horseman'. Para la misma plataforma, Netflix, volvió a encarnar su papel en 'Breaking Bad' de Jesse Pinkman para la película 'El Camino'. La cinta era una continuación del final de la serie y se estrenó en octubre de 2019. En esta ocasión también fue productor de la cinta.",
					"Emmett, Idaho, USA", "Masculino", "/lowE44ffgu4UmnOT3wOTKYhtUzp.jpg");
			em.persist(a11);
			Actor a12 = new Actor("Jim Parsons", LocalDate.of(1973, 3, 24), null, 49,
					"James Joseph Parsons (24 de marzo de 1973), más conocido como Jim Parsons, un actor estadounidense de televisión, teatro y cine.\r\n" + 
					"\r\n" + 
					"Reconocido con múltiples premios debido a su peculiar forma de actuar, incluidos el de Television Critics Association, el National Association of Broadcasters, cuatro Premios Emmy y también un Premio Globo de Oro por mejor actor de comedia en serie de televisión.\r\n" + 
					"\r\n" + 
					"Su papel más conocido es el de Sheldon Cooper, un físico teórico, uno de los personajes principales de la serie televisiva The Big Bang Theory dirigida por Chuck Lorre, de gran éxito en Estados Unidos. Por este papel, obtuvo el Premio Emmy a mejor actor protagonista de comedia en 2010, 2011, 2013, 2014 y el Globo de Oro, también como mejor actor protagonista de comedia en 2011.",
					"Houston, Texas, USA", "Masculino", "/4D5oAUeM2wlejSwJJ6TmKoM9Abn.jpg");
			em.persist(a12);
			Actor a13 = new Actor("Jose Coronado", LocalDate.of(1957, 8, 14), null, 64,
					"José María Coronado García (14 de agosto de 1957) es un actor de cine y televisión español, ganador del Premio Goya como Mejor actor protagonista en 2011.",
					"Madrid, Spain", "Masculino", "/9xo68HzH8n78Xv6gMzKK7XnjtHd.jpg");
			em.persist(a13);
			Actor a14 = new Actor("Álex González", LocalDate.of(1980, 8, 13), null, 41,
					"Álex González was born on August 13, 1980 in Madrid, Spain as Augusto Alejandro José González. He is an actor, known for X-Men: First Class (2011), Scorpion in Love (2013) and Countdown (2007).",
					"Madrid, Spain", "Masculino", "/wSshBfOlhrRbHG7SRJp8nDeOtnD.jpg");
			em.persist(a14);
			Actor a15 = new Actor("Hiba Abouk", LocalDate.of(1986, 10, 30), null, 35,
					"De ascendencia tunecina y libia, ha saltado a la fama por su papel de Candela en la serie de Antena 3 Con el culo al aire.",
					"Madrid, Spain", "Femenino", "/6JnTfq14FdDHJrEOh39b51civSJ.jpg");
			em.persist(a15);
			Actor a16 = new Actor("TINI", LocalDate.of(1997, 3, 21), null, 25,
					"TINI, es una actriz, cantante, bailarina y modelo argentina. Comenzó a hacerse conocida por su personaje de Violetta Castillo en la serie original de Disney Channel Latinoamérica, Violetta.",
					"Buenos Aires, Buenos Aires, Argentina", "Femenino", "/vMnaz9txc4MdXchrZGWg0Z26sLq.jpg");
			em.persist(a16);
			Actor a17 = new Actor("Roberto Gómez Bolaños", LocalDate.of(1929, 2, 21), LocalDate.of(2014, 11, 28), 85,
					"Roberto Gómez Bolaños (21 February 1929 – 28 November 2014), more commonly known by his pseudonym Chespirito, was a Mexican screenwriter, actor, comedian, film director, television director, playwright, songwriter, and author. He is widely regarded as one of the most important Spanish-language comedians of the 20th century. He was internationally known for writing, directing, and starring in the Chespirito (1968), El Chavo del Ocho (1971), and El Chapulín Colorado (1972) television series. The character of El Chavo is one of the most iconic in the history of Latin American television, and El Chavo del Ocho continues to be immensely popular, with daily worldwide viewership averaging 91 million viewers per episode.",
					"Mexico City - Distrito Federal - Mexico", "Masculino", "/bwSQeMmSuYd5IKZdjOtbrsfZ3jy.jpg");
			em.persist(a17);


			// Populate Movies
			Movie m1 = new Movie("Soy leyenda", LocalDate.of(2007, 12, 19), "1h 40m",
					"Año 2012. Robert Neville es el último hombre vivo que hay sobre la Tierra, pero no está solo. Los demás seres humanos se han convertido en unos mutantes nocturnos llamados \"Darkseekers\" y todos ansían beber su sangre. Durante el día vive en estado de alerta, como un cazador, y busca a los muertos vivientes mientras duermen; pero durante la noche debe esconderse de ellos y esperar el amanecer. Esta pesadilla empezó hace tres años: Neville era un brillante científico, pero no pudo impedir la expansión de un terrible virus creado por el hombre. Él ha sobrevivido porque es inmune al virus; todos los días envía mensajes por radio con la esperanza de que haya otros supervivientes, pero es inútil. Lo único que puede hacer es buscar una fórmula que le permita utilizar su sangre inmune para devolverles a los hombres su naturaleza. Pero está en inferioridad de condiciones y el tiempo se acaba.",
					"Drama, Ciencia ficción, Suspense", "/suoz4D4dctVraPhC8HqD5xnpfsa.jpg");
			m1.setActors(Arrays.asList(a3));
			em.persist(m1);
			
			Movie m2 = new Movie("The Batman", LocalDate.of(2022, 3, 4), "2h 56m",
					"Cuando un asesino se dirige a la élite de Gotham con una serie de maquinaciones sádicas, un rastro de pistas crípticas envía Batman a una investigación en los bajos fondos. A medida que las pruebas comienzan a acercarse a su casa y se hace evidente la magnitud de los planes del autor, Batman debe forjar nuevas relaciones, desenmascarar al culpable y hacer justicia al abuso de poder y la corrupción que durante mucho tiempo han asolado Gotham City.",
					"Crimen, Misterio, Suspense", "/mo7teil1qH0SxgLijnqeYP1Eb4w.jpg");
			m2.setActors(Arrays.asList(a4));
			em.persist(m2);
			
			Movie m3 = new Movie("El Padrino", LocalDate.of(1972, 10, 20), "2h 55m",
					"Don Vito Corleone, conocido dentro de los círculos del hampa como 'El Padrino', es el patriarca de una de las cinco familias que ejercen el mando de la Cosa Nostra en Nueva York en los años cuarenta. Don Corleone tiene cuatro hijos: una chica, Connie, y tres varones; Sonny, Michael y Fredo. Cuando el Padrino reclina intervenir en el negocio de estupefacientes, empieza una cruenta lucha de violentos episodios entre las distintas familias del crimen organizado.",
					"Drama, Crimen", "/wLXd1Cd0XW7DhXayfC0Ok5ago9r.jpg");
			m3.setActors(Arrays.asList(a5));
			em.persist(m3);
			
			Movie m4 = new Movie("La milla verde", LocalDate.of(2000, 2, 18), "3h 09m",
					"En el sur de los Estados Unidos, en plena Depresión, Paul Edgecomb es un vigilante penitenciario a cargo de la Milla Verde, un pasillo que separa las celdas de los reclusos condenados a la silla eléctrica. Esperando su ejecución está John Coffey, un gigantesco negro acusado de asesinar brutalmente a dos hermanas de nueve años. Tras una personalidad ingenua, Coffey esconde un don sobrenatural prodigioso. A medida que transcurre la historia, Paul Edgecomb aprende que los milagros ocurren... incluso en los lugares más insospechados.",
					"Fantasía, Drama, Crimen", "/1EFS40uFzv5ZVLSpu3xqYqnou67.jpg");
			m4.setActors(Arrays.asList(a6));
			em.persist(m4);
			
			Movie m5 = new Movie("Forrest Gump", LocalDate.of(1994, 9, 23), "2h 22m",
					"Forrest Gump es un chico con deficiencias mentales no muy profundas y con alguna incapacidad motora que, a pesar de todo, llegará a convertirse, entre otras cosas, en un héroe durante la Guerra del Vietnam. Su persistencia y bondad le llevarán a conseguir una gran fortuna, ser objeto del clamor popular y a codearse con las más altas esferas sociales y políticas del país. Siempre sin olvidar a Jenny, su gran amor desde que era niño.",
					"Comedia, Drama, Romance", "/azV6hV99lYkdhydsQbJCI6FqMl4.jpg");
			m5.setActors(Arrays.asList(a6));
			em.persist(m5);
			
			Movie m6 = new Movie("Cadena perpetua", LocalDate.of(1995, 2, 24), "2h 23m",
					"Acusado del asesinato de su mujer, Andrew Dufresne, tras ser condenado a cadena perpetua, es enviado a la prisión de Shawshank. Con el paso de los años conseguirá ganarse la confianza del director del centro y el respeto de sus compañeros presidiarios, especialmente de Red, el jefe de la mafia de los sobornos.",
					"Drama, Crimen", "/dc1fX265fZIIY5Hab8I7CdETyJy.jpg");
			m6.setActors(Arrays.asList(a7, a8));
			em.persist(m6);
			
			Movie m7 = new Movie("En busca de la felicidad", LocalDate.of(2007, 2, 2), "1h 55m",
					"Chris Gardner es un vendedor brillante y con talento, pero su empleo no le permite cubrir sus necesidades más básicas. Tanto es así que acaban echándolo, junto a su hijo de cinco años, de su piso de San Francisco y no tienen ningún lugar al que ir. Cuando Gardner consigue hacer unas prácticas en una prestigiosa correduría de bolsa, los dos protagonistas tendrán que afrontar muchas adversidades parar hacer realidad su sueño de una vida mejor. Basada en hechos reales.",
					"Drama", "/qF6JFr6IdfNep0x6yw3i7S8avAb.jpg");
			m7.setActors(Arrays.asList(a3));
			em.persist(m7);
			
			Movie m8 = new Movie("El pianista", LocalDate.of(2002, 10, 25), "2h 30m",
					"Varsovia, 1939. El pianista polaco de origen judío Wladyslaw Szpilman (Adrien Brody) interpreta un tema de Chopin en la radio nacional de Polonia mientras la aviación alemana bombardea la capital. El régimen nazi ha invadido el país, y como hace en otros países invadidos, lleva a cabo la misma política con respecto a los judíos. Así Szpilman y toda su familia -sus padres, su hermano y sus dos hermanas- se ven obligados a dejar su casa y todo lo que les pertenece para trasladarse con miles de personas de origen judío al ghetto de Varsovia. Mientras Wladyslaw trabaja como pianista en un restaurante propiedad de un judío que colabora con los nazis, su hermano Henryk (Ed Stoppard) prefiere luchar contra los nazis. Pero tres años más tarde, los habitantes del ghetto son trasladados en trenes hacia campos de concentración.",
					"Drama, Bélica", "/mxfLOWnHnSlbdraKfzRn5mqoqk7.jpg");
			m8.setActors(Arrays.asList(a9));
			em.persist(m8);

			// Populate Series
			Serie s1 = new Serie("Vikingos", LocalDate.of(2013, 3, 3), "45m",
					"Sigue las aventuras de Ragnar Lothbrok, el héroe más grande de su época. La serie narra las sagas de la banda de hermanos vikingos de Ragnar y su familia, cuando él se levanta para convertirse en el rey de las tribus vikingas. Además de ser un guerrero valiente, Ragnar encarna las tradiciones nórdicas de la devoción a los dioses, la leyenda dice que él era un descendiente directo de Odín, el dios de la guerra y los guerreros.",
					6, "Action & Adventure, Drama, War & Politics", "Netflix, Prime Video, History", true,
					"/uNFSCxeZsZVIQ1TrD6mzu6uMQEb.jpg");
			s1.setActors(Arrays.asList(a1, a2));
			em.persist(s1);
			
			Serie s2 = new Serie("Breaking Bad", LocalDate.of(2008, 1, 20), "45m",
					"Tras cumplir 50 años, Walter White (Bryan Cranston), un profesor de química de un instituto de Albuquerque, Nuevo México, se entera de que tiene un cáncer de pulmón incurable. Casado con Skyler (Anna Gunn) y con un hijo discapacitado (RJ Mitte), la brutal noticia lo impulsa a dar un drástico cambio a su vida: decide, con la ayuda de un antiguo alumno (Aaron Paul), fabricar anfetaminas y ponerlas a la venta. Lo que pretende es liberar a su familia de problemas económicos cuando se produzca el fatal desenlace.",
					5, "Drama", "Netflix", true,"/ztkUQFLlC19CCMYHW9o1zWhJRNq.jpg");
			s2.setActors(Arrays.asList(a10, a11));
			em.persist(s2);
			
			Serie s3 = new Serie("Big Bang", LocalDate.of(2008, 1, 20), "22m",
					"Mientras los físicos Leonard y Sheldon completan su pandilla de frikis con Howard y Raj, la aspirante a actriz Penny ocupa el piso de enfrente.",
					12, "Comedia", "Amazon Prime Video", true,"/2bDQWCvFxRGhdvThTJvVxueEoLl.jpg");
			s3.setActors(Arrays.asList(a12));
			em.persist(s3);
			
			Serie s4 = new Serie("Vivir sin permiso", LocalDate.of(2018, 9, 24), "1h 20m",
					"La serie narra el declive de un líder poderoso, dominante y temido que ha controlado con mano de hierro durante años la comunidad en la que vive y el espectáculo cruel y despiadado que ofrecen sus familiares y allegados por hacerse con el control de su imperio. Pasiones, rivalidades e intereses enfrentados son los ejes en torno a los que se vertebra la serie.",
					2, "Crimen, Drama", "Netflix", true,"/58Z3KlTeOe1rHwa6x3xSRRVTIXk.jpg");
			s4.setActors(Arrays.asList(a13));
			em.persist(s4);
			
			Serie s5 = new Serie("El Príncipe", LocalDate.of(2014, 2, 4), "1h 15m",
					"La historia de \"El Príncipe\" se sitúa en la conflictiva barriada de El Príncipe Alonso, en Ceuta, lugar donde Fran (José Coronado) no duda en imponer el orden recurriendo a métodos poco ortodoxos, algo que parece peligrar con la llegada de Morey (Álex González), un agente que llega a la comisaría con la misión de investigar una supuesta colaboración de la policía con una red yihadista. Su situación se complicará con la llegada a su vida de Fátima (Hiba Abouk), una joven profesora musulmana que trata de encontrar a su hermano pequeño, desaparecido hace algún tiempo, y que se opone a las actividades delictivas de su otro hermano (Rubén Cortada).",
					2, "Crimen, Drama", "Movistar +", true,"/9edkwqws2gstULZDzDMBJEBulkA.jpg");
			s5.setActors(Arrays.asList(a13,a14,a15));
			em.persist(s5);
			
			Serie s6 = new Serie("Violetta", LocalDate.of(2012, 5, 14), "45m",
					"Violetta cuenta la historia de una adolescente con talento musical que regresa a su Buenos Aires natal con su padre, Herman, después de vivir en Europa durante varios años, navegando por las pruebas y tribulaciones de creciendo.",
					3, "Familia, Kids", "Disney +", true,"/b3MUGJeKakAZwQa7lNJxTP1pJmD.jpg");
			s6.setActors(Arrays.asList(a16));
			em.persist(s6);
			
			Serie s7 = new Serie("Rick y Morty", LocalDate.of(2012, 12, 2), "22m",
					"Comedia animada que narra las aventuras de un científico loco Rick Sánchez, que regresa después de 20 años para vivir con su hija, su marido y sus hijos Morty y Summer.",
					5, "Animación, Comedia, Sci-Fi & Fantasy, Action & Adventure", "Netflix", false,"/5Yiep9EwcQgLolg013ETBVqHxuD.jpg");
			em.persist(s7);
			
			Serie s8 = new Serie("El Chapulín Colorado", LocalDate.of(1973, 4, 11), "22m",
					"El Chapulín Colorado es una serie de televisión mexicana, parodia de los programas de superhéroes, creada por Chespirito. Fue transmitida en México por primera vez en 1970 como un segmento del programa \"Los Supergenios de la mesa cuadrada\" donde actuaba Chespirito y tres de los futuros miembros de la serie. Entre 1972 y 1979 paso a tener su propio programa, al igual que su producción hermana El Chavo del Ocho y tuvo un capítulo final donde se agradeció a los espectadores. Pero luego continuo como un segmento de la serie Chespirito hasta 1993. Su nombre se refiere a un chapulín (el nombre dado en México a una especie de saltamontes) de color rojo o colorado.\r\n" + 
					"\r\n" + 
					"No aparece en el programa ningún otro superhéroe de ficción, a excepción de Super Sam, parodia de Superman y el Tio Sam.",
					1, "Comedia, Familia, Crimen, Sci-Fi & Fantasy, Misterio", "Las Estrellas", true,"/qF8NDpVBSTDhdLlEjVAhNhfqB8K.jpg");
			s8.setActors(Arrays.asList(a17));
			em.persist(s8);

			// Populate Users
			em.persist(new User("usuario1", "usuario1", true, SecureRandom.getInstance("SHA1PRNG").nextLong()));
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (em.getTransaction().isActive())
				em.getTransaction().rollback();
			em.close();
		}
	}
}
