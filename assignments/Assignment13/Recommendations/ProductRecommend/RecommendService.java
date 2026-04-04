package cg.example.ProductRecommend;

import java.util.*;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RecommendService {

	public Set<ProductDTO> getByCategory(Set<ProductDTO> map) {
		
		RestTemplate rt = new RestTemplate();
		Set<ProductDTO> list = new HashSet<>();
		for(ProductDTO pd: map) {
			ProductDTO[] pdto = rt.getForObject("http://localhost:8081/catalogs/products/category/"+pd.getPcategory(),ProductDTO[].class);
			for(ProductDTO p:pdto) {
			   list.add(p);
			}
		}
		return list;
	}
}
