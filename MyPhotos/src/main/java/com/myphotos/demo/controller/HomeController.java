package com.myphotos.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller		// si indica che questa è classe-controller
public class HomeController {

	@RequestMapping("/")	// indica che questo metodo risponde al path "/"
	@ResponseBody		// indica che il contenuto del return farà parte della renderizzazione della pagina
	public String index() {
		return "Hello world!";
	}

	@RequestMapping("demo")
	@ResponseBody
	public String demo() {
		return "page of demo!";
	}

}
