package de.daug.semanticchess.Controller;

import org.apache.jena.query.ResultSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import de.daug.semanticchess.Service.SparqlService;

@Controller
public class MainController {

	@GetMapping("/")
	public String home() {
		return "index";

	}

//	@GetMapping("/games")
//	public String redirect() {
//		return "resultpages/games";
//	}
}