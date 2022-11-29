package springboot.hello.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.annotation.RequestScope;

import jakarta.persistence.EntityManager;

@Controller		// si indica che questo componente riceve richieste web, quindi è un controller in springboot
@RequestMapping("/")	// questo controller sarà disponibile a partire dall'indirizzo "/"
@RequestScope	
public class HomeController {
	
	JdbcTemplate jdbc;
	
	@Autowired
	EntityManager em;
	
	@Autowired
	MySession session;	// verrà creato un nuovo oggetto "session" per ogni prima chiamata alla classe corrente o sessione http
	
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
