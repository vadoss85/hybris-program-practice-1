package javaCode.se.collectionsFramework;

import javaCode.console.example.AbstractConsoleExample;
import javaCode.console.example.ConsolePrinter;

import java.util.HashMap;
import java.util.Map;

public class HashMapExample extends AbstractConsoleExample {
    public HashMapExample(ConsolePrinter printer) {
        super(printer);
    }

    @Override
    public void printTitle() {
        printer.printString("");
        printer.printString("[HashMap example]");
        printer.printString("---------------");
    }

    @Override
    public void printBody() {
        put();
        loop();
    }

    private void put() {
        printer.printString("-- put() --");
        HashMap<String, String> map = new HashMap<>();

        map.put("first", "one");
        map.put("second", "two");
        map.put("third", "three");

        printer.printString("map " + map.toString());
    }

    private void loop() {
        printer.printString("-- loop() --");
        HashMap<String, String> map = new HashMap<>();

        map.put("first", "one");
        map.put("second", "two");
        map.put("third", "three");

//        printer.printString("map.keySet() " + map.keySet().toString());
        // Deprecated???
//        for (String key : map.keySet()) {
//            printer.printString("key => " + key + ", value => " + map.get(key));
//        }

        for (Map.Entry<String, String> entry : map.entrySet()) {
            printer.printString(entry.getKey() + " " + entry.getValue());
//            printer.printString(entry.getValue());
        }
    }
}
