package com.movie.dto.request;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.movie.enums.MovieType;

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
public class MovieRequest {

	@Size(min = 1, max = 30)
	@NotBlank
	private String title;
	private MovieType type;
	@DecimalMin("0.5")
	@DecimalMax("5.0")
	private Double rating;
}
