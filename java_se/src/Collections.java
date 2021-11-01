import javaCode.console.printer.Printer;
import javaCode.se.collectionsFramework.CollectionsConsoleExample;

public class Collections {
    public static void main(String[] args) {
        Printer printer = new Printer();

        CollectionsConsoleExample collectionsExample = new CollectionsConsoleExample(printer);

        collectionsExample.printout();
    }
}
