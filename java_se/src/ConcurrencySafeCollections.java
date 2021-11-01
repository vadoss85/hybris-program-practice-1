import javaCode.console.example.AbstractConsoleExample;
import javaCode.console.example.ConsolePrinter;
import javaCode.console.printer.Printer;
import javaCode.se.concurrency.SafeCollectionsConsoleExample;

public class ConcurrencySafeCollections {
    public static void main(String[] args) {
        ConsolePrinter printer = new Printer();
        AbstractConsoleExample example = new SafeCollectionsConsoleExample(printer);

        example.printout();
    }
}
