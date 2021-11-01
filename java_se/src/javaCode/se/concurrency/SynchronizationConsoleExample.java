package javaCode.se.concurrency;

import javaCode.console.example.AbstractConsoleExample;
import javaCode.console.example.ConsolePrinter;

public class SynchronizationConsoleExample extends AbstractConsoleExample {
    public SynchronizationConsoleExample(ConsolePrinter printer) {
        super(printer);
    }

    @Override
    public void printTitle() {
        printer.printString("-------------------------------------------");
        printer.printString("--- CONCURRENCY SYNCHRONIZATION EXAMPLE ---");
        printer.printString("-------------------------------------------");
    }

    @Override
    public void printBody() {
        Sequence sequence = new Sequence();
        Worker worker1 = new Worker("FirstThread", printer, sequence);
        Worker worker2 = new Worker("SecondThread", printer, sequence);

        worker1.start();
        worker2.start();
    }
}

class Worker extends Thread {
    String name;
    ConsolePrinter printer;
    Sequence sequence;

    Worker(String name, ConsolePrinter printer, Sequence sequence) {
        this.name = name;
        this.printer = printer;
        this.sequence = sequence;
    }
    @Override
    public void run() {
        Thread.currentThread().setName(name);
        for (int i = 0; i < 20; i++) {
            printer.printString(Thread.currentThread().getName() + " got value " + sequence.getNext());
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Sequence {
    private int value = 0;

//    public int getNext() {
//        synchronized (this) {
//            value = value + 1;
//            return value;
//        }
//    }

    public synchronized int getNext() {
        value = value + 1;
        return value;
    }
}