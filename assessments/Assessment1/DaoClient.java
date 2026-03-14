package cg.demo.Assessment1;

import java.time.LocalDate;
import java.util.*;

import cg.demo.Assessment1.entities.*;

/**
 * Hello world!
 */
public class DaoClient {
    static Order dao = new OrderDaoImpl();
    static Scanner scan = new Scanner(System.in);
        
	public static void main(String[] args) {
		String opt = null;
		do {
			System.out.println("1-ADD, 2--VIEW BY ORDER ID, 3--VIEW BY CUSTOMER NAME");
			int mtype = scan.nextInt();
			processMenu(mtype);
			System.out.println("press y to continue");
			opt=scan.next();
		}while(opt.equalsIgnoreCase("y"));

	}
	
	public static void processMenu(int mtype) {
		switch(mtype) {
		case 1:
			abes_order o = new abes_order();
			o.setOrder_date(LocalDate.now());
			System.out.print("Enter amount: ");
			Double amount = scan.nextDouble();
			o.setOrder_amt(amount);
			System.out.print("Enter customer Id: ");
			int id = scan.nextInt();
			boolean b = dao.addOrder(o,id);
			if(b) System.out.println("Order added");
			else System.out.println("Order already exists");
			break;
		case 2:
			System.out.print("Enter Order Id: ");
			int id1 = scan.nextInt();
			System.out.println();
			abes_order o1 = dao.viewOrderByOrderID(id1);
			if(o1!=null)
			System.out.println(o1);
			break;
		case 3:
			scan.nextLine(); 
		    System.out.print("Enter Customer Name: ");
		    String name = scan.nextLine();
			List<abes_order> l=dao.viewOrdersByCustName(name);
			System.out.println(name);
			for(abes_order od : l){
				System.out.println(od);
			}
			break;
		default:
			System.out.println("Invalid option");
		}
	}

	
 }