package com.myphotos.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller		// si indica che questa è classe-controller
public class HomeController {

	@RequestMapping("/")	// indica che questo metodo risponde al path "/"
	public String index() {
		return "index";		// si inserice il nome, senza l'estenzione, del template che si vuole usare. I templates di thymeleaf vengono cercati da spring in resources
	}

	@RequestMapping("demo")
	@ResponseBody
	public String demo() {
		return "page of demo!";
	}

}
