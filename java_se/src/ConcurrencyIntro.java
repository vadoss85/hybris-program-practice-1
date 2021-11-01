import javaCode.console.example.AbstractConsoleExample;
import javaCode.console.example.ConsolePrinter;
import javaCode.console.printer.Printer;
import javaCode.se.concurrency.IntroConsoleExample;

public class ConcurrencyIntro {
    public static void main(String[] args) {
        Printer printer = new Printer();
        AbstractConsoleExample intro = new IntroConsoleExample(printer);

        intro.printout();
    }
}
