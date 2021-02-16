package hr.best.shortlinks.config;

import hr.best.shortlinks.model.ShortLink;
import hr.best.shortlinks.repository.ShortLinkRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ShortLinkConfig {

    @Bean
    CommandLineRunner commandLineRunner(ShortLinkRepository repository) {
        return args -> {
            ShortLink link1 = new ShortLink(
                    "Some Link",
                    "fromURL",
                    "toURL");


            ShortLink link2 = new ShortLink(
                    "Another Link",
                "fromURL",
                "toURL");

            repository.saveAll(List.of(link1, link2));
    };


    }
}
