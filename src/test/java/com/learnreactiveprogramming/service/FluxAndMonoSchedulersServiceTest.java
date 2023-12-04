package com.learnreactiveprogramming.service;

import org.junit.jupiter.api.Test;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.*;

class FluxAndMonoSchedulersServiceTest {

    FluxAndMonoSchedulersService fluxAndMonoSchedulersService
            = new FluxAndMonoSchedulersService();

    @Test
    void explore_publishOn() {
        //given

        //when
        var flux = fluxAndMonoSchedulersService.explore_publishOn();

        //then
        StepVerifier.create(flux)
                .expectNextCount(6)
                .verifyComplete();

    }

    @Test
    void explore_subscribeOn() {
        //given

        //when
        var flux = fluxAndMonoSchedulersService.explore_subscribeOn();

        //then
        StepVerifier.create(flux)
                .expectNextCount(6)
                .verifyComplete();

    }

    @Test
    void explore_parallel() {
        //given

        //when
        var flux = fluxAndMonoSchedulersService.explore_parallel();

        //then
        StepVerifier.create(flux)
                .expectNextCount(3)
                .verifyComplete();
    }

    @Test
    void explore_parallel_usingFlatmap() {
        //given

        var flux = fluxAndMonoSchedulersService.explore_parallel_usingFlatmap();

        //then
        StepVerifier.create(flux)
                //.expectNextCount(3)
                .expectNext("ALEX", "BEN", "CHLOE")
                .verifyComplete();

    }

    @Test
    void explore_parallel_usingFlatmap_1() {
        //given

        var flux = fluxAndMonoSchedulersService.explore_parallel_usingFlatmap_1();

        //then
        StepVerifier.create(flux)
                .expectNextCount(6)
                .verifyComplete();

    }

    @Test
    void explore_parallel_usingFlatmapsequential() {
        //given

        var flux = fluxAndMonoSchedulersService.explore_parallel_usingFlatmapsequential();

        //then
        StepVerifier.create(flux)
                //.expectNextCount(3)
                .expectNext("ALEX", "BEN", "CHLOE")
                .verifyComplete();
    }
}