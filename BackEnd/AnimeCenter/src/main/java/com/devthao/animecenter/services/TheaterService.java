package com.devthao.animecenter.services;

import com.devthao.animecenter.models.entities.Genre;
import com.devthao.animecenter.models.entities.Movie;
import com.devthao.animecenter.models.response.GenreClusterDTO;
import org.springframework.stereotype.Service;

import java.util.List;


public interface TheaterService {
    Genre getGenreById(Long id);
    Genre getGenreByName(String name);
    List<Genre> getAllGenres();
    GenreClusterDTO getGenreClusterByName(String name);
    Movie getMovieById(Long id);
    List<Movie> getTopNByGenres(List<Long> genreIds, int limit);
    List<Movie> getMoviesBySearchText(String searchText);
    Movie saveMovie(Movie movie);
    List<Movie> getTopNFilmNew(int limit);
    List<Movie> getTopNByCommentsAndRatings(int limit);
    List<Movie> getTopNByTotalViews(int limit);
    List<Movie> getAllMovies();
}
