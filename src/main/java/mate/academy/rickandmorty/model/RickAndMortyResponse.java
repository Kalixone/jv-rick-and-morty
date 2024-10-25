package mate.academy.rickandmorty.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RickAndMortyResponse {
    @JsonProperty("results")
    private List<RickAndMorty> results;
}
