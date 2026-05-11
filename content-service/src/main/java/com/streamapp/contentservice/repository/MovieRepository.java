package com.streamapp.contentservice.repository;

import com.streamapp.contentservice.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie,String> {
}
