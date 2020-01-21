package za.co.discovery.assignment.bo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement (name="Planet")
@Entity
public class Planet {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int Id;
	
	@Column(name = "Planet_Node")
	private String pNode;
	
	@Column(name = "Planet_Name")
	private String pName;
	
	public Planet() {
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getpNode() {
		return pNode;
	}
	public void setpNode(String pNode) {
		this.pNode = pNode;
	}
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	
	
}
