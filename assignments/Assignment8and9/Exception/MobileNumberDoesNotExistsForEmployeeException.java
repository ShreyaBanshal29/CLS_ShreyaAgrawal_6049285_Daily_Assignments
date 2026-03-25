package cg.example.Assignment8.Exception;

public class MobileNumberDoesNotExistsForEmployeeException extends RuntimeException {
  public MobileNumberDoesNotExistsForEmployeeException() {
	  super("there is no employee with such mobile number!");
  }
}
