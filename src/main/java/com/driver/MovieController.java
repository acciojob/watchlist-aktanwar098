package com.driver;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<String> addMovieDirectorPair(@RequestParam("movie") String movieName , @RequestParam("director") String directorName){
        movieService.addMovieDirectorPair(movieName,directorName);
        return new ResponseEntity<>("Movie-Director Pair added Successfully",HttpStatus.OK);
    }



}
