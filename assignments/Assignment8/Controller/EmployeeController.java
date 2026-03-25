package cg.example.Assignment8.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cg.example.Assignment8.Service.EmployeeService;
import cg.example.Assignment8.dto.DeptCountDTO;
import cg.example.Assignment8.entities.Employee;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    // 1. Insert Employee
    @PostMapping("/employees")
    public Employee addEmployee(@Valid @RequestBody Employee emp) {
        return service.saveEmployee(emp);
    }

    // 2. Fetch all employees with department details
    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return service.getAllEmployees();
    }

    // 3. Count employees in each department
    @GetMapping("/departments/count")
    public List<DeptCountDTO> getEmployeeCount() {
        return service.getEmployeeCountByDept();
    }

    // 4. Employees by department name
    @GetMapping("/employees/department/{name}")
    public List<Employee> getByDept(@PathVariable String name) {
        return service.getEmployeesByDept(name);
    }

    // 5. Employee details by mobile number
    @GetMapping("/employees/mobile/{mobile}")
    public List<Employee> getByMobile(@PathVariable String mobile) {
        return service.getEmployeeByMobile(mobile);
    }
}