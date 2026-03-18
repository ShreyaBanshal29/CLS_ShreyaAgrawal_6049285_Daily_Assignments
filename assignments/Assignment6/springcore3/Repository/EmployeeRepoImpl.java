package cg.demo.springcore3.Repository;

import java.util.*;
import java.util.List;

import org.springframework.stereotype.Repository;

import cg.demo.springcore3.Entities.Employee;
@Repository
public class EmployeeRepoImpl implements EmployeeRepo {
	
	private Map<Integer, Employee> emp = new HashMap<>();

	@Override
	public boolean addEmployee(Employee e) {
		int id = e.getEid();

        if (emp.containsKey(id)) {
            return false;
        }

        emp.put(id, e);
		return true;
	}

	@Override
	public List<Employee> viewAllEmp() {
	    List<Employee> list = new ArrayList<>();
	    for (Employee e : emp.values()) {
	    	list.add(e);
	    }
		return list;
	}

	@Override
	public boolean updateSalary(int id, double salary) {

	        if (!emp.containsKey(id)) {
	            return false;
	        }
            Employee e = emp.get(id);
            emp.remove(id);
            e.setSalary(salary);
	        emp.put(id, e);
	       return true;
	}

	@Override
	public boolean deleteEmployee(int id) {
		  if (!emp.containsKey(id)) {
	            return false;
	        }

	        emp.remove(id);
	        return true;
	}

	@Override
	public Employee viewById(int id) {
		 if (!emp.containsKey(id)) {
        return null;
    }

    Employee e = emp.get(id);
		return e;
	}

}
