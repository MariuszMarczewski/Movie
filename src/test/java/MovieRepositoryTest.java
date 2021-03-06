
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

    public class MovieRepositoryTest {


        private MovieRepository movieRepository;

        @Before
        public void setUp() {
            movieRepository = new MovieRepository();
        }

        @Test
        public void shouldReturnMaxIdBiggerBy1() {

//        given

            Movie movietoSave = new Movie("var", null, "comedy",
                    null, null, true, true, true);
            final Integer expected = 6;

//        when

            Movie result = movieRepository.save(movietoSave);

//        then

            Assert.assertEquals(expected, result.getId());
        }

        @Test
        public void shouldReturnMovieListSmallerby1() {

//            given

            List<Movie> movieList = new ArrayList<>();
            Movie movieToBeDeleted  = new Movie("f", 1, "c",
                    2, "g", true, true, true);


            final int expected = 0;

//        when

            movieRepository.delete(movieToBeDeleted);
            int result = movieList.size();

//        then
            Assert.assertEquals(expected, result);
        }

        @Test
        public void shouldReturnUpdatedMovie(){

//            given

            final Movie movie = new Movie("f", 1, "c",
                    2, "g", true, true, true);

            final Movie expected = new Movie("a", 1, "c",
                    2, "g", true, true, true);

//            when

          Movie result = movieRepository.update(movie);

//            then

            Assert.assertEquals(expected.getName(), result.getName());
        }

        @Test
        public void shouldFindMovieByName() {

//        given

            final String name = "Armageddon";
            final String expected = "Armageddon";


//        when

            String result = movieRepository.findByName(name).getName();

//        then

            Assert.assertEquals(expected, result);
        }

        @Test
        public void shouldFindMovieById() {

//        given

            final Integer id = 1;
            final Integer expected = 1;


//        when

            Integer result = movieRepository.findById(id).getId();

//        then

            Assert.assertEquals(expected, result);
        }

        @Test
        public void shouldFindMovieByGenre() {

//        given

            final String genre = "horror";
            final String expected = "horror";


//        when

            String result = movieRepository.findByGenre(genre).getGenre();

//        then

            Assert.assertEquals(expected, result);
        }

    }

