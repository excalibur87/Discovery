package za.co.discovery.assignment.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {

	public static Session getSession() throws Exception {
		try {
            Configuration config = new Configuration();
            SessionFactory sessionFactory = config.configure("hibernate.cfg.xml").buildSessionFactory();
            return sessionFactory.openSession();
        } catch (Throwable e) {
            System.err.println("Error in creating SessionFactory object."
                    + e.getMessage());
            throw new ExceptionInInitializerError(e);
        }
	}

}
