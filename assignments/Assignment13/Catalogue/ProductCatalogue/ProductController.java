package cg.example.ProductCatalogue;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/catalogs/products")
public class ProductController {

    @Autowired
    private ProductService service;
    RestTemplate rt = new RestTemplate();
    @GetMapping()
    public List<ProductDTO> getAllProducts() {
//		Movie m = rt.getForObject("http://localhost:8082/movies/"+id,Movie.class);
        List<Product> l = service.getAllProducts();
        List<ProductDTO> list = new ArrayList<>();
        for(Product p:l) {
        	ProductDTO pd = new ProductDTO();
        	pd.setPid(p.getId());
        	pd.setPcategory(p.getCategory());
        	pd.setPname(p.getName());
        	Double price = rt.getForObject("http://localhost:8082/Price/"+p.getId(),Double.class);
        	int stock = rt.getForObject("http://localhost:8083/Stock/"+p.getId(),Integer.class);
        	pd.setDiscountedPrice(price);
        	pd.setNoOfItems(stock);
        	list.add(pd);
        }
        return list;
    }
    
    
    @GetMapping("/{id}")
    public ProductDTO getProductById(@PathVariable int id) {
    	Product p = service.getProductById(id);
    	ProductDTO pd = new ProductDTO();
    	pd.setPid(p.getId());
    	pd.setPcategory(p.getCategory());
    	pd.setPname(p.getName());
    	Double price = rt.getForObject("http://localhost:8082/Price/"+p.getId(),Double.class);
    	int stock = rt.getForObject("http://localhost:8083/Stock/"+p.getId(),Integer.class);
    	pd.setDiscountedPrice(price);
    	pd.setNoOfItems(stock);
    	return pd;
    }
     
    @GetMapping("/category/{Category}")
    public List<ProductDTO> getAllProductsByCategory(@PathVariable String Category) {
        List<Product> l = service.getAllProductsByCategory(Category);
        List<ProductDTO> list = new ArrayList<>();
        for(Product p:l) {
        	ProductDTO pd = new ProductDTO();
        	pd.setPid(p.getId());
        	pd.setPcategory(p.getCategory());
        	pd.setPname(p.getName());
        	Double price = rt.getForObject("http://localhost:8082/Price/"+p.getId(),Double.class);
        	int stock = rt.getForObject("http://localhost:8083/Stock/"+p.getId(),Integer.class);
        	pd.setDiscountedPrice(price);
        	pd.setNoOfItems(stock);
        	list.add(pd);
        }
        return list;
    }
}
