package cg.demo.associationmapping.assignment;

import java.util.List;

import jakarta.persistence.*;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.*;

/**
 * Hello world!
 *
 */
public class daoApp
{
    
    	EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA-PU");
   	 	EntityManager em = emf.createEntityManager();
   	 	

   	 	//1. Insert Employees
   	 	public Employee1 InsertEmployee(Employee1 e) {
   	 		em.getTransaction().begin();
   	 		em.persist(e);
   	 		em.getTransaction().commit();
   	 		return e;
   	 	}

   	 	
   	 	//2. Find department by name
   	 	public Department1 findDeptByName(String name) {
//   	 		TypedQuery <Department1> toquery = em.createQuery("Select d from Department d where d.name=:name ", Department1.class);
//   	 		tquery.setParameter("name", name);
//	   	 	List<Department1> list = tquery.getResultList();
   	 	CriteriaBuilder cb= em.getCriteriaBuilder();
 		CriteriaQuery <Department1> cq= cb.createQuery(Department1.class);
 		Root<Department1> root = cq.from(Department1.class);
 		Predicate salaryPredicate = cb.equal(root.get("name"), name);
 		cq.select(root).where(salaryPredicate);

 		List<Department1> list = em.createQuery(cq).getResultList();
	
	   	    if(list.isEmpty()) {
	   	        return null;
	   	    }
	
	   	    return list.get(0);
   	 				
   	 	}
   	 	
   	 	// find all employees and with department details
   	 	public List<Employee1> viewAllWithDept(){
//   	 		TypedQuery <Employee1> tq= em.createQuery("select e  from Employee e JOIN e.dept d ", Employee1.class);
   	 	CriteriaBuilder cb= em.getCriteriaBuilder();
	 		CriteriaQuery <Employee1> cq= cb.createQuery(Employee1.class);
	 		Root<Employee1> root = cq.from(Employee1.class);
	 		
	 		cq.select(root);
	 		TypedQuery <Employee1> tq= em.createQuery(cq);
   	 		List<Employee1> list =tq.getResultList();
   	 		return list;
   	 		
   	 	}
   	 	
   	 	//3. number of employees working in each department
	   	 public List<Object[]> employeesInEachDepartment() {
	
//	   	    TypedQuery<Object[]> tq = em.createQuery(
//	   	        "SELECT d.name, COUNT(e) FROM Employee e JOIN e.dept d GROUP BY d.name" , Object[].class);
	   		CriteriaBuilder cb= em.getCriteriaBuilder();
	 		CriteriaQuery <Object[]> cq= cb.createQuery(Object[].class);
	 		Root<Employee1> root = cq.from(Employee1.class);
	 		Join<Employee1, Department1> dept = root.join("dept");
	 		cq.multiselect(dept.get("name"),cb.count(root)).groupBy(dept.get("name"));
	 		TypedQuery <Object[]> tq= em.createQuery(cq);
   	 		List<Object[]> list = tq.getResultList();
   	 		return list;
   	 		}
	   	 
	   	public List<Employee1> findEmployeesByDepartment(String deptName){

//	   	    TypedQuery<Employee1> tq = em.createQuery(
//	   	        "SELECT e FROM Employee e JOIN e.dept d WHERE d.name = :deptName",
//	   	        Employee.class
//	   	    );

	   	 CriteriaBuilder cb = em.getCriteriaBuilder();

	   	    CriteriaQuery<Employee1> cq = cb.createQuery(Employee1.class);

	   	    Root<Employee1> root = cq.from(Employee1.class);

	   	    Join<Employee1, Department1> deptJoin = root.join("dept");

	   	    cq.select(root)
	   	      .where(cb.equal(deptJoin.get("name"), deptName));

	   	    TypedQuery<Employee1> tq = em.createQuery(cq);

	   	    return tq.getResultList();
	   	}
	   	 
	   	//5. find employee by mobile
	   	public List<Object[]> findEmployeeByMobile(Long mobile){

//	   		TypedQuery<Object[]> tq = em.createQuery(
//	   			    "SELECT e.Eid, e.name, d.name, d.managername FROM Employee e JOIN e.dept d JOIN e.phone p WHERE p = :mobile",Object[].class);
//	   	 
	   		CriteriaBuilder cb = em.getCriteriaBuilder();

 		    CriteriaQuery<Object[]> cq = cb.createQuery(Object[].class);

 		    Root<Employee1> root = cq.from(Employee1.class);

 		    Join<Employee1, Department1> deptJoin = root.join("dept");

 		    Join<Employee1, Long> phoneJoin = root.join("phone");

 		    cq.multiselect(
 		            root.get("Eid"),
 		            root.get("name"),
 		            deptJoin.get("name"),
 		            deptJoin.get("managername")
 		    );

 		    cq.where(cb.equal(phoneJoin, mobile));

 		    TypedQuery<Object[]> tq = em.createQuery(cq);

 		    return tq.getResultList();
	   	}
	   	
	   	public List<Employee1> findEmployeeHavingGreaterSalary(int salary){
	   		CriteriaBuilder cb = em.getCriteriaBuilder();
	   		CriteriaQuery cq = cb.createQuery(Employee1.class);
	   		Root<Employee1> root = cq.from(Employee1.class);
	   		Predicate salaryPredicate = cb.gt(root.get("salary"), salary);
	   		cq.select(root).where(salaryPredicate);
	   		TypedQuery <Employee1> tq= em.createQuery(cq);
   	 		List<Employee1> list =tq.getResultList();
   	 		return list;
	   	}
   	 	
   	 	
    }

