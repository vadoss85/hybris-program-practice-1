package javaCode.se.lambdaExpressions;

import javaCode.console.example.AbstractConsoleExample;
import javaCode.console.example.ConsolePrinter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamsConsoleExample extends AbstractConsoleExample {
    public StreamsConsoleExample(ConsolePrinter printer) {
        super(printer);
    }

    @Override
    public void printTitle() {
        printer.printString("-----------------------");
        printer.printString("--- STREAMS EXAMPLE ---");
        printer.printString("-----------------------");
    }

    @Override
    public void printBody() {
        IntStream.range(1, 10).forEach((x) -> System.out.print(x));
        System.out.println("");
        IntStream.range(1, 10).skip(5).forEach((x) -> System.out.print(x));
        System.out.println("");
        System.out.println(IntStream.range(1, 5).sum());
        System.out.println("");
        Stream.of("Hello", "bottle", "Africa").sorted().findFirst().ifPresent((x) -> System.out.print(x));
        System.out.println("");

        try {
            Stream<String> lines = Files.lines(Paths.get("files/wordFile.txt"));
            lines.filter((l) -> l.length() > 6).sorted().forEach((x) -> System.out.println(x));
            lines.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("");

        try {
            Stream<String> words = Files.lines(Paths.get("files/wordFile.txt"));
            words.filter((l) -> l.contains("th"))
                    .collect(Collectors.toList())
                    .forEach((x) -> System.out.print(x + ", "));
            words.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("");

        try {
            Stream<String> rows = Files.lines(Paths.get("files/stockDataCsv.txt"));
            int rowCount = (int) rows
                    .map(x -> x.split(","))
                    .filter(x -> x.length > 3)
                    .count();
            rows.close();
            System.out.println(rowCount);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("");

        try {
            Stream<String> rows = Files.lines(Paths.get("files/stockDataCsv.txt"));
            rows.map(x -> x.split(","))
                    .filter(x -> x.length > 3)
                    .filter(x -> Integer.parseInt(x[1].trim()) > 15)
                    .forEach(x -> System.out.println(x[0].trim() + " " + x[2].trim() + " " + x[3].trim()));
            rows.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("");

        System.out.println("");
    }
}
