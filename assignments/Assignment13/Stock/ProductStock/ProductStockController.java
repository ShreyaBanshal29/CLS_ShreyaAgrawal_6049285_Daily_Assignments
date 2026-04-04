package cg.example.ProductStock;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductStockController {

    @Autowired
    private ProductStockService stockService;
    
    @GetMapping("/Stock/{id}")
   public int getStockById(@PathVariable int id) {
	   return stockService.getStockById(id);
   }
}