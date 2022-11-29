package springboot.hello.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.annotation.RequestScope;

import springboot.backend.ProductManager;

@Controller
@RequestMapping("/products")
@RequestScope
public class ProductController {

	@Autowired
	ProductManager pm;
	
	@GetMapping("")
	public String products(Model m) {
		m.addAttribute("products", pm.getAll());
		return "products";
	}

	@GetMapping("addform")
	public String form() {
		return "addform";
	}

	@PostMapping("add")
	@Transactional
	public String add(@RequestParam String name,
			@RequestParam int price, Model m) {
		pm.create(name, price);		
		return products(m);
	}

	@GetMapping("remove/{id}")
	@Transactional
	public String remove(@PathVariable long id, Model m) {
		pm.delete(id);
		return products(m);
	}
}
