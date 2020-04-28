package com.movie.service.dto.response;

import com.movie.service.enums.MovieType;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class MovieResponse {

	private Long id;
	private String title;
	private MovieType type;
	private Double rating;
}
