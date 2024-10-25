package mate.academy.rickandmorty.config;

import java.util.Random;
import mate.academy.rickandmorty.service.CharacterService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public Random random() {
        return new Random();
    }

    @Bean
    public CommandLineRunner commandLineRunner(CharacterService characterService) {
        return args -> {
            characterService.fetchCharacters();
        };
    }
}
