package com.movie.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movie.constants.RestConstants;
import com.movie.dto.request.MovieRequest;
import com.movie.dto.response.MovieResponse;
import com.movie.service.MovieService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(RestConstants.MOVIES_API)
@Slf4j
public class MovieController {

	@Autowired
	private MovieService movieService;

	@GetMapping
	public ResponseEntity<List<MovieResponse>> getAll() {
		log.info("request for all movies");
		return ResponseEntity.status(HttpStatus.OK).body(movieService.getAllMovies());
	}

	@GetMapping(RestConstants.PATH_VARIABLE_ID)
	public ResponseEntity<MovieResponse> get(@PathVariable("id") final Long id) {
		log.info("request for getting movie by id : {}", id);
		return ResponseEntity.status(HttpStatus.OK).body(movieService.getMovieById(id));
	}

	@PostMapping
	public ResponseEntity<MovieResponse> create(@RequestBody @Valid final MovieRequest movie) {
		log.info("request for creating movie : {}", movie);
		return ResponseEntity.status(HttpStatus.CREATED).body(movieService.create(movie));
	}

	@PutMapping(RestConstants.PATH_VARIABLE_ID)
	public ResponseEntity<MovieResponse> update(@PathVariable("id") final Long id, @RequestBody @Valid final MovieRequest movie) {
		log.info("request for updating movie by id : {}", id);
		return ResponseEntity.status(HttpStatus.OK).body(movieService.update(id, movie));
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") final Long id) {
		log.info("request for deleting movie by id : {}", id);
		movieService.deleteMovieById(id);
	}

}
