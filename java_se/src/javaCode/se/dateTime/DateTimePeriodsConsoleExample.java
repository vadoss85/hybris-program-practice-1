package javaCode.se.dateTime;

import javaCode.console.example.AbstractConsoleExample;
import javaCode.console.example.ConsolePrinter;

import java.time.*;

public class DateTimePeriodsConsoleExample extends AbstractConsoleExample {
    public DateTimePeriodsConsoleExample(ConsolePrinter printer) {
        super(printer);
    }

    @Override
    public void printTitle() {
        printer.printString("--------------------------------");
        printer.printString("--- DATETIME PERIODS EXAMPLE ---");
        printer.printString("--------------------------------");
    }

    @Override
    public void printBody() {
        LocalDate start = LocalDate.of(2017, Month.JANUARY, 1);
        LocalDate end = LocalDate.of(2017, Month.APRIL, 30);
        Period period = Period.ofDays(15);

//        start.toEpochDay() // number of days since January 1 1970

        cleanCage(start, end, period);

        printer.printString(start.plus(period).toString());
        printer.printString(LocalDateTime.now().plus(period).toString());
//        printer.printString(LocalTime.now().plus(period).toString()); // throws error: unsupported unit day
//        Period yearAndMonth = Period.ofYears(1).ofMonths(1);
        Period yearAndMonth = Period.of(1, 1, 0);
        printer.printString(yearAndMonth.toString());
    }

    private void cleanCage(LocalDate start, LocalDate end, Period period) {
        while (start.isBefore(end)) {
            printer.printString("Start:" + start);
            start = start.plus(period);
        }
    }

    private void cleanCage(LocalDate start, LocalDate end) {
        while (start.isBefore(end)) {
            printer.printString("Start:" + start.toString());
            start = start.plusMonths(1);
        }
    }
}
