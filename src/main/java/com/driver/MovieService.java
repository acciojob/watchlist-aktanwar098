package com.driver;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {


    @Autowired
    MovieRepository movieRepository;

    public String addMovie(Movie movie){
        return movieRepository.addMovieInDb(movie);
    }


    public Movie getMovieByName(String name){
        return movieRepository.getMovieInDb(name);
    }

    public String addDirector(Director director){
        return movieRepository.addDirectorInDb(director);
    }

    public Director getDirectorByName(String name){
        return movieRepository.getDirectorInDb(name);
    }

    public void createMovieDirectorPair(String movie, String director){
        movieRepository.saveMovieDirectorPair(movie, director);
    }

    public List<String> findMoviesByDirector(String director){
        return movieRepository.findMoviesByDirector(director);
    }

    public List<String> findAllMovies(){
        return movieRepository.findAllMovies();
    }

    public void deleteDirector(String director){
        movieRepository.deleteDirector(director);
    }

    public void deleteAllDirectors(){
        movieRepository.deleteAllDirector();
    }

}
