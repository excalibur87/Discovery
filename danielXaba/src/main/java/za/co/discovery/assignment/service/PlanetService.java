package za.co.discovery.assignment.service;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.xml.ws.Response;

import za.co.discovery.assignment.bo.Planet;
import za.co.discovery.assignment.dao.PlanetDAO;
import za.co.discovery.assignment.utils.DataLoader;

@Path("/planet")
public class PlanetService {
	private final PlanetDAO pDao = new PlanetDAO();
	
	@GET
	@Path("/all")
	@Produces(MediaType.APPLICATION_XML)
	public List<Planet> getPlanets(){
		try {
			DataLoader.loadData();
			return pDao.getPlanets();
		}catch(Exception b) {
			
		}
		return null;
	}
	
	@POST
	@Path("/add")
	@Consumes(MediaType.APPLICATION_XML)
	public String addPerson( Planet p) {

		try {
			if (pDao.getPlanetById(p.getId()) != null) {
				return "Person Already Exists";
			}
			pDao.addPlanet(p);
		} catch (Exception e) {
		}

		return "Person created successfully";
	}

	@POST
	@Path("/{id}/delete")
	@Consumes(MediaType.APPLICATION_XML)
	public String deletePlanet(@PathParam("id") int id) {
		Planet p;
		try {
			p = pDao.getPlanetById(id);
			if (p == null) {
				return "Planet Doesn't Exists";
			}
			pDao.deletePlanet(p);

		} catch (Exception e1) {
		}

		return "Person deleted successfully";
	}

	@GET
	@Path("/{id}/get")
	@Produces(MediaType.APPLICATION_XML)
	public Planet getPlanet(@PathParam("id") int id) {
		try {
			return pDao.getPlanetById(id);
		} catch (Exception e) {
			return null;
		}
	}
}
