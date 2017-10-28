package de.daug.semanticchess.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * main controller that maps the index.html to the homepage 
 */
@Controller
public class MainController {

	/**
	 * maps "/" to index.html
	 * @return index.html
	 */
	@GetMapping("/")
	public String home() {
		return "index";

	}
	
	
	/**
	 * maps "/game" to game.html
	 * @return index.html
	 */
	@GetMapping("/game")
	public String game() {
		return "game";

	}
	
	/**
	 * maps "/search" to search.html
	 * @return index.html
	 */
	@GetMapping("/search")
	public String search() {
		return "search";

	}
}