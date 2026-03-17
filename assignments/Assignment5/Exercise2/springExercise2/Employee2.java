package cg.demo.springExercise2;

public class Employee2 {
	private int employeeId;
	private String employeeName;
	private double salary;
	private int age;
	private SBU2 businessUnit;
	
	
	
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	public SBU2 getBusinessUnit() {
		return businessUnit;
	}
	public void setBusinessUnit(SBU2 businessUnit) {
		this.businessUnit = businessUnit;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", employeeName=" + employeeName + ", salary=" + salary + ", age="
				+ age + ", businessUnit=" + businessUnit + "]";
	}
	
	
	
	
	
	

}
