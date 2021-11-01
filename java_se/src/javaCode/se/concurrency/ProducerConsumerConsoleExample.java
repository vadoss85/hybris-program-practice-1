package javaCode.se.concurrency;

import javaCode.console.example.AbstractConsoleExample;
import javaCode.console.example.ConsolePrinter;

import java.util.ArrayList;
import java.util.List;

public class ProducerConsumerConsoleExample extends AbstractConsoleExample {
    public ProducerConsumerConsoleExample(ConsolePrinter printer) {
        super(printer);
    }

    @Override
    public void printTitle() {
        printer.printString("---------------------------------------------");
        printer.printString("--- CONCURRENCY PRODUCER CONSUMER EXAMPLE ---");
        printer.printString("---------------------------------------------");
    }

    @Override
    public void printBody() {
        List<Integer> questionList = new ArrayList<>();

        Thread t1 = new Thread(new Producer(questionList));
        Thread t2 = new Thread(new Consumer(questionList));

        t1.start();
        t2.start();
    }
}

class Producer implements Runnable {

    List<Integer> questionList = null;
    final int LIMIT = 5;
    private int questionNumber;
//    Object myObject = new Object();

    public Producer(List<Integer> questionList) {
        this.questionList = questionList;
    }

    public void readQuestion(int questionNumber) throws InterruptedException {
        synchronized (questionList) {
            while (questionList.size() == LIMIT) {
                System.out.println("Questions have piled up. Wait for answers");
                questionList.wait();
            }
        }

        synchronized (questionList) {
            System.out.println("new Question: " + questionNumber);
            questionList.add(questionNumber);
            Thread.sleep(100);
            questionList.notify();
        }
    }

    @Override
    public void run() {
        while (true) {
            try {
                readQuestion(questionNumber++);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Consumer implements Runnable {
    List<Integer> questionList = null;

    public Consumer(List<Integer> questionList) {
        this.questionList = questionList;
    }

    public void answerQuestion() throws InterruptedException {

        synchronized (questionList) {
            while (questionList.isEmpty()) {
                System.out.println("No questions to answer. Waiting for Producer get questions");
                questionList.wait();
            }
        }

        synchronized (questionList) {
            Thread.sleep(5000);
            System.out.println("ANSWERED QUESTION: " + questionList.remove(0));
            questionList.notify();
        }
    }

    @Override
    public void run() {
        while (true) {
            try {
                answerQuestion();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}