package cg.demo.springcore3.Repository;

import java.util.List;
import cg.demo.springcore3.Entities.Employee;

public interface EmployeeRepo {
  public abstract boolean addEmployee(Employee e);
  public abstract List<Employee> viewAllEmp();
  public abstract boolean updateSalary(int id , double salary);
  public abstract boolean deleteEmployee(int id);
  public abstract Employee viewById(int id);
}
