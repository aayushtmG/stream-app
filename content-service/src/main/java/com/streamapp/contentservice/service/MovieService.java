package com.streamapp.contentservice.service;

import com.streamapp.contentservice.dto.MovieRequest;
import com.streamapp.contentservice.dto.MovieResponse;
import com.streamapp.contentservice.model.Genre;
import com.streamapp.contentservice.model.Movie;
import com.streamapp.contentservice.model.VideoStatus;
import com.streamapp.contentservice.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class MovieService {
    private final MovieRepository movieRepository;

   public MovieResponse addMovie(
           MovieRequest request
   ){
        log.info("Adding new movie: {}",request.getTitle());

        Movie movie = new Movie();
    movie.setTitle(request.getTitle());
    movie.setDescription(request.getDescription());
    movie.setGenre(request.getGenre());
    movie.setDirector(request.getDirector());
    movie.setCast(request.getCast());
    movie.setReleaseYear(request.getReleaseYear());
    movie.setRating(request.getRating());
    movie.setThumbnailUrl(request.getThumbnailUrl());
    movie.setDurationMinutes(request.getDurationMinutes());
    movie.setVideoStatus(VideoStatus.PENDING);

    Movie savedMovie = movieRepository.save(movie);
    log.info("Movie added with ID: {}",savedMovie.getId());
        return mapToResponse(savedMovie);
   }

   public List<MovieResponse> getAllMovies(){
       return movieRepository.findAll().stream().map(this::mapToResponse).collect(Collectors.toList());
   }

   public List<MovieResponse> getMoviesByGenre(Genre genre){
       return  movieRepository.findByGenre(genre).stream().map(this::mapToResponse).collect(Collectors.toList());
   }

    public MovieResponse getMovieById(
            String id
    ){
       Movie movie = movieRepository.findById(id).orElseThrow(()-> new RuntimeException("Movie with id:" + id + " not found") );

        return mapToResponse(movie);
    }

    public List<MovieResponse> searchMovies(String title) {
        return movieRepository.findByTitleContainingIgnoreCase(title).stream().map(this::mapToResponse).collect(Collectors.toList());

    }

    //custom mapper
    private MovieResponse mapToResponse(Movie movie){
            MovieResponse movieResponse = new MovieResponse();
           movieResponse.setId(movie.getId());
           movieResponse.setTitle(movie.getTitle());
           movieResponse.setDescription(movie.getDescription());
           movieResponse.setGenre(movie.getGenre());
           movieResponse.setRating(movie.getRating());
           movieResponse.setReleaseYear(movie.getReleaseYear());
            movieResponse.setCast(movie.getCast());
            movieResponse.setThumbnailUrl(movie.getThumbnailUrl());
            movieResponse.setDurationMinutes(movie.getDurationMinutes());
            movieResponse.setVideoKey(movie.getVideoKey());
            movieResponse.setVideoStatus(movie.getVideoStatus());
            movieResponse.setHlsUrl(movie.getHlsUrl());
            movieResponse.setCreatedAt(movie.getCreatedAt());

            return movieResponse;
    }
}
