package com.driver;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public String addMovieDirectorPair(String movieName, String directorName){
        return movieRepository.addMovieDirectorPairToDb(movieName,directorName);

    }

}
