package za.co.discovery.assignment.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import za.co.discovery.assignment.bo.Route;
import za.co.discovery.assignment.utils.HibernateUtils;

public class RouteDAO {
	private Route route;
	private List<Route> routeList;
	private Session session;

	public void addRoute(Route r) throws Exception {
		try {
			session = HibernateUtils.getSession();
			session.beginTransaction();
			session.save(r);
			session.getTransaction().commit();
		} catch (Exception ex) {
			session.getTransaction().rollback();
			throw new Exception(ex);
		} finally {
			if (session.isOpen()) {
				session.close();
			}
		}
	}
	
	public void updateRoute(Route r) throws Exception {
		try {
			session = HibernateUtils.getSession();
			session.beginTransaction();
			session.update(r);
			session.getTransaction().commit();
		} catch (Exception ex) {
			session.getTransaction().rollback();
			throw new Exception(ex);
		} finally {
			if (session.isOpen()) {
				session.close();
			}
		}
	}
	
	public Route getRouteById(int id) throws Exception {
		try {
			session = HibernateUtils.getSession();
			session.beginTransaction();
			route = (Route) session.get(Route.class, id);
			return route;
		} catch (Exception ex) {
			throw new Exception(ex);
		} finally {
			if (session.isOpen()) {
				session.close();
			}
		}
	}
	
	//Method to get linked routes from any node
	public List<Route> getRouteByNode(String id) throws Exception {
		try {
			session = HibernateUtils.getSession();
			session.beginTransaction();
			Query q = session.createQuery(" from Route where origin = :origin ");
			q.setString(0, id);
			routeList = q.list();
			return routeList;
		} catch (Exception ex) {
			throw new Exception(ex);
		} finally {
			if (session.isOpen()) {
				session.close();
			}
		}
	}
	
	public void deleteRoute(Route r) throws Exception {
		try {
			session = HibernateUtils.getSession();
			session.beginTransaction();
			session.delete(r);
			session.getTransaction().commit();
		} catch (Exception ex) {
			session.getTransaction().rollback();
			throw new Exception(ex);
		} finally {
			if (session.isOpen()) {
				session.close();
			}
		}
	}
	
	public List<Route> getRoutes() throws Exception {
		try {
			session = HibernateUtils.getSession();
			session.beginTransaction();
			routeList = session.createQuery(" from Route").list();
			
			return routeList;
		} catch (Exception ex) {
			throw new Exception(ex);
		} finally {
			if (session.isOpen()) {
				session.close();
			}
		}
	}
}
