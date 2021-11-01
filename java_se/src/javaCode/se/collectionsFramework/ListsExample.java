package javaCode.se.collectionsFramework;

import javaCode.console.example.AbstractConsoleExample;
import javaCode.console.example.ConsolePrinter;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListsExample extends AbstractConsoleExample {
    public ListsExample(ConsolePrinter printer) {
        super(printer);
    }

    private void printArrayListExample() {
        printer.printString("-- Array List --");
        ArrayList arr = new ArrayList();

        arr.add("string 1");
        arr.add("string 2");
        arr.add(1, "inserted by index string;");

        printer.printString("arr size => " + arr.size());

        String first = (String) arr.get(0);
        printer.printString("first element => " + first);

        String second = (String) arr.get(1);
        printer.printString("second element => " + second);
    }

    public void printLinkedListExample() {
        printer.printString("-- Linked List --");
//        In linked arrays should be used classes but not primitives
//        LinkedList<int> linkedArr = new LinkedList<int>(); // wrong
        LinkedList<Integer> linkedArr = new LinkedList<Integer>();

        printer.printString("arr size => " + linkedArr.size());
//        error because of type <Integer>
//        linkedArr.add('1');
        linkedArr.add(1);
        linkedArr.add(2);
        linkedArr.add(3);
        linkedArr.add(4);
        linkedArr.add(5);

        printer.printString("arr size => " + linkedArr.size());

        linkedArr.remove(); // removes first element
        linkedArr.remove(0); // removes element by index

        LinkedList<Integer> arr = new LinkedList<Integer>();
        arr.add(3);
        arr.add(5);
        linkedArr.removeAll(arr); // removes all received values

        printer.printString(linkedArr.toString());
    }

    public void collectionTraversing() {
        printer.printString("-- List traversing (Loops) --");
        ArrayList<String> animals = new ArrayList();

        animals.add("Cat");
        animals.add("Bird");
        animals.add("Dog");
        animals.add("Lion");

        printer.printString("-- For.. loop --");

        for(int i = 0; i < animals.size(); i++) {
            printer.printString(animals.get(i));
        }

        printer.printString("-- For..in loop --");
        for(String animal : animals) {
            printer.printString(animal);
        }

        printer.printString("-- List of objects --");
        ArrayList<Vehicle> vehicles = new ArrayList();
        Vehicle jeep = new Vehicle("Jeep", "wrangler", 15000, true);
        vehicles.add(new Vehicle("Honda", "accord", 12000, true));
        vehicles.add(new Vehicle("Toyota", "carola", 9000, false));
        vehicles.add(jeep);

        for(Vehicle car : vehicles) {
            printer.printString(car.toString());
        }

        iterate(vehicles);
    }

    @Override
    public void printTitle() {
        printer.printString("");
        printer.printString("[Lists example]");
        printer.printString("---------------");
    }

    @Override
    public void printBody() {
        printArrayListExample();
        printLinkedListExample();
        collectionTraversing();
    }

    private void iterate(List list) {
        printer.printString("-- Using `List` type --");
        for (int i = 0; i < list.size(); i++) {
            printer.printString(list.get(i).toString());
        }
    }

}
