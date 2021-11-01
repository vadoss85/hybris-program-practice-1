package javaCode.se.collectionsFramework;

import javaCode.console.example.AbstractConsoleExample;
import javaCode.console.example.ConsolePrinter;

public class CollectionsConsoleExample extends AbstractConsoleExample {
    AbstractConsoleExample listsExample;
    AbstractConsoleExample setsExample;
    AbstractConsoleExample collectionMethodsExample;
    AbstractConsoleExample hashMap;
    AbstractConsoleExample treeMap;

    public CollectionsConsoleExample(ConsolePrinter printer) {
        super(printer);

        listsExample = new ListsExample(printer);
        setsExample = new SetsExample(printer);
        collectionMethodsExample = new CollectionMethodsExample(printer);
        hashMap = new HashMapExample(printer);
        treeMap = new TreeMapExample(printer);
    }

    @Override
    public void printTitle() {
        printer.printString("---------------------------");
        printer.printString("--- COLLECTIONS EXAMPLE ---");
        printer.printString("---------------------------");
    }

    @Override
    public void printBody() {
        listsExample.printout();
        setsExample.printout();
        collectionMethodsExample.printout();
        hashMap.printout();
        treeMap.printout();
    }
}
