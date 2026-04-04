package cg.example.ProductCatalogue;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public List<Product> getAllProducts() {
        return repository.findAll();
    }

	public Product getProductById(int id) {
		// TODO Auto-generated method stub
		return repository.getById(id);
	}

	public List<Product> getAllProductsByCategory(String Category) {
		// TODO Auto-generated method stub
		return repository.findByCategory(Category);
	}
}