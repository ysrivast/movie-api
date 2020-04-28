package com.movie.service;

import java.util.List;

import com.movie.service.dto.request.MovieRequest;
import com.movie.service.dto.response.MovieResponse;

public interface MovieService {

	List<MovieResponse> getAll();

	MovieResponse create(MovieRequest movie);

	MovieResponse getById(Long id);

	MovieResponse update(Long id, MovieRequest movie);

	void delete(Long id);

}
