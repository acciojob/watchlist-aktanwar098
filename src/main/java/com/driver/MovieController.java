package com.driver;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MovieController {


    @Autowired
    MovieService movieService;

    @PostMapping("/add_movie")
    public ResponseEntity<String> addMovie(@RequestBody() Movie movie){

        String message = movieService.addMovie(movie);
        return new ResponseEntity<>(message, HttpStatus.CREATED);
    }

    @GetMapping("/get_movie_by_name")
    public ResponseEntity<Movie> getMovieByName(@RequestParam("name")String name){
        Movie movie = movieService.getMovieByName(name);
        return new ResponseEntity<>(movie,HttpStatus.ACCEPTED);
    }

    @PostMapping("/add_director")
    public ResponseEntity<String> addDirector(@RequestBody() Director director){
        String dirName = movieService.addDirector(director);
        return new ResponseEntity<>(dirName,HttpStatus.CREATED);
    }

    @GetMapping("/get_director_by_name")
    public ResponseEntity<Director> getDirectorByName(@RequestParam("name") String name){
        Director director = movieService.getDirectorByName(name);
        return new ResponseEntity<>(director,HttpStatus.ACCEPTED);
    }


    @PutMapping("/add_movie_director_pair")
    public ResponseEntity<String> addMovieDirectorPair(@RequestParam("movie") String movie , @RequestParam("director") String director){

        movieService.createMovieDirectorPair(movie,director);

        return new ResponseEntity<>("Movie-Director Pair added Successfully !!",HttpStatus.CREATED);
    }

    @GetMapping("/get_movies_by_director_name/{director}")
    public ResponseEntity<List<String>> getMoviesByDirectorName(@PathVariable String director){
        List<String> movies = movieService.findMoviesByDirector(director);

        return new ResponseEntity<>(movies,HttpStatus.OK);
    }

    @GetMapping("/get_all_movies")
    public ResponseEntity<List<String>> findAllMovies(){

        List<String> movies = movieService.findAllMovies();
        return new ResponseEntity<>(movies,HttpStatus.CREATED);
    }

    @DeleteMapping("/delete_director_by_name")
    public ResponseEntity<String> deleteDirectorByName(@RequestParam  String director){

        movieService.deleteDirector(director);

        return new ResponseEntity<>("Director " +director + " deleted Successfully !!",HttpStatus.GONE);
    }

    @DeleteMapping("/delete-all-directors")
    public ResponseEntity<String> deleteAllDirectors(){
        movieService.deleteAllDirectors();
        return new ResponseEntity<>("All directors deleted successfully", HttpStatus.CREATED);
    }






}
