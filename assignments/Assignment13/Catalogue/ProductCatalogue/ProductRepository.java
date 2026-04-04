package cg.example.ProductCatalogue;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {

	List<Product> findByCategory(String category);
	
}
