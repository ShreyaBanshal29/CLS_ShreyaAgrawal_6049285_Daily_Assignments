package cg.example.Assignment8.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cg.example.Assignment8.Exception.DepartmentNameNotFoundException;
import cg.example.Assignment8.Exception.MobileNumberDoesNotExistsForEmployeeException;
import cg.example.Assignment8.Repo.DepartmentRepository;
import cg.example.Assignment8.Repo.EmployeeRepository;
import cg.example.Assignment8.dto.DeptCountDTO;
import cg.example.Assignment8.entities.Department;
import cg.example.Assignment8.entities.Employee;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository empRepo;
    @Autowired
    private DepartmentRepository deptRepo;
   

    // 1. Insert Employee
    public Employee saveEmployee(Employee emp) {

        if(emp.getDepartment() == null) {
            throw new RuntimeException("Department is required");
        }

        Department dept;

        if(emp.getDepartment().getId() != null) {

            dept = deptRepo.findById(emp.getDepartment().getId())
                    .orElseGet(() -> {
                        // ✅ Create new department if ID not found
                        Department newDept = new Department();
                        newDept.setName(emp.getDepartment().getName());
                        newDept.setManagerName(emp.getDepartment().getManagerName());
                        return deptRepo.save(newDept);
                    });

        } else {
            // ✅ No ID → create new department
            dept = deptRepo.save(emp.getDepartment());
        }

        emp.setDepartment(dept);

        return empRepo.save(emp);
    }

    // 2. Fetch all employees with department
    public List<Employee> getAllEmployees() {
        return empRepo.findAllWithDepartment();
    }

    // 3. Count employees per department
    public List<DeptCountDTO> getEmployeeCountByDept() {
        return deptRepo.countEmployeesByDepartment();
    }

    // 4. Employees by department name
    public List<Employee> getEmployeesByDept(String deptName) {
    	List<Employee> e = empRepo.findByDepartmentName(deptName);
    	if(e.size()!=0) return e;
    	else throw new DepartmentNameNotFoundException();
    }

    // 5. Employee + department by mobile
    public List<Employee> getEmployeeByMobile(String mobile) {
    	List<Employee> e = empRepo.findByMobileNumber(mobile);
        if(e.size()!=0) return e;
    	else throw new MobileNumberDoesNotExistsForEmployeeException();
                  
    }
}