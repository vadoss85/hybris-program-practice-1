package javaCode.se.collectionsFramework;

import javaCode.console.example.AbstractConsoleExample;
import javaCode.console.example.ConsolePrinter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class CollectionMethodsExample extends AbstractConsoleExample {
    public CollectionMethodsExample(ConsolePrinter printer) {
        super(printer);
    }

    @Override
    public void printTitle() {
        printer.printString("");
        printer.printString("[Collection example]");
        printer.printString("---------------");
    }

    @Override
    public void printBody() {
        addAll();
        removeAll();
        clear();
        contains();
        retainAll();
        sort();
    }

    private void addAll() {
        printer.printString("-- ArrayList addAll() --");
        ArrayList<Integer> numbers = new ArrayList<>();
        ArrayList<Integer> numbers2 = new ArrayList<>();

        numbers2.add(1);
        numbers2.add(2);
        numbers2.add(3);
        numbers2.add(4);
        numbers2.add(5);

        numbers.addAll(numbers2);

        printer.printString(numbers.toString());
    }

    private void removeAll() {
        printer.printString("-- ArrayList removeAll() --");
        ArrayList<String> strings = new ArrayList<>();
        ArrayList<String> strings2 = new ArrayList<>();

        strings.add("a");
        strings.add("b");
        strings.add("b");
        strings.add("b");
        strings.add("c");

        printer.printString("array " + strings.toString());

        strings2.add("b");
        strings2.add("c");

        printer.printString("array to remove " + strings2.toString());

        strings.removeAll(strings2);

        printer.printString("result" + strings.toString());
    }

    private void clear() {
        printer.printString("-- ArrayList clear() --");
        ArrayList<String> strings = new ArrayList<>();

        strings.add("a");
        strings.add("b");
        strings.add("b");
        strings.add("b");
        strings.add("c");

        printer.printString("array " + strings.toString());

        strings.clear();

        printer.printString("result" + strings.toString());
    }

    private void contains() {
        printer.printString("-- ArrayList contains() --");
        ArrayList<String> strings = new ArrayList<>();

        strings.add("a");
        strings.add("b");
        strings.add("c");

        printer.printString("array " + strings.toString());

        boolean isExistsA = strings.contains("a");
        boolean isExistsD = strings.contains("d");

        printer.printString("isExists a " + Boolean.toString(isExistsA));
        printer.printString("isExists d " + Boolean.toString(isExistsD));

        printer.printString("-- ArrayList isEmpty() --");
        printer.printString("isEmpty " + strings.isEmpty());
    }

    private void retainAll() {
        printer.printString("-- ArrayList retainAll() --");
        ArrayList<String> strings = new ArrayList<>();
        ArrayList<String> strings2 = new ArrayList<>();

        strings.add("a");
        strings.add("b");
        strings.add("b");
        strings.add("b");
        strings.add("c");

        printer.printString("array " + strings.toString());

        strings2.add("b");
        strings2.add("c");

        printer.printString("array to retain " + strings2.toString());

        strings.retainAll(strings2);

        printer.printString("result" + strings.toString());
    }

    private void sort() {
        printer.printString("-- ArrayList sort() --");
        HashSet<Integer> hashSet = new HashSet();

        hashSet.add(10);
        hashSet.add(2);
        hashSet.add(13);
        hashSet.add(4);
        hashSet.add(155);

        ArrayList<Integer> numbers = new ArrayList(hashSet);

        Collections.sort(numbers);

        printer.printString(numbers.toString());

        printer.printString("-- ArrayList sort() objects --");

        ArrayList<VehicleComparable> vehicles = new ArrayList();

        vehicles.add(new VehicleComparable("Jeep", "wrangler", 15000, true));
        vehicles.add(new VehicleComparable("Honda", "accord", 12000, true));
        vehicles.add(new VehicleComparable("Toyota", "carola", 9000, false));

        printer.printString("vehicles array " + vehicles.toString());

        Collections.sort(vehicles);
        printer.printString("vehicles array sorted by price " + vehicles.toString());

    }
}
