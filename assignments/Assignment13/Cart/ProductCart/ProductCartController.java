package cg.example.ProductCart;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("carts/{cartId}")
public class ProductCartController {
	@Autowired
	ProductCartService pc;
      
	RestTemplate rt = new RestTemplate();
	@PostMapping()
	public String addProduct(@PathVariable int cartId,@RequestBody int id) {
		pc.addProductInCart(cartId,id);
		return "Product added";
	}
	
	@GetMapping()
	public Set<ProductDTO> showCart(@PathVariable int cartId) {
		Set<Integer> mp = pc.getById(cartId).getCart();
		Set<ProductDTO> list = new HashSet<>();
		for(Integer id:mp) {
			list.add(rt.getForObject("http://localhost:8081/catalogs/products/"+id,ProductDTO.class));
		}
		return list;
	}
	
	
	@GetMapping("/recommendations")
	public List<ProductDTO> showRecommendations(@PathVariable int cartId) {
		ProductDTO[] arr = rt.getForObject(
		        "http://localhost:8085/recommend/"+cartId,
		        ProductDTO[].class
		);
		List<ProductDTO> recommend = Arrays.asList(arr);
		return recommend;
	}
}
