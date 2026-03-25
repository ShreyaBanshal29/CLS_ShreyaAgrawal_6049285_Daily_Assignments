package cg.example.Assignment8.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import cg.example.Assignment8.dto.DeptCountDTO;
import cg.example.Assignment8.entities.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

	@Query("SELECT new cg.example.Assignment8.dto.DeptCountDTO(d.name, COUNT(e)) " +
		       "FROM Department d LEFT JOIN d.employees e GROUP BY d.name")
		List<DeptCountDTO> countEmployeesByDepartment();
}
