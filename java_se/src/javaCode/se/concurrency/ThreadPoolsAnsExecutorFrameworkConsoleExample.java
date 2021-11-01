package javaCode.se.concurrency;

import javaCode.console.example.AbstractConsoleExample;
import javaCode.console.example.ConsolePrinter;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadPoolsAnsExecutorFrameworkConsoleExample extends AbstractConsoleExample {
    public ThreadPoolsAnsExecutorFrameworkConsoleExample(ConsolePrinter printer) {
        super(printer);
    }

    @Override
    public void printTitle() {
        printer.printString("----------------------------------------------------------------------");
        printer.printString("--- CONCURRENCY THREADPOOL AND EXECUTOR FRAMEWORK EXAMPLE ---");
        printer.printString("----------------------------------------------------------------------");
    }

    @Override
    public void printBody() {
        ExecutorService executor = Executors.newFixedThreadPool(2); // recycle threads

        Runnable processor = new MessageProcessor(2);
        executor.execute(processor);

        Runnable processor2 = new MessageProcessor(3);
        executor.execute(processor2);

        Runnable processor3 = new MessageProcessor(4);
        executor.execute(processor3);

        Runnable processor4 = new MessageProcessor(5);
        executor.execute(processor4);

        executor.shutdown(); // rejects any new tasks from being submitted. Gracefully shuts done the service
//        executor.shutdownNow(); // Terminate the executor service immediately

//        while (!executor.isTerminated()) {
//
//        }

        try {
            executor.awaitTermination(2, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        printer.printString("submitted all tasks...");
    }
}

class MessageProcessor implements Runnable {
    private int message;

    public MessageProcessor(int message) {
        this.message = message;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " [RECEIVED] Message = " + message);
        respondToMessage(); // make thread sleep to simulate doing some work
        System.out.println(Thread.currentThread().getName() + " (DONE) Processing message = " + message);
    }

    private void respondToMessage() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            System.out.println("Unable to process message " + message);
        }
    }
}
