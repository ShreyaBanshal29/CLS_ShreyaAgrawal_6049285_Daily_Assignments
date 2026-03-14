package cg.demo.jpahibernate.entities;

import java.util.Set;
import jakarta.persistence.*;

@Entity
@Table(name="employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private int salary;
    private String department;

    @ElementCollection
    @CollectionTable(name="employee_mobiles",
            joinColumns=@JoinColumn(name="emp_id"))
    @Column(name="mobile_no")
    private Set<String> mobileNumbers;

    // getters setters

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getSalary() { return salary; }
    public void setSalary(int salary) { this.salary = salary; }

    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }

    public Set<String> getMobileNumbers() { return mobileNumbers; }
    public void setMobileNumbers(Set<String> mobileNumbers) { this.mobileNumbers = mobileNumbers; }

    @Override
    public String toString() {
        return "Employee [id=" + id + ", name=" + name +
                ", salary=" + salary +
                ", department=" + department +
                ", mobiles=" + mobileNumbers + "]";
    }
}