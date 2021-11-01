package javaCode.se.dateTime;

import javaCode.console.example.AbstractConsoleExample;
import javaCode.console.example.ConsolePrinter;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Date;

public class DateTimeFormattingConsoleExample extends AbstractConsoleExample {
    public DateTimeFormattingConsoleExample(ConsolePrinter printer) {
        super(printer);
    }

    @Override
    public void printTitle() {
        printer.printString("-----------------------------------");
        printer.printString("--- DATETIME FORMATTING EXAMPLE ---");
        printer.printString("-----------------------------------");
    }

    @Override
    public void printBody() {
        LocalDate date = LocalDate.of(2010, Month.APRIL, 15);
        LocalTime time = LocalTime.of(11, 22, 33);
        LocalDateTime dt = LocalDateTime.of(date, time);

        printer.printString(dt.format(DateTimeFormatter.ISO_LOCAL_DATE));
        printer.printString(dt.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
        printer.printString(dt.format(DateTimeFormatter.ISO_LOCAL_TIME));

        DateTimeFormatter shortFormatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT);
        DateTimeFormatter mediumFormatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM);

        printer.printString(shortFormatter.format(dt));
        printer.printString(shortFormatter.format(date));
//        printer.printString(shortFormatter.format(time));

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM dd, yyyy, hh:mm:ss");
        printer.printString(dt.format(formatter));

//        before java 8

        SimpleDateFormat sf = new SimpleDateFormat("hh:mm");
        printer.printString(sf.format(new Date()));

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("hh:mm");
        printer.printString(dtf.format(dt));
//        printer.printString(dtf.format(date));
        printer.printString(dtf.format(time));
    }
}