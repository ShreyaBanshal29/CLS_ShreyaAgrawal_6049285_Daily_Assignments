package cg.demo.jpahibernate;

import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import cg.demo.jpahibernate.entities.Employee;

public class App {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        EmpDAO dao = new EmpDAO();

        int choice;

        do {

            System.out.println("\n------ Employee Management ------");
            System.out.println("1. Insert Employee");
            System.out.println("2. View Employees");
            System.out.println("3. View Employee by ID");
            System.out.println("4. Update Salary");
            System.out.println("5. Delete Employee");
            System.out.println("6. Total Employees in Each Department");
            System.out.println("7. Employees with Same Salary");
            System.out.println("8. Search Employee by Mobile Number");
            System.out.println("9. Exit");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch(choice) {

            case 1:

                Employee emp = new Employee();

                sc.nextLine();

                System.out.print("Enter Name: ");
                emp.setName(sc.nextLine());

                System.out.print("Enter Salary: ");
                emp.setSalary(sc.nextInt());
                sc.nextLine();

                System.out.print("Enter Department: ");
                emp.setDepartment(sc.nextLine());

                System.out.print("Enter number of mobile numbers: ");
                int n = sc.nextInt();

                Set<String> mobiles = new HashSet<>();

                for(int i=0;i<n;i++) {
                    System.out.print("Enter mobile number: ");
                    mobiles.add(sc.next());
                }

                emp.setMobileNumbers(mobiles);

                Employee insertedEmp = dao.insertEmployee(emp);

                System.out.println("Inserted Employee:");
                System.out.println(insertedEmp);

                break;

            case 2:

                List<Employee> employees = dao.viewEmployees();

                for(Employee e : employees) {
                    System.out.println(e);
                }

                break;

            case 3:

                System.out.print("Enter Employee ID: ");
                int id = sc.nextInt();

                Employee emp1 = dao.viewEmployeeById(id);

                if(emp1 != null)
                    System.out.println(emp1);
                else
                    System.out.println("Employee not found");

                break;

            case 4:

                System.out.print("Enter Employee ID: ");
                int id1 = sc.nextInt();

                System.out.print("Enter New Salary: ");
                int salary = sc.nextInt();

                Employee updatedEmp = dao.updateSalary(id1, salary);

                if(updatedEmp != null)
                    System.out.println(updatedEmp);
                else
                    System.out.println("Employee not found");

                break;

            case 5:

                System.out.print("Enter Employee ID: ");
                int deleteId = sc.nextInt();

                Employee deletedEmp = dao.deleteEmployee(deleteId);

                if(deletedEmp != null)
                    System.out.println("Deleted: " + deletedEmp);
                else
                    System.out.println("Employee not found");

                break;

            case 6:

                List<Object[]> deptCount = dao.countEmployeesByDept();

                for(Object[] row : deptCount) {
                    System.out.println("Department: " + row[0] +
                            " | Employees: " + row[1]);
                }

                break;

            case 7:

                List<Employee> sameSalary = dao.employeesWithSameSalary();

                if(sameSalary.isEmpty())
                    System.out.println("No employees with same salary");
                else
                    sameSalary.forEach(System.out::println);

                break;

            case 8:

                System.out.print("Enter Mobile Number: ");
                String mobile = sc.next();

                Employee empMobile = dao.findEmployeeByMobile(mobile);

                if(empMobile != null)
                    System.out.println(empMobile);
                else
                    System.out.println("Employee not found");

                break;

            }

        } while(choice != 9);

        System.out.println("Program Ended");

        sc.close();
    }
}