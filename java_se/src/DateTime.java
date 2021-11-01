import javaCode.console.example.AbstractConsoleExample;
import javaCode.console.example.ConsolePrinter;
import javaCode.console.printer.Printer;
import javaCode.se.dateTime.*;

public class        DateTime {
    public static void main(String[] args) {
        ConsolePrinter printer = new Printer();

        AbstractConsoleExample creation = new DateTimeCreationConsoleExample(printer);
        AbstractConsoleExample formatting = new DateTimeFormattingConsoleExample(printer);
        AbstractConsoleExample parsing = new DateTimeParsingConsoleExample(printer);
        AbstractConsoleExample periods = new DateTimePeriodsConsoleExample(printer);
        AbstractConsoleExample using = new DateTimeUsingConsoleExample(printer);

        creation.printout();
        using.printout();
        periods.printout();
        formatting.printout();
        parsing.printout();
    }
}
