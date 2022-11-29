package springboot.hello.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import springboot.backend.Product;
import springboot.backend.ProductManager;

@RestController
@RequestMapping("/api/products")
public class ProductService {

	@Autowired
	ProductManager pm;
	
	@GetMapping("")
	public List<Product> getAll() {
		return pm.getAll();
	}
	
	@DeleteMapping("{id}/remove")
	public Product remove(@PathVariable int id) {
		System.out.println("rimuovo prodotto id= " + id);
		return new Product(0L, "fake", 100);
	}

	public static class ProductData{
		private String name; 
		private int price;
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getPrice() {
			return price;
		}
		public void setPrice(int price) {
			this.price = price;
		}
		
	}
	
	@PutMapping("{id}")
	public Product update(@PathVariable long id, ProductData data) {
		System.out.println("aggiorno " + id + " con " + data);
		return new Product(id, data.getName(), data.getPrice());
	}
}
