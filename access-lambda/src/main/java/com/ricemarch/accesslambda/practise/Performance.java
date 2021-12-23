package com.ricemarch.accesslambda.practise;

import com.ricemarch.accesslambda.dto.Artist;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Arrays.asList;
import static java.util.stream.Stream.concat;

public interface Performance {

    String getName();

    Stream<Artist> getMusicians();

    default Stream<Artist> getAllMusicians() {
        List<Integer> together = Stream.of(asList(1, 2), asList(3, 4)).flatMap(x -> x.stream()).collect(Collectors.toList());

        return getMusicians()
                .flatMap(artist -> concat(Stream.of(artist), artist.getMembers()));
    }

}
