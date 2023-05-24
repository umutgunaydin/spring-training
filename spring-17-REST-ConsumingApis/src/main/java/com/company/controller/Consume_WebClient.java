package com.company.controller;

import com.company.dto.GenreDTO;
import com.company.dto.MovieCinemaDTO;
import com.company.service.GenreService;
import com.company.service.MovieCinemaService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class Consume_WebClient {

    private WebClient webClient = WebClient.builder().baseUrl("http://localhost:8080").build();

    private final MovieCinemaService movieCinemaService;
    private final GenreService genreService;

    public Consume_WebClient(MovieCinemaService movieCinemaService, GenreService genreService) {
        this.movieCinemaService = movieCinemaService;
        this.genreService = genreService;
    }

    @GetMapping("/flux-movie-cinemas")  //localhost:8080/flux-movie-cinemas
    public Flux<MovieCinemaDTO> readAllCinemaFlux(){

        return Flux.fromIterable(movieCinemaService.findAll());

    }

//    @GetMapping("/mono-movie-cinema/{id}")
//    public Mono<MovieCinemaDTO> readById(@PathVariable("id") Long id){
//
//        return Mono.just(movieCinemaService.findById(id));
//
//    }

    @GetMapping("/mono-movie-cinema/{id}")
    public ResponseEntity<Mono<MovieCinemaDTO>> readById(@PathVariable("id") Long id){

        return ResponseEntity.ok(Mono.just(movieCinemaService.findById(id)));

    }

    @PostMapping("/create-genre")
    public Mono<GenreDTO> createGenre(@RequestBody GenreDTO genre){

        GenreDTO createdGenre = genreService.save(genre);

        return Mono.just(createdGenre);
//        return Mono.just(genreRepository.save(genre));

    }

    @DeleteMapping("/delete/genre/{id}")
    public Mono<Void> deleteGenre(@PathVariable("id") Long id){

        genreService.deleteById(id);

        return Mono.empty();
    }

//    ---------------------------WEBCLIENT--------------------------- CONSUME --------------

    @GetMapping("/flux")
    public Flux<MovieCinemaDTO> readWithWebClient(){

        return webClient
                .get()
                .uri("/flux-movie-cinemas")
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .retrieve()
                .bodyToFlux(MovieCinemaDTO.class);

    }

    @GetMapping("/mono/{id}")
    public Mono<MovieCinemaDTO> readMonoWithWebClient(@PathVariable("id") Long id){

        return webClient
                .get()
                .uri("/mono-movie-cinema/{id}",id)
                .retrieve()
                .bodyToMono(MovieCinemaDTO.class);

    }

}