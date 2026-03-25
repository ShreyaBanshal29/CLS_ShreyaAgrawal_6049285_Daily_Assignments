package cg.example.Assignment8.Exception;

public class DepartmentNameNotFoundException extends RuntimeException{
	public DepartmentNameNotFoundException() {
		super("There is not department with such name!");
	}

}
