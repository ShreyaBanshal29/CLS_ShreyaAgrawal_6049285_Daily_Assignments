package cg.example.ProductCart;

import java.util.Map;
import java.util.Set;

import jakarta.persistence.*;

@Entity
public class Cart {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
   int cartId;
	 @ElementCollection(fetch = FetchType.EAGER)
   Set<Integer> cart;
   public int getCartId() {
	return cartId;
   }
   public void setCartId(int cartId) {
	this.cartId = cartId;
   }
   public Set<Integer> getCart() {
	return cart;
   }
   public void setCart(Set<Integer> cart) {
	this.cart = cart;
   }
   
}
