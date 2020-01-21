package za.co.discovery.assignment.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import za.co.discovery.assignment.bo.Planet;

@WebServlet("/route")
public class BaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public BaseServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nextJSP = "/route.jsp";
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//get destination id
		int destination = Integer.parseInt(request.getParameter("sel_planet"));
		
		//Implement route calculation or call function 
		
		List<Planet> path = new ArrayList<Planet>();
		Planet test = new Planet();
		test.setId(1);
		test.setpName("hello");
		
		path.add(test);
		//set route attribute
		request.setAttribute("origin", "Earth");
		request.setAttribute("destination", getDestinationPlanet(destination));
		request.setAttribute("path", path);

		doGet(request, response);
	}

	//method to get the destination planet
	private String getDestinationPlanet(int id) {
	
		try {
			String dest  = "";
			Client client = ClientBuilder.newClient();
			
			Planet p =  client.target("http://localhost:8080/danielXaba/services/planet/")
	          .path(String.valueOf(id) + "/get")
	          .request(MediaType.APPLICATION_XML)
	          .get(Planet.class);
		
			dest = p.getpName();
			return dest;
		}catch(Exception n) {
			n.printStackTrace();
			return "Error getting destination details";
		}
	}
	
   
}
