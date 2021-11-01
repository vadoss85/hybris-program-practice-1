package javaCode.se.concurrency;

import javaCode.console.example.AbstractConsoleExample;
import javaCode.console.example.ConsolePrinter;
import javaCode.console.printer.Printer;

public class IntroConsoleExample extends AbstractConsoleExample {
    public IntroConsoleExample(ConsolePrinter printer) {
        super(printer);
    }

    @Override
    public void printTitle() {
        printer.printString("---------------------------------");
        printer.printString("--- CONCURRENCY INTRO EXAMPLE ---");
        printer.printString("---------------------------------");
    }

    @Override
    public void printBody() {
        printer.printString("First line");
        Task task = new Task();

        task.start();
        printer.printString("Fourth line");

        // IllegalThreadStateException
        //task.start();

        // Parallel threads
        Task task2 = new Task();
        task2.start();
    }
}

class Task extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }
    }
}
