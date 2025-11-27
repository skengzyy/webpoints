package at.ac.tgm.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // Generates Getter, Setter, toString(), equals(), hashCode()
@NoArgsConstructor // Generates empty Constructor
@AllArgsConstructor // Generates Constructor with all fields
public class GroceryItemDto {
    private Long id;

    @NotNull(message = "must not be null")
    @NotBlank(message = "must not be blank")
    @Size(max = 255, message = "size must be between 0 and 255")

    private String name;
    private Integer amount;
    private Boolean collected;
}