package com.driver;


import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class MovieRepository {

    //Below hashmaps are considered as databases
    HashMap<String,Movie> movieDb = new HashMap<>();
    HashMap<String,Director> directorDb = new HashMap<>();

    HashMap<Movie,Director> movieDirectorDb = new HashMap<>();



    public String addMovieInDb(Movie movie){

        String movieName = movie.getName();
        movieDb.put(movieName,movie);

        return "Movie added Successfully !!";
    }

    public Movie getMovieInDb(String searchedMovie){
        if(movieDb.containsKey(searchedMovie)){
            return movieDb.get(searchedMovie);
        }
        else{
            return null;
        }
    }

    public String addDirectorInDb(Director director){

        String directorName = director.getName();
        directorDb.put(directorName,director);

        return "Director added Successfully !!";
    }

    public Director getDirectorInDb(String searchedDirector){
        if(directorDb.containsKey(searchedDirector)){
            return directorDb.get(searchedDirector);
        }
        else{
            return null;
        }
    }

    public String addMovieDirectorPairToDb(String movieName, String directorName){

        Movie movie = movieDb.get(movieName);
        Director director = directorDb.get(directorName);

        movieDirectorDb.put(movie,director);

        return "Pair added Successfully";

    }







}
