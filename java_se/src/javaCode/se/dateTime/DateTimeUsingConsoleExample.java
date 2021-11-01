package javaCode.se.dateTime;

import javaCode.console.example.AbstractConsoleExample;
import javaCode.console.example.ConsolePrinter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.Calendar;
import java.util.Date;

public class DateTimeUsingConsoleExample extends AbstractConsoleExample {
    public DateTimeUsingConsoleExample(ConsolePrinter printer) {
        super(printer);
    }

    @Override
    public void printTitle() {
        printer.printString("------------------------------");
        printer.printString("--- DATETIME USING EXAMPLE ---");
        printer.printString("------------------------------");
    }

    @Override
    public void printBody() {
        LocalDate date = LocalDate.of(2030, Month.JANUARY, 10);
        printer.printString(date.toString());
        date = date.plusDays(5).plusMonths(2);
        printer.printString(date.toString());

        LocalTime time = LocalTime.of(10, 30);
        printer.printString(time.toString());
        time = time.plusHours(2).plusMinutes(20);
        printer.printString(time.toString());

        LocalDateTime localDateTime = LocalDateTime.of(date, time);
        printer.printString(localDateTime.toString());
        localDateTime = localDateTime.minusHours(10).minusDays(2).plusWeeks(1);
        printer.printString(localDateTime.toString());

        // before java 8
        Date myDate = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(myDate);
        cal.set(Calendar.DATE, 1);
        cal.set(Calendar.MONTH, 2);
        myDate = cal.getTime();

        printer.printString(myDate.toString());

        // exam tricks
        LocalDate ld1 = LocalDate.of(2010, Month.APRIL, 1);
        ld1.plusDays(10); // return result is ignored
        printer.printString(ld1.toString());

        // ld1.plusMinutes(10) // method doesn't exists
    }
}
