package es.nom.marcosfernandez.functional.chapter2;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Component
public class CollectionProcessor {

    public static final List<String> names = Arrays.asList("Juan", "Jose", "Pepe");

    //String.join
    public Function<List<String>,String> printNames = input -> String.join(", ", input);

    public Function<List<String>,List<String>> toUpperCase = input -> input.stream().map(String::toUpperCase).collect(Collectors.toList());

    //Collectors.joining
    public Function<List<String>,String> joining = input -> input.stream().map(String::toUpperCase).collect(Collectors.joining(", "));

    // Checks if a String starts with a given letter
    public Function<String, Predicate<String>> startsWithLeter = letter -> string -> string.startsWith(letter);

    // Use of reduce
    public Function<List<String>, Optional<String>> smallerString = input -> input.stream().reduce( (String n1, String n2) -> n1.length() < n2.length()? n1:n2);

    // Use of reduce
    public Function<List<String>, String> manuelOrSmaller = input -> input.stream().reduce("manuel", (String n1, String n2) -> n1.length() < n2.length()? n1:n2);

}
