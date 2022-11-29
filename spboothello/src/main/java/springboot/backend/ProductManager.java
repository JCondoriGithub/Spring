package springboot.backend;

import java.util.List;

public interface ProductManager {

	public List<Product> getAll();
	public Product get(Long id);
	public void delete(Long id);
	public Product create(String name, int price);
}
