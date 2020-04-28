package com.movie.controller;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.movie.dto.request.MovieRequest;
import com.movie.dto.response.MovieResponse;
import com.movie.enums.MovieType;
import com.movie.service.MovieService;

@RunWith(SpringRunner.class)
@WebMvcTest(MovieController.class)
class MovieControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private MovieService movieService;

	@Test
	void testForGetMovieByIdShouldReturnMovieIdExists() throws Exception {
		Long id = Long.valueOf(2);
		MovieResponse movieResponse = new MovieResponse(id, "Dance", MovieType.ACTION, 3.0);
		when(movieService.getMovieById(id)).thenReturn(movieResponse);
		this.mockMvc.perform(MockMvcRequestBuilders.get("/api/v1.0/movies/2")).andDo(print()).andExpect(status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.title").value("Dance"))
				.andExpect(MockMvcResultMatchers.jsonPath("$.rating").value("3.0"));
	}

	@Test
	public void testForDeleteMovieByGivenId() throws Exception {
		doNothing().when(movieService).deleteMovieById(Long.valueOf(1));
		RequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/api/v1.0/movies/1");
		mockMvc.perform(requestBuilder).andDo(print()).andExpect(status().isOk());
	}

	@Test
	void testForCreateMovieForGivenMovieData() throws JsonProcessingException, Exception {
		MovieRequest request = new MovieRequest("Dance", MovieType.ACTION, 3.0);
		MovieResponse response = new MovieResponse(2l, "Dance", MovieType.ACTION, 3.0);
		when(movieService.create(request)).thenReturn(response);

		ObjectMapper mapper = new ObjectMapper();
		this.mockMvc
				.perform(MockMvcRequestBuilders.post("/api/v1.0/movies").content(mapper.writeValueAsString(request))
				.contentType(MediaType.APPLICATION_JSON_VALUE))
				.andDo(print()).andExpect(status().isCreated())
				.andExpect(MockMvcResultMatchers.jsonPath("$.title").value("Dance"))
				.andExpect(MockMvcResultMatchers.jsonPath("$.type").value("ACTION"));
	}

	@Test
	void testForUpdateMovieWithGivenId() throws JsonProcessingException, Exception {
		Long id = Long.valueOf(2);
		MovieResponse response = new MovieResponse(id, "Dance", MovieType.ACTION, 3.0);
		MovieRequest request = new MovieRequest("Dance", MovieType.ACTION, 3.0);
		when(movieService.update(id, request)).thenReturn(response);
		ObjectMapper mapper = new ObjectMapper();
		this.mockMvc
				.perform(MockMvcRequestBuilders.put("/api/v1.0/movies/2").content(mapper.writeValueAsString(request))
						.contentType(MediaType.APPLICATION_JSON_VALUE))
				.andDo(print()).andExpect(status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.title").value("Dance"))
				.andExpect(MockMvcResultMatchers.jsonPath("$.type").value("ACTION"));
	}

}
