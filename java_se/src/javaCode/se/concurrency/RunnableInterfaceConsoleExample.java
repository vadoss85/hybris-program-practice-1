package javaCode.se.concurrency;

import javaCode.console.example.AbstractConsoleExample;
import javaCode.console.example.ConsolePrinter;
import javaCode.console.printer.Printer;

public class RunnableInterfaceConsoleExample extends AbstractConsoleExample {
    public RunnableInterfaceConsoleExample(ConsolePrinter printer) {
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
        printer.printString("Starting FirstTread");
        Thread task1 = new Task1("FirstTread", printer);
        task1.start();

        printer.printString("Starting SecondTread");
        Runnable task2 = new Task2("SecondThread", printer);
        Thread thread2 = new Thread(task2);
        thread2.start();
    }
}

class Task1 extends Thread {
    String name;
    ConsolePrinter printer;

    Task1(String name, ConsolePrinter printer) {
        this.name = name;
        this.printer = printer;
    }

    @Override
    public void run() {
        Thread.currentThread().setName(this.name);
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            printer.printString(Integer.toString(i) + " " + Thread.currentThread().getName());
        }
    }
}

class Task2 implements Runnable {
    String name;
    ConsolePrinter printer;

    Task2(String name, ConsolePrinter printer) {
        this.name = name;
        this.printer = printer;
    }

    @Override
    public void run() {
        Thread.currentThread().setName(this.name);
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            printer.printString(Integer.toString(i) + " " + Thread.currentThread().getName());
        }
    }
}
