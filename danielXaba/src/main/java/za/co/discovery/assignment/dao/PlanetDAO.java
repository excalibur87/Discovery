package za.co.discovery.assignment.dao;

import java.util.List;

import org.hibernate.Session;
import za.co.discovery.assignment.bo.Planet;
import za.co.discovery.assignment.utils.HibernateUtils;

public class PlanetDAO {
	private Planet planet;
	private List<Planet> planetList;
	private Session session;

	public PlanetDAO() {
		
	}
	
	public Planet getPlanetById(int id) throws Exception {
		try {
			session = HibernateUtils.getSession();
			session.beginTransaction();
			planet = (Planet) session.get(Planet.class, id);
			return planet;
		} catch (Exception ex) {
			throw new Exception(ex);
		} finally {
			if (session.isOpen()) {
				session.flush();
				session.close();
			}
		}
	}
	
	public void addPlanet(Planet p) throws Exception {
		try {
			session = HibernateUtils.getSession();
			session.beginTransaction();
			session.save(p);
			session.getTransaction().commit();
		} catch (Exception ex) {
			session.getTransaction().rollback();
			throw new Exception(ex);
		} finally {
			if (session.isOpen()) {
				session.flush();
				session.close();
			}
		}
	}
	
	public void updatePlanet(Planet p) throws Exception {
		try {
			session = HibernateUtils.getSession();
			session.beginTransaction();
			session.update(p);
			session.getTransaction().commit();
		} catch (Exception ex) {
			session.getTransaction().rollback();
			throw new Exception(ex);
		} finally {
			if (session.isOpen()) {
				session.flush();
				session.close();
			}
		}
	}
	
	public void deletePlanet(Planet p) throws Exception {
		try {
			session = HibernateUtils.getSession();
			session.beginTransaction();
			session.delete(p);
			session.getTransaction().commit();
		} catch (Exception ex) {
			session.getTransaction().rollback();
			throw new Exception(ex);
		} finally {
			if (session.isOpen()) {
				session.flush();
				session.close();
			}
		}
	}
	
	public List<Planet> getPlanets() throws Exception {
		try {
			session = HibernateUtils.getSession();
			session.beginTransaction();
			planetList = session.createQuery(" from Planet").list();
			
			return planetList;
		} catch (Exception ex) {
			throw new Exception(ex);
		} finally {
			if (session.isOpen()) {
				session.flush();
				session.close();
			}
		}
	}
}
