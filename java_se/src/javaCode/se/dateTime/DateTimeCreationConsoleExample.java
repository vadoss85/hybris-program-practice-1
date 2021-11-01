package javaCode.se.dateTime;

import javaCode.console.example.AbstractConsoleExample;
import javaCode.console.example.ConsolePrinter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.Calendar;
import java.util.Date;

public class DateTimeCreationConsoleExample extends AbstractConsoleExample {
    public DateTimeCreationConsoleExample(ConsolePrinter printer) {
        super(printer);
    }

    @Override
    public void printTitle() {
        printer.printString("----------------------------------");
        printer.printString("--- DATETIME CREATION  EXAMPLE ---");
        printer.printString("----------------------------------");
    }

    @Override
    public void printBody() {
        printer.printString(LocalDate.now().toString());
        printer.printString(LocalTime.now().toString());
        printer.printString(LocalDateTime.now().toString());

        LocalDate ld = LocalDate.of(2021, Month.OCTOBER, 31);
        LocalTime lt = LocalTime.of(12, 12);
        // LocalTime lt = LocalTime.of(0, 12);

        printer.printString(ld.toString());
        printer.printString(lt.toString());
        printer.printString(LocalDateTime.of(ld, lt).toString());

        //  before java 8
        printer.printString(new Date().toString());
        Calendar calendar = Calendar.getInstance();
        calendar.set(2020, Calendar.JANUARY, 1);
        Date january = calendar.getTime();
        printer.printString(january.toString());
    }
}
