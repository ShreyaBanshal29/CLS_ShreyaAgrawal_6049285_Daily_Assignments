package cg.demo.Assessment1.entities;

import java.time.LocalDate;

import jakarta.persistence.*;

@Entity
public class abes_order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int order_id;
	private LocalDate order_date;
	private Double order_amt;
	@ManyToOne(cascade = CascadeType.ALL)
	private abes_customer cust;
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public LocalDate getOrder_date() {
		return order_date;
	}
	public void setOrder_date(LocalDate order_date) {
		this.order_date = order_date;
	}
	public Double getOrder_amt() {
		return order_amt;
	}
	public void setOrder_amt(Double order_amt) {
		this.order_amt = order_amt;
	}
	public abes_customer getCust() {
		return cust;
	}
	public void setCust(abes_customer cust) {
		this.cust = cust;
	}
	@Override
	public String toString() {
		return "abes_order [order_id=" + order_id + ", order_date=" + order_date + ", order_amt=" + order_amt
				+ ", custId=" + cust + "]";
	}
	
}
