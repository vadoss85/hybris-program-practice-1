package javaCode.se.collectionsFramework;

import javaCode.console.example.AbstractConsoleExample;
import javaCode.console.example.ConsolePrinter;

import java.util.HashSet;
import java.util.LinkedHashSet;

public class SetsExample extends AbstractConsoleExample {
    public SetsExample(ConsolePrinter printer) {
        super(printer);
    }

    @Override
    public void printTitle() {
        printer.printString("");
        printer.printString("[Sets example]");
        printer.printString("---------------");
    }

    @Override
    public void printBody() {
        printSet();
        printLinkedHashSet();
        printObjectsHashSet();
    }
    private void printSet() {
        printer.printString("-- HashSet --");
        HashSet<String> values = new HashSet<String>();

        values.add("A");
        values.add("Z");
        values.add("B");
        values.add("Y");
        values.add("Y"); // will not be added because of duplicate

        for (String value: values) {
            printer.printString(value.toString());
        }

    }

    private void printLinkedHashSet() {
        printer.printString("-- LinkedHashSet --");
        LinkedHashSet<String> values = new LinkedHashSet<String>();

        values.add("A");
        values.add("Z");
        values.add("B");
        values.add("Y");

        for (String value:
                values) {
            printer.printString(value);
        }
    }

    private void printObjectsHashSet() {
        printer.printString("-- HashSet of objects --");
        HashSet<Vehicle> vehicles = new HashSet<Vehicle>();

        Vehicle jeep = new Vehicle("Jeep", "wrangler", 15000, true);
        Vehicle jeep2 = new Vehicle("Jeep", "wrangler", 15000, true);

        vehicles.add(jeep);
        vehicles.add(new Vehicle("Honda", "accord", 12000, true));
        vehicles.add(new Vehicle("Toyota", "carola", 9000, false));
        vehicles.add(jeep); // will not be added because of jeep is same object
        vehicles.add(jeep2); // will be added

        for (Vehicle vehicle: vehicles) {
            printer.printString(vehicle.toString());
        }

        printer.printString("-- HashSet of objects with override hashCode() and equals() methods --");

        HashSet<VehicleOverrideHashCode> vehicles2 = new HashSet<>();
        VehicleOverrideHashCode jeep3 = new VehicleOverrideHashCode("Jeep", "wrangler", 15000, true);
        VehicleOverrideHashCode jeep4 = new VehicleOverrideHashCode("Jeep", "wrangler", 15000, true);

        printer.printString("jeep3 hashCode() =>" + Integer.toString(jeep3.hashCode()));
        printer.printString("jeep4 hashCode() =>" + Integer.toString(jeep4.hashCode()));

        vehicles2.add(jeep3);
        vehicles2.add(jeep4);

        printer.printString(Boolean.toString(jeep3.equals(jeep4)));

        for (Vehicle vehicle: vehicles2) {
            printer.printString(vehicle.toString());
        }

    }

}
