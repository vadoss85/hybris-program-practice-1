package javaCode.se.collectionsFramework;

import javaCode.console.example.AbstractConsoleExample;
import javaCode.console.example.ConsolePrinter;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class TreeMapExample extends AbstractConsoleExample {
    public TreeMapExample(ConsolePrinter printer) {
        super(printer);
    }

    @Override
    public void printTitle() {
        printer.printString("");
        printer.printString("[TreeMap example]");
        printer.printString("---------------");
    }

    @Override
    public void printBody() {
        loop();
    }

    private void loop() {
        printer.printString("-- loop() --");
        TreeMap<String, String> map = new TreeMap<>();

        map.put("c", "str1");
        map.put("a", "str2");
        map.put("b", "str3");

        for (Map.Entry<String, String> entry : map.entrySet()) {
            printer.printString(entry.getKey() + " " + entry.getValue());
        }
    }
}
