package cg.example.ProductPrice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductPriceController {
	@Autowired
	ProductPriceRepo pr;
	
	@GetMapping("/Price/{id}")
   public double getPriceByProductId(@PathVariable int id) {
	   double price = pr.findById(id)
		        .orElseThrow(() -> new RuntimeException("Product not found"))
		        .getPrice();
	   double discount = pr.findById(id)
		        .orElseThrow(() -> new RuntimeException("Product not found")).getDiscount();
	   return price - discount;
   }
}
