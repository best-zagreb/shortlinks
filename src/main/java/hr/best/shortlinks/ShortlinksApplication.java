package hr.best.shortlinks;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Shortlinks
 *
 * Simple link shortening service developed for internal use at
 * BEST Zagreb nonprofit Student organization for the purpose
 * of learning and demonstrating RESTful Web Applications
 *
 * For that reason this repository is heavily commented
 *
 * @author IT Working Group of BEST Zagreb
 *
 */
@SpringBootApplication
public class ShortlinksApplication {

	/**
	 * Entry point of the application - the application starts here
	 *
	 * @param args command line arguments (e.g. port app will be started on)
	 */
	public static void main(String[] args) {
		SpringApplication.run(ShortlinksApplication.class, args);
	}

}
