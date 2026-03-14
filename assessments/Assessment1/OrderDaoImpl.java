package cg.demo.Assessment1;

import java.util.ArrayList;
import java.util.List;

import cg.demo.Assessment1.entities.abes_customer;
import cg.demo.Assessment1.entities.abes_order;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class OrderDaoImpl implements Order{
	EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("JPA-PU");
	EntityManager em = emf.createEntityManager();

	public boolean addOrder(abes_order o, int id) {

	    em.getTransaction().begin();

	    abes_customer c = em.find(abes_customer.class, id);

	    if (c == null) {
	        em.getTransaction().rollback();
	        return false;
	    }

	    o.setCust(c);
	    em.persist(o);

	    em.getTransaction().commit();

	    return true;
	}
	
	public abes_order viewOrderByOrderID(int id) {
		em.getTransaction().begin();
		abes_order o = em.find(abes_order.class,id);
		em.getTransaction().commit();
		return o;
	}
	
	public List<abes_order> viewOrdersByCustName(String name){

	    List<abes_order> list = em.createQuery(
	        "SELECT o FROM abes_order o WHERE o.cust.Customer_name = :name",
	        abes_order.class)
	        .setParameter("name", name)
	        .getResultList();

	    return list;
	}
}
