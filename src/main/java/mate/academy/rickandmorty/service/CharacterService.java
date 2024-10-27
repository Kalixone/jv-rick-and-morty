package mate.academy.rickandmorty.service;

import java.util.List;
import mate.academy.rickandmorty.dto.CharacterResponseDto;
import org.springframework.stereotype.Service;

@Service
public interface CharacterService {
    void fetchCharacters();

    CharacterResponseDto getRandomCharacter();

    List<CharacterResponseDto> searchCharactersByName(String word);
}
