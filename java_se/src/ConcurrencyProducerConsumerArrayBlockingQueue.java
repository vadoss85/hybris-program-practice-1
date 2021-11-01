import javaCode.console.example.AbstractConsoleExample;
import javaCode.console.example.ConsolePrinter;
import javaCode.console.printer.Printer;
import javaCode.se.concurrency.ProducerConsumerArrayBlockingQueueConsoleExample;

    public class ConcurrencyProducerConsumerArrayBlockingQueue {
    public static void main(String[] args) {
        ConsolePrinter printer = new Printer();
        AbstractConsoleExample example = new ProducerConsumerArrayBlockingQueueConsoleExample(printer);

        example.printout();
    }
}
