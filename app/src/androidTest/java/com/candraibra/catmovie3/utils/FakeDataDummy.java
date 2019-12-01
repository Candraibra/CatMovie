/*
 * *
 *  * Created by Candra Ibra Sanie on 11/28/19 11:13 AM
 *  * Copyright (c) 2019 . All rights reserved.
 *  * Last modified 11/19/19 7:34 AM
 *
 */

package com.candraibra.catmovie3.utils;

import com.candraibra.catmovie3.data.entity.movie.MovieResults;
import com.candraibra.catmovie3.data.entity.tv.TvResults;

import java.util.ArrayList;

public class FakeDataDummy {

    public static ArrayList<MovieResults> generateDummyMovies() {

        ArrayList<MovieResults> movies = new ArrayList<>();

        movies.add(new MovieResults(
                "During the 1980s, a failed stand-up comedian is driven insane and turns to a life of crime and chaos in Gotham City while becoming an infamous psychopathic crime figure.",
                "en",
                "Joker",
                false,
                "Joker",
                null,
                "/udDclJoHjfjb8Ekgsd4FDteOkCU.jpg",
                "/n6bUvigpRFqSwmPp1m2YADdbRBc.jpg",
                "2019-10-02",
                410.601,
                8.5,
                475557,
                false,
                5386));
        return movies;
    }

    public static ArrayList<TvResults> generateDummyTvs() {

        ArrayList<TvResults> movies = new ArrayList<>();

        movies.add(new TvResults(
                "2013-12-02",
                "Rick is a mentally-unbalanced but scientifically-gifted old man who has recently reconnected with his family. He spends most of his time involving his young grandson Morty in dangerous, outlandish adventures throughout space and alternate universes. Compounded with Morty's already unstable family life, these events cause Morty much distress at home and school.",
                "en",
                null,
                "/qJdfO3ahgAMf2rcmhoqngjBBZW1.jpg",
                null,
                "/mzzHr6g1yvZ05Mc7hNj3tUdy2bM.jpg",
                "Rick and Morty",
                626.673,
                8.6,
                "Rick and Morty",
                60625,
                1474
        ));

        return movies;
    }

    public static ArrayList<MovieResults> generateDummyMoviesById(Integer movieId) {

        ArrayList<MovieResults> movies = new ArrayList<>();

        movies.add(new MovieResults(
                "During the 1980s, a failed stand-up comedian is driven insane and turns to a life of crime and chaos in Gotham City while becoming an infamous psychopathic crime figure.",
                "en",
                "Joker",
                false,
                "Joker",
                null,
                "/udDclJoHjfjb8Ekgsd4FDteOkCU.jpg",
                "/n6bUvigpRFqSwmPp1m2YADdbRBc.jpg",
                "2019-10-02",
                410.601,
                8.5,
                475557,
                false,
                5386));
        return movies;
    }

}