package com.streamapp.contentservice.service;

import com.streamapp.contentservice.dto.MovieRequest;
import com.streamapp.contentservice.dto.MovieResponse;
import com.streamapp.contentservice.model.Genre;
import com.streamapp.contentservice.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class MovieService {
    private final MovieRepository movieRepository;

   public MovieResponse addMovie(
           MovieRequest movieRequest
   ){
        return new MovieResponse();
   }

   public List<MovieResponse> getAllMovies(){
       return null;
   }

   public List<MovieResponse> getMoviesByGenre(Genre genre){
       List<MovieResponse> movieList = new ArrayList<MovieResponse>();
       return  movieList;
   }

    public MovieResponse getMovieById(
            String id
    ){
        return new MovieResponse();
    }

    public List<MovieResponse> searchMovies(String title) {
        return null;
    }
}
