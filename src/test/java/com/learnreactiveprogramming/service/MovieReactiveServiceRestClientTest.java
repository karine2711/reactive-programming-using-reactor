package com.learnreactiveprogramming.service;

import org.junit.jupiter.api.Test;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.*;

class MovieReactiveServiceRestClientTest {

    WebClient webClient = WebClient.builder()
            .baseUrl("http://localhost:8080/movies")
            .build();

    private MovieInfoService movieInfoService
            =new MovieInfoService(webClient);
    private ReviewService reviewService
            =new ReviewService(webClient);
    MovieReactiveService movieReactiveService
            =new MovieReactiveService(movieInfoService,
            reviewService );

    @Test
    void getAllMovies_restClient() {
        //given

        //when
        var moviesFlux = movieReactiveService.getAllMovies_restClient();

        //then
        StepVerifier.create(moviesFlux)
                .expectNextCount(7)
                .verifyComplete();
    }

    @Test
    void getMovieById_RestClient() {
        //given

        //when
        var movieMono = movieReactiveService.getMovieById_RestClient(1L);

        //then
        StepVerifier.create(movieMono)
                .expectNextCount(1)
                .verifyComplete();
    }
}