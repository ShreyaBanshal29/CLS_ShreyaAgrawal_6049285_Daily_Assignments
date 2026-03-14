package cg.demo.Assessment1.entities;

import java.util.List;

import jakarta.persistence.*;

@Entity
public class abes_customer {
    @Id
	private int Customer_id;
    @Column(nullable = false)
    private String Customer_name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cust")
    private List<abes_order> order;
	
	public List<abes_order> getOrder() {
		return order;
	}
	public void setOrder(List<abes_order> order) {
		this.order = order;
	}
	public int getCustomer_id() {
		return Customer_id;
	}
	public void setCustomer_id(int customer_id) {
		Customer_id = customer_id;
	}
	public String getCustomer_name() {
		return Customer_name;
	}
	public void setCustomer_name(String customer_name) {
		Customer_name = customer_name;
	}
	@Override
	public String toString() {
		return "abes_customer [Customer_id=" + Customer_id + ", Customer_name=" + Customer_name + "]";
	}
    
}
