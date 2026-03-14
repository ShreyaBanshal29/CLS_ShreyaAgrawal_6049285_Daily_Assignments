package cg.demo.jpahibernate;

import java.util.List;

import cg.demo.jpahibernate.entities.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EmpDAO {

    EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("JPA-PU");

    EntityManager em = emf.createEntityManager();

    // Insert Employee
    Employee insertEmployee(Employee e) {

        em.getTransaction().begin();
        em.persist(e);
        em.getTransaction().commit();

        return e;
    }

    // View All Employees
    List<Employee> viewEmployees(){

        return em.createQuery(
                "SELECT e FROM Employee e",
                Employee.class
        ).getResultList();
    }

    // View Employee By ID
    Employee viewEmployeeById(int id) {

        return em.find(Employee.class, id);
    }

    // Update Salary
    Employee updateSalary(int id, int salary) {

        em.getTransaction().begin();

        Employee e = em.find(Employee.class, id);

        if(e != null) {
            e.setSalary(salary);
            em.merge(e);
        }

        em.getTransaction().commit();

        return e;
    }

    // Delete Employee
    Employee deleteEmployee(int id) {

        em.getTransaction().begin();

        Employee e = em.find(Employee.class, id);

        if(e != null)
            em.remove(e);

        em.getTransaction().commit();

        return e;
    }

    // Total Employees in Each Department
    List<Object[]> countEmployeesByDept(){

        return em.createQuery(
                "SELECT e.department, COUNT(e) FROM Employee e GROUP BY e.department",
                Object[].class
        ).getResultList();
    }

    // Employees with Same Salary
    List<Employee> employeesWithSameSalary(){

        return em.createQuery(
                "SELECT e FROM Employee e WHERE e.salary IN " +
                        "(SELECT e2.salary FROM Employee e2 GROUP BY e2.salary HAVING COUNT(e2) > 1)",
                Employee.class
        ).getResultList();
    }

    // Find Employee By Mobile Number
    Employee findEmployeeByMobile(String mobile){

        try {

            return em.createQuery(
                    "SELECT e FROM Employee e JOIN e.mobileNumbers m WHERE m = :mob",
                    Employee.class)
                    .setParameter("mob", mobile)
                    .getSingleResult();

        } catch(Exception e) {

            return null;
        }
    }
}