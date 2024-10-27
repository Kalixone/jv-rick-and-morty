package mate.academy.rickandmorty.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import mate.academy.rickandmorty.model.CharacterApiResponse;

@Getter
@Setter
public class CharacterListDto {
    @JsonProperty("results")
    private List<CharacterApiResponse> results;
}
