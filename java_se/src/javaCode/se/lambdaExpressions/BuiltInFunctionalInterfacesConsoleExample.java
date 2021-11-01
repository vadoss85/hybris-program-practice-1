package javaCode.se.lambdaExpressions;

import javaCode.console.example.AbstractConsoleExample;
import javaCode.console.example.ConsolePrinter;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class BuiltInFunctionalInterfacesConsoleExample extends AbstractConsoleExample {
    public BuiltInFunctionalInterfacesConsoleExample(ConsolePrinter printer) {
        super(printer);
    }

    @Override
    public void printTitle() {
        printer.printString("--------------------------------------------------");
        printer.printString("--- BUILT-IN FUNCTIONAL EXAMPLE ---");
        printer.printString("--------------------------------------------------");
    }

    @Override
    public void printBody() {
        List<Car> cars = Arrays.asList(
                new Car("Honda", "Accord", "Red", 22300),
                new Car("Honda", "Civic", "Blue", 17700),
                new Car("Toyota", "Land Cruiser", "White", 48500),
                new Car("Toyota", "Corolla", "Black", 16200),
                new Car("Toyota", "Camry", "Blue", 24000),
                new Car("Nissan", "Sentra", "White", 17300),
                new Car("Mitsubishi", "Lancer", "White", 20000),
                new Car("Jeep", "Wrangler", "Red", 24500)
        );

//        printCarsPriceRange(cars, 18000, 22000);
//        printCarByColor(cars, "Red");

//        printer.printString("price between 18k and 22k");
//        printCars(cars, new CarCondition<Car>() {
//            @Override
//            public boolean test(Car c) {
//                return c.getPrice() >= 18000 && c.getPrice() <= 22000;
//            }
//        });
//
//        printer.printString("cars with blue color");
//        printCars(cars, new CarCondition<Car>() {
//            @Override
//            public boolean test(Car c) {
//                return c.getColor().equals("Blue");
//            }
//        });

        Function<Car, String> priceAndColor = (c) -> "price = " + c.getPrice() + " color = " + c.getColor();
        String strCar = priceAndColor.apply(cars.get(0));
        printer.printString(strCar);

        printer.printString("price between 18k and 22k");
        printCars(cars, (c) -> c.getPrice() >= 18000 && c.getPrice() <= 22000);

        printer.printString("cars with blue color");
        printCars(cars, (c) -> c.getColor().equals("Blue"));

    }
    public static void printCars(List<Car> cars, Predicate<Car> condition) {
        for(Car c: cars) {
            if(condition.test(c)) {
                c.printCar();
            }
        }
    }

//    public static void printCarsPriceRange(List<Car> cars, int low, int high) {
//        for(Car c: cars) {
//            if(low <= c.getPrice() && c.getPrice() <= high) {
//                c.printCar();
//            }
//        }
//    }
//
//
//    public static void printCarByColor(List<Car> cars, String color) {
//        for(Car c: cars) {
//            if(c.getColor().equals(color)) {
//                c.printCar();
//            }
//        }
//    }

}

@FunctionalInterface
interface Condition<T> {
    public boolean test(T t);
}
