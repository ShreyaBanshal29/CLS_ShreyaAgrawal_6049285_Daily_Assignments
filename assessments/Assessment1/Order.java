package cg.demo.Assessment1;

import java.util.List;

import cg.demo.Assessment1.entities.*;

public interface Order {
    public boolean addOrder(abes_order o,int id);
	
	public abes_order viewOrderByOrderID(int id);
	
	public List<abes_order> viewOrdersByCustName(String name);

	
}
