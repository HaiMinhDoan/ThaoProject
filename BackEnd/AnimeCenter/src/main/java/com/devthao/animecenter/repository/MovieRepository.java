package com.devthao.animecenter.repository;

import com.devthao.animecenter.models.entities.Genre;
import com.devthao.animecenter.models.entities.Movie;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
    @Query("SELECT m from Movie m join m.genres g where g.id in :genreIds GROUP BY m.id ORDER BY COUNT(g) DESC")
    List<Movie> getTopNMoviesByGenres(@Param("genreIds") List<Long> genreIds, Pageable pageable);

    List<Movie> findByTitleIsContainingOrDescriptionIsContainingOrJapaneseTitleIsContaining(String title, String description,String jTitle);

    @Query("SELECT m from  Movie m order by m.id desc ")
    List<Movie> findTopNByOrderByIdDesc(Pageable pageable);

    //Lấy n phim có số lượng comments và ratings cao nhất
    @Query("SELECT m FROM Movie m " +
            "LEFT JOIN m.comments c " +
            "LEFT JOIN m.ratings r " +
            "GROUP BY m " +
            "ORDER BY (COUNT(c) + COUNT(r)) DESC")
    List<Movie> findTopNByNumberOfCommentsAndByNumberOfRatingsMovies(Pageable pageable);

    @Query("select m from Movie m order by m.totalViews desc")
    List<Movie> findTopNByOrderByTotalViewsDesc(Pageable pageable);
}
