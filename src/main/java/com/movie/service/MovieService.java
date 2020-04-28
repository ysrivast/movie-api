package com.movie.service;

import java.util.List;

import com.movie.dto.request.MovieRequest;
import com.movie.dto.response.MovieResponse;

public interface MovieService {

	List<MovieResponse> getAllMovies();

	MovieResponse create(MovieRequest movie);

	MovieResponse getMovieById(Long id);

	MovieResponse update(Long id, MovieRequest movie);

	void deleteMovieById(Long id);

}
