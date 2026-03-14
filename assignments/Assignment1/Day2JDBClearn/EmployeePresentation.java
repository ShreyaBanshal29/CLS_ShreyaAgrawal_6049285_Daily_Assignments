package Day2JDBClearn;

import java.util.Scanner;

import java.util.List;



public class EmployeePresentation {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        employeeDAO dao = new employeeDAO();

        int choice;

        do {
        	
        	System.out.println("\n0.Create Table");
            System.out.println("1. Insert Employee");
            System.out.println("2. View Employees");
            System.out.println("3. View by id");
            System.out.println("4. Update Salary");
            System.out.println("5. Delete Employee");
            System.out.println("6. Exit");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch(choice) {
            	
            	case 0:
            	    try {
            	        dao.createTable();
            	        System.out.println("Employee table created successfully.");
            	    } 
            	    catch (Exception e) {
            	        System.err.println("Table already exists.");
            	    }
            	    break;

                case 1:
                	Employee emp = new Employee();

                    System.out.print("Enter ID: ");
                    emp.setId(sc.nextInt());
                    sc.nextLine();

                    System.out.print("Enter Name: ");
                    emp.setName(sc.nextLine());

                    System.out.print("Enter Salary: ");
                    emp.setSalary(sc.nextInt());
                    sc.nextLine();

                    System.out.print("Enter Department: ");
                    emp.setDepartment(sc.nextLine());

                    System.out.print("Enter Phone: ");
                    emp.setPhone(sc.nextLong());
                   
                	Employee insertedEmp = dao.insertEmployee(emp);

                	System.out.println("Inserted Employee:");
                	System.out.println(insertedEmp.getId()+" "+
                	                   insertedEmp.getName()+" "+
                	                   insertedEmp.getSalary()+" "+
                	                   insertedEmp.getDepartment()+" "+
                	                   insertedEmp.getPhone());
                    break;


                case 2:
                	List<Employee> employees = dao.viewEmployees();

                	for(Employee e : employees) {
                	    System.out.println(e.getId()+" "+e.getName()+" "+e.getSalary()+" "+e.getDepartment()+" "+e.getPhone());
                	}
                	break;
                    
                case 3:
                	System.out.print("Enter Employee ID: ");
                	int id = sc.nextInt();

                	Employee emp1 = dao.viewEmployeeById(id);

                	if(emp1 != null) {
                	    System.out.println(emp1.getId()+" "+emp1.getName()+" "+emp1.getSalary()+" "+emp1.getDepartment()+" "+emp1.getPhone());
                	}
                	else {
                	    System.err.println("Employee not found");
                	}
                	break;

                case 4:

                    System.out.print("Enter Employee ID: ");
                    int id1 = sc.nextInt();

                    System.out.print("Enter New Salary: ");
                    int salary = sc.nextInt();

                    Employee e = new Employee();
                    e.setSalary(salary);

                    Employee updatedEmp = dao.updateEmployee(id1, e);

                    if(updatedEmp != null) {
                        System.out.println("Updated Employee:");
                        System.out.println(
                            updatedEmp.getId() + " " +
                            updatedEmp.getName() + " " +
                            updatedEmp.getSalary() + " " +
                            updatedEmp.getDepartment() + " " +
                            updatedEmp.getPhone()
                        );
                    }
                    else {
                        System.err.println("Employee not found");
                    }

                    break;

                case 5:

                	System.out.print("Enter Employee ID: ");
                	int deleteId = sc.nextInt();

                	Employee deletedEmp = dao.deleteEmployee(deleteId);

                	if(deletedEmp != null) {
                	    System.out.println("Deleted Employee:");
                	    System.out.println(deletedEmp.getId()+" "+
                	                       deletedEmp.getName()+" "+
                	                       deletedEmp.getSalary()+" "+
                	                       deletedEmp.getDepartment()+" "+
                	                       deletedEmp.getPhone());
                	}
                	else {
                	    System.err.println("Employee not found");
                	}
                    break;

            }

        } while(choice != 7);

        System.out.println("Program Ended.");
 sc.close();
 
    }
}