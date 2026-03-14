package cg.demo.associationmapping.assignment;


import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Department1 {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Did;
	
	private String name;
	
	private String managername;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy= "dept")
	private List<Employee1> emp;

	public List<Employee1> getEmp() {
		return emp;
	}

	public void setEmp(List<Employee1> emp) {
	    this.emp = emp;
	}

	public int getDid() {
		return Did;
	}

	public void setDid(int did) {
		Did = did;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getManagername() {
		return managername;
	}

	public void setManagername(String managername) {
		this.managername = managername;
	}
	
	

}
