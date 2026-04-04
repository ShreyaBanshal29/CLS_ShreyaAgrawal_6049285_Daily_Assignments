package cg.example.ProductStock;



import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductStockRepo extends JpaRepository<ProductStock, Integer>{
	
}
