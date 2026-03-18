package cg.demo.springcore3.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cg.demo.springcore3.Entities.Employee;
import cg.demo.springcore3.Repository.EmployeeRepo;
@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
    EmployeeRepo er;
    
	@Override
	public boolean addEmployee(Employee e) {
		return er.addEmployee(e);
	}

	@Override
	public List<Employee> viewAllEmp() {
		return er.viewAllEmp();
	}

	@Override
	public boolean updateSalary(int id, double salary) {
		return er.updateSalary(id, salary);
	}

	@Override
	public boolean deleteEmployee(int id) {
		return er.deleteEmployee(id);
	}

	@Override
	public Employee viewById(int id) {
		return er.viewById(id);
	}

}
