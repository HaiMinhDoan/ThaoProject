package com.devthao.animecenter.models.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@Entity
@Table(name = "movies")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column
    private String japaneseTitle;

    @Column(length = 2000)
    private String image;

    @Column(length = 2000)
    private String description;

    @Column
    private Double duration;

    @Column
    private String quality;

    @Column
    private String status;

    @Column(length = 2000)
    private String filmLink;

    @Column(nullable = false)
    private int totalViews;
    @Column(nullable = true)
    private int publishYear;

    @ManyToMany
    @JoinTable(
            name = "movie_genres",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id")
    )
    @JsonManagedReference
    private List<Genre> genres;

    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Comment> comments;

    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Rating> ratings;

    // Getters and setters
}
