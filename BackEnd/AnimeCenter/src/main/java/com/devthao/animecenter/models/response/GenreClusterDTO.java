package com.devthao.animecenter.models.response;

import com.devthao.animecenter.models.entities.Genre;
import com.devthao.animecenter.models.entities.Movie;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
public class GenreClusterDTO {
    Genre genre;
    List<Movie> movies;
}
