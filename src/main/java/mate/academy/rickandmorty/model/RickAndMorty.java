package mate.academy.rickandmorty.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RickAndMorty {
    @JsonProperty("id")
    private int id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("status")
    private String status;
    @JsonProperty("gender")
    private String gender;
}
