package javaCode.se.lambdaExpressions;

import javaCode.console.example.AbstractConsoleExample;
import javaCode.console.example.ConsolePrinter;

public class PractiseWithLambdasConsoleExample extends AbstractConsoleExample {
    public PractiseWithLambdasConsoleExample(ConsolePrinter printer) {
        super(printer);
    }

    @Override
    public void printTitle() {
        printer.printString("--------------------------------------------------");
        printer.printString("--- FUNCTIONAL INTERFACES AND LAMBDAS  EXAMPLE ---");
        printer.printString("--------------------------------------------------");
    }

    @Override
    public void printBody() {
        Human tom = new Human();
        Robot wale = new Robot();

//        FunctionalInterfacesAndLambdasConsoleExample.walker(tom);
//        FunctionalInterfacesAndLambdasConsoleExample.walker(wale);

        walker(() -> System.out.println("Custom object walking"));

        Walkable aBlockOfCode = () -> {
            System.out.println("Custom object walking");
            System.out.println("Custom object walking2");
        };
        walker(aBlockOfCode);

        ALambdaInterface helloVar = () -> printer.printString("hello");
        Calculate sumVar = (int a, int b) -> a + b;

        printer.printString(Integer.toString(sumVar.compute(4, 6)));

        Calculate nonZeroDivider = (int a, int b) -> {
            if(a == 0) {
                return 0;
            }

            return a/b;
        };

        MyGenericInterface<String> reverser = (String s) -> {
            String result = "";

            for (int i = s.length() - 1; i >= 0; i--) {
                result += s.charAt(i);
            }

            return result;
        };

        MyGenericInterface<Integer> computeNumber = (n) -> {
            int result = 1;
            for (int i = 1; i <= n; i++) {
                result = i*result;
            }
            return result;
        };

        printer.printString(Integer.toString(nonZeroDivider.compute(0, 6)));
        printer.printString(reverser.work("some string"));
        printer.printString(Integer.toString(computeNumber.work(6)));


//        tom.walk();
//        wale.walk();
    }

    public static void walker(Walkable entity) {
        entity.walk();
    }

    public void sayHello() {
        printer.printString("hello");
    }

    public  int sum(int arg1, int arg2) {
        return arg1 + arg2;
    }

    public int nonZeroDivide(int arg1, int arg2) {
        if(arg1 == 0) {
            return 0;
        }

        return arg1/arg2;
    }

    public int factorial(int num) {
        int result = 1;
        for (int i = 0; i <= num; i++) {
            result = i*result;
        }
        return result;
    }

    public String reverse(String str) {
        String result = "";

        for (int i = str.length() - 1; i >= 0; i--) {
            result = result + str.charAt(i);
        }

        return result;
    }
}

interface Calculate {
    public int compute(int a, int b);
}

interface MyGenericInterface<T> {
    public T work(T str);
}

interface NumberWorker {
    public int compute(int n);
}