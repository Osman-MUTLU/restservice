package com.grispi.bootcamp.restservice.controller;

import com.grispi.bootcamp.restservice.model.Movie;
import com.grispi.bootcamp.restservice.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
public class MovieController {

    @Autowired
    private final MovieRepository movieRepository;

    public MovieController(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @GetMapping("/movies")
    public List<Movie> getMovies(){

        return (List<Movie>) movieRepository.findAll();
    }

    @PostMapping("/movies")
    public ResponseEntity<Movie> createMovie(@RequestBody Movie movie){

        movieRepository.save(movie);
//        movies.add(movie);
        return ResponseEntity.status(HttpStatus.CREATED).body(movie);
    }
}
