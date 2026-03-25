package cg.example.Assignment8.dto;

public class DeptCountDTO {

    private String departmentName;
    private Long employeeCount;

    public DeptCountDTO(String departmentName, Long employeeCount) {
        this.departmentName = departmentName;
        this.employeeCount = employeeCount;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public Long getEmployeeCount() {
        return employeeCount;
    }
}