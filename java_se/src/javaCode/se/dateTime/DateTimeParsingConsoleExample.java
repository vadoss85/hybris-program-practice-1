package javaCode.se.dateTime;

import javaCode.console.example.AbstractConsoleExample;
import javaCode.console.example.ConsolePrinter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;

public class DateTimeParsingConsoleExample extends AbstractConsoleExample {
    public DateTimeParsingConsoleExample(ConsolePrinter printer) {
        super(printer);
    }

    @Override
    public void printTitle() {
        printer.printString("--------------------------------");
        printer.printString("--- DATETIME PARSING EXAMPLE ---");
        printer.printString("--------------------------------");
    }

    @Override
    public void printBody() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM dd yyyy");
        LocalDate date = LocalDate.parse("02 15 2010", formatter);
        LocalTime time = LocalTime.parse("11:22");

        printer.printString(date.toString());
        printer.printString(time.toString());

        String text = date.format(formatter);
        printer.printString(text);

        LocalDate myDate = LocalDate.of(2010, Month.MAY, 5);
        String formattedMyDate = formatter.format(myDate);
        printer.printString(formattedMyDate);

        LocalDate anotherDate= LocalDate.parse(formattedMyDate, formatter);
        anotherDate = anotherDate.plusMonths(5).plusDays(5);
        printer.printString(formatter.format(anotherDate));
    }
}