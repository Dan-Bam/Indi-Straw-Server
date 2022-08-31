package com.project.IndiStraw.domain.movie.dto.response;

import com.project.IndiStraw.domain.movie.enumType.Genre;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AllVideoDto {

    private Long movie_id;
    private String title;
    private String summary;
    private int spector;
    private int opening_date;
    private List<Genre> genres;
    private int time;
    private String image_url;

}
