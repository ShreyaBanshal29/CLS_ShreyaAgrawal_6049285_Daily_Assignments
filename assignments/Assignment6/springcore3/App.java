package cg.demo.springcore3;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import cg.demo.springcore3.Entities.Employee;
import cg.demo.springcore3.Service.EmployeeService;
import cg.demo.springcore3.Service.EmployeeServiceImpl;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        System.out.println("App Started!");
        ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConf.class);
        EmployeeService es = ac.getBean(EmployeeServiceImpl.class);
        Scanner sc = new Scanner(System.in);

        int choice;

        do {

            System.out.println("\n===== EMPLOYEE MANAGEMENT =====");
            System.out.println("1. Add Employee");
            System.out.println("2. View Employee by ID");
            System.out.println("3. View All Employees");
            System.out.println("4. Update Employee salary");
            System.out.println("5. Delete Employee");
            System.out.println("6. Exit");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {

            case 1:

                Employee e = ac.getBean(Employee.class);

                System.out.print("Enter ID: ");
                e.setEid(sc.nextInt());

                System.out.print("Enter Name: ");
                e.setName(sc.next());

                System.out.print("Enter Salary: ");
                e.setSalary(sc.nextDouble());

                boolean b = es.addEmployee(e);
                if (!b) {
                    System.out.println("Employee with ID " + e.getEid() + " already exists!");
                }

                System.out.println("Employee added successfully!");
                break;

            case 2:

                System.out.print("Enter Employee ID: ");
                int id = sc.nextInt();

                Employee e1 =  es.viewById(id);
                System.out.println(e1); 
                break;

            case 3:

                List<Employee> l = es.viewAllEmp();
                for (Employee e2 : l) {
                	System.out.println(e2); 
                }
                break;

            case 4:

                System.out.print("Enter ID to update: ");
                int id1 = sc.nextInt();

                System.out.print("Enter New Salary: ");
                Double salary = sc.nextDouble();

                
                boolean b1 = es.updateSalary(id1,salary);
                if (!b1) {
                    System.out.println("Employee with ID " + id1 + " does not exist!");
                }

                System.out.println("Salary successfully!");
                break;

            case 5:

                System.out.print("Enter Employee ID to delete: ");
                int deleteId = sc.nextInt();

               boolean b2 =  es.deleteEmployee(deleteId);
                if (b2) {
                    System.out.println("Employee with ID " + deleteId + " does not exist!");
                    return;
                }

                System.out.println("Employee deleted successfully!");
               
                break;

            case 6:

                System.out.println("Exiting application...");
                break;

            default:

                System.out.println("Invalid choice!");
            }

        } while (choice != 6);

        sc.close();
        
    }
}
