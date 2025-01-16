package com.devthao.animecenter.services.impl;

import com.devthao.animecenter.exception.FailureActionException;
import com.devthao.animecenter.models.entities.Genre;
import com.devthao.animecenter.models.entities.Movie;
import com.devthao.animecenter.models.response.GenreClusterDTO;
import com.devthao.animecenter.repository.GenreRepository;
import com.devthao.animecenter.repository.MovieRepository;
import com.devthao.animecenter.services.TheaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TheaterServiceImpl implements TheaterService {
    @Autowired
    private GenreRepository genreRepository;
    @Autowired
    private MovieRepository movieRepository;
    @Override
    public Genre getGenreById(Long id) {
        Optional<Genre> genre = genreRepository.findById(id);
        if(genre.isEmpty()){
            FailureActionException failureActionException = new FailureActionException("Genre not found");
            failureActionException.setData(id);
            throw failureActionException;
        }
        return genre.get();
    }

    @Override
    public Genre getGenreByName(String name) {
        Optional<Genre> genre = genreRepository.findByName(name);
        if(genre.isEmpty()){
            FailureActionException failureActionException = new FailureActionException("Genre not found");
            failureActionException.setData(name);
            throw failureActionException;
        }
        return genre.get();
    }

    @Override
    public List<Genre> getAllGenres() {
        return genreRepository.findAll();
    }

    @Override
    public GenreClusterDTO getGenreClusterByName(String name) {
        Optional<Genre> optionalGenre = genreRepository.findByName(name);
        if(optionalGenre.isEmpty()){
            FailureActionException failureActionException = new FailureActionException("Genre not found");
            failureActionException.setData(name);
            throw failureActionException;
        }
        Genre genre = optionalGenre.get();
        return GenreClusterDTO.builder()
                .genre(genre)
                .movies(genre.getMovies())
                .build();
    }

    @Override
    public Movie getMovieById(Long id) {
        Optional<Movie> optionalMovie = movieRepository.findById(id);
        if(optionalMovie.isEmpty()){
            FailureActionException failureActionException = new FailureActionException("Genre not found");
            failureActionException.setData(id);
            throw failureActionException;
        }
        return optionalMovie.get();
    }

    @Override
    public List<Movie> getTopNByGenres(List<Long> genreIds, int limit) {
        Pageable pageable = PageRequest.of(0, limit);
        return movieRepository.getTopNMoviesByGenres(genreIds,pageable);
    }

    @Override
    public List<Movie> getMoviesBySearchText(String searchText) {
        return movieRepository.findByTitleIsContainingOrDescriptionIsContainingOrJapaneseTitleIsContaining(searchText, searchText,searchText);
    }

    @Override
    public Movie saveMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    @Override
    public List<Movie> getTopNFilmNew(int limit) {
        Pageable pageable = PageRequest.of(0,limit);

        return movieRepository.findTopNByOrderByIdDesc(pageable);
    }

    @Override
    public List<Movie> getTopNByCommentsAndRatings(int limit) {
        Pageable pageable = PageRequest.of(0,limit);
        return movieRepository.findTopNByNumberOfCommentsAndByNumberOfRatingsMovies(pageable);
    }

    @Override
    public List<Movie> getTopNByTotalViews(int limit) {
        Pageable pageable = PageRequest.of(0,limit);
        return movieRepository.findTopNByOrderByTotalViewsDesc(pageable);
    }

    @Override
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }


}
