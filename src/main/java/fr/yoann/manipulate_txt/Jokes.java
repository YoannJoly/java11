package fr.yoann.manipulate_txt;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class Jokes {

    public static void main(String[] args) throws IOException {
        Path path = Path.of("src/main/resources/jokes.txt");

        //System.out.println(readAllLines(Path.of("src/main/resources/jokes.txt"), StandardCharsets.UTF_8).get(1));
        String newQuestion = "Qu'est ce qui est jaune et qui attends ?";
        String newAnswer = "Jonathan";
        Files.writeString(path, newQuestion + "\n" + newAnswer, StandardCharsets.UTF_8, StandardOpenOption.APPEND);
        System.out.println(readAllLines(path, StandardCharsets.UTF_8));

    }

    public static List<String> readAllLines(Path path, Charset cs) throws IOException {
        return Files.readAllLines(path, cs);
    }


}

