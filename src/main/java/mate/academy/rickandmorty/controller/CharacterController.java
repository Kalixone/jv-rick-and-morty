package mate.academy.rickandmorty.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import mate.academy.rickandmorty.model.Character;
import mate.academy.rickandmorty.service.CharacterService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/characters")
@Tag(name = "Character API", description = "Operations related to characters from Rick and Morty")
public class CharacterController {
    private final CharacterService characterService;

    @GetMapping("/random")
    @Operation(summary = "Get a random character",
            description = "Returns a random character from the database.")
    public Optional<Character> getRandomCharacter() {
        return characterService.getRandomCharacter();
    }

    @GetMapping("/search")
    @Operation(summary = "Search characters by name",
            description = "Returns a list of characters whose name contains the specified word.")
    public List<Character> searchCharactersByName(@RequestParam String word) {
        return characterService.searchCharactersByName(word);
    }
}
