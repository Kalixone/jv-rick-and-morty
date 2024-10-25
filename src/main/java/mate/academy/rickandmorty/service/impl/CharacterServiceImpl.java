package mate.academy.rickandmorty.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import mate.academy.rickandmorty.model.Character;
import mate.academy.rickandmorty.model.RickAndMortyResponse;
import mate.academy.rickandmorty.repository.CharacterRepository;
import mate.academy.rickandmorty.service.CharacterService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class CharacterServiceImpl implements CharacterService {
    private final RestTemplate restTemplate;
    private final CharacterRepository characterRepository;
    private final Random random;

    @Override
    public void fetchCharacters() {
        String url = "https://rickandmortyapi.com/api/character";
        int page = 1;

        while (true) {
            String pageUrl = url + "?page=" + page;
            RickAndMortyResponse response;

            try {
                response = restTemplate.getForObject(pageUrl, RickAndMortyResponse.class);
            } catch (HttpClientErrorException e) {
                if (e.getStatusCode() == HttpStatus.NOT_FOUND) {
                    break;
                }
                throw e;
            }

            if (response == null || response.getResults() == null
                    || response.getResults().isEmpty()) {
                break;
            }

            List<Character> characters = response.getResults()
                    .stream()
                    .map(result -> {
                        Character character = new Character();
                        character.setExternalId(result.getId());

                        if (result.getName() != null) {
                            character.setName(result.getName());
                        } else {
                            throw new IllegalArgumentException("Field name is missing");
                        }

                        character.setGender(result.getGender());
                        character.setStatus(result.getStatus());
                        return character;
                    }).collect(Collectors.toList());

            characterRepository.saveAll(characters);

            page++;
        }
    }

    @Override
    public Optional<Character> getRandomCharacter() {
        int randomId = random.nextInt(1, (int) characterRepository.count());
        return characterRepository.findById(Long.valueOf(randomId));
    }

    @Override
    public List<Character> searchCharactersByName(String word) {
        return characterRepository.findAll().stream()
                .filter(ch -> ch.getName().toLowerCase().contains(word.toLowerCase()))
                .collect(Collectors.toList());
    }
}
