package com.streamapp.contentservice.controller;

import com.streamapp.contentservice.dto.MovieRequest;
import com.streamapp.contentservice.dto.MovieResponse;
import com.streamapp.contentservice.model.Genre;
import com.streamapp.contentservice.service.MovieService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/movies")
@Slf4j
@RequiredArgsConstructor
public class ContentController {

    private final MovieService movieService;

    //add movie
    @PostMapping
    public ResponseEntity<MovieResponse> addMovie(
            @Valid @RequestBody MovieRequest movieRequest
            ){
    return ResponseEntity.status(HttpStatus.CREATED).body(movieService.addMovie(movieRequest));
    }

    //get all movies
    @GetMapping
    public ResponseEntity<List<MovieResponse>> getAllMovies(){
        return   ResponseEntity.ok(movieService.getAllMovies());
    }
    //get movies by genre
    @GetMapping("/genre/{genre}")
    public  ResponseEntity<List<MovieResponse>> getMoviesByGenre(
            @PathVariable Genre genre
            ){
        return ResponseEntity.ok(movieService.getMoviesByGenre(genre));
     }

    // get movie by id
    @GetMapping("/{id}")
    public  ResponseEntity<MovieResponse> getMoviesById(
            @PathVariable String id
    ){
        return ResponseEntity.ok(movieService.getMovieById(id));
    }

    @GetMapping("/search")
    public ResponseEntity<List<MovieResponse>> searchMovies(
            @RequestParam String title
    ){
        return  ResponseEntity.ok(movieService.searchMovies(title));
    }


}
