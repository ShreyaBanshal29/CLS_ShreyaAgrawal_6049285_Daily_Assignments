package cg.example.Assignment8.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;

@Entity
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty(message = "Department name can't be empty")
    private String name;
    @NotEmpty(message = "manager name can't be empty")
    private String managerName;

    @JsonIgnore
    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
    private List<Employee> employees;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getManagerName() {
		return managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	@Override
	public String toString() {
		return "Department [id=" + id + ", name=" + name + ", managerName=" + managerName + "]";
	}


}