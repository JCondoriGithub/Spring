package springboot.backend;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

public class JpaProductManager {

	@Autowired
	ProductRepository repo;		// viene inniettato il bean della classe creata da spring che fa implementare l'interfaccia

	public List<Product> getAll() {
		return repo.findAll();
	}
	
	public Product get(Long id) {
		return repo.findById(id).get();
	}
	
	@Transactional
	public void remove(Long id) {
		repo.deleteById(id);
	}
	
	@Transactional
	public Product create(String name, int price) {
		Product p = new Product();
		p.setName(name);
		p.setPrice(price);
		repo.save(p);
		
		return p;
	}
}
