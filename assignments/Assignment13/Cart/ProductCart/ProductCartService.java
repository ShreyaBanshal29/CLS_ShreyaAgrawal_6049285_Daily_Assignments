package cg.example.ProductCart;

import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductCartService {
	@Autowired
  ProductCartRepo cr;

	public Cart getById(int cartId) {
		return cr.getById(cartId);
	}

	public void addProductInCart(int cartId,int productId) {
		Cart c = cr.getById(cartId);
		Set<Integer> m = c.getCart();
		m.add(productId);
		c.setCart(m);
		cr.save(c);
	}
  
  
}
