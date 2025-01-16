package com.devthao.animecenter.controller;

import com.devthao.animecenter.models.entities.Comment;
import com.devthao.animecenter.models.entities.Genre;
import com.devthao.animecenter.models.entities.Movie;
import com.devthao.animecenter.models.request.CommentRequest;
import com.devthao.animecenter.models.response.GenreClusterDTO;
import com.devthao.animecenter.models.response.ResponseData;
import com.devthao.animecenter.services.CommentService;
import com.devthao.animecenter.services.TheaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/theater")
@CrossOrigin("*")
public class TheaterController {
    @Autowired
    private TheaterService theaterService;
    @Autowired
    private CommentService commentService;

    @GetMapping("/genre/one/{name}")
    public ResponseEntity<?> getOneGenreAndMovies(@PathVariable String name) {
        GenreClusterDTO genreClusterDTO = theaterService.getGenreClusterByName(name);
        return ResponseEntity.ok().body(ResponseData.builder()
                .status(200)
                .data(genreClusterDTO)
                .message("Success")
                .build());
    }

    @GetMapping("/genre/all")
    public ResponseEntity<?> getAllGenre() {
        List<Genre> findingGenres = theaterService.getAllGenres();
        return ResponseEntity.ok().body(ResponseData.builder()
                .status(200)
                .data(findingGenres)
                .message("Success")
                .build());
    }

    @GetMapping("/film/one/{id}")
    public ResponseEntity<?> getOneFilm(@PathVariable Long id) {
        Movie findingMovie = theaterService.getMovieById(id);
        return ResponseEntity.ok().body(ResponseData.builder()
                .status(200)
                .data(findingMovie)
                .message("Success")
                .build());
    }

    @PostMapping("/film/comment/post")
    public ResponseEntity<?> postFilmComment(@RequestBody CommentRequest commentRequest) {
        commentService.saveComment(commentRequest);
        return ResponseEntity.ok().body(ResponseData.builder().status(200)
                .message("Success")
                .data(commentRequest)
                .build());
    }

    @GetMapping("/film/comment/get/{movieId}")
    public ResponseEntity<?> getOneFilmComments(@PathVariable Long movieId) {
        return ResponseEntity.ok().body(ResponseData.builder()
                .status(200)
                .message("Success")
                .data(commentService.getCommentsByMovieId(movieId))
                .build());
    }

    @PostMapping("/film/by-genres/{number}")
    public ResponseEntity<?> getAllFilmByGenre(@PathVariable int number, @RequestBody List<Long> genreIds) {
        return ResponseEntity.ok().body(ResponseData.builder()
                .status(200)
                .message("Success")
                .data(theaterService.getTopNByGenres(genreIds, number))
                .build());
    }

    @GetMapping("/film/search/{searchText}")
    public ResponseEntity<?> getFilmBySearchText(@PathVariable String searchText) {
        return ResponseEntity.ok().body(ResponseData.builder()
                .status(200)
                .message("Success")
                .data(theaterService.getMoviesBySearchText(searchText == null ? "" : searchText.trim().toLowerCase()))
                .build());

    }

    @GetMapping("/film/watching/{id}")
    public ResponseEntity<?> getFilmWatching(@PathVariable Long id) {
        Movie movie = theaterService.getMovieById(id);
        movie.setTotalViews(movie.getTotalViews() + 1);
        theaterService.saveMovie(movie);
        return ResponseEntity.ok().body(ResponseData.builder()
                .status(200)
                .message("Success")
                .data(id)
                .build());
    }

    @GetMapping("/film/new/{limit}")
    public ResponseEntity<?> getFilmsNew(@PathVariable int limit) {
        return ResponseEntity.ok().body(ResponseData.builder()
                .status(200)
                .message("Success")
                .data(theaterService.getTopNFilmNew(limit))
                .build());
    }

    @GetMapping("/film/trending/{limit}")
    public ResponseEntity<?> getFilmsTrending(@PathVariable int limit) {
        return ResponseEntity.ok().body(ResponseData.builder()
                .status(200)
                .message("Success")
                .data(theaterService.getTopNByCommentsAndRatings(limit))
                .build());
    }

    @GetMapping("/film/popular/{limit}")
    public ResponseEntity<?> getFilmsPopular(@PathVariable int limit) {
        return ResponseEntity.ok().body(ResponseData.builder()
                .status(200)
                .message("Success")
                .data(theaterService.getTopNByTotalViews(limit))
                .build());
    }

    @GetMapping("/film/all")
    public ResponseEntity<?> getAllFilms() {
        return ResponseEntity.ok().body(ResponseData.builder()
                .status(200)
                .message("Success")
                .data(theaterService.getAllMovies())
                .build());
    }
}
