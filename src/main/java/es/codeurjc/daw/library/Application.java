package es.codeurjc.daw.library;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@SpringBootApplication
public class Application implements ErrorController {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	// Allow Angular to get non-api request

	private static final String PATH = "/error";

    @RequestMapping(value = PATH)
    public String error() {
        return "forward:/index.html";
    }

    public String getErrorPath() {
        return PATH;
    }
}
