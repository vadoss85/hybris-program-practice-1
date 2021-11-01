import javaCode.console.example.AbstractConsoleExample;
import javaCode.console.example.ConsolePrinter;
import javaCode.console.printer.Printer;
import javaCode.se.concurrency.ThreadPoolsAnsExecutorFrameworkConsoleExample;

public class ConcurrencyThreadPoolsAnsExecutorFramework {
    public static void main(String[] args) {
        ConsolePrinter printer = new Printer();
        AbstractConsoleExample example = new ThreadPoolsAnsExecutorFrameworkConsoleExample(printer);

        example.printout();
    }
}
