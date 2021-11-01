import javaCode.console.example.ConsolePrinter;
import javaCode.console.printer.Printer;
import javaCode.se.concurrency.SynchronizationConsoleExample;

public class ConcurrencySynchronization {
    public static void main(String[] args) {
        ConsolePrinter printer = new Printer();
        SynchronizationConsoleExample example = new SynchronizationConsoleExample(printer);

        example.printout();
    }
}
