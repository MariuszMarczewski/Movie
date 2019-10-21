


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MovieRepository {

    private List<Movie> movieList = new ArrayList<>();

    private Integer maxId = 6;

    public MovieRepository() {
        movieList.add(new Movie("Armageddon", 1, "SF",
                2001, "Guy Rithie", true, false, false));
        movieList.add(new Movie("Scary Movie", 2, "comedy",
                2011, "Zbigniew Ziobro", true, false, false));
        movieList.add(new Movie("Impostor", 3, "SF",
                2016, "Luc Besson", true, false, false));
        movieList.add(new Movie("Doda", 4, "horror",
                2007, "Pedro Almodovar", true, false, false));
        movieList.add(new Movie("Sexmission", 5, "comedy",
                2009, "Peter James", true, false, false));
    }

    public Movie save(Movie movie) {

        movie.setId(maxId);
        maxId++;
        movieList.add(movie);
        return movie;
    }

    public void delete(Movie movie) {

        movieList = movieList.stream()
                .filter(x -> !x.getId().equals(movie.getId()))
                .collect(Collectors.toList());
    }

    public Movie update(Movie movie) {

        Movie movie1 = movieList.stream()
                .filter(x -> x.getId().equals(movie.getId()))
                .findFirst()
                .get();

        movie1.setName(movie.getName());
        movie1.setGenre(movie.getGenre());
        movie1.setReleaseYear(movie.getReleaseYear());
        movie1.setReleaseYear(movie.getReleaseYear());

        return movie1;
    }


    public Movie findByName(String name) {
        return movieList.stream()
                .filter(x -> name.equals(x.getName()))
                .findFirst()
                .get();
    }

    public Movie findById(Integer id) {
        return movieList.stream()
                .filter(x -> id.equals(x.getId()))
                .findFirst()
                .get();

    }

    public Movie findByGenre(String genre) {
        return movieList.stream()
                .filter(x -> genre.equals(x.getGenre()))
                .findFirst()
                .get();
    }

    public Movie findByDirectorName(String directorName) {
        return movieList.stream()
                .filter(x -> directorName.equals(x.getDirectorName()))
                .findFirst()
                .get();
    }

    public Movie findByReleaseYear(Integer releaseYear) {
        return movieList.stream()
                .filter(x -> releaseYear.equals(x.getReleaseYear()))
                .findFirst()
                .get();
    }

}

