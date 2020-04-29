package com.movie.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.dao.MovieRepository;
import com.movie.dto.request.MovieRequest;
import com.movie.dto.response.MovieResponse;
import com.movie.entity.Movie;
import com.movie.exception.MovieException;
import com.movie.service.MovieService;
import com.movie.utils.MovieUtils;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class MovieServiceImpl implements MovieService {

	@Autowired
	private MovieRepository movieRepository;

	@Override
	public List<MovieResponse> getAllMovies() {
		return MovieUtils.convert(movieRepository.findAll());
	}

	@Override
	public MovieResponse create(final MovieRequest request) {
		Movie movie = MovieUtils.convert(request);
		movie = movieRepository.save(movie);
		return MovieUtils.convert(movie);
	}

	@Override
	public MovieResponse getMovieById(final Long id) {
		Optional<Movie> movie = movieRepository.findById(id);
		if (!movie.isPresent()) {
			log.error(" movie not found by id : {}", id);
			throw new MovieException(String.format("movie  not found by id : %d", id));
		}
		return MovieUtils.convert(movie.get());
	}

	@Override
	public MovieResponse update(final Long id, final MovieRequest movie) {
		Optional<Movie> optional = movieRepository.findById(id);
		if (!optional.isPresent()) {
			log.error("movie not found by id : {}", id);
			throw new MovieException(String.format("movie not found by id : %d", id));
		}
		Movie persistMovie = optional.get();
		persistMovie.setTitle(movie.getTitle());
		persistMovie.setRating(movie.getRating());
		persistMovie.setType(movie.getType());
		return MovieUtils.convert(movieRepository.save(persistMovie));
	}

	@Override
	public void deleteMovieById(final Long id) {
		Optional<Movie> optional = movieRepository.findById(id);
		if (!optional.isPresent()) {
			log.error("movie not found by id : {}", id);
			throw new MovieException(String.format("movie not found by id : %d", id));
		}
		movieRepository.deleteById(id);
	}

}
