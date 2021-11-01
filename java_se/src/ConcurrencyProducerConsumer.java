import javaCode.console.example.AbstractConsoleExample;
import javaCode.console.example.ConsolePrinter;
import javaCode.console.printer.Printer;
import javaCode.se.concurrency.ProducerConsumerConsoleExample;

public class ConcurrencyProducerConsumer {
    public static void main(String[] args) {
        ConsolePrinter printer = new Printer();

        AbstractConsoleExample example = new ProducerConsumerConsoleExample(printer);

        example.printout();
    }
}
