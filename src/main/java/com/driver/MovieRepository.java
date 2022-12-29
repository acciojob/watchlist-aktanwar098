package com.driver;


import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

@Repository
public class MovieRepository {

    //Below hashmaps are considered as databases
    HashMap<String,Movie> movieDb = new HashMap<>();
    HashMap<String,Director> directorDb = new HashMap<>();

    HashMap<String, List<String>> movieDirectorPair = new HashMap<>();





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

    public void saveMovieDirectorPair(String movie , String director){
        if(movieDb.containsKey(movie) && directorDb.containsKey(director)){

            List<String> currentMoviesByDirector = new ArrayList<>();

            if(movieDirectorPair.containsKey(director)){
                currentMoviesByDirector = movieDirectorPair.get(director);
            }
            currentMoviesByDirector.add(movie);

            movieDirectorPair.put(director,currentMoviesByDirector);
        }
    }

    public List<String> findMoviesByDirector(String director){

        List<String> movieList = new ArrayList<>();
        if(movieDirectorPair.containsKey(director)){
            movieList = movieDirectorPair.get(director);
        }
        return movieList;
    }

    public List<String> findAllMovies(){
        return new ArrayList<>(movieDb.keySet());
    }

    public void deleteDirector(String director){

        List<String> movies = new ArrayList<String>();
        if(movieDirectorPair.containsKey(director)){
            //1. Find the movie names by director from the pair
            movies = movieDirectorPair.get(director);

            //2. Deleting all the movies from movieDb by using movieName
            for(String movie: movies){
                if(movieDb.containsKey(movie)){
                    movieDb.remove(movie);
                }
            }

            //3. Deleteing the pair
            movieDirectorPair.remove(director);
        }

        //4. Delete the director from directorDb.
        if(directorDb.containsKey(director)){
            directorDb.remove(director);
        }
    }

    public void deleteAllDirector(){

        HashSet<String> moviesSet = new HashSet<String>();

        //Deleting the director's map
        directorDb = new HashMap<>();

        //Finding out all the movies by all the directors combined
        for(String director: movieDirectorPair.keySet()){

            //Iterating in the list of movies by a director.
            for(String movie: movieDirectorPair.get(director)){
                moviesSet.add(movie);
            }
        }

        //Deleting the movie from the movieDb.
        for(String movie: moviesSet){
            if(movieDb.containsKey(movie)){
                movieDb.remove(movie);
            }
        }
        //clearing the pair.
        movieDirectorPair = new HashMap<>();
    }



}
