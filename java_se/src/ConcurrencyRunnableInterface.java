import javaCode.console.example.AbstractConsoleExample;
import javaCode.console.example.ConsolePrinter;
import javaCode.console.printer.Printer;
import javaCode.se.concurrency.RunnableInterfaceConsoleExample;

public class ConcurrencyRunnableInterface {
    public static void main(String[] args) {
        Printer printer = new Printer();
        AbstractConsoleExample example = new RunnableInterfaceConsoleExample(printer);

        example.printout();
    }
}