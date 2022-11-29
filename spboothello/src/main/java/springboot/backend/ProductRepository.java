package springboot.backend;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductRepository extends JpaRepository<Product, Long> {

	public List<Product> findByName(String name);	// per creare dei metodi con query personalizzate è possibile dichiarare un metodo, il cui nome deve descrivere la sua funzionalità
													// poi spring sulla base della struttura del metodo, creerà un metodo, con la query adatta, nel bean repository
	
	@Query("select p from Product p where p.price>=:prezzoMin")		// per creare dei metodi con le proprie query
	public List<Product> findPersonalizzato(int prezzoMin);
}
