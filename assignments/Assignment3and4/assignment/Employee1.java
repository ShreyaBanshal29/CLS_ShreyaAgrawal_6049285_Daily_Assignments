package cg.demo.associationmapping.assignment;


import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Employee1 {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Eid;
	
	private String name;
	
	private int sal;
	
	@ElementCollection
    private Set<Long> phone;
	
	public Set<Long> getPhone() {
		return phone;
	}

	@Override
	public String toString() {
		return "Employee [Eid=" + Eid + ", name=" + name + ", sal=" + sal + ", phone=" + phone + ", dept=" + dept + "]";
	}

	public void setPhone(Set<Long> phone) {
		this.phone = phone;
	}

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Department1 dept;
	
	public Department1 getDept() {
		return dept;
	}

	public void setDept(Department1 dept) {
		this.dept = dept;
	}

	public int getEid() {
		return Eid;
	}

	public void setEid(int eid) {
		Eid = eid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSal() {
		return sal;
	}

	public void setSal(int sal) {
		this.sal = sal;
	}
	
	

}