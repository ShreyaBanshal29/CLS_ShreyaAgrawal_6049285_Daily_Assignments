package cg.example.ProductRecommend;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
public class RecommendController {
	@Autowired
	RecommendService rs;
	@GetMapping("/recommend/{cartId}")
   public Set<ProductDTO> showRecommendations(@PathVariable int cartId) {
	   RestTemplate rt = new RestTemplate();
	   ResponseEntity<Set<ProductDTO>> response =
		        rt.exchange(
		                "http://localhost:8084/carts/"+cartId,
		                HttpMethod.GET,
		                null,
		                new ParameterizedTypeReference<Set<ProductDTO>>() {}
		        );

		Set<ProductDTO> map = response.getBody();
		
		return rs.getByCategory(map);
   }
}
