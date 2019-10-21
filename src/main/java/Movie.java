import lombok.*;

@Data
//@NoArgsConstructor
@AllArgsConstructor

public class Movie {

    private String name;
    private Integer id;
    private String genre;
    private Integer releaseYear;
    private String directorName;

    boolean isRented;
    boolean isNotYetAvailable;
    boolean isOverdued;

}
