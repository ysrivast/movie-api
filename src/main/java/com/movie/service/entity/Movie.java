package com.movie.service.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

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
@Entity
@Table(name = "MOVIE")
public class Movie {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator="native")
    @GenericGenerator(
    	    name = "native",
    	    strategy = "native"
    	)
	private Long id;
	private String title;
	@Enumerated(EnumType.STRING)
	private MovieType type;
	private Double rating;
}
