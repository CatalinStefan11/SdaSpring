package ro.sda.spring.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// -> data is @Getter, @Setter, @ToString, @EqualsAndHashcode

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    // when a constraint is not met then an exception of type will be thrown MethodArgumentNotValidException
    @NotBlank(message = "Title most not be empty")
    private String title;

    @NotBlank(message = "Author most not be empty")
    private String author;

    @Min(value = 1, message = "Price must be greater than 0")
    private int price;

    @NotBlank(message = "Gender most not be empty")
    private String gender;
}
