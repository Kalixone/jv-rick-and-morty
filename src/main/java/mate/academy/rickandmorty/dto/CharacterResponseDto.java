package mate.academy.rickandmorty.dto;

public record CharacterResponseDto(
        Long id,
        int externalId,
        String name,
        String status,
        String gender
) {
}
