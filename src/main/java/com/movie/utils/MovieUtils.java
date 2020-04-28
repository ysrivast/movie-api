package com.movie.utils;

import java.util.ArrayList;
import java.util.List;

import com.movie.dto.request.MovieRequest;
import com.movie.dto.response.MovieResponse;
import com.movie.entity.Movie;

public class MovieUtils {

	public static Movie convert(MovieRequest request) {
		Movie movie = new Movie();
		movie.setRating(request.getRating());
		movie.setTitle(request.getTitle());
		movie.setType(request.getType());
		return movie;
	}

	public static MovieResponse convert(Movie request) {
		MovieResponse movie = new MovieResponse();
		movie.setId(request.getId());
		movie.setRating(request.getRating());
		movie.setTitle(request.getTitle());
		movie.setType(request.getType());
		return movie;
	}

	public static List<MovieResponse> convert(List<Movie> source) {
		List<MovieResponse> target = new ArrayList<>();
		for (Movie input : source) {
			target.add(convert(input));
		}
		return target;
	}
}
