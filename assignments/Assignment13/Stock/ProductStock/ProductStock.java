package cg.example.ProductStock;

import jakarta.persistence.*;

@Entity
public class ProductStock {
	@Id
int id;
int stock;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public int getStock() {
	return stock;
}
public void setStock(int stock) {
	this.stock = stock;
}
}
