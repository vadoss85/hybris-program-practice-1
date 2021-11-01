package javaCode.console.example;

public abstract class AbstractConsoleExample implements ConsoleExample {
    abstract public void printTitle();
    abstract public void printBody();

    public ConsolePrinter printer;

    public AbstractConsoleExample(ConsolePrinter printer) {
        this.printer = printer;
    }

    @Override
    public void printout() {
        printTitle();
        printBody();
    }
}
