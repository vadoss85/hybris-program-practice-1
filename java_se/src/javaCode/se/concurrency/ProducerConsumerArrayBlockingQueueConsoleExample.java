package javaCode.se.concurrency;

import javaCode.console.example.AbstractConsoleExample;
import javaCode.console.example.ConsolePrinter;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumerArrayBlockingQueueConsoleExample extends AbstractConsoleExample {
    public ProducerConsumerArrayBlockingQueueConsoleExample(ConsolePrinter printer) {
        super(printer);
    }

    @Override
    public void printTitle() {
        printer.printString("----------------------------------------------------------------------");
        printer.printString("--- CONCURRENCY PRODUCER CONSUMER USING ARRAYBLOCKINGQUEUE EXAMPLE ---");
        printer.printString("----------------------------------------------------------------------");
    }

    @Override
    public void printBody() {
        BlockingQueue<Integer> questionQueue = new ArrayBlockingQueue<Integer>(5);

        Thread t1 = new Thread(new Producer2(questionQueue));
        Thread t2 = new Thread(new Consumer2(questionQueue));

        t1.start();
        t2.start();
    }
}

class Producer2 implements Runnable {
    int questionNo = 0;
    BlockingQueue questionQueue;
    public Producer2(BlockingQueue questionQueue) {
        this.questionQueue = questionQueue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                synchronized (this) {
                    int next = questionNo++;
                    System.out.println("Got new Question: " + questionNo);
                    questionQueue.put(next);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

//    private synchronized int getNextQuestion() {
//        int next = questionNo++;
//        System.out.println("Got new Question: " + questionNo);
//
//        return next;
//    }
}

class Consumer2 implements Runnable {
    BlockingQueue questionQueue;

    public Consumer2(BlockingQueue questionQueue) {
        this.questionQueue = questionQueue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
                System.out.println("Answered Question: " + questionQueue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}