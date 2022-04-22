package cbd.util;
 
import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
 
public class WikifilmListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent e) {
		Map<String, String> properties = new HashMap<String, String>();
		  properties.put("javax.persistence.jdbc.user", "admin");
		  properties.put("javax.persistence.jdbc.password", "admin");
		  
        EntityManagerFactory emf =
        		Persistence.createEntityManagerFactory("objectdb://localhost:6136/data-cbd.odb", properties);
        e.getServletContext().setAttribute("emf", emf);
    }
 
    @Override
    public void contextDestroyed(ServletContextEvent e) {
        EntityManagerFactory emf =
            (EntityManagerFactory)e.getServletContext().getAttribute("emf");
        emf.close();
    }
}