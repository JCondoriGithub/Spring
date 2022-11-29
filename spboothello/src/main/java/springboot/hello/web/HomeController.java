package springboot.hello.web;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller		// si indica che questo componente riceve richieste web, quindi è un controller in springboot
@RequestMapping("/")	// questo controller sarà disponibile a partire dall'indirizzo "/"
public class HomeController {
	
	JdbcTemplate jdbc;

	public String home(Model m) {
		m.addAttribute("messaggio", "ciao a tutti");
		SqlRowSet res = jdbc.queryForRowSet("select * from products");
		while(res.next()) {
			Long id = res.getLong("id");
			String name = res.getString("name");
			int price = res.getInt("price");
			System.out.println("product: " + id + name + price);
		}
		return "home";
	}
	
	/*@GetMapping("/")	// questo metodo sarà eseguito solo alle richieste GET con indirizzo "/"
	@ResponseBody
	public String home() {		// il metodo si riferisce ad una servlet che verrà implementata da spring
		return "<html><body><form action='invia' method='post'><input type='submit'></input></form></body></html>";
	}*/
	
	@PostMapping("invia")	// questo metodo sarà eseguito solo alle richieste POST con indirizzo "invia"
	@ResponseBody
	public String ricevi() {
		return "ricevuto";
	}
}
