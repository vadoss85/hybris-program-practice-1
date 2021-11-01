package javaCode.se.lambdaExpressions;

import javaCode.console.example.AbstractConsoleExample;
import javaCode.console.example.ConsolePrinter;

public class FunctionalInterfacesAndLambdasConsoleExample extends AbstractConsoleExample {
    public FunctionalInterfacesAndLambdasConsoleExample(ConsolePrinter printer) {
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

//        tom.walk();
//        wale.walk();
    }

    public static void walker(Walkable entity) {
        entity.walk();
    }
}
