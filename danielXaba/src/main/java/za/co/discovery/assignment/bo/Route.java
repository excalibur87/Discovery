package za.co.discovery.assignment.bo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement (name="Route")
@Entity
public class Route {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int Id;
	
	@Column(name = "Origin")
	private String origin;
	
	@Column(name = "Destination")
	private String destination;
	
	@Column(name = "Distance")
	private double distance;
	
	@Column(name = "Traffic")
	private double traffic;
	
	public Route() {
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public double getDistance() {
		return distance;
	}
	public void setDistance(double distance) {
		this.distance = distance;
	}
	public double getTraffic() {
		return traffic;
	}
	public void setTraffic(double traffic) {
		this.traffic = traffic;
	}
	
}
