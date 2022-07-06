package fr.yoann.string_method;

import java.io.IOException;
import java.util.stream.Stream;

public class lines {

    public static void main(String[] args) throws IOException {
        String str = "A \n B \n C \n D";

        Stream<String> lines = str.lines();

        lines.forEach(System.out::println);
    }
}
