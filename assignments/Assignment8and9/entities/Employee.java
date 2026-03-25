package cg.example.Assignment8.entities;

import java.util.Set;

import org.hibernate.validator.constraints.Length;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty(message = "Employee name can't be empty")
    private String name;
    @Min(message="salary can't be less than 1000",value = 1000)
    private double salary;

    @ElementCollection
    private Set<@Length(min = 10, max = 10, message = "Mobile number must be exactly 10 digits") String> mobileNumbers;

    @ManyToOne
    @JoinColumn(name = "dept_id")
    private Department department;

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

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public Set<String> getMobileNumbers() {
		return mobileNumbers;
	}

	public void setMobileNumbers(Set<String> mobileNumbers) {
		this.mobileNumbers = mobileNumbers;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

    
}