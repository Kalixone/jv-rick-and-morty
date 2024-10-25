package mate.academy.rickandmorty.service;

import java.util.List;
import java.util.Optional;
import mate.academy.rickandmorty.model.Character;
import org.springframework.stereotype.Service;

@Service
public interface CharacterService {
    void fetchCharacters();

    Optional<Character> getRandomCharacter();

    List<Character> searchCharactersByName(String word);
}
